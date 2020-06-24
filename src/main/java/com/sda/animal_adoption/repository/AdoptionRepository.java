package com.sda.animal_adoption.repository;


import com.sda.animal_adoption.model.Adoption;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AdoptionRepository extends CrudRepository<Adoption, Long> {

}
