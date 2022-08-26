package com.app.service;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.app.model.MoviesModel;
import com.app.repository.MovieRepo;

@Service
@Transactional
public class MovieServiceImpl implements MovieService {

	@Autowired
	MovieRepo movieRepo;
	
	@Override
	public MoviesModel addCharacter(MoviesModel character) {
		return movieRepo.save(character);
	}

	@Override
	public MoviesModel getById(int id) {
		Optional<MoviesModel> cc = movieRepo.findById(id);
		
		return cc.get();
	}

}
