package com.example.persona.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.persona.model.Persona;

public interface PersonaRepository extends JpaRepository<Persona, Long>{

}
