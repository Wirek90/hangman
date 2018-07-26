package com.codecool.src.Controller;

import java.util.ArrayList;
import java.util.Collections;

import com.codecool.src.View.*;
import com.codecool.src.Model.*;

public class App {

    private Menu menuObject = new Menu();
    private GameView viewObject = new GameView();
    private int errors = 0;
    private int hintsUsed = 0;
    private int maxErrors = 7; // arbitralnie
    private String[] userGuessArr;
    private String[] wordArr;
    private String userInput = "";
    private ArrayList<String> usedLetters;
    boolean playerWon;
    private HangMan hangManObject = new HangMan();


    public void playHangmanPRO() {

            startGame();
            prepareGame();
            playGame();
            finishGame();
            restartGame();
    }



    public void playAgain() {

        errors = 0;
        prepareGame();
        playGame();
        finishGame();
        restartGame();
    }



    public void startGame() {
        menuObject.welcome();
        userInput = menuObject.askToPlay();
        userInput = (userInput.equals("N")) ? "0" : "";
    }



    public void prepareGame() {
        RandomWordsGenerator randomWord = new RandomWordsGenerator();
        userInput = menuObject.chooseDifficulty();
        wordArr = randomWord.chooseDifficulty(userInput).split("");
        usedLetters = new ArrayList<String>();
        userGuessArr = String.join(
                "",
                Collections.nCopies(wordArr.length, "__ ,")
        ).split(",");
        for (int counter = 0; counter < wordArr.length; counter++){
            if (wordArr[counter].equals("-")){
                userGuessArr[counter] = "-";

            }
        }


    }



    public void playGame() {
        String userInput = "";
        while (!userInput.equals("0")) {

            viewObject.printArrayAsString(userGuessArr);
            boolean match = false;
            userInput = menuObject.getLetterFromUser();
            if (userInput.equals("1")) {
                giveAHint();
            }

            else if (usedLetters.contains(userInput)) {
                viewObject.informLetterUsed();

            } else {

                for (int i = 0; i < wordArr.length; i++) {
                    if (userInput.equals(wordArr[i])) {
                        userGuessArr[i] = userInput + " ";
                        match = true;
                    }
                }

                viewObject.printArrayAsString(userGuessArr);


                if (match) {
                    viewObject.correctMatch();

                } else if (!match) {
                    errors += 1;
                    viewObject.incorrectMatch();
                    hangManObject.hangmanImage(wordArr, errors);

                }

                if (guessIsCorrect()) {
                    playerWon = true;
                    break;
                }

                if (errors >= maxErrors) {
                    playerWon = false;
                    break;
                }

                usedLetters.add(userInput);
            }

        }
        if (userInput.equals("0")) {
            exitGame();
        }

    }



    public void finishGame() {
            if (playerWon) {
                viewObject.informOfSuccess();
            } else if (!playerWon) {
                viewObject.informOfFailure();
            }
         }



    public void restartGame() {

        userInput = menuObject.playAgain();


            if (userInput.equals("1")){
                System.out.println(errors);
                playAgain();
            } else if (userInput.equals("0")) {
                exitGame();
            }

    }



    public void exitGame() {
        System.exit(0);
    }


    public boolean guessIsCorrect() {
        String wordString = arrayToString(wordArr);
        String userGuessString = arrayToString(userGuessArr).replaceAll("\\s", "");

        return wordString.equals(userGuessString);
    }


    public String arrayToString(String[] arr) {
        StringBuilder str = new StringBuilder();

        for (String element : arr) {
            str.append(element);
        }
        return str.toString();
    }


    public void giveAHint() {
        if (hintsUsed < 3) {
            for (String letter : wordArr) {

                if (!usedLetters.contains(letter)) {
                    viewObject.giveHint(letter);
                    hintsUsed++;
                    break;
                }
            }

        } else {
            viewObject.informHintsUsed();
        }
    }

}