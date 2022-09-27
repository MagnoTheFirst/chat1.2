package com.example.chatdemo.controller;


import com.example.chatdemo.model.Dice;
import com.example.chatdemo.model.UserAccount;
import com.example.chatdemo.services.DiceService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;

import java.util.List;

@Controller
public class GameController {

    private final DiceService diceService;
    private Dice dice;
    public GameController(DiceService diceService) {

        this.diceService = diceService;
        this.dice  = new Dice();
    }

    @GetMapping("api/v1/get-dice-value")
    public String rollTheDice(Model model){
        model.addAttribute("dice", diceService.getDice());
        return "dice-value";
    }

    @CrossOrigin(origins = "*")
    @GetMapping("api/v1/diceValue")
    public ResponseEntity<Dice> getDiceValue(){
        this.dice.roll_the_dice();
        return new ResponseEntity<Dice>(this.dice, HttpStatus.OK);
    }

}
