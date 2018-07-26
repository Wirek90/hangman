package com.codecool.src.View;

public class GameView {


    public void printArrayAsString(String[] array) {
        StringBuilder prettyArr = new StringBuilder();
        for (String element : array) {
            prettyArr.append(element);
        }
        System.out.println(ConsoleColors.YELLOW_BOLD);
        System.out.println(prettyArr.toString().toUpperCase());
        System.out.println("\n" + ConsoleColors.RESET);
        }

    public void informOfFailure() {
        System.out.println(ConsoleColors.RED_BOLD + "SO MANY MISTAKES...\nYOU LOST! SHAME ON YOU...\n" + ConsoleColors.RESET);
     }

    public void informOfSuccess() {
        System.out.println(ConsoleColors.GREEN_BOLD + "YOU WON! YAY!\n" + ConsoleColors.RESET);
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

    public void informHintsUsed() {
        System.out.println(ConsoleColors.RED_BOLD + "\nYou've already used all available hints. You're on your own now...\n" + ConsoleColors.RESET);
    }

    public void giveHint(String letter) {
        System.out.println(ConsoleColors.GREEN_BOLD + "\nWhy don't you give \"" + letter.toUpperCase() + "\" a try.\n" +  ConsoleColors.RESET);
    }


    public void sayGoodbye() {
        System.out.println(ConsoleColors.GREEN_BOLD + "\nGoodbye... You will be missed!\n" +  ConsoleColors.RESET);
    }


    }



