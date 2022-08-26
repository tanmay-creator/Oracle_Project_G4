package com.app.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.app.model.MoviesModel;
import com.app.service.MovieService;

@RestController
@RequestMapping("/api")
public class MovieController {
	@Autowired
	MovieService movieServ;
	
	@PostMapping("/movie")
	public ResponseEntity<MoviesModel> addChar(@RequestBody MoviesModel movieModel)
	{
		return new ResponseEntity<>(movieServ.addCharacter(movieModel), HttpStatus.CREATED);
	}
	@GetMapping("/movie/{id}")
	public ResponseEntity<MoviesModel> getById(@PathVariable(name="id") int id){
		 return new ResponseEntity<>(movieServ.getById(id),HttpStatus.OK);
	}
	

}
