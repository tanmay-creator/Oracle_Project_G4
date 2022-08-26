package com.app.service;

import com.app.model.CharacterModel;

public interface CharacterService {
	public CharacterModel addCharacter(CharacterModel character);
	public CharacterModel getById(int charId);
}
