package com.emberalive.menu;

import javax.swing.*;
import javax.swing.text.View;
import java.awt.*;

public class MenuView {
    private static JFrame window;
    private JButton Rentals, Equipment, User;

    public MenuView(ViewManager viewManager) {
        window = new JFrame();
        window.setTitle("Menu");
        window.setSize(400, 700);
        window.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        window.setResizable(false);


        window.setLayout(new GridLayout(3, 1));
        Rentals = new JButton("Rentals");
        Equipment = new JButton("Equipment");
        User = new JButton("Users");


        window.add(Rentals);
        window.add(Equipment);
        window.add(User);
    }

    public JButton getRentalsButton(){
        return Rentals;
    }
    public JButton getEquipmentButton(){
        return Equipment;
    }
    public JButton getUsersButton(){
        return User;
    }

    public static void display() {
        window.setVisible(true);
    }
}
