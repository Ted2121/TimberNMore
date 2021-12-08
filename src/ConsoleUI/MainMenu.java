package ConsoleUI;

public class MainMenu implements Menu {

    @Override
    public void runMenu() {
        mainMenu();
    }

    private void mainMenu(){
        writeMainMenu();
        boolean running = true;
        while (running) {
            int choice = Menu.getIntegerFromUser();
            switch (choice) {
                // TODO
                case 1 -> System.out.println();
                case 2 -> System.out.println();
                case 3 -> System.out.println();
                case 0 -> {
                    System.out.println("Closing Application");
                    running = false;
                }
                default -> System.out.println("Invalid input: " + choice);
            }
        }
    }

    private void writeMainMenu(){
        System.out.println("****** Main menu ******");
        System.out.println(" (1) Create Order");
        System.out.println(" (2) Update Order"); // TODO
        System.out.println(" (3) Find Order"); // TODO
        System.out.println(" (0) Close Application");
        System.out.print("\n Choice:");
    }
}
