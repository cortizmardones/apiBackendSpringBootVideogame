package com.videogame.spring.service;

import java.util.List;
import java.util.Optional;

import org.springframework.http.ResponseEntity;

import com.videogame.spring.model.Videogame;

public interface IVideogameService {

	// ###################### CREATE ######################
	public ResponseEntity<String> guardarVideojuego(String nombre, Double precio, int id_categoria);

	public ResponseEntity<String> guardarVideojuegoBody(Videogame videogame);

	// ###################### READ ######################
	public ResponseEntity<List<Videogame>> listarVideojuegos();

	public ResponseEntity<Optional<Videogame>> buscarVideojuego(Long id);

	// ###################### UPDATE ######################
	public ResponseEntity<String> actualizarVideojuegoBody(Videogame videogame);
	
	// ###################### DELETE ######################
	public ResponseEntity<String> eliminarVideojuego(Long id);

}
