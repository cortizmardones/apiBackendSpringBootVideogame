package com.videogame.spring.service;

import java.util.List;
import java.util.Optional;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import com.videogame.spring.model.Videogame;
import com.videogame.spring.model.dao.IVideoGameDao;

@Service
public class VideogameServiceImpl implements IVideogameService {

	private static final Logger LOGGER = LoggerFactory.getLogger(VideogameServiceImpl.class);

	@Autowired
	private IVideoGameDao videoGameDao;

	@Override
	@Transactional(readOnly = true)
	public ResponseEntity<List<Videogame>> listarVideojuegos() {
		LOGGER.info("Inicio método listarVideojuegos()");
		List<Videogame> listaVideojuegos = null;
		try {
			//Query JPA SPRING_BOOT
			listaVideojuegos = (List<Videogame>) videoGameDao.findAll();
			//Devolver código http 200
			return new ResponseEntity<List<Videogame>>(listaVideojuegos,HttpStatus.OK);
		} catch (Exception e) {
			LOGGER.error("Error al consultar la lista de videojuegos", e);
			e.printStackTrace();
			//Devolver código error http 500
			return new ResponseEntity<List<Videogame>>(listaVideojuegos,HttpStatus.INTERNAL_SERVER_ERROR);
		}	
	}

	@Override
	@Transactional(readOnly = true)
	public ResponseEntity<Optional<Videogame>> buscarVideojuego(Long id) {
		LOGGER.info("Inicio método buscarVideojuego()");
		Optional<Videogame> videogame = null;
		try {
			videogame = videoGameDao.findById(id);
			return new ResponseEntity<Optional<Videogame>>(videogame,HttpStatus.OK);
		} catch (Exception e) {
			LOGGER.error("Error al consultar el videojuego", e);
			e.printStackTrace();
			return new ResponseEntity<Optional<Videogame>>(videogame,HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}
}
