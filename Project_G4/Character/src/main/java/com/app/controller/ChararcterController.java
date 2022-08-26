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

import com.app.model.CharacterModel;
import com.app.service.CharacterService;

@RestController
@RequestMapping("/api")
public class ChararcterController {
	@Autowired
	CharacterService charserv;
	
	@PostMapping("/character")
	public ResponseEntity<CharacterModel> addChar(@RequestBody CharacterModel charModel)
	{
		return new ResponseEntity<>(charserv.addCharacter(charModel), HttpStatus.CREATED);
	}
	
//	@GetMapping("/character/{id}")
//	public CharacterModel getCharById(@PathVariable(name="id") int id)
//	{
//		return charserv.getById(id);
//	}
	
	@GetMapping("/character/{id}")
	public ResponseEntity<CharacterModel> getById(@PathVariable(name="id") int id){
		 return new ResponseEntity<>(charserv.getById(id),HttpStatus.OK);
	}
	
}
