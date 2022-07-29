package com.thiagosantana.desafiocap01.services;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.thiagosantana.desafiocap01.dto.ClientDTO;
import com.thiagosantana.desafiocap01.entities.Client;
import com.thiagosantana.desafiocap01.repositories.ClientRepository;

@Service
public class ClientService {

	@Autowired
	private ClientRepository repository;
	
	@Transactional(readOnly = true)
	public List<ClientDTO> findAll(){
		List<Client> list = repository.findAll();
		return list.stream().map(cli -> new ClientDTO(cli)).collect(Collectors.toList());
	}
}
