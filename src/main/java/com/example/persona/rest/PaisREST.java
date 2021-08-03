package com.example.persona.rest;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.GetMapping;

import com.example.persona.model.Pais;
import com.example.persona.service.PaisService;
//notaciones web
@RestController
@RequestMapping ("/pais/") //nos da la url base para acceder a nuestro servicio
public class PaisREST {
	
	@Autowired
	private PaisService paisService; //esto es una propiedad 
	
	@GetMapping
	private ResponseEntity<List<Pais>> getAllPaises(){//aqui se importa list de java util y pais de model
		return ResponseEntity.ok(paisService.findAll());
	}

}
