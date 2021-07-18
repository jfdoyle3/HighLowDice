package com.company;

import java.util.Scanner;

public class Main {

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);
        boolean didWin;
        int winsCount = 0;

        Die die1 = new Die();
        Die die2 = new Die();

        do {
            didWin = false;
            die1.roll();
            die2.roll();
            int total = die1.faceUpValue + die2.faceUpValue;

            System.out.println(die1.faceUpValue + " + " + die2.faceUpValue + " = " + (total));

            System.out.println("Will the next number be (h)igher or (l)ower?");
            String input = scanner.next();

            die1.roll();
            die2.roll();
            int newTotal = die1.faceUpValue + die2.faceUpValue;

            if (total == newTotal)
                System.out.println("same number you lose");


            boolean isLarger = newTotal > total;
            System.out.println(die1.faceUpValue + " + " + die2.faceUpValue + " = " + (newTotal));

            System.out.println(isLarger ? "Number is higher" : "Number is lower");

            if (input.equals("h")) { //guessed higher
                if (isLarger) {
                    didWin = true;
                }
            } else { //guessed lower
                if (!isLarger) {
                    didWin = true;
                }
            }
            if (didWin) {
                System.out.println("You Win");
                winsCount++;
            } else {
                System.out.println("You Lose");
            }


        } while (didWin);

        System.out.printf("Consecutive wins: %d", winsCount);
    }

}
