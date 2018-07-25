package com.codecool.src.View;
import java.util.Scanner;



public class Menu {
    Scanner input = new Scanner(System.in);

    public void welcome() {
        System.out.println("                                   WELCOME TO");
        System.out.println(
                " __    __       ___      .__   __.   _______ .___  ___.      ___      .__   __. \n" +
                        "|  |  |  |     /   \\     |  \\ |  |  /  _____||   \\/   |     /   \\     |  \\ |  | \n" +
                        "|  |__|  |    /  ^  \\    |   \\|  | |  |  __  |  \\  /  |    /  ^  \\    |   \\|  | \n" +
                        "|   __   |   /  /_\\  \\   |  . `  | |  | |_ | |  |\\/|  |   /  /_\\  \\   |  . `  | \n" +
                        "|  |  |  |  /  _____  \\  |  |\\   | |  |__| | |  |  |  |  /  _____  \\  |  |\\   | \n" +
                        "|__|  |__| /__/     \\__\\ |__| \\__|  \\______| |__|  |__| /__/     \\__\\ |__| \\__| \n" +
                        "                                                                                "
                );
    }

    public String askToPlay() {
        System.out.println("Would you like to start a new game? Y/N");
        String choice = "";
        System.out.println();

            while (!choice.equals("0")) {
                choice = input.nextLine();
                if (choice.equals("Y") || choice.equals("N")) {
                    return choice;
                } else {
                    System.out.println("Please enter only Y to play or N to quit");
                }
            }

        return choice;
    }

    //public String chooseDifficulty() {
    // ask the user about the level of difficulty
    // }


    public String getLetterFromUser() {
        System.out.println("Enter a letter");
        String choice = "";
        System.out.println();
            while (!choice.equals("0")) {
                choice = input.nextLine();
                if (choice.matches("^[a-zA-Z]*$") && choice.length() == 1) {
                    System.out.println("IT'S A MATCH!");
                    return choice;
                } else {
                    System.out.println("Please enter only one letter. No Polish letters!");
                }
            }

        return choice;

    }
}

