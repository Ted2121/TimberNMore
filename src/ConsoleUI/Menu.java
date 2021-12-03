package ConsoleUI;

import java.util.InputMismatchException;
import java.util.Scanner;

public interface Menu {
    void runMenu();

    static void closeApplication(){
        System.exit(0);
    }

    static void returnToMainMenu(){
        new MainMenu().runMenu();
    }

    static int getIntegerFromUser(){
        int choice = 0;
        try{
            Scanner scanner = new Scanner(System.in);
            choice = scanner.nextInt();
            return choice;
        }catch (InputMismatchException e){
            System.out.println("Invalid input");
        }
        return choice;
    }
}
