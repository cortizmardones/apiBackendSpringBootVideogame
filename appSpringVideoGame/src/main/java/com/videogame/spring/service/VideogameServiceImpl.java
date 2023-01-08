package com.videogame.spring.service;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import com.videogame.spring.model.VideoGame;
import com.videogame.spring.model.dao.IVideoGameDao;

@Service
public class VideogameServiceImpl implements IVideogameService {

	private static final Logger LOGGER = LoggerFactory.getLogger(VideogameServiceImpl.class);

	@Autowired
	private IVideoGameDao videoGameDao;

	@Override
	@Transactional(readOnly = true)
	public ResponseEntity<List<VideoGame>> listarVideojuegos() {
		LOGGER.info("Inicio método listarVideojuegos()");
		List<VideoGame> listaVideojuegos = null;
		try {
			//Query JPA Spirngboot para obtener todos los registros
			listaVideojuegos = (List<VideoGame>) videoGameDao.findAll();
			//Devolver código http 200
			return new ResponseEntity<List<VideoGame>>(listaVideojuegos,HttpStatus.OK);
		} catch (Exception e) {
			LOGGER.error("Error al consultar la lista de videojuegos", e);
			e.printStackTrace();
			//Devolver código error http 500
			return new ResponseEntity<List<VideoGame>>(listaVideojuegos,HttpStatus.INTERNAL_SERVER_ERROR);
		}	
	}
}