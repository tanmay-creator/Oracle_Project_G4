package com.app.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.app.model.InfinityModel;

@Repository
public interface InfinityRepo extends JpaRepository<InfinityModel,Integer>,CrudRepository<InfinityModel,Integer> {
	   public boolean existsByEkyc(long ekyc);
	   public InfinityModel findByEkyc(long ekyc);

	}
