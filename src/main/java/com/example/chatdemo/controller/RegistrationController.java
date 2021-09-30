package com.example.chatdemo.controller;

import com.example.chatdemo.model.User;
import com.example.chatdemo.model.UserAccount;
import com.example.chatdemo.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;


@RestController
@RequestMapping(path="api/v1/")
public class RegistrationController {

    private final UserService userService;

    @Autowired
    public RegistrationController(UserService userService) {

        this.userService = userService;

    }

    @GetMapping("/user_reg")
    public String showRegistrationForm(Model model){
        UserAccount user = new UserAccount();
        model.addAttribute("user", user);

        return "registration";
    }

    @GetMapping("/users")
    public List<UserAccount> getStock(){
        return userService.getUsers();
    }

    @PostMapping
    public void addNewUser(@RequestBody UserAccount user){
        userService.addNewUser(user);
    }



}
