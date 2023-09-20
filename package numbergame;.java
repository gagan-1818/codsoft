package numbergame; 
import java.util.Random;
import java.util.Scanner;

public class NumberGame {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Random random = new Random();
        
        int minnum = 1;
        int maxnum = 100;
        int maxchance= 10;
        int score = 0;
        
        System.out.println("Welcome to the Number Guessing Game");
        System.out.println("I have a number between " + minnum + " and " + maxnum);
        
        boolean playAgain = true;
        while (playAgain) {
            int targetNumber = random.nextInt(maxnum - minnum + 1) + minnum;
            int attempts = 0;
            
            System.out.println("Shall we start!");
            
            while (attempts <  maxchance) {
                System.out.print("Enter your guess: ");
                int userGuess = scanner.nextInt();
                
                if (userGuess < minnum || userGuess > maxnum) {
                    System.out.println("Please enter a number between " + minnum + " and " + maxnum);
                } else if (userGuess == targetNumber) {
                    System.out.println("Congratulations You've guessed the correct number: " + targetNumber);
                    score++;
                    break;
                } else if (userGuess < targetNumber) {
                    System.out.println("Too low! Try again.");
                } else {
                    System.out.println("Too high! Try again.");
                }
                
                attempts++;
                System.out.println("Attempts left: " + ( maxchance - attempts));
            }
            
            if (attempts ==  maxchance) {
                System.out.println("Sorry, you've run out of attempts. The correct number was: " + targetNumber);
            }
            
            System.out.print("Do you want to play again? 'yes or no' ");
            String playAgainChoice = scanner.next().toLowerCase();
            if (!playAgainChoice.equals("yes")) {
                playAgain = false;
            }
        }
        
        System.out.println("Game over! Your score is: " + score);
        scanner.close();
    }
}

