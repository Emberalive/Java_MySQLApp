package com.emberalive.menu;

import javax.swing.*;
import javax.swing.text.View;
import java.awt.*;

public class MenuView {
    private JFrame window;
    private JButton Rentals, Equipment, users;

    public MenuView(ViewManager viewManager) {
        window = new JFrame();
        window.setTitle("Menu");
        window.setSize(400, 700);
        window.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        window.setResizable(false);

        GridLayout layout = new GridLayout(3, 1);
        window.setLayout(layout);
        Rentals = new JButton("Rentals");
        Equipment = new JButton("Equipment");
        users = new JButton("Users");


        window.add(Rentals);
        window.add(Equipment);
        window.add(users);
        window.setVisible(true);
    }

    public JButton getRentalsButton(){
        return Rentals;
    }
    public JButton getEquipmentButton(){
        return Equipment;
    }
    public JButton getUsersButton(){
        return users;
    }

    public void display() {
        window.setVisible(true);
    }
}
