package com.sda.animal_adoption.service;

import com.sda.animal_adoption.model.Adoption;
import com.sda.animal_adoption.repository.AdoptionRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class AdoptionService {
    AdoptionRepository adoptionRepository;

    @Autowired
    public AdoptionService(AdoptionRepository adoptionRepository) {
        this.adoptionRepository = adoptionRepository;
    }

    public Adoption findById(Long id){
        return adoptionRepository.findById(id).get();
    }

    public void save(Adoption adoption){
        adoptionRepository.save(adoption);
    }

    //todo
    public void updateAnimal(){

    }
}
