package com.example.chatdemo.model;

import java.util.Random;

public class Dice {

    public Integer dice_value;
    public Integer number_of_used_dice;


    //Number have to be in range 0-2
    public Dice(Integer number_of_used_dice) {
        number_of_used_dice = number_of_used_dice;
    }

    public Dice() {
        this.number_of_used_dice = 1;

    }

    public Integer roll_the_dice(){
        Random random = new Random();
        Integer dice_value;
        switch (number_of_used_dice){
            case 0:
                dice_value = random.nextInt(5);
                return dice_value;
            case 1:
                dice_value = random.nextInt(5);
                return dice_value;
            case 2:
                dice_value = random.nextInt(11);
                return dice_value;

            case 3:
                dice_value = random.nextInt(17);
                return dice_value;
            case 4:
                dice_value = random.nextInt(23);
                return dice_value;
        }
        return random.nextInt(5);
    }

    public int getNumber_of_used_dices() {
        return number_of_used_dice;
    }

    public void setNumber_of_used_dices(int number_of_used_dices) {
        this.number_of_used_dice = number_of_used_dices;
    }

    public int getDice_value() {
        return dice_value;
    }

    public void setDice_value(int dice_value) {
        this.dice_value = dice_value;
    }
}
