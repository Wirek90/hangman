package com.codecool.src.Controller;
import java.util.Collections;
import java.util.Arrays;
import com.codecool.src.View.*;
import com.codecool.src.Model.*;

public class App {

    String[] wordArr;
    String[] userGuessArr;
    int errors = 0;
    int maxErrors = 7; // arbitralnie
    Menu gameMenu = new Menu();
    GameView view = new GameView();

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
        wordArr = randomWord.chooseDifficulty("easy").split("");
        userGuessArr = String.join("", Collections.nCopies(wordArr.length, "__ ,")).split(","); //create an arr
        view.printArrayAsString(userGuessArr);

        while (errors < maxErrors ) {// we have to choose max number of errors. Maybe depending on the difficulty?
            boolean match = false;
            String userInput = gameMenu.getLetterFromUser();
            for (int i = 0; i < wordArr.length; i++) {
                if (userInput.equals(wordArr[i])) {
                    userGuessArr[i] = userInput + " ";
                    match = true;
                }

            }
            view.printArrayAsString(userGuessArr);
            if (!match) {
                errors += 1;
                System.out.print(errors);
            }


        }



    }



}