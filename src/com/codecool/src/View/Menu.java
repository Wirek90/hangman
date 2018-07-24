package com.codecool.src.View;
import java.util.Scanner;



public class Menu {

    public void welcome() {
        System.out.println("WELCOME TO HANGMAN!");
    }

    public String askToPlay() {
        System.out.println("Would you like to start a new game? Y/N");
        Scanner input = new Scanner(System.in);
        String choice = "";
        System.out.println();

        while (!choice.equals("0")) {
            choice = input.nextLine();
            if (choice.equals("Y") || choice.equals("N")) {
                input.close();
                return choice;
            } else {
                System.out.println("Please enter only Y to play or N to quit");
            }
        }
        input.close();
        return choice;

    }

    //public String chooseDifficulty() {
    // ask the user about the level of difficulty
    // }


    public String getLetterFromUser() {
        Scanner input = new Scanner(System.in);
        String choice = "";
        System.out.println();

        while (!choice.equals("0")) {
            choice = input.nextLine();
            if (choice.length() == 1) {
                return choice;
            } else {
                System.out.println("Please enter only one letter or 0 to quit");
            }
        }
        return choice;
    }

}