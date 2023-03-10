package com.videogame.spring.model;

import java.io.Serializable;

import org.springframework.stereotype.Component;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "Videogame")
@Component
public class Videogame implements Serializable {

	private static final long serialVersionUID = 9152217868255911129L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id_videogame")
	private Long id;
	private String nombre;
	private Double precio;
	private int id_categoria;

	public Videogame() {

	}
	
	public Videogame(Long id, String nombre, Double precio, int id_categoria) {
		this.id = id;
		this.nombre = nombre;
		this.precio = precio;
		this.id_categoria = id_categoria;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public Double getPrecio() {
		return precio;
	}

	public void setPrecio(Double precio) {
		this.precio = precio;
	}

	public int getId_categoria() {
		return id_categoria;
	}

	public void setId_categoria(int id_categoria) {
		this.id_categoria = id_categoria;
	}

	
	
}
