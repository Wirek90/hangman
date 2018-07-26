package com.codecool.src.Controller;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;
import java.util.Arrays;
import java.io.BufferedWriter;


public class Highscore {



    public void writeToFile(String[] topPlayerArr) {
        File file = new File("highscore.txt");

        try {
            FileWriter fw = new FileWriter(file.getAbsoluteFile());
            BufferedWriter bw = new BufferedWriter(fw);
            for (String entry : topPlayerArr) {
                bw.write(entry + ",");
                }
            bw.close();

        } catch (IOException ex) {
            System.out.println("saving file has encountered a problem");
        }
    }



    public String[] readFile() {

        File file = new File("highscore.txt");
        StringBuilder reading = new StringBuilder();

        try {
            Scanner scan = new Scanner(file);
            reading.append(scan.nextLine());

        } catch (FileNotFoundException e) {
            System.out.println("no file");
        }

            String[] topPlayerArr = reading.toString().split(",");

            return topPlayerArr;
    }



    public boolean checkIfHighScore(int score) {
        String[] emptyArray = {"8void", "8void", "8void"};
        String[] fileArray = readFile();
        String[] topPlayerArr;

        if (fileArray.length < 3) {
            topPlayerArr = emptyArray;
        }
        else {
            topPlayerArr = fileArray;
        }

        Arrays.sort(topPlayerArr);
        for (String element : topPlayerArr) {
            if (Character.getNumericValue(element.charAt(0)) >= score) {
                return true;

            }
        }

        return false;
    }


    public void saveHighscore(int score, String player) {
        String[] emptyArray = {"8void", "8void", "8void"};
        String[] fileArray = readFile();
        String[] topPlayerArr;

        if (fileArray.length < 3) {
            topPlayerArr = emptyArray;
        }
        else {
            topPlayerArr = fileArray;
        }
        Arrays.sort(topPlayerArr);
        for (int i = 0; i < topPlayerArr.length; i++) {
            if (Character.getNumericValue(topPlayerArr[i].charAt(0)) >= score) {
                if (i == 1) {
                    topPlayerArr[2] = topPlayerArr[1];
                }
                 topPlayerArr[i] = Integer.toString(score) + player;
                 break;
            }
        }
        writeToFile(topPlayerArr);

    }


    public String[] getHighscore() {
        return readFile();
    }
}
