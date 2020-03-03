package com.testyantra.tyssehub.controller;

import java.util.Arrays;
import java.util.List;

import javax.validation.Valid;
import javax.validation.executable.ValidateOnExecution;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.testyantra.tyssehub.dto.ClientInfoDTO;
import com.testyantra.tyssehub.dto.ClientResponse;
import com.testyantra.tyssehub.service.ClientInfoService;

@CrossOrigin(origins = "*", allowedHeaders = "*", allowCredentials = "true")
@RestController
@ValidateOnExecution
public class ClientInfoController {

	@Autowired
	private ClientInfoService service;

	@PostMapping(path = "/addClientinfo", consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
	public ClientResponse addClient(@Valid @RequestBody ClientInfoDTO dto) {
		ClientResponse response = new ClientResponse();
		if (service.addClient(dto)) {

			response.setStatuscode(200);
			response.setMessage("success");
			response.setDescription("client data added");
			response.setClientInfoDTOs(Arrays.asList(dto));
			return response;

		} else {

			response.setStatuscode(401);
			response.setMessage("failed");
			response.setDescription("client data not added");
			return response;

		}

	}

	@GetMapping(path = "/getClientInfo", produces = MediaType.APPLICATION_JSON_VALUE)
	public ClientResponse getAllClients() {
		ClientResponse response = new ClientResponse();

		List<ClientInfoDTO> list = service.getAllClients();
		if (list != null) {

			response.setStatuscode(200);
			response.setMessage("success");
			response.setDescription("list of clients data found");
			response.setClientInfoDTOs(list);
			return response;

		} else {

			response.setStatuscode(401);
			response.setMessage("failed");
			response.setDescription("client data not found");
			return response;

		}

	}

	@GetMapping(path = "/getByName/{clientName}", produces = MediaType.APPLICATION_JSON_VALUE)
	public ClientResponse getClientByName(@PathVariable("clientName") String clientName) {
		ClientResponse response = new ClientResponse();

		ClientInfoDTO byName = service.getByName(clientName);
		if (byName != null) {

			response.setStatuscode(200);
			response.setMessage("success");
			response.setDescription("clients data found");
			response.setClientInfoDTO(byName);

			return response;

		} else {

			response.setStatuscode(401);
			response.setMessage("failed");
			response.setDescription("client data not found");
			return response;

		}

	}

	@GetMapping(path = "/getByGstin/{gstin}", produces = MediaType.APPLICATION_JSON_VALUE)
	public ClientResponse getClientByGstin(@PathVariable("gstin") String gstin) {
		ClientResponse response = new ClientResponse();

		ClientInfoDTO byGstin = service.getByGstin(gstin);
		if (byGstin != null) {

			response.setStatuscode(200);
			response.setMessage("success");
			response.setDescription("clients data found");
			response.setClientInfoDTO(byGstin);

			return response;

		} else {

			response.setStatuscode(401);
			response.setMessage("failed");
			response.setDescription("client data not found");
			return response;

		}

	}

}
