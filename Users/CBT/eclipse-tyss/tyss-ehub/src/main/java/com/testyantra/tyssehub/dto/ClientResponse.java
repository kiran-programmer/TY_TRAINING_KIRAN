package com.testyantra.tyssehub.dto;

import java.util.List;

import lombok.Data;

@Data
public class ClientResponse {
	
	private int statuscode;
	private String message;
	private String description;
	
	private List<ClientInfoDTO> clientInfoDTOs;
	
	private ClientInfoDTO clientInfoDTO;
	
	

}
