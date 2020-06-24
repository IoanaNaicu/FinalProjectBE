package com.sda.animal_adoption.repository.user;

import com.sda.animal_adoption.model.User;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface UserRepository extends CrudRepository<User, Long>{
    List<User> findAllByFirstNameAndLastName(String firstName, String lastName);

    @Query("Select a from User a where a.firstName=:firstName")
    List<User> findAllByFirstName(@Param("firstName") String firstName);

}
