package com.example.exercisejpa.Service;

import com.example.exercisejpa.Model.User;
import com.example.exercisejpa.Repository.UserRepository;
import lombok.NoArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@NoArgsConstructor
public class UserService {

    private UserRepository userRepository;

    public List<User> getUser() {
        return userRepository.findAll();
    }

    public void addUser(User user) {
        userRepository.save(user);
    }

    public boolean updateUser(Integer id , User user) {
        User u = userRepository.getById(id);
        if(u==null) {
            return false;
        }
        u.setBalance(user.getBalance());
        u.setRole(user.getRole());
        u.setEmail(user.getEmail());
        u.setPrimary(user.isPrimary());
        u.setPassword(user.getPassword());
        u.setUsername(user.getUsername());
        userRepository.save(u);
        return true;
    }
    public boolean deleteUser(Integer id) {
        User u = userRepository.getById(id);
        if(u==null) {
            return false;
        }
        userRepository.delete(u);
        return true;
    }

}
