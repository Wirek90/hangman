package com.codecool.src.View;
import java.io.Console;
import java.util.Scanner;



public class Menu {
    Scanner input = new Scanner(System.in);

    public void welcome() {
        System.out.println(ConsoleColors.YELLOW_BOLD + "                                   WELCOME TO");
        System.out.println(
                " __    __       ___      .__   __.   _______ .___  ___.      ___      .__   __. \n" +
                        "|  |  |  |     /   \\     |  \\ |  |  /  _____||   \\/   |     /   \\     |  \\ |  | \n" +
                        "|  |__|  |    /  ^  \\    |   \\|  | |  |  __  |  \\  /  |    /  ^  \\    |   \\|  | \n" +
                        "|   __   |   /  /_\\  \\   |  . `  | |  | |_ | |  |\\/|  |   /  /_\\  \\   |  . `  | \n" +
                        "|  |  |  |  /  _____  \\  |  |\\   | |  |__| | |  |  |  |  /  _____  \\  |  |\\   | \n" +
                        "|__|  |__| /__/     \\__\\ |__| \\__|  \\______| |__|  |__| /__/     \\__\\ |__| \\__| \n" +
                        "                                                                                " +
                        ConsoleColors.RESET
                );
    }

    public String askToPlay() {
        System.out.println("Would you like to start a new game? Y/N");
        String choice = "";
        System.out.println();

            while (!choice.equals("0")) {
                choice = input.nextLine().toUpperCase();
                if (choice.equals("Y") || choice.equals("N") || choice.equals("0")){
                    return choice;
                } else {
                    System.out.println("Please enter only Y to play or N to quit");
                }
            }

        return choice;
    }



    public String chooseDifficulty() {
    // ask the user about the level of difficulty


        System.out.println("Choose the difficulty");
        System.out.println("1. easy, 2. medium, 3. hard");
        String lvl = "";

        while (!lvl.equals("0")) {
        lvl = input.nextLine();
        System.out.println("Choose the difficulty\n");
        System.out.println("1. easy, 2. medium, 3. hard\n");

        switch (lvl) {
            case ("0"):
                  System.out.printf("Goodbye\n");
                return lvl;
            case ("1"):
                lvl = "easy";
                System.out.printf("You choose %s. You're weak!", lvl);
                return lvl;
            case ("2"):
                lvl = "medium";
                System.out.printf("You choose %s. Not bad", lvl);
                return lvl;
            case ("3"):
                lvl = "hard";
                System.out.printf("You choose %s. You like Dark Souls?", lvl);
                return lvl;
            default:
                System.out.println("bad input");

        }
            }
        return lvl;
     }

     public String playAgain() {

        System.out.println("If you want to continue press 1 or press 0 and DIE!");
        String choicePlayAgain = "";
        System.out.println();

        while (!choicePlayAgain.equals("0")) {
            choicePlayAgain = input.nextLine();
            if (choicePlayAgain.equals("1")){
                return choicePlayAgain;
            } else if (choicePlayAgain.equals("0")) {
                System.out.println("Please enter only Y to play or N to quit");
            } else {
                System.out.printf("Bad input you moron. Go commit sudoku!");
            }
        }

        return choicePlayAgain;
    }

    public String getLetterFromUser() {
        System.out.println("Guess a letter\n");
        String choice = "";

            while (!choice.equals("0")) {
                choice = input.nextLine().toLowerCase();
                if (choice.matches("^[a-zA-Z]*$") && choice.length() == 1) {
                    return choice;
                } else {
                    System.out.println("Please enter only one letter. No numbers or Polish letters allowed!\n");
                }
            }

        return choice;

    }



}

