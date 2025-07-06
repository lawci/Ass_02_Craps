import java.util.Random;
import java.util.Scanner;

public class CrapsGameD {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Random rnd = new Random();
        boolean playAgain = true;

        System.out.println("Welcome to the Craps Game!");

        while (playAgain) {
            playCrapsGame(scanner, rnd);
            System.out.print("Would you like to play again? (y/n): ");
            String response = scanner.next();
            playAgain = response.equalsIgnoreCase("y");
        }

        System.out.println("Thanks for playing Craps!");
        scanner.close();
    }

    private static void playCrapsGame(Scanner scanner, Random rnd) {
        // Initial roll
        int die1 = rnd.nextInt(6) + 1;
        int die2 = rnd.nextInt(6) + 1;
        int sum = die1 + die2;

        System.out.printf("You rolled %d and %d = %d%n", die1, die2, sum);

        // Check initial roll conditions
        if (sum == 2 || sum == 3 || sum == 12) {
            System.out.println("Craps! You lose!");
        }
        else if (sum == 7 || sum == 11) {
            System.out.println("Natural! You win!");
        }
        else {
            int point = sum;
            System.out.printf("The point is now %d. Trying for point...%n", point);

            // Continue rolling until point or 7 is made
            boolean rollingForPoint = true;
            while (rollingForPoint) {
                System.out.print("Press enter to roll again...");
                scanner.nextLine(); // Wait for user input

                die1 = rnd.nextInt(6) + 1;
                die2 = rnd.nextInt(6) + 1;
                sum = die1 + die2;

                System.out.printf("You rolled %d and %d = %d%n", die1, die2, sum);

                if (sum == point) {
                    System.out.println("Made point! You win!");
                    rollingForPoint = false;
                }
                else if (sum == 7) {
                    System.out.println("Got a seven! You lose!");
                    rollingForPoint = false;
                }
                else {
                    System.out.println("Trying for point...");
                }
            }
        }
    }

}