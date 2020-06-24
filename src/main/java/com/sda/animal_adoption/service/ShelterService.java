package com.sda.animal_adoption.service;

import com.sda.animal_adoption.repository.ShelterRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

//@Service
public class ShelterService {
    private ShelterRepository shelterRepository;

  //  @Autowired
    public ShelterService(ShelterRepository shelterRepository) {
        this.shelterRepository = shelterRepository;
    }
}
