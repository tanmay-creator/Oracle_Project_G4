package com.app.model;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "Character")
@Data
@AllArgsConstructor(staticName = "abc")
@NoArgsConstructor
public class CharacterModel {
	@Id
	private int charId;
	private String charName;
	
}
