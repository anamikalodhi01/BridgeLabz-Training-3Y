import java.util.Scanner;
import java.util.Random;

public class NumberGuessingGame {

    public static int generateGuess(Random rand, int low, int high) {
        return rand.nextInt(high - low + 1) + low;
    }

    public static String getFeedback(Scanner sc, int guess) {
        System.out.println("Is your number " + guess + "? (Enter: high/low/correct)");
        return sc.nextLine().toLowerCase();
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        Random rand = new Random();
        int low = 1, high = 100;
        String feedback;

        System.out.println("Think of a number between 1 and 100...");

        while (true) {
            int guess = generateGuess(rand, low, high);
            feedback = getFeedback(sc, guess);

            if (feedback.equals("correct")) {
                System.out.println("Yay! I guessed your number!");
                break;
            } else if (feedback.equals("low")) {
                low = guess + 1;
            } else if (feedback.equals("high")) {
                high = guess - 1;
            }
        }
    }
}
