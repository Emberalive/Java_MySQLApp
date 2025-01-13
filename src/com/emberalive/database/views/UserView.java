package com.emberalive.database.views;

import javax.swing.*;
import java.awt.*;
import java.util.HashMap;
import java.util.Map;

public class UserView extends View{
    private JButton showRentals, UserRentals, UserInformation;

    public UserView(){
        super();

        showRentals = new JButton("Show Rentals");
        UserRentals = new JButton("User Rentals");
        UserInformation = new JButton("User Information");

        JPanel topPanel = new JPanel(new GridLayout(2, 5, 10, 10));
        topPanel.add(connectButton);
        topPanel.add(disconnectButton);
        topPanel.add(showRentals);
        topPanel.add(UserRentals);
        topPanel.add(UserInformation);

        mainPanel.add(topPanel, BorderLayout.NORTH);
        mainPanel.add(new JScrollPane(resultsTable), BorderLayout.CENTER);
        mainPanel.add(statusLabel, BorderLayout.SOUTH);
    }

    @Override
    public Map<JButton, String> getActionButtons() {
        Map<JButton, String> actionButtons = new HashMap<>();
        actionButtons.put(showRentals, "SELECT * FROM `show_rentals`");
        actionButtons.put(UserRentals, "SELECT * FROM `UserRentals`");
        actionButtons.put(UserInformation, "SELECT userID, uFName, uSName, uAddress1, uCounty, uPostcode, uTown, uPhone FROM tUser; ");
        return actionButtons;
    }

    @Override
    public void show(){
        JFrame frame = new JFrame("User");
        frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        frame.setContentPane(mainPanel);
        frame.setSize(1100, 600);
        frame.setVisible(true);
    }
}
