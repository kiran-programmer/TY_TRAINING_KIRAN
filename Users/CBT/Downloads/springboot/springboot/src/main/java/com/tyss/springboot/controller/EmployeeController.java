package com.tyss.springboot.controller;

import java.util.List;

import javax.validation.Valid;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.tyss.springboot.SpringbootApplication;
import com.tyss.springboot.dto.EmployeeBean;
import com.tyss.springboot.dto.EmployeeResponse;
import com.tyss.springboot.service.EmployeeService;

@RestController
public class EmployeeController {

	@Autowired
	private EmployeeService service;

	private static final Logger LOGGER = LoggerFactory.getLogger(SpringbootApplication.class);

	@PostMapping(path = "/add", consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<EmployeeBean> addEmployee(@Valid @RequestBody EmployeeBean bean) {
		LOGGER.info("bean object", bean);
		if (service.addEmployee(bean)) {
			System.out.println(bean);
			return new ResponseEntity<EmployeeBean>(bean, HttpStatus.OK);
		} else {
			return new ResponseEntity<EmployeeBean>(bean, HttpStatus.BAD_REQUEST);
		}

	}

	@PutMapping(path = "/modify", consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
	public EmployeeResponse modifyEmployee(@RequestBody EmployeeBean bean) {
		EmployeeResponse response = new EmployeeResponse();
		if (service.modifyEmployee(bean)) {
			response.setStatusCode(201);
			response.setMessage("Success");
			response.setDescription("Data added to the DB");
		} else {
			response.setStatusCode(401);
			response.setMessage("Failure");
			response.setDescription("Data not added to the DB");
		}
		return response;
	}

	@DeleteMapping(path = "/delete/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
	public EmployeeResponse deleteEmployee(@PathVariable("id") int id) {
		EmployeeResponse response = new EmployeeResponse();
		if (service.deleteEmployee(id)) {
			response.setStatusCode(201);
			response.setMessage("Success");
			response.setDescription("Data delete in the DB");
		} else {
			response.setStatusCode(401);
			response.setMessage("Failure");
			response.setDescription("Data not delete to the DB");
		}
		return response;

	}

	@GetMapping(path = "/get/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<EmployeeBean> getEmployee(@PathVariable("id") int id) {
		EmployeeBean bean = service.getEmployee(id);
		if (bean != null) {
			return new ResponseEntity<EmployeeBean>(bean, HttpStatus.OK);
		} else {
			return new ResponseEntity<EmployeeBean>(HttpStatus.NOT_FOUND);
		}
	}

	@GetMapping(path = "/get-all", produces = MediaType.APPLICATION_JSON_VALUE)
	public EmployeeResponse getAllEmployee() {
		EmployeeResponse response = new EmployeeResponse();
		List<EmployeeBean> bean = service.getAllEmployee();
		if (bean.isEmpty()) {
			response.setStatusCode(401);
			response.setMessage("Failure");
			response.setDescription("Data not found in the DB");
		} else {
			response.setStatusCode(201);
			response.setMessage("Success");
			response.setDescription("Data found in the DB");
			response.setEmployeeBeans(bean);

		}
		return response;
	}

	/*
	 * @GetMapping(path = "exec", produces = MediaType.APPLICATION_JSON_VALUE)
	 * public void createException() { int i = 1 / 0; }
	 */

}
