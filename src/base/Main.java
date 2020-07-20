package base;

import java.util.ArrayList;
import java.io.InputStreamReader;
import java.util.Scanner;
import java.util.Random;

public class Main {

    public static void main(String[] args) throws Exception {

        //Declare Variables
        int number, input;
        ArrayList<Integer> triedNumbers;
        char answer;
        boolean guessed;

        InputStreamReader br;
        Random generator = new Random();
        Scanner in = new Scanner(System.in);


        while (true) {
            //Initialize some Variables for the new Game
            guessed = false;
            triedNumbers = new ArrayList<>();

            System.out.println("Welcome to the Guessing Game");
            number = generator.nextInt(100) + 1; //Generate a random Number

            do {
                System.out.println("Please enter a number between 1 and 1oo");
                input = in.nextInt(); //Read input

                //Add input to the ArrayList if it is not already in it
                if (!triedNumbers.contains(input)) {
                    triedNumbers.add(input);
                }

                //Check if the number is correct
                if (input == number) {

                    System.out.println("Yay you guessed correct!\n" +
                                       "You needed " + triedNumbers.size() + " tries!");
                    guessed = true; //Set guessed to true to stop the game

                } else if (input < number) {
                    System.out.println("The number is bigger than " + input);

                } else if (input > number) {
                    System.out.println("The number is smaller than " + input);

                } //else if()

            } while (!guessed); //Run until the number is guessed


            //Checking if the player wants to continue
            System.out.println("Do you wanna play again? (y/N)");
            br = new InputStreamReader(System.in); //Initialise the stream reader new so no old stuff is in it
            answer = (char) br.read(); //Read the char from commandline

            //Check if the user wanted to leave the game
            if (answer == 'y' | answer == 'Y') {
                System.out.println("The game goes on\n");
            } else if (answer == 'n' | answer == 'N') {
                System.out.println("Goodbye");
                break; //End game
            } else {
                System.out.println("Error: Wrong input. Stopping");
                break; //End game
            } //else

        } //while(true)
    } //public static main ()
}//public class Main
