package ConsoleUI;

import java.util.InputMismatchException;
import java.util.Random;
import java.util.Scanner;

public class Utility {

    public static int getRandom(int min, int max) {
        Random random = new Random();
        return random.ints(min, max)
                .findFirst()
                .getAsInt();
    }

}
