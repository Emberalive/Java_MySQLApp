package com.emberalive.database.views;

import javax.swing.*;
import java.awt.*;
import java.util.HashMap;
import java.util.Map;

public class RentalView extends View {
    private JButton UserRentalButton, ConsumableButton, RentalInfoButton, rentalAndEquipment;


    public RentalView()  {
        super();
        // Layout
        UserRentalButton = new JButton("user Rentals");
        ConsumableButton = new JButton("Consumables for rentals");
        RentalInfoButton = new JButton("basic info for rentals");
        rentalAndEquipment = new JButton("Rental and Equipment");

        JPanel topPanel = new JPanel(new FlowLayout());
        topPanel.add(disconnectButton);
        topPanel.add(connectButton);
        topPanel.add(rentalAndEquipment);
        topPanel.add(UserRentalButton);
        topPanel.add(ConsumableButton);
        topPanel.add(RentalInfoButton);

        // Add Panels to Frame
        mainPanel.add(topPanel, BorderLayout.NORTH);
        mainPanel.add(new JScrollPane(resultsTable), BorderLayout.CENTER);
        mainPanel.add(statusLabel, BorderLayout.SOUTH);
    }

    @Override
    public Map<JButton, String> getActionButtons(){
        Map<JButton, String> actionButton = new HashMap<>();
        actionButton.put(UserRentalButton, "SELECT * FROM `UserRentals`");
        actionButton.put(ConsumableButton, "SELECT * FROM `ConsumablesForRentals`");
        actionButton.put(RentalInfoButton, "SELECT userID, rentalNo, collection, returned FROM tRental");
        actionButton.put(rentalAndEquipment, "SELECT r.userID, r.rentalNo, rl.copyID FROM tRental r\n" +
                "INNER JOIN tRentalLine rl ON r.rentalNo = rl.rentalNo");

        return actionButton;
    }

    @Override
    public void show() {
        // Display this view
        JFrame frame = new JFrame("Rental View");
        frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        frame.setContentPane(mainPanel);
        frame.setSize(1100, 700);
        frame.setVisible(true);
    }

}
