package com.app.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.app.model.HdccModel;


@Repository
public interface HdccRepo extends JpaRepository<HdccModel,Integer>,CrudRepository<HdccModel,Integer> {
   public boolean existsByEkyc(long ekyc);
   public HdccModel findByEkyc(long ekyc);

}
