package com.testyantra.tyssehub.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.PersistenceUnit;
import javax.persistence.TypedQuery;

import org.hibernate.query.Query;
import org.springframework.stereotype.Repository;

import com.testyantra.tyssehub.dto.ClientInfoDTO;

@Repository
public class ClientInfoDAOImpl implements ClientInfoDAO {

	@PersistenceUnit
	private EntityManagerFactory emf;

	@Override
	public boolean addClient(ClientInfoDTO dto) {
		EntityManager manager = emf.createEntityManager();
		EntityTransaction transaction = manager.getTransaction();

		try {

			transaction.begin();
			manager.persist(dto);
			transaction.commit();
			return true;

		} catch (Exception e) {
			transaction.rollback();
			return false;
		}

	}

	@Override
	public List<ClientInfoDTO> getAllClients() {

		Query<ClientInfoDTO> query = null;
		List<ClientInfoDTO> list = null;
		EntityManager manager = emf.createEntityManager();
		try {
			String get = "from ClientInfoDTO";
			query = (Query<ClientInfoDTO>) manager.createQuery(get);
			list = query.getResultList();
			if (list == null) {
				return null;
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			manager.close();
		}
		return list;
	}

	@Override
	public ClientInfoDTO getByName(String clientName) {
		EntityManager manager=emf.createEntityManager();
		
		try {
			
			String query="from ClientInfoDTO where clientName=:clientName";
			
			TypedQuery<ClientInfoDTO> info=manager.createQuery(query, ClientInfoDTO.class);
			info.setParameter("clientName", clientName);
			ClientInfoDTO dto=info.getSingleResult();
			if(dto!=null)
			{
				return dto;
			}
		}catch (Exception e) {
			
		}
		return null;
	}

	@Override
	public ClientInfoDTO getByGstin(String gstin) {
EntityManager manager=emf.createEntityManager();
		
		try {
			
			String query="from ClientInfoDTO where gstin=:gstin";
			
			TypedQuery<ClientInfoDTO> info=manager.createQuery(query, ClientInfoDTO.class);
			info.setParameter("gstin", gstin);
			ClientInfoDTO dto=info.getSingleResult();
			if(dto!=null)
			{
				return dto;
			}
		}catch (Exception e) {
			
		}
		return null;
	}

}
