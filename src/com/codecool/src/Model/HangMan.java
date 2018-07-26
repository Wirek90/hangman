package com.codecool.src.Model;

import com.codecool.src.View.GameView;

public class HangMan {

    GameView view = new GameView();

    public void hangmanImage(String[] word, int count) {
        if (count == 1) {
            System.out.println();
            System.out.println();
            System.out.println();
            System.out.println();
            System.out.println();
            System.out.println("___|___");
        }
        if (count == 2) {
            System.out.println("   |");
            System.out.println("   |");
            System.out.println("   |");
            System.out.println("   |");
            System.out.println("   |");
            System.out.println("___|___");
        }
        if (count == 3) {
            System.out.println("   ____________");
            System.out.println("   |");
            System.out.println("   |");
            System.out.println("   |");
            System.out.println("   |");
            System.out.println("   |");
            System.out.println("___|___");
        }
        if (count == 4) {
            System.out.println("   ____________");
            System.out.println("   |          |");
            System.out.println("   |          O");
            System.out.println("   |");
            System.out.println("   |");
            System.out.println("   |");
            System.out.println("___|___");
        }
        if (count == 5) {
            System.out.println("   ____________");
            System.out.println("   |          |");
            System.out.println("   |          O");
            System.out.println("   |         /|\\");
            System.out.println("   |");
            System.out.println("   |");
            System.out.println("___|___");
        }
        if (count == 6) {
            System.out.println("   ____________");
            System.out.println("   |          |");
            System.out.println("   |          O");
            System.out.println("   |         /|\\");
            System.out.println("   |          |");
            System.out.println("   |");
            System.out.println("___|___");
        }
        if (count == 7) {
            System.out.println("GAME OVER!");
            System.out.println("   ____________");
            System.out.println("   |          |");
            System.out.println("   |          O");
            System.out.println("   |         /|\\");
            System.out.println("   |          |");
            System.out.println("   |         / \\");
            System.out.println("___|___");
            System.out.println("GAME OVER! The word was ");
            view.printArrayAsString(word);
        }
    }
}