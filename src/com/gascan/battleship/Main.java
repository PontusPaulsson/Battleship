package com.gascan.battleship;

import java.util.Scanner;

public class Main {
    static Scanner sc = new Scanner(System.in);

    public static void main(String[] args) {
        // write your code here
        BattleShip battleShip = new BattleShip();
        System.out.println("Welcome to the Battleship! 7x7 GRID");
        while (true) {
            battleShip.printPlayGround();
            System.out.print("Please enter a grid (Example B3): ");
            System.out.println(battleShip.checkYourSelf(sc.next()));
        }
    }
}
