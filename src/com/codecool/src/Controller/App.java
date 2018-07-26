package com.codecool.src.Controller;

import java.util.ArrayList;
import java.util.Collections;

import com.codecool.src.View.*;
import com.codecool.src.Model.*;

public class App {

    private Menu menuObject = new Menu();
    private GameView viewObject = new GameView();
    private int errors = 0;
    private int maxErrors = 7; // arbitralnie
    private String[] userGuessArr;
    private String[] wordArr;
    private String userInput = "";
    private ArrayList <String> usedLetters;
    boolean playerWon;
    int gameScore;
    private HangMan hangManObject = new HangMan();


    public void playHangmanPRO() {

        while (!userInput.equals("0")) {
            startGame();
            prepareGame();
            playGame();
            finishGame();
        }
        System.exit(0);
    }



    public void startGame() {
        menuObject.welcome();
        userInput = menuObject.askToPlay();
        userInput = (userInput.equals("N"))? "0" : "";
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
    }



    public void playGame() {
        String userInput = "";
        while (!userInput.equals("0")) {

            viewObject.printArrayAsString(userGuessArr);
            boolean match = false;
            userInput = menuObject.getLetterFromUser();
            if (usedLetters.contains(userInput)) {
                viewObject.informLetterUsed();

            } else {

                for (int i = 0; i < wordArr.length; i++) {
                    if (userInput.equals(wordArr[i])) {
                        userGuessArr[i] = userInput + " ";
                        match = true;
                    }
                }


            if (!match) {
                errors += 1;
                HangMan.hangmanImage(wordArr.toString() ,errors);
                //draw hangman(errors);
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
    }



//        for(int i = 0; i < listOfTopPlayer.length; i++ ){
//            if(i%2 != 0){
//                System.out.println(listOfTopPlayer[i]);
//                if(listOfTopPlayer[i] < scoreGame){
//                    //zapisz najwyższy
//                }
//                else {
//                    //nic
//                }
//            }
//        }

public void finishGame() {
        if (playerWon) {
            viewObject.informOfSuccess();
        } else if (!playerWon) {
            viewObject.informOfFailure();
        }
     }



    public boolean guessIsCorrect() {
            String wordString = arrayToString(wordArr);
            String userGuessString = arrayToString(userGuessArr).replaceAll("\\s","");

            return wordString.equals(userGuessString);
        }



    public String arrayToString(String[] arr) {
        StringBuilder str = new StringBuilder();

        for (String element : arr) {
            str.append(element);
        }
        return str.toString();
    }
}
