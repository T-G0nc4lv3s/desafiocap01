package com.thiagosantana.desafiocap01.resources;

import java.time.Instant;
import java.util.ArrayList;
import java.util.List;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.thiagosantana.desafiocap01.entities.Client;

@RestController
@RequestMapping(value = "/clients")
public class ClientResource {

	@GetMapping
	public ResponseEntity<List<Client>> findAll(){

		List<Client> list = new ArrayList<>();

		list.add(new Client(1L, "Miyamoto Musashi", "11417260839", 3500.0, Instant.parse("1990-03-20T00:01:00Z"), 3));
		list.add(new Client(2L, "Sasuke Uchiha", "12177600591", 4180.0, Instant.now(), 1));
		list.add(new Client(3L, "Yusuke Urameshi", "11617266899", 3900.0, Instant.now(), 5));
		return ResponseEntity.ok().body(list);
	}	
}
