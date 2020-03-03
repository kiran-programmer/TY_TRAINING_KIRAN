package com.testyantra.tyssehub.dao;

import java.util.List;

import com.testyantra.tyssehub.dto.ClientInfoDTO;

public interface ClientInfoDAO {
	
	public boolean addClient(ClientInfoDTO dto);
	
	public List<ClientInfoDTO> getAllClients();
	
	public ClientInfoDTO getByName(String clientName);
	public ClientInfoDTO getByGstin(String gstin);
	

}
