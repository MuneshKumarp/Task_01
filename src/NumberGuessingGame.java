import java.util.Random;
import java.util.Scanner;

public class NumberGuessingGame {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Random random = new Random();
        int minimum = 1;//Random Number Starting Range
        int maximum = 100; //Random Number Maximum Range
        int Attempts = 5; //Attempts to guess the number
        int Round = 0;
        int Score = 0;

        System.out.println("******Welcome to the Number Guessing Game!*****");

        while (true) { //This is for guessing the Random Number
            int targetNumber = random.nextInt(maximum - minimum + 1) + minimum;
            int attempts = 0;

            System.out.println("Round " + (Round + 1));
            System.out.println("Guess the number between " + minimum + " and " + maximum);

            while (attempts < Attempts) { //This Loop[ checks if attempts are available then run the game
                System.out.print("Enter your guess: ");
                int userGuess = scanner.nextInt();
                attempts++;

                if (userGuess == targetNumber) {//If user guess the correct answer
                    System.out.println("Congratulations! You guessed the correct number in " + attempts + " attempts.");
                    Score += Attempts - attempts + 1;
                    break;
                } else if (userGuess < targetNumber) {
                    System.out.println("Try a higher number.");
                } else {
                    System.out.println("Try a lower number.");
                }

                if (attempts == Attempts) {
                    System.out.println("Sorry, you've reached the maximum number of attempts. The correct number was: " + targetNumber);
                }
            }

            Round++; //If user wants to play another game then the round got +1 and start the game
            System.out.print("Do you want to play another round? (yes/no): ");
            String playAgain = scanner.next().toLowerCase();

            if (!playAgain.equals("yes")) {
                System.out.println("Game Over!");
                System.out.println("Total Rounds: " + Round);
                System.out.println("Total Score: " + Score);
                break;
            }
        }
    }
}