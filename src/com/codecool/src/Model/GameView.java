package com.codecool.src.Model;

public class GameView {

    public void printArrayAsString(String[] array) {
        StringBuilder prettyArr = new StringBuilder();
        for (String element : array) {
            prettyArr.append(element);
        }
        System.out.println("\n");
        System.out.println(prettyArr);
        System.out.println("\n");
        }

     public void informOfFailure() {
        System.out.println("\nSO MANY MISTAKES...\nYOU LOST! SHAME ON YOU...\n");
     }

    public void informOfSuccess() {
        System.out.println("\nYOU WON! YAY!\n");
    }


    public void correctMatch() {
        System.out.println("\nIt's a match!\n");
    }

    public void incorrectMatch() {
        System.out.println("\nOops... Better luck next time!\n");
    }

    }

