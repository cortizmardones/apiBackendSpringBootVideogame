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
	private Videogame videogame;
	
	@Autowired
	private IVideoGameDao videoGameDao;

	@Override
	@Transactional(readOnly = true)
	public ResponseEntity<List<Videogame>> listarVideojuegos() {
		LOGGER.info("Inicio método listarVideojuegos()");
		List<Videogame> listaVideojuegos = null;
		try {
			listaVideojuegos = (List<Videogame>) videoGameDao.findAll();
			return new ResponseEntity<List<Videogame>>(listaVideojuegos, HttpStatus.OK);
		} catch (Exception e) {
			LOGGER.error("Error al consultar la lista de videojuegos", e);
			e.printStackTrace();
			return new ResponseEntity<List<Videogame>>(listaVideojuegos, HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}

	@Override
	@Transactional(readOnly = true)
	public ResponseEntity<Optional<Videogame>> buscarVideojuego(Long id) {
		LOGGER.info("Inicio método buscarVideojuego()");
		Optional<Videogame> videogame = null;
		try {
			videogame = videoGameDao.findById(id);
			return videogame.isPresent() ? new ResponseEntity<Optional<Videogame>>(videogame, HttpStatus.OK)
					: new ResponseEntity<Optional<Videogame>>(videogame, HttpStatus.NOT_FOUND);
		} catch (Exception e) {
			LOGGER.error("Error al consultar el videojuego", e);
			e.printStackTrace();
			return new ResponseEntity<Optional<Videogame>>(videogame, HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}

	@Override
	public ResponseEntity<String> guardarVideojuego(String nombre, Double precio) {
		LOGGER.info("Inicio método guardarVideojuego() - Parámetros : Nombre: " + nombre + " , Precio: " + precio);
		try {
			//El campo id lo paso como nulo ya que el parametro id del entity Videogame es autogenerado por JPA y por MYSQL.
			videogame.setNombre(nombre);
			videogame.setPrecio(precio);
			videoGameDao.save(videogame);
			return new ResponseEntity<String>("Videojuego guardado exitosamente", HttpStatus.OK);
		} catch (Exception e) {
			LOGGER.error("Error al guardar videojuego - parámetros: Nombre " + nombre +  " , Precio: " + precio , e);
 			e.printStackTrace();
			return new ResponseEntity<String>("", HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}

	@Override
	public ResponseEntity<String> guardarVideojuegoBody(Videogame videogame) {
		LOGGER.info("Inicio método guardarVideojuegoBody()");
		try {
			videoGameDao.save(videogame);
			return new ResponseEntity<String>("Videojuego guardado exitosamente", HttpStatus.OK);
		} catch (Exception e) {
			LOGGER.error("Error al guardar videojuego", e);
 			e.printStackTrace();
			return new ResponseEntity<String>("", HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}
}
