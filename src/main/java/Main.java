import java.util.Random;
import java.util.Scanner;

public class Main {
    private static int losses = 0;
    private static int wins = 0;
    //handling general code running
    public static void main(String[] args) {
        //Prithee running
        Prithee prithee = new Prithee();
        Scanner scanner = new Scanner(System.in);
        Random random = new Random();
        while (losses < 3 && wins < 3) {
            boolean result = prithee.runRound(scanner,random);
            if (result) {
                System.out.println("\nCorrect!\n");
                wins += 1;
            } else {
                System.out.println("\nIncorrect...\n");
                losses += 1;
            }
        }
        //results display
        if (losses < 3) {
            System.out.println("\nYou won! Good job!");
        } else {
            System.out.println("\nYou lost, darn...");
        }
    }
}