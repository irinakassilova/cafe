package com.example.cafe.service;

import com.example.cafe.dto.UserDTO;
import com.example.cafe.excepion.UserAlreadyRegister;
import com.example.cafe.model.User;
import com.example.cafe.model.UserRegisterForm;
import com.example.cafe.repository.UserRepository;
import lombok.AllArgsConstructor;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.security.Principal;

@Service
@AllArgsConstructor
public class UserService {
    private final UserRepository repository;
    private final PasswordEncoder encoder;

    public UserDTO register(UserRegisterForm user){
        if (repository.existsByEmail(user.getEmail())){
            throw new UserAlreadyRegister();
        }

        var user1 = User.builder()
                .email(user.getEmail())
                .password(encoder.encode(user.getPassword()))
                .role("USER")
                .build();

        repository.save(user1);

        return UserDTO.from(user1);

    }

    public UserDTO getByEmail(String email) {
        var user = repository.findByEmail(email);
        return UserDTO.from(user);
    }
//
//    public boolean isAdmin(Principal principal) {
//        User user = repository.findByEmail(principal.getName());
//        return user.getRole().equalsIgnoreCase("admin");
//    }
//
//    public boolean isManager(Principal principal) {
//        User user = repository.findByEmail(principal.getName());
//        return user.getRole().equalsIgnoreCase("manager");
//    }

//    public UserDTO getByEmail(String email) {
//        var user = userRepository.findByEmail(email);
//
//        return UserDTO.from(user);
}



