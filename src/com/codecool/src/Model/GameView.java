package com.codecool.src.Model;

public class GameView {

    public void printArrayAsString(String[] array) {
        StringBuilder prettyArr = new StringBuilder();
        for (String element : array) {
            prettyArr.append(element);
        }
         System.out.println(prettyArr);

        }
    }

