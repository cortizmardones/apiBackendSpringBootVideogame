package com.videogame.spring.model.dao;

import org.springframework.data.repository.CrudRepository;

import com.videogame.spring.model.Videogame;

public interface IVideoGameDao extends CrudRepository<Videogame, Long> {

}
