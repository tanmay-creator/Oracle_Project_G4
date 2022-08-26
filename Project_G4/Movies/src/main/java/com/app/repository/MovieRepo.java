package com.app.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.app.model.MoviesModel;

@Repository
public interface MovieRepo extends JpaRepository<MoviesModel,Integer>,CrudRepository<MoviesModel,Integer> {

}
