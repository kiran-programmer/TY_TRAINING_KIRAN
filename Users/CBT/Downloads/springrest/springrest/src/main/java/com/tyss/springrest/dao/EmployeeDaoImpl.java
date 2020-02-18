package com.tyss.springrest.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.PersistenceUnit;
import javax.persistence.TypedQuery;

import org.springframework.stereotype.Repository;

import com.tyss.springrest.dto.EmployeeBean;

@Repository
public class EmployeeDaoImpl implements EmployeeDao{
	
	@PersistenceUnit
	private EntityManagerFactory factory;
	
	@Override
	public boolean addEmployee(EmployeeBean bean) {

		EntityManager manager = factory.createEntityManager();
		EntityTransaction transaction = manager.getTransaction();
		
		try {
			transaction.begin();
			manager.persist(bean);
			transaction.commit();
			return true;
		} catch (Exception e) {
			e.printStackTrace();
			return false;
		}
	}

	@Override
	public boolean modifyEmployee(EmployeeBean bean) {
	
		EntityManager manager = factory.createEntityManager();
		EntityTransaction transaction = manager.getTransaction();
		try {
			transaction.begin();
			EmployeeBean bean1 = manager.find(EmployeeBean.class, bean.getId());
			bean1.setName(bean.getName());
			bean1.setPassword(bean.getPassword());
			bean1.setGender(bean.getGender());
			bean1.setDoj(bean.getDoj());
			transaction.commit();
			return true;
		} catch (Exception e) {
			e.printStackTrace();
			return false;
		}
		
	}

	@Override
	public boolean deleteEmployee(int id) {
		
		EntityManager manager = factory.createEntityManager();
		EntityTransaction transaction = manager.getTransaction();
		transaction.begin();
		EmployeeBean bean = manager.find(EmployeeBean.class, id);
		
		if(bean != null)
		{
			manager.remove(bean);
		transaction.commit();
		return true;
		}
		else
		{
			return false;
		}
		
	}

	@Override
	public EmployeeBean getEmployee(int id) {
		EntityManager manager = factory.createEntityManager();
		EmployeeBean bean = manager.find(EmployeeBean.class,id);
		return bean;
		
		
	}

	@Override
	public List<EmployeeBean> getAllEmployee() {
		EntityManager manager = factory.createEntityManager();
		String jpql ="from EmployeeBean";
		TypedQuery<EmployeeBean> typedQuery = manager.createQuery(jpql,EmployeeBean.class);
		List<EmployeeBean> list = typedQuery.getResultList();
		return list;
	}

}
