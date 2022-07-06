package com.example.davr_task.Controller;

import com.example.davr_task.DTO.LoginDTO;
import com.example.davr_task.entity.Student;
import com.example.davr_task.repository.StudentRepository;
import com.example.davr_task.security.CurrentUser;
import com.example.davr_task.security.JwtProvider;
import com.example.davr_task.security.entity.User;
import com.example.davr_task.security.repository.UserRepository;
import com.example.davr_task.security.service.AuthService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpEntity;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;


@RestController
@RequestMapping("/api/auth")

public class AuthController {


    @Autowired
    JwtProvider jwtProvider;
    @Autowired
    private AuthService authService;
    @Autowired
    private AuthenticationManager authenticationManager;

    private final UserRepository userRepository;
    private final StudentRepository studentRepository;


    public AuthController(UserRepository userRepository, StudentRepository studentRepository) {
        this.userRepository = userRepository;
        this.studentRepository = studentRepository;
    }


//    @PostMapping("/register")


    @GetMapping("/me")
    public HttpEntity<?> getUser(@CurrentUser User user) {
        return ResponseEntity.ok(user);
    }

    @PostMapping("/login")
    public HttpEntity<?> login(@RequestBody LoginDTO loginDTO) {
        Optional<Student> userr=studentRepository.findByFullName("marat");

        System.out.println(userr);
        Authentication authenticate = authenticationManager.authenticate
                (new UsernamePasswordAuthenticationToken(loginDTO.getUsername(), loginDTO.getPassword()));
        User user = (User) authenticate.getPrincipal();

        String token = jwtProvider.generateToken(loginDTO.getUsername());
        System.out.println(token);
        return ResponseEntity.ok(token);
    }


}
