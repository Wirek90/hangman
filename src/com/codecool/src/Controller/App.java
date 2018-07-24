package com.codecool.src.Controller;
import java.util.Collections;
import com.codecool.src.View.*;
import com.codecool.src.Model.*;

public class App {

    String word;
    String userGuess;
    Menu gameMenu = new Menu();


    public void startGame(){
        String choice = gameMenu.askToPlay();
        if (choice.equals("N")) {
            System.exit(0);
        }
    }

    public void playGame() {
        RandomWordsGenerator randomWord = new RandomWordsGenerator();
        word = randomWord.chooseDifficulty("easy");
        userGuess = String.join("", Collections.nCopies(word.length(), "_ "));
        System.out.println(userGuess);


    }



}