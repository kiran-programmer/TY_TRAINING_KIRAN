package com.testyantra.tyssehub.service;

import java.util.List;

import com.testyantra.tyssehub.dto.ClientInfoDTO;

public interface ClientInfoService {
	
	
	public boolean addClient(ClientInfoDTO dto);
	
	public List<ClientInfoDTO> getAllClients();
	
	public ClientInfoDTO getByName(String clientName);
	
	
	public ClientInfoDTO getByGstin(String gstin);

}
