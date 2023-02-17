package com.springtester.springdemo.demo.rest;


import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.springtester.springdemo.demo.entity.Client;
import com.springtester.springdemo.demo.service.ClientService;

@RestController
@RequestMapping("/api")
public class ClientRestController {

	private ClientService clientService;
	
	@Autowired
	public ClientRestController(ClientService clientService) {
		this.clientService = clientService;
	}
	
	@GetMapping("/clients")
	public List<Client> finAll() {
		return clientService.findAll();
	}
	
	@GetMapping("/clients/{id}")
	public Client getClient(@PathVariable int id) {
		Client client = clientService.findById(id);
		
		if (client == null) {
			throw new RuntimeException("Client id not found: " + id);
		}
		return client;
	
	}
	@PostMapping("/clients")
	public Client addClient(@RequestBody Client client) {
		client.setId(0);
		clientService.save(client);
		return client;
	}
	
	@PutMapping("/clients")
	public Client updateClient(@RequestBody Client client) {
		
		clientService.save(client);
		return client;
	}
	
	@DeleteMapping("/clients/{id}")
	public String deleteClient(@PathVariable int id) {
		
		Client client = clientService.findById(id);
		
		if (client == null) {
			throw new RuntimeException("Client id not found: " + id);
		}
		
		clientService.deleteById(id);
		return "Deleted id: " + id;
		
		}
	}
	
