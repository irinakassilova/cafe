package com.example.cafe.controller;

import com.example.cafe.model.User;
import com.example.cafe.repository.UserRepository;
import com.example.cafe.service.UserService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/manager")
@AllArgsConstructor
public class ManagerController {
    private final UserService service;
    private final UserRepository userRepository;

    @GetMapping
    public List<User> userList() {
        return userRepository.findAll();
//        return "userList";
//    }
//
//    @GetMapping("{user}")
//    public String userEdit(@PathVariable User user, Model model) {
//        model.addAttribute("user", user);
//        return "userEdit";
//    }
//
//    @PostMapping("{user}")
//    public String saveUserAfterEdit(@RequestParam String email,
//                                    @RequestParam String role, @PathVariable User user) {
//        user.setRole(role);
//        user.setEmail(email);
//        userRepository.save(user);
//        return "redirect:/manager";
//    }
    }
}