package Arrays;

import java.util.Scanner;
import java.util.Random;

public class RockPaperScissor {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Random random = new Random();
        String[] rps = {"Rock", "Paper", "Scissors"};
        boolean playAgain = true;

        while (playAgain) {
            System.out.println("Enter move (Rock, Paper, Scissors). To exit the game, type Exit:");
            String userMove = scanner.nextLine();

            if (userMove.equalsIgnoreCase("Exit")) {
                playAgain = false;
                continue;
            }

            int compIndex = random.nextInt(3);
            String compMove = rps[compIndex];
            System.out.println("Computer move: " + compMove);

            if (userMove.equalsIgnoreCase(compMove)) {
                System.out.println("It's a tie!");
            } else if (userMove.equalsIgnoreCase("Rock") && compMove.equals("Scissors") ||
                    userMove.equalsIgnoreCase("Paper") && compMove.equals("Rock") ||
                    userMove.equalsIgnoreCase("Scissors") && compMove.equals("Paper")) {
                System.out.println("You win!");
            } else {
                System.out.println("You lose!");
            }
        }

        scanner.close();
    }
}
