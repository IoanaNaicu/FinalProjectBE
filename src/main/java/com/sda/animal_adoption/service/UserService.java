package com.sda.animal_adoption.service;

import com.sda.animal_adoption.model.User;
import com.sda.animal_adoption.repository.user.UserRepository;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class UserService {
//    private MyInterface myInterface;
    private UserRepository userRepository;

    @Autowired
    public UserService(UserRepository userRepository){
        this.userRepository = userRepository;
    }

    public List<User> findAll(){
        return (List<User>) userRepository.findAll();
    }


    public void deleteUser(Long id){
        userRepository.deleteById(id);
    }

    public User findUserById(Long id){
        return userRepository.findById(id).orElseThrow(() -> new NullPointerException("user does not exist"));
    }

    public void updateUser(Long id, User user)  {
        User existingUser = userRepository.findById(id).orElseThrow(() -> new NullPointerException("user does not exist"));

        BeanUtils.copyProperties(user, existingUser, "id");
        userRepository.save(existingUser);
    }

    public List<User> findAllByFirstNameAndLastName(String firstName, String lastName){
        return userRepository.findAllByFirstNameAndLastName(firstName, lastName);

    }

    public List<User> findAllUsersWithGivenInitial(String initial) {
        List<User> users = (List<User>) userRepository.findAll();
        List<User> usersWithInitial = users.stream()
                .filter(e -> e.getFirstName().startsWith(initial))
                .collect(Collectors.toList());
        return usersWithInitial;
    }

//    private UserRepositorysFake userRepositorysFake;
//
//    @Autowired
//    public UserService(UserRepositorysFake userRepositorysFake) {
//        this.userRepositorysFake = userRepositorysFake;
//    }

//    public List<User> findAll() {
//        return userRepositorysFake.findAll();
//    }

//    public void saveUser(User user) {
//        userRepositorysFake.saveUser(user);
//    }
//
//    public void deleteUser(Long id) {
//        userRepositorysFake.deleteUser(id);
//    }

    //sa ne intoarca toti userii care au prima litera =cu cea data la firstName
//    public List<User> findAllUsersWithGivenInitial(String initial) {
//        List<User> users = userRepositorysFake.findAll();
//        List<User> usersResult = new ArrayList<>();
//
//        for (User user : users) {
//            if (user.getFirstName().startsWith(initial)) {
//                usersResult.add(user);
//            }
//        }
//
//        return usersResult;
//    }
}
