package GUI;

import Model.Database;

import javax.swing.*;
import java.awt.*;

public class MainFrame extends JFrame {

        static LogInMenu logInMenu;
        static CreateOrder createOrder;

    public MainFrame(){
        Database.getInstance().populateDatabase();
        GraphicsEnvironment env =
                GraphicsEnvironment.getLocalGraphicsEnvironment();
        this.setMaximizedBounds(env.getMaximumWindowBounds());
        this.setExtendedState(this.getExtendedState() | this.MAXIMIZED_BOTH);

    }

    public static void main(String[] args) {
        MainFrame frame = new MainFrame();



        createOrder = new CreateOrder(JTabbedPane.TOP);

        frame.add(createOrder);

        frame.setLayout(null);

        frame.setVisible(true);
       //logInMenu = new LogInMenu();


    }
}
