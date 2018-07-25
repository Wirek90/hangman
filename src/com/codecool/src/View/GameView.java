package com.codecool.src.View;

public class GameView {


    public void printArrayAsString(String[] array) {
        StringBuilder prettyArr = new StringBuilder();
        for (String element : array) {
            prettyArr.append(element);
        }
        System.out.println(ConsoleColors.YELLOW_BOLD + "\n Your guess: \n");
        System.out.println(prettyArr.toString().toUpperCase());
        System.out.println("\n" + ConsoleColors.RESET);
        }

    public void informOfFailure() {
        System.out.println(ConsoleColors.RED_BOLD + "\nSO MANY MISTAKES...\nYOU LOST! SHAME ON YOU...\n" + ConsoleColors.RESET);
     }

    public void informOfSuccess() {
        System.out.println(ConsoleColors.GREEN_BOLD + "\nYOU WON! YAY!\n" + ConsoleColors.RESET);
    }

    public void correctMatch() {
        System.out.println(ConsoleColors.GREEN_BOLD + "\nIt's a match!\n");
    }

    public void incorrectMatch() {
        System.out.println(ConsoleColors.RED_BOLD + "\nOops... Better luck next time!\n" + ConsoleColors.RESET);
    }

    public void informLetterUsed() {
            System.out.println(ConsoleColors.RED_BOLD + "\nYou've already used this one. Try again!\n" + ConsoleColors.RESET);
        }
    }



