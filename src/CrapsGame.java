import java.util.Random;
import java.util.Scanner;

public class CrapsGame {

    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        Random rnd = new Random();
        boolean playAgain = true;

        while (playAgain) {
            int die1 = rnd.nextInt(6) + 1;
            int die2 = rnd.nextInt(6) + 1;
            int sum = die1 + die2;

            System.out.println("You rolled: " + die1 + " + " + die2 + " = " + sum);

            if (sum == 2 || sum == 3 || sum == 12) {
                System.out.println("It is craps. You lose.");
            } else if (sum == 7 || sum == 11) {
                System.out.println("It is natural. You win.");
            } else {
                int point = sum;
                System.out.println("The point is now: " + point + ". You win by making point sum or you lose by making a 7.");

                boolean rolling = true;

                while (rolling) {
                    die1 = rnd.nextInt(6) + 1;
                    die2 = rnd.nextInt(6) + 1;
                    sum = die1 + die2;
                    System.out.println("You rolled: " + die1 + " + " + die2 + " = " + sum);

                    if (sum == point) {
                        System.out.println("You made the point. You win.");
                        rolling = false;
                    } else if (sum == 7) {
                        System.out.println("You rolled a 7. You lose.");
                        rolling = false;
                    } else {
                        System.out.println("Trying for point.");
                    }
                }
            }

            // Prompt to play again
            System.out.print("Do you want to play again? (y/n): ");
            String response = input.nextLine();
            if (!response.equalsIgnoreCase("y")) {
                playAgain = false;
                System.out.println("Thanks for playing!");
            }
        }
    }
}