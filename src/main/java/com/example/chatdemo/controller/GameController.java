package com.example.chatdemo.controller;


import com.example.chatdemo.model.Dice;
import com.example.chatdemo.model.UserAccount;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.List;

@Controller
public class GameController {


    @GetMapping("api/v1/get-dice-value")
    public String rollTheDice(){
        Dice d = new Dice(1);
        return d.roll_the_dice().toString();
    }


}
