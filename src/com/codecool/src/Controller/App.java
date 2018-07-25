
package com.codecool.src.Controller;
import java.io.*;
import java.util.Collections;
import java.util.Scanner;

import com.codecool.src.View.*;
import com.codecool.src.Model.*;

public class App {


    private Menu menuObject = new Menu();
    private GameView viewObject = new GameView();
    private int errors = 0;
    private int maxErrors = 7; // arbitralnie
    private String[] userGuessArr;
    private String[] wordArr;
    boolean playerWon;



    public void playHangmanPRO() {
        startGame();
        prepareGame();
        playGame();
        finishGame();
    }



    public void startGame() {
        menuObject.welcome();
        String choice = menuObject.askToPlay();
        if (choice.equals("N")) {
            System.exit(0);
        }
    }



    public void prepareGame() {
        RandomWordsGenerator randomWord = new RandomWordsGenerator();
        String lvl = menuObject.chooseDifficulty();
        wordArr = randomWord.chooseDifficulty(lvl).split("");
        userGuessArr = String.join("", Collections.nCopies(wordArr.length, "__ ,")).split(",");
    }



    public void playGame() {
        String userInput = "";
        while (userInput != "0") {

            viewObject.printArrayAsString(userGuessArr);
            boolean match = false;
            userInput = menuObject.getLetterFromUser();

            for (int i = 0; i < wordArr.length; i++) {
                if (userInput.equals(wordArr[i])) {
                      userGuessArr[i] = userInput + " ";
                    match = true;
                }
            }

            viewObject.printArrayAsString(userGuessArr);

            //draw hangman(errors);
            if (match) {
                viewObject.correctMatch();

            } else if (!match) {
                errors += 1;
                viewObject.incorrectMatch();
            }

            if (guessIsCorrect()) {
                playerWon = true;
                break;
            }

            if (errors >= maxErrors) {
                playerWon = false;
                break;
            }
        }
    }

        public static void writeToFile(String player, int score) {

            try {
                File file = new File("test.txt");

                if (file.createNewFile()){
                    System.out.println("File is created!");
                }else{
                    System.out.println("File already exists.");
                }

                FileWriter fw = new FileWriter(file, true);
                fw.write(player + "," + score + ",");
                fw.close();

            } catch (IOException ex) {
               System.out.println("błąd zapisu");
            }
        }
        public static void readFile() {

        File file = new File("test.txt");
        StringBuilder reading = new StringBuilder();

        try {
            Scanner scan = new Scanner(file);
            while(scan.hasNextLine()) {
                reading.append(scan.nextLine() + "\n");
            }

        } catch (FileNotFoundException e) {
            System.out.println("brak pliku");
        }
        //System.out.println(reading.toString());

        String[] listOfTopPlayer = reading.toString().split(",");

        //System.out.println(listOfTopPlayer[1]);


        for(int i = 0; i < listOfTopPlayer.length; i++ ){
            if(i%2 != 0){
                System.out.println(listOfTopPlayer[i]);
                if(listOfTopPlayer[i] < scoreGame){
                    //zapisz najwyższy
                }
                else {
                    //nic
                }
            }
        }

    }


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
