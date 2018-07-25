
package com.codecool.src.Controller;
import java.io.*;
import java.util.Collections;
import java.util.Scanner;

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


}
