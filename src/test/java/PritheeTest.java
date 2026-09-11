import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.Random;
import java.util.Scanner;

class PritheeTest {

    @Test
    void runRound() {
        Prithee prithee = new Prithee();
        Scanner scannerF = new Scanner("FALSEINPUT\n" +
                "FALSEINPUT\n" +
                "FALSEINPUT\n" +
                "FALSEINPUT\n" +
                "FALSEINPUT\n");
        //first word test
        Scanner scanner0T = new Scanner("Shall");
        //end of line, and removing caps correctly are both being tested here
        Scanner scanner7T = new Scanner("Day");
        //random word deep in test
        Scanner scanner79T = new Scanner("death");
        //overwriting random to test things
        Random random0 = new Random() {
            @Override
            public int nextInt(int bound) {
                return 0;
            }
        };
        Random random7 = new Random() {
            @Override
            public int nextInt(int bound) {
                return 7;
            }
        };
        Random random79 = new Random() {
            @Override
            public int nextInt(int bound) {
                return 79;
            }
        };
        Assertions.assertTrue(prithee.runRound(scanner0T, random0));
        Assertions.assertFalse(prithee.runRound(scannerF, random0));
        Assertions.assertTrue(prithee.runRound(scanner7T,random7));
        Assertions.assertFalse(prithee.runRound(scannerF,random7));
        Assertions.assertTrue(prithee.runRound(scanner79T,random79));
        Assertions.assertFalse(prithee.runRound(scannerF,random79));
    }
}