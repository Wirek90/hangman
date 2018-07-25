package com.codecool.src.Controller;
import java.util.Collections;
import com.codecool.src.View.*;
import com.codecool.src.Model.*;

public class App {

    String word;
    String userGuess;
    Menu gameMenu = new Menu();

    public void welcomeMessage(){
        Menu MenuObject = new Menu();
        MenuObject.welcome();
    }

    public void startGame(){
        String choice = gameMenu.askToPlay();
        if (choice.equals("N")) {
            System.exit(0);
        }
    }

    public void playGame() {
        RandomWordsGenerator randomWord = new RandomWordsGenerator();
        word = randomWord.chooseDifficulty("easy");
        userGuess = String.join("", Collections.nCopies(word.length(), "_"));
        System.out.println(userGuess);
        String userInput = gameMenu.getLetterFromUser();
        String[] userGuessArr = userGuess.split("");
        String[] wordArr = word.split("");
        for (int i = 0; i < word.length(); i++) {
            if (userInput.equals(wordArr[i])) {
                userGuessArr[i] = userInput;
            }
        }

        System.out.println(userGuess);


    }



}