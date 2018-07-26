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
    private int maxErrors = 7;
    private String[] userGuessArr;
    private String[] wordArr;
    private String userInput = "";
    private ArrayList<String> usedLetters;
    private boolean playerWon;
    private HangMan hangManObject = new HangMan();
    private Highscore highScoreObject = new Highscore();


    public void playHangmanPRO() {
            prepareGame();
            playGame();
            finishGame();
            restartGame();
    }



    public void welcome() {
        menuObject.welcome();
        userInput = menuObject.askToPlay();
        if (userInput.equals("N")) {
            exitGame();
        }
        if (userInput.equals("H")) {
            viewObject.printHighScore(highScoreObject.getHighscore());
        }
    }




    private void prepareGame() {
        RandomWordsGenerator randomWord = new RandomWordsGenerator();
        userInput = menuObject.chooseDifficulty();
        wordArr = randomWord.chooseRandomWord(userInput).split("");
        usedLetters = new ArrayList<>();
        prepareGuessArr();

        if (userInput.equals("0")) {
            exitGame();
        }

    }



    private void prepareGuessArr() {
        userGuessArr = String.join(
                "",
                Collections.nCopies(wordArr.length, "__ ,"))
                .split(",");

        for (int i = 0; i < wordArr.length; i++) {
            if (wordArr[i].equals("-")) {
                userGuessArr[i] = "-";
            }
        }
    }

    private void playGame() {
        String userInput = "";
        while (!userInput.equals("0")) {


            boolean match = false;
            userInput = menuObject.getLetterFromUser();

            if (userInput.equals("0")) {
                exitGame();
            }

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



    private void finishGame() {
            if (playerWon) {
                viewObject.informOfSuccess();
                if (highScoreObject.checkIfHighScore(errors)) {
                    String userName = menuObject.getPlayerNameFromUser();
                    highScoreObject.saveHighscore(errors, userName);
                    String[] highScore = highScoreObject.readFile();
                    viewObject.printHighScore(highScore);


                }
            } else if (!playerWon) {
                viewObject.informOfFailure();
            }
         }



    private void restartGame() {

        userInput = menuObject.playAgain();


            if (userInput.equals("1")){
                resetStats();
                playHangmanPRO();

            } else if (userInput.equals("0")) {
                exitGame();
            }

    }



    private void resetStats() {
        errors = 0;
        hintsUsed = 0;
        maxErrors = 7;
        userInput = "";
        usedLetters.clear();
        playerWon = false;
    }



    private void exitGame() {
        viewObject.sayGoodbye();
        System.exit(0);
    }


    private boolean guessIsCorrect() {
        String wordString = arrayToString(wordArr);
        String userGuessString = arrayToString(userGuessArr).replaceAll("\\s", "");

        return wordString.equals(userGuessString);
    }


    private String arrayToString(String[] arr) {
        StringBuilder str = new StringBuilder();

        for (String element : arr) {
            str.append(element);
        }
        return str.toString();
    }


    private void giveAHint() {
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