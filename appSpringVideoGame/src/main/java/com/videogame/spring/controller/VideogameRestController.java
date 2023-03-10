package com.videogame.spring.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.videogame.spring.model.Videogame;
import com.videogame.spring.service.IVideogameService;

@RestController
@RequestMapping("/v1")
public class VideogameRestController {

	@Autowired
	private IVideogameService videogameService;

	// ###################### CREATE ######################
	@PostMapping("/guardarVideojuego/{nombre}/{precio}/{id_categoria}")
	public ResponseEntity<String> guardarVideojuego(@PathVariable String nombre, @PathVariable Double precio , @PathVariable int id_categoria) {
		return videogameService.guardarVideojuego(nombre, precio, id_categoria);
	}

	@PostMapping("/guardarVideojuegoBody")
	public ResponseEntity<String> guardarVideojuegoBody(@RequestBody Videogame videogame) {
		return videogameService.guardarVideojuegoBody(videogame);
	}

	// ###################### READ ######################
	@GetMapping("/listarVideojuegos")
	public ResponseEntity<List<Videogame>> listarVideojuegos() {
		return videogameService.listarVideojuegos();
	}

	@GetMapping("/buscarVideojuego/{id}")
	public ResponseEntity<Optional<Videogame>> buscarVideojuego(@PathVariable Long id) {
		return videogameService.buscarVideojuego(id);
	}

	// ###################### UPDATE ######################
	@PutMapping("actualizarVideojuegoBody")
	public ResponseEntity<String> actualizarVideojuego(@RequestBody Videogame videogame) {
		return videogameService.actualizarVideojuegoBody(videogame);
	}
	
	// ###################### DELETE ######################
	@DeleteMapping("eliminarVideojuego/{id}")
	public ResponseEntity<String> eliminarVideojuego(@PathVariable Long id) {
		return videogameService.eliminarVideojuego(id);
	}

}
