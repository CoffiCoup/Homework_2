import java.util.Random;
import java.util.Scanner;

public class Prithee {
    final String sonnet =
            "Shall I compare thee to a summer's day?\n " +
            "Thou art more lovely and more temperate:\n " +
            "Rough winds do shake the darling buds of May,\n " +
            "And summer's lease hath all too short a date;\n " +
            "Sometime too hot the eye of heaven shines,\n " +
            "And often is his gold complexion dimm'd;\n " +
            "And every fair from fair sometime declines,\n " +
            "By chance or nature's changing course untrimm'd;\n " +
            "But thy eternal summer shall not fade,\n " +
            "Nor lose possession of that fair thou ow'st;\n " +
            "Nor shall death brag thou wander'st in his shade,\n " +
            "When in eternal lines to time thou grow'st:\n " +
            "\tSo long as men can breathe or eyes can see,\n " +
            "\tSo long lives this, and this gives life to thee.\n ";

    private final String[] sonnetWords; //list of words in the sonnet, INCLUDING FORMATTING!
    private final int maxWords; //for limiting how far the random word will go
    //constructor
    public Prithee() {
        sonnetWords = sonnet.split(" ");
        maxWords = sonnetWords.length;
    }

    //runs a round of the prithee
    public boolean runRound(Scanner scanner, Random random) {
        int wordIndex = random.nextInt(maxWords);
        printSonnetUntil(wordIndex);
        return askPrithee(wordIndex, scanner);
    }

    //printing the sonnet up to the index
    private void printSonnetUntil(int wordIndex) {
        StringBuilder sonnetBuilder = new StringBuilder(sonnet.chars().toArray().length);
        for (int i = 0;i<wordIndex;i++) {
            sonnetBuilder.append(sonnetWords[i]);
            if (!sonnetWords[i].contains("\n")) {
                sonnetBuilder.append(" ");
            }
        }
        String wordSpace = "";
        int wordLength = sonnetWords[wordIndex].replaceAll("[\t\n,;?:.]","").length();
        for (int i = 0;i<wordLength;i++) {
            wordSpace += "_";
        }
        sonnetBuilder.append(wordSpace);
        System.out.println(sonnetBuilder);
    }

    //actual comparison occurs here
    private boolean askPrithee(int wordIndex, Scanner scanner) {
        System.out.println("\nPrithee\n");
        String attempt = scanner.nextLine().toLowerCase();
        String compareWord = sonnetWords[wordIndex].replaceAll("[\t\n,;?:.]","").toLowerCase();
        return attempt.compareTo(compareWord) == 0;
    }
}
