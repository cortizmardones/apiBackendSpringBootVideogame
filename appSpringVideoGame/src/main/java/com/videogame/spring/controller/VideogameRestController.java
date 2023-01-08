package com.videogame.spring.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.videogame.spring.model.VideoGame;
import com.videogame.spring.service.IVideogameService;

@RestController
@RequestMapping("/v1")
public class VideogameRestController {

	@Autowired
	private IVideogameService videogameService;
	
	@GetMapping("/listarVideojuegos")
	public ResponseEntity<List<VideoGame>> listarVideojuegos(){
		return videogameService.listarVideojuegos();
	}
	
}