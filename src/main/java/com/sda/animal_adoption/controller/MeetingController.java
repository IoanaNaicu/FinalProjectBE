package com.sda.animal_adoption.controller;

import com.sda.animal_adoption.model.Meeting;
import com.sda.animal_adoption.service.AnimalService;
import com.sda.animal_adoption.service.MeetingService;
import com.sda.animal_adoption.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.sql.Date;
import java.time.LocalDate;
import java.util.Calendar;

@RestController
@RequestMapping("/meeting")
public class MeetingController {

    MeetingService meetingService;
    UserService userService;
    AnimalService animalService;

    @Autowired
    public MeetingController(MeetingService meetingService, UserService userService, AnimalService animalService) {
        this.meetingService = meetingService;
        this.userService = userService;
        this.animalService = animalService;
    }

    @PostMapping("/createMeeting")
    @CrossOrigin("*")
    public void createMeeting(@RequestParam(name = "idUser") Long idUser,@RequestParam(name = "idAnimal") Long idAnimal){
        Meeting meeting = new Meeting();
        meeting.setDate(new java.sql.Date(Calendar.getInstance().getTime().getTime()));
        meeting.setAnimal(animalService.findAnimalById(idAnimal));
        meeting.setUser(userService.findUserById(idUser));
        meetingService.save(meeting);
    }
}
