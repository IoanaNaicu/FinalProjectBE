package com.sda.animal_adoption.service;

import com.sda.animal_adoption.model.Meeting;
import com.sda.animal_adoption.repository.MeetingRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class MeetingService {
    MeetingRepository meetingRepository;

    @Autowired
    public MeetingService(MeetingRepository meetingRepository) {
        this.meetingRepository = meetingRepository;
    }

    public Meeting findMeetingById(Long id){
        return  meetingRepository.findById(id).get();
    }

    public void save(Meeting meeting){
        meetingRepository.save(meeting);
    }
}
