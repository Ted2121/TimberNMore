package ConsoleUI;

import java.time.format.DateTimeFormatter;
import java.util.InputMismatchException;
import java.util.Random;
import java.util.Scanner;

public class Utility {

    private static final DateTimeFormatter format = DateTimeFormatter.ofPattern("dd-MM-yyyy HH:mm:ss");

    public static DateTimeFormatter getFormat() {
        return format;
    }

    public static int getRandom(int min, int max) {
        Random random = new Random();
        return random.ints(min, max)
                .findFirst()
                .getAsInt();
    }

}
