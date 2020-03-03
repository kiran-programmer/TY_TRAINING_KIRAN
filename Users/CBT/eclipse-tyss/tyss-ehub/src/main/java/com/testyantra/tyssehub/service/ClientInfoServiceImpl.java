package com.testyantra.tyssehub.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.testyantra.tyssehub.dao.ClientInfoDAO;
import com.testyantra.tyssehub.dto.ClientInfoDTO;
@Service
public class ClientInfoServiceImpl implements ClientInfoService{
	@Autowired
	private ClientInfoDAO dao;

	@Override
	public boolean addClient(ClientInfoDTO dto) {
		
		return dao.addClient(dto);
	}

	@Override
	public List<ClientInfoDTO> getAllClients() {
		
		return dao.getAllClients();
	}

	@Override
	public ClientInfoDTO getByName(String clientName) {
		// TODO Auto-generated method stub
		return dao.getByName(clientName);
	}

	@Override
	public ClientInfoDTO getByGstin(String gstin) {
		
		return dao.getByGstin(gstin);
	}
	
	
	

}
