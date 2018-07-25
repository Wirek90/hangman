package com.codecool.src;
import com.codecool.src.Controller.*;
import com.codecool.src.View.Menu;

class Main {

    public static void main(String[] args){

        App game = new App();
        Menu MenuObject = new Menu();
        MenuObject.welcome();
        game.startGame();
        game.playGame();

    }
}