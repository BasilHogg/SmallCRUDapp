package com.springtester.springdemo.demo.dao;

import java.util.List;

import com.springtester.springdemo.demo.entity.Client;

public interface ClientDAO {

	public List<Client> findAll();
	public Client findById(int id);
	public void save(Client client);
	public void deleteById(int id);
}
