package com.sda.animal_adoption.service;

import com.sda.animal_adoption.model.Animal;
import com.sda.animal_adoption.repository.AnimalRepository;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AnimalService {

    private AnimalRepository animalRepository;

    @Autowired
    public AnimalService(AnimalRepository animalRepository) {
        this.animalRepository = animalRepository;
    }

    public List<Animal> findAllAnimals() {
        return (List<Animal>) animalRepository.findAll();
    }

    public void saveAnimal(Animal animal) {
        animalRepository.save(animal);
    }

    public void deleteAnimal(Long id) {
        animalRepository.deleteById(id);
    }


    public Animal findAnimalById(Long id) {
        return animalRepository.findById(id).orElseThrow(() ->new NullPointerException("does not exist"));
    }

    public void updateAnimal(Long id, Animal animal){
        Animal existingAnimal = animalRepository.findById(id).orElseThrow(() -> new NullPointerException("does not exist"));
        BeanUtils.copyProperties(animal, existingAnimal, "id");
        animalRepository.save(existingAnimal);

        Animal animale5 = new Animal();
        Animal animale = new Animal();
        Animal animale2 = new Animal();
        Animal animale3 = new Animal();
        Animal animale4 = new Animal();
    }
}
