package com.app.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.app.model.CharacterModel;

@Repository
public interface CharacterRepo extends JpaRepository<CharacterModel,Integer>,CrudRepository<CharacterModel,Integer> {
//	public CharacterModel findByCharId(int id);
}
