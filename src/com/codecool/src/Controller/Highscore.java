package com.codecool.src.Controller;

import com.codecool.src.View.GameView;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;
import java.util.Collection;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;
import java.util.TreeMap;

public class Highscore {

    Map<Integer, String> scoreMap = new TreeMap<>();

    public  void writeToFile(String player, int score) {



        try {
            File file = new File("test.txt");

            if (file.createNewFile()){
                System.out.println("File is created!");
            }else{
                System.out.println("File already exists.");
            }

            FileWriter fw = new FileWriter(file, true);



            scoreMap.put(score, player);


            for(Map.Entry<Integer, String> entry : scoreMap.entrySet()) {
                String key = Integer.toString(entry.getKey());
                String value = entry.getValue();
                fw.write(key + value + "\n");
            }

            fw.close();

        } catch (IOException ex) {
            System.out.println("błąd zapisu");
        }
    }
    public void readFile() {

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

        String[] topPlayerArr = reading.toString().split("");

        GameView view = new GameView();

        //view.printArrayAsString(topPlayerArr);

        int score = Integer.parseInt(topPlayerArr[0]);
        String player = "";
        for(int i = 1; i < topPlayerArr.length; i++){
            player += topPlayerArr[i];
        }

        scoreMap.put(score, player);

        for(Map.Entry<Integer, String> entry : scoreMap.entrySet()) {
            Integer key = entry.getKey();
            String value = entry.getValue();
            System.out.println(key);
            System.out.print(value);
        }



    }


}
