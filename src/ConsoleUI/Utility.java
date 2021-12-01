package ConsoleUI;

import java.util.Random;

public class Utility {

    public static int getRandom(int lowerBound, int upperBound){
        Random random = new Random();
        return random.nextInt((upperBound - lowerBound) + lowerBound);


    }
}
