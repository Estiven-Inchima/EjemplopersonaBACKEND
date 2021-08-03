package com.example.persona.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table (name = "estado")
public class Estado {
	
	@Id//dice que es el id
	@GeneratedValue(strategy = GenerationType.AUTO)//generara automaticamente el id 
	private Long id;
	@ManyToOne//relacion de uno a muchos 
	@JoinColumn(name="id_pais")//nombre de columna 
	private Pais pais;//es in objeto de la clase pais
	private String nombre;
	
	public Estado() {//esto es un constructor por defecto
	}
	
	
	public Estado(Pais pais, String nombre) {
		super();
		this.pais = pais;
		this.nombre = nombre;
	}
	
	
	


	public Long getId() {
		return id;
	}


	public void setId(Long id) {
		this.id = id;
	}


	public Pais getPais() {
		return pais;
	}
	public void setPais(Pais pais) {
		this.pais = pais;
	}
	public String getNombre() {
		return nombre;
	}
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	
	
	
	
	

}