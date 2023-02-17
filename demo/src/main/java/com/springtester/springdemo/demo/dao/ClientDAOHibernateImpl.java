package com.springtester.springdemo.demo.dao;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import com.springtester.springdemo.demo.entity.Client;

import jakarta.persistence.EntityManager;

@Repository
public class ClientDAOHibernateImpl implements ClientDAO {

	private EntityManager entityManager;
	
	@Autowired
	public ClientDAOHibernateImpl(EntityManager manager) {
		entityManager = manager;
	}
	
	@Override
	public List<Client> findAll() {
		Session session = entityManager.unwrap(Session.class);
		
		Query<Client> query = session.createQuery("from Client", Client.class);
		
		List<Client> clients = query.getResultList();
		
		return clients;
	}

	@Override
	public Client findById(int id) {
		
		Session session = entityManager.unwrap(Session.class);
				
		Client client = session.get(Client.class, id);
		
		return client;
	}

	@Override
	public void save(Client client) {
		
		Session session = entityManager.unwrap(Session.class);
		
		session.saveOrUpdate(client);
		
		
	}

	@Override
	public void deleteById(int id) {
		
		Session session = entityManager.unwrap(Session.class);
		
		Query query = session.createQuery
				("delete from Client where id=:clientId");
		query.setParameter("clientId", id);
		
		query.executeUpdate();
		
	}

}
