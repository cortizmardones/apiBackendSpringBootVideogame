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

	// ###################### CREATE ######################
	@Override
	@Transactional
	public ResponseEntity<String> guardarVideojuego(String nombre, Double precio , int id_categoria) {
		LOGGER.info("Inicio método guardarVideojuego()");
		try {
			// El campo id lo paso como nulo ya que el parametro id del entity Videogame es autogenerado por JPA y por MYSQL.
			videogame.setNombre(nombre);
			videogame.setPrecio(precio);
			videogame.setId_categoria(id_categoria);
			videoGameDao.save(videogame);
			return new ResponseEntity<String>("Videojuego guardado exitosamente", HttpStatus.OK);
		} catch (Exception e) {
			LOGGER.error("Error al guardar videojuego - parámetros: Nombre: " + nombre + " , Precio: " + precio, e);
			e.printStackTrace();
			return new ResponseEntity<String>("", HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}

	@Override
	@Transactional
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

	// ###################### READ ######################
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
			return videogame.isPresent() ? new ResponseEntity<Optional<Videogame>>(videogame, HttpStatus.OK) : new ResponseEntity<Optional<Videogame>>(videogame, HttpStatus.NOT_FOUND);
		} catch (Exception e) {
			LOGGER.error("Error al consultar el videojuego", e);
			e.printStackTrace();
			return new ResponseEntity<Optional<Videogame>>(videogame, HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}

	// ###################### UPDATE ######################
	@Override
	@Transactional
	public ResponseEntity<String> actualizarVideojuegoBody(Videogame videogame) {
		LOGGER.info("Inicio método actualizarVideojuegoBody()");
		try {
			// Busco primero si existe el videojuego previamente en la BDD.
			Optional<Videogame> videojuegoBuscado = videoGameDao.findById(videogame.getId());

			if (videojuegoBuscado.isPresent()) {
				videoGameDao.save(videogame);
				return new ResponseEntity<String>("Videojuego actualizado exitosamente", HttpStatus.OK);
			} else {
				return new ResponseEntity<String>("Videojuego NO encontrado en los registros", HttpStatus.NOT_FOUND);
			}

		} catch (Exception e) {
			LOGGER.error("Error al actualizar videojuego", e);
			e.printStackTrace();
			return new ResponseEntity<String>("", HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}

	// ###################### DELETE ######################
	@Override
	@Transactional
	public ResponseEntity<String> eliminarVideojuego(Long id) {
		LOGGER.info("Inicio método eliminarVideojuego()");
		try {
			// Busco primero si existe el videojuego previamente en la BDD.
			Optional<Videogame> videojuegoBuscado = videoGameDao.findById(id);

			if (videojuegoBuscado.isPresent()) {
				videoGameDao.deleteById(id);
				return new ResponseEntity<String>("Videojuego eliminado exitosamente", HttpStatus.OK);
			} else {
				return new ResponseEntity<String>("Videojuego NO encontrado en los registros", HttpStatus.NOT_FOUND);
			}

		} catch (Exception e) {
			LOGGER.error("Error al eliminar videojuego", e);
			e.printStackTrace();
			return new ResponseEntity<String>("", HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}
}
