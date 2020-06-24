package com.sda.animal_adoption.repository;

import com.sda.animal_adoption.model.Meeting;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface MeetingRepository extends CrudRepository<Meeting, Long> {

}
