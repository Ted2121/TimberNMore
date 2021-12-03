package ConsoleUI;

public class LogInMenu implements Menu {



    private void logInMenu(){
        System.out.println("**** Log In ****\n");
        System.out.print("Username: ");
    }

    @Override
    public void runMenu() {
        logInMenu();
    }




}
