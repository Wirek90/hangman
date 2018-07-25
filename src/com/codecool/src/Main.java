package com.codecool.src;
import com.codecool.src.Controller.*;

class Main {

    public static void main(String[] args) {

        App game = new App();
        game.playHangmanPRO();

        App.writeToFile("Adam", 15);
        App.writeToFile("Tomek", 100);
        App.readFile();
    }
}