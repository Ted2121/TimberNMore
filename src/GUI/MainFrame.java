package GUI;

import Model.Database;

import javax.swing.*;
import java.awt.*;

public class MainFrame extends JFrame {

        static LogInMenu logInMenu;

    public MainFrame(){
        Database.getInstance().populateDatabase();
        GraphicsEnvironment env =
                GraphicsEnvironment.getLocalGraphicsEnvironment();
        this.setMaximizedBounds(env.getMaximumWindowBounds());
        this.setExtendedState(this.getExtendedState() | this.MAXIMIZED_BOTH);

    }

    public static void main(String[] args) {
        MainFrame frame = new MainFrame();




        frame.setLayout(null);
        //frame.setBounds(0, 0, 1920, 1080);
        frame.setVisible(true);
        logInMenu = new LogInMenu();
//        logInMenu.setModal(true);
//        logInMenu.setVisible(true);

        //logInMenu.setAlwaysOnTop(true);

    }
}
