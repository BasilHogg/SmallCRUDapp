package com.springtester.springdemo.demo.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.springtester.springdemo.demo.dao.ClientDAO;
import com.springtester.springdemo.demo.entity.Client;

@Service
public class ClientServiceImpl implements ClientService {

	private ClientDAO clientDAO;
	
	@Autowired
	public ClientServiceImpl(ClientDAO clientDAO ) {
		this.clientDAO = clientDAO;
	}
	@Override
	@Transactional
	public List<Client> findAll() {
		return clientDAO.findAll();
	}

	@Override
	@Transactional
	public Client findById(int id) {
		return clientDAO.findById(id);
	}

	@Override
	@Transactional
	public void save(Client client) {
		clientDAO.save(client);

	}

	@Override
	@Transactional
	public void deleteById(int id) {
		clientDAO.deleteById(id);
	}

}
