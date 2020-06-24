package com.sda.animal_adoption.repository;

import com.sda.animal_adoption.model.Animal;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface AnimalRepository  extends CrudRepository<Animal, Long> {
    List<Animal> findAllBySex(String sex);
    List<Animal> findAllByTypeAndRace(String type, String race);
    Animal findAllById(Long id);
}
