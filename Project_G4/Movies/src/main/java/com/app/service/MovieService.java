package com.app.service;

import com.app.model.MoviesModel;

public interface MovieService {
	public MoviesModel addCharacter(MoviesModel character);
	public MoviesModel getById(int id);

}
