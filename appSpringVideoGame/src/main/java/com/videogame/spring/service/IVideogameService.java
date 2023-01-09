package com.videogame.spring.service;

import java.util.List;
import java.util.Optional;

import org.springframework.http.ResponseEntity;

import com.videogame.spring.model.Videogame;

public interface IVideogameService {
	
	public ResponseEntity<List<Videogame>> listarVideojuegos();
	public ResponseEntity<Optional<Videogame>> buscarVideojuego(Long id);
	public ResponseEntity<String> guardarVideojuego(String nombre, Double precio);
	public ResponseEntity<String> guardarVideojuegoBody(Videogame videogame);

}
