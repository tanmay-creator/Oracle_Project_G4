package com.app.api;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import com.app.model.Characterr;
import com.app.model.Movie;
import com.app.model.PersonModel;
import com.app.model.PersonResponse;

@RestController
public class PersonApi {
	@Autowired
	private RestTemplate restTemplate;
	
	@PostMapping(path = "details")
	public ResponseEntity<PersonResponse> getDetails(@RequestBody  PersonModel details) {
			Characterr ch = restTemplate
					.getForObject("http://localhost:8091/characterApp/api/character/"+details.getCharId(), Characterr.class);
			
			Movie moovie = restTemplate
					.getForObject("http://localhost:8092/movieApp/api/movie/"+details.getMovieId(), Movie.class);
			
			PersonResponse person = new PersonResponse();
			person.setName(details.getName());
			person.setCharacter(ch);
			person.setMovie(moovie);
			 return ResponseEntity.status(HttpStatus.CREATED).body(person);
			
	}
}
