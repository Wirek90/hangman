
package com.codecool.src.Controller;
import java.io.*;
import java.util.Collections;
import java.util.Scanner;

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
