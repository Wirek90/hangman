package com.codecool.src.Controller;

import com.codecool.src.View.GameView;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;
import java.util.Arrays;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;

public class Highscore {



    public void writeToFile(String[] topPlayerArr) {
        File file = new File("highscore.txt");

        try {
            FileWriter fw = new FileWriter(file.getAbsoluteFile());
            BufferedWriter bw = new BufferedWriter(fw);
            bw.write("/n");
            for (String entry : topPlayerArr) {
                bw.write(entry + ",");
                }


            bw.close();

        } catch (IOException ex) {
            System.out.println("saving file has encountered a problem");
        }
    }


    public String[]  readFile() {

        File file = new File("highscore.txt");
        StringBuilder reading = new StringBuilder();
        System.out.println("Weszlo do readfile");

        try {
            Scanner scan = new Scanner(file);
            System.out.println("try2");
            reading.append(scan.nextLine());
            System.out.println(reading.toString());


        } catch (FileNotFoundException e) {
            System.out.println("no file");
        }

            String[] topPlayerArr = reading.toString().split(",");

            return topPlayerArr;


    }


    public boolean checkIfHighscore(int score) {
        String[] topPlayerArr = readFile();
        Arrays.sort(topPlayerArr);
        System.out.println(Arrays.toString(topPlayerArr));
        for (String element : topPlayerArr) {
            if (Character.getNumericValue(element.charAt(0)) >= score) {
                return true;

            }
        }

        return false;
    }


    public void saveHighscore(int score, String player) {
        System.out.println("Save HS 1");
        String[] emptyArray = {"8void", "8void", "8void"};
        String[] fileArray = readFile();
        String[] topPlayerArr;
        System.out.println(fileArray.length);
        if (fileArray.length < 3) {
            System.out.println(fileArray.length);
            topPlayerArr = emptyArray;
        }
        else {
            topPlayerArr = fileArray;
        }
        System.out.println("Save HS 2");
        System.out.println(Arrays.toString(topPlayerArr));
        Arrays.sort(topPlayerArr);
        System.out.println(Arrays.toString(topPlayerArr));
        for (int i = 0; i < topPlayerArr.length; i++) {
            if (Character.getNumericValue(topPlayerArr[i].charAt(0)) >= score) {
                topPlayerArr[i] = Integer.toString(score) + player;
                break;
            }
        }
        System.out.println(Arrays.toString(topPlayerArr));
        writeToFile(topPlayerArr);


    }
}
