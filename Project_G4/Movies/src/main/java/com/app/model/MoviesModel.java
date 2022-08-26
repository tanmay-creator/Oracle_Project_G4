package com.app.model;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "Movies")
@Data
@AllArgsConstructor(staticName = "def")
@NoArgsConstructor
public class MoviesModel {
		@Id
		private int movieId;
		private String movieName;

}
