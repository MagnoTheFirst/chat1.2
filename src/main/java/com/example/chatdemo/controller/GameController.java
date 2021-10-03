package com.example.chatdemo.controller;


import com.example.chatdemo.model.Dice;
import com.example.chatdemo.model.UserAccount;
import com.example.chatdemo.services.DiceService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;

import java.util.List;

@Controller
public class GameController {

    private final DiceService diceService;

    public GameController(DiceService diceService) {
        this.diceService = diceService;
    }

    @GetMapping("api/v1/get-dice-value")
    public String rollTheDice(Model model){
        model.addAttribute("dice", diceService.getDice());
        return "dice-value";
    }




}
