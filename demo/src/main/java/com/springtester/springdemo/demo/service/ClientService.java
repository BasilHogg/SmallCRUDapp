package com.springtester.springdemo.demo.service;

import java.util.List;

import com.springtester.springdemo.demo.entity.Client;

public interface ClientService {

	public List<Client> findAll();
	public Client findById(int id);
	public void save(Client client);
	public void deleteById(int id);
}
