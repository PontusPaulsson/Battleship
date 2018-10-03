package com.gascan.battleship;


import java.util.ArrayList;

public class BattleShip {
    ArrayList<String> guessedNumbers;
    int[][] locationCell = new int[7][7];
    int numberOfTotalGuesses = 0;
    int hitMarker = 0;

    public BattleShip(){
       guessedNumbers = new ArrayList<>();
        initializePlayGround();
        setLocationCells();
        setLocationCells();
        setLocationCells();
    }

    String checkYourSelf(String guess) {
        numberOfTotalGuesses++;

        int numberGuess = Integer.parseInt(guess.substring(1));
        int squareGuess = 8;
        for (String guessedNumber : guessedNumbers) {
            if(guessedNumber.equals(guess)){
                return "You've already guessed " + guess + ". Guess again!";
            }
        }
        guessedNumbers.add(guess);
        switch (guess.substring(0,1)) {
            case "A":
                squareGuess = 0;
                break;
            case "B":
                squareGuess = 1;
                break;
            case "C":
                squareGuess = 2;
                break;
            case "D":
                squareGuess = 3;
                break;
            case "E":
                squareGuess = 4;
                break;
            case "F":
                squareGuess = 5;
                break;
            case "G":
                squareGuess = 6;
                break;
        }
        if (locationCell[squareGuess][numberGuess] == 1) {
            locationCell[squareGuess][numberGuess] = 2;
            hitMarker++;
            if(hitMarker == 3){
                return "You sank boat number 1!";
            } else if(hitMarker == 6){
                return "You sank boat number 2!";
            } else if(hitMarker == 9){
                System.out.println("You sank boat number 3! YOU WON THE GAME! You completed the game on a total of " + numberOfTotalGuesses + " guesses!");
                System.exit(0);
            }
            return "Hit";
        }
        return "Miss";

    }

    void setLocationCells() {
        int upOrDown = (int) (Math.random() * 2);
        int tal1 = (int) (Math.random() * 5);
        int tal2 = (int) (Math.random() * 5);

        if (upOrDown == 0) {
            while (true) {
                if (locationCell[tal1][tal2] == 0 && locationCell[tal1][tal2 + 1] == 0 && locationCell[tal1][tal2 + 2] == 0) {
                    locationCell[tal1][tal2] = 1;
                    locationCell[tal1][tal2 + 1] = 1;
                    locationCell[tal1][tal2 + 2] = 1;
                    break;
                }
                tal1 = (int) (Math.random() * 5);
                tal1 = (int) (Math.random() * 5);
            }
        }else {
            while (true) {
                if (locationCell[tal2][tal1] == 0 && locationCell[tal2 + 1][tal1] == 0 && locationCell[tal2 + 2][tal1] == 0) {
                    locationCell[tal2][tal1] = 1;
                    locationCell[tal2 + 1][tal1] = 1;
                    locationCell[tal2 + 2][tal1] = 1;
                    break;
                }
                tal1 = (int) (Math.random() * 5);
                tal1 = (int) (Math.random() * 5);
            }
        }
    }

    void initializePlayGround() {
        int row = 6;
        int col = 6;
        for (int i = 0; i <= col; i++) {
            for (int j = 0; j <= row; j++) {
                locationCell[row][col] = 0;
            }
        }
    }

    void printPlayGround() {
        int row = 6;
        int col = 6;
        for (int i = 0; i <= col; i++) {
            for (int j = 0; j <= row; j++) {
                if (j == 6) {
                    System.out.print(locationCell[i][j] + "\n");
                } else {
                    System.out.print(locationCell[i][j] + " ");
                }

            }
        }
    }
}
