package com.videogame.spring.service;

import java.util.List;

import org.springframework.http.ResponseEntity;

import com.videogame.spring.model.VideoGame;

public interface IVideogameService {
	
	public ResponseEntity<List<VideoGame>> listarVideojuegos();

}
