package com.thiagosantana.desafiocap01.services;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.thiagosantana.desafiocap01.dto.ClientDTO;
import com.thiagosantana.desafiocap01.entities.Client;
import com.thiagosantana.desafiocap01.repositories.ClientRepository;
import com.thiagosantana.desafiocap01.services.exceptions.ResourceNotFoundException;

@Service
public class ClientService {

	@Autowired
	private ClientRepository repository;
	
	@Transactional(readOnly = true)
	public List<ClientDTO> findAll(){
		List<Client> list = repository.findAll();
		return list.stream().map(cli -> new ClientDTO(cli)).collect(Collectors.toList());
	}
	
	@Transactional(readOnly = true)
	public ClientDTO findById(Long id) {
		Optional<Client> obj = repository.findById(id);
		Client entity = obj.orElseThrow(() -> new ResourceNotFoundException("Entity not found"));
		return new ClientDTO(entity);
	}

	@Transactional
	public ClientDTO insert(ClientDTO dto) {
		
		Client client = new Client();
		dtoToEntity(client, dto);
		client = repository.save(client);
		return new ClientDTO(client);
	}

	private void dtoToEntity(Client client, ClientDTO dto) {
		client.setId(dto.getId());
		client.setName(dto.getName());
		client.setCpf(dto.getCpf());
		client.setIncome(dto.getIncome());
		client.setBirthDate(dto.getBirthDate());
		client.setChildren(dto.getChildren());
	}
}
