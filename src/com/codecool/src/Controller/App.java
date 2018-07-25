package com.codecool.src.Controller;
import java.util.Collections;
import com.codecool.src.View.*;
import com.codecool.src.Model.*;

public class App {

    private String[] wordArr;
    private int errors = 0;
    private int maxErrors = 7; // arbitralnie
    private Menu menuObject = new Menu();
    private GameView viewObject = new GameView();



    public void startGame() {
        menuObject.welcome();
        String choice = menuObject.askToPlay();
        if (choice.equals("N")) {
            System.exit(0);
        }
    }


    public void playGame() {
        RandomWordsGenerator randomWord = new RandomWordsGenerator();
        String lvl = menuObject.chooseDifficulty();
        wordArr = randomWord.chooseDifficulty(lvl).split("");
        String[] userGuessArr;
        userGuessArr = String.join("", Collections.nCopies(wordArr.length, "__ ,")).split(",");
        viewObject.printArrayAsString(userGuessArr);

        if (getUserToPlayAndCheckIfTheyWon(wordArr, userGuessArr)) {
            viewObject.informOfSuccess();
        } else {
            viewObject.informOfFailure();
        }
    }


    public boolean getUserToPlayAndCheckIfTheyWon(String[] wordArr, String[] userGuessArr){
        while (errors < maxErrors) {

            boolean match = false;
            String userInput = menuObject.getLetterFromUser();

            for (int i = 0; i < wordArr.length; i++) {
                if (userInput.equals(wordArr[i])) {
                    userGuessArr[i] = userInput + " ";
                    match = true;
                }
            }

            viewObject.printArrayAsString(userGuessArr);

            if (!match) {
                errors += 1;
                //draw hangman(errors);
            }

            if (isEqual(wordArr, userGuessArr)) {
                return true;
            }
        }
        return false;
    }




    public boolean isEqual(String[] wordArr, String[] userGuessArr) {
            String word = arrayToString(wordArr);
            String userGuess = arrayToString(userGuessArr).replaceAll("\\s","");

            return word.equals(userGuess);

        }

    public String arrayToString(String[] arr) {
        StringBuilder str = new StringBuilder();

        for (String element : arr) {
            str.append(element);
        }
        return str.toString();
    }
}