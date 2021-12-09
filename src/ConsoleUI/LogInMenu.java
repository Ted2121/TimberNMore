package ConsoleUI;


public class LogInMenu implements Menu {

    private String username;
    private String password;

    @Override
    public void runMenu() {
        logInMenu();
    }

    // username is access level + firstname + lastname
    // password is firstname + lastname + "123"
    private void logInMenu() {
        System.out.println("**** Log In ****\n");
        System.out.print("Username: ");
        username = Menu.getStringFromUser();
        System.out.print("Password: ");
        password = Menu.getStringFromUser();
        checkAccountDetails();
    }

    private void checkAccountDetails() {
        if (Menu.grantAccess(username, password)) {
            Menu.goToMainMenu();
        } else {
            System.err.println("Incorrect Username or Password. Please try again!");

            Runnable runnable = new Runnable() {
                @Override
                public void run() {
                    try {
                        Thread.sleep(500);
                        logInMenu();
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
            };

            runnable.run();

        }


    }
}
