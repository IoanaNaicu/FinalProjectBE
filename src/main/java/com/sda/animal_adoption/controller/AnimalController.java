package com.sda.animal_adoption.controller;

import com.sda.animal_adoption.model.Animal;
import com.sda.animal_adoption.service.AnimalService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class AnimalController {

    private AnimalService animalService;

    @Autowired
    public AnimalController(AnimalService animalService) {
        this.animalService = animalService;
    }

    @GetMapping("/findAllAnimals")
    @CrossOrigin("*")
    public List<Animal> findAllAnimals(){
        return animalService.findAllAnimals();
    }

    @PostMapping("/save")
    @CrossOrigin("*")
    public void saveAnimal(@RequestBody Animal animal) {
        animalService.saveAnimal(animal);
    }

    @GetMapping("/edit/{id}")
    @CrossOrigin("*")
    public Animal getEditAnimal(@PathVariable Long id){
      return animalService.findAnimalById(id);
    }

    @DeleteMapping("/deleteAnimal/{id}")
    @CrossOrigin("*")
    public void deleteAnimal(@PathVariable Long id){
        animalService.deleteAnimal(id);
    }

    @PutMapping("/edit/{id}")
    @CrossOrigin("*")
    public void updateAnimal(@PathVariable Long id, @RequestBody Animal animal){
        animalService.updateAnimal(id, animal);
    }



}
