package com.example.persona.rest;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import com.example.persona.service.PersonaService;
import com.example.persona.model.Persona;
import org.springframework.web.bind.annotation.RequestBody;

import java.net.URI;
import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

@RestController
@RequestMapping ("/personas/")
public class PersonaREST {
	
	@Autowired
	private PersonaService personaService;
	
	@GetMapping
	private ResponseEntity<List<Persona>> getAllPersonas (){//este es para listar las personas
		return ResponseEntity.ok(personaService.findAll());
	}

	@PostMapping
	private ResponseEntity<Persona> savePersona (@RequestBody Persona persona){
		
		try {
			Persona personaGuardada = personaService.save(persona);
			return ResponseEntity.created(new URI("/personas/"+personaGuardada.getId())).body(personaGuardada);
		}catch(Exception e){
			return ResponseEntity.status(HttpStatus.BAD_REQUEST).build();
			
		}
		
		
	}
	
	//vamos hacer el metodo para eliminar 
	@DeleteMapping (value = "delete/{id}")
	private ResponseEntity<Boolean> deletePersona (@PathVariable ("id") long id ){
		personaService.deleteById(id);
		return ResponseEntity.ok(!(personaService.findById(id)!=null)); //la logica es si el id es diferente de null entonces esta por lo que negamos
		//todo para decir que no esta de esa forma regresamos un si a la varible boolean que esta esperando respuesta
	}
	
}
