package com.example.davr_task.security.service;

import com.example.davr_task.security.entity.User;
import com.example.davr_task.security.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.StreamSupport;

@Service
@RequiredArgsConstructor
public class UserService {

    private BCryptPasswordEncoder encoder;


    private UserRepository userRepository;

    //Get All Users
    public List<User> findAll() {
        return StreamSupport.stream(userRepository.findAll().spliterator(), false)
                .collect(Collectors.toList());
    }

    //Get User By Id
    public User findById(Long id) {
        return userRepository.findById(id).orElse(null);
    }

    //Delete User
    public void delete(Long id) {
        userRepository.deleteById(id);
    }

    //Update User
    public void save(User user) {
        user.setPassword(encoder.encode(user.getPassword()));
        userRepository.save(user);
    }

}
