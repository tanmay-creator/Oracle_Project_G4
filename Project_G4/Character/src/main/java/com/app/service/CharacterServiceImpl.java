package com.app.service;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.app.model.CharacterModel;
import com.app.repository.CharacterRepo;

@Service
@Transactional
public class CharacterServiceImpl implements CharacterService {
	
	@Autowired
	CharacterRepo charRepo;

	@Override
	public CharacterModel addCharacter(CharacterModel character) {
		return charRepo.save(character);
	}

	@Override
	public CharacterModel getById(int charId) {
		Optional<CharacterModel> cc = charRepo.findById(charId);
		
		return cc.get();
	}




}
