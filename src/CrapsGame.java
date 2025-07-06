import java.util.Random;
import java.util.Scanner;

public class CrapsGame {

    public static void main(String[] args) {
        // Create Scanner and Random objects
        Scanner scanner = new Scanner(System.in);
        Random random = new Random();
        String playAgain;

        do {
            // Initial roll of two dice
            int die1 = random.nextInt(6) + 1; // Generates a random int between 1 and 6
            int die2 = random.nextInt(6) + 1; // Generates a random int between 1 and 6
            int sum = die1 + die2;

            System.out.println("You rolled " + die1 + " + " + die2 + " = " + sum);

            // Check for initial win or loss
            if (sum == 7 || sum == 11) {
                System.out.println("Congratulations, you rolled a natural! You win!");
            } else if (sum == 2 || sum == 3 || sum == 12) {
                System.out.println("Sorry, you crapped out! You lose.");
            } else {
                // Continue rolling for the point
                int point = sum;
                System.out.println("The point is now " + point);

                boolean keepRolling = true;
                while (keepRolling) {
                    System.out.println("Trying for point...");
                    die1 = random.nextInt(6) + 1;
                    die2 = random.nextInt(6) + 1;
                    int rollSum = die1 + die2;

                    System.out.println("You rolled " + die1 + " + " + die2 + " = " + rollSum);

                    if (rollSum == point) {
                        System.out.println("You made the point! You win!");
                        keepRolling = false;
                    } else if (rollSum == 7) {
                        System.out.println("You rolled a 7. You lose.");
                        keepRolling = false;
                    }
                }
            }

            // Prompt user to play again
            System.out.print("\nPlay again? (yes/no): ");
            playAgain = scanner.next();

        } while (playAgain.equalsIgnoreCase("yes"));

        System.out.println("Thanks for playing!");
        scanner.close();
    }
}