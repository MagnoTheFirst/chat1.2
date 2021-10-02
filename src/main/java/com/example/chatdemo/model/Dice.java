package com.example.chatdemo.model;

import java.util.Random;

public class Dice {

    int number_of_used_dices;
    int dice_value;

    //Number have to be in range 0-2
    public Dice(int number_of_used_dices) {
        number_of_used_dices = number_of_used_dices;
    }

    public Integer roll_the_dice(){
        Random random = new Random();
        Integer dice_value;
        switch (number_of_used_dices){

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


}
