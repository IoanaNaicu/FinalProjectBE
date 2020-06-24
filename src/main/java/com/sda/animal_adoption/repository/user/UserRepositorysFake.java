package com.sda.animal_adoption.repository.user;

import com.sda.animal_adoption.model.User;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Repository
public class UserRepositorysFake   {

    List<User> users = new ArrayList<>();

    {
        User user = new User();
        user.setId(10L);
        user.setFirstName("Ioana");

        User user1 = new User();
        user1.setId(20L);
        user1.setFirstName("Alex");

        User user2 = new User();
        user2.setId(30L);
        user2.setFirstName("Mihai");


        users.add(user);
        users.add(user1);
        users.add(user2);

    }

    public void saveUser(User user) {
        users.add(user);
    }

    public void deleteUser(Long id) {
        int index = -1;

//        for(int i = 0; i < users.size(); i++){
//            if(users.get(i).getId() != null && users.get(i).getId().equals(id)){
//                index = i;
//                break;
//            }
//        }

//        Optional<User> user = users.stream()
//                .filter(e -> e.getId().equals(id))
//                .findFirst();

        users.removeIf(user -> user.getId().equals(id));


//        if (user.isPresent()) {
//            users.remove(user.get());
//        }

//        if(index != -1) {
//            users.remove(index);
//        }
    }

    public void updateUser(Long id, User newUser) {
    }

    public void updateUserEmail(Long id, String email) {
//         users.stream()
//                .filter(e -> e.getId().equals(id))
//                .findAny()
//                .get()
//                .setEmail(email);

        for (User user : users) {
            if (user.getId().equals(id)) {
                user.setEmail(email);
            }
        }
    }

    public User getUserById(Long id) {
        for (User user : users) {
            if (user.getId().equals(id)) {
                return user;
            }
        }
        throw new NullPointerException("User does not exist ");

//        User user = users.stream()
//                .filter(e -> e.getId().equals(id))
//                .findAny()
//                .get();
//        return user;
    }

    public List<User> findAll() {
        return this.users;
    }
}
