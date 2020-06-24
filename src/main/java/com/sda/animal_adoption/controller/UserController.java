package com.sda.animal_adoption.controller;

import com.sda.animal_adoption.model.User;
import com.sda.animal_adoption.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/user")
public class UserController {

    private UserService userService;

    @Autowired
    public UserController(UserService userService) {
        this.userService = userService;
    }

    @GetMapping("/findAll")
    @CrossOrigin("*")
    public List<User> findAll() {
        return userService.findAll();
    }


    @GetMapping("/edit/{id}")
    @CrossOrigin("*")
    public User getUserById(@PathVariable Long id){
        return userService.findUserById(id);
    }

    @PutMapping("/edit/{id}")
    @CrossOrigin("*")
    public void updateUser(@PathVariable Long id, @RequestBody User user){
        userService.updateUser(id, user);
    }

    @DeleteMapping("/delete/{id}")
    @CrossOrigin("*")
    public void deleteUser(@PathVariable Long id) {
        userService.deleteUser(id);
    }
}
