package com.codecool.src.Controller;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;

public class Highscore {

    public  void writeToFile(String player, int score) {

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
    public void readFile(int gameScore) {

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
                if(Integer.parseInt(listOfTopPlayer[i]) < gameScore){
                    //zapisz najwyższy
                }
                else {
                    //nic
                }
            }
        }

    }


}
