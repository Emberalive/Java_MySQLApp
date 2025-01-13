package com.emberalive.database.views;

import javax.swing.*;
import java.awt.*;

public class RentalView {
    private JFrame frame;
    private JButton UserRentalButton, ConsumableButton, RentalInfoButton, connectButton, rentalAndEquipment, disconnectButton;
    private JLabel statusLabel;
    private JTable resultsTable;

    public RentalView()  {
        frame = new JFrame("Rentals");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(800, 600);

        // Layout
        JPanel panel = new JPanel(new BorderLayout());

        // Top Panel (Predefined Query Buttons)
        JPanel topPanel = new JPanel(new FlowLayout());
        connectButton = new JButton("Connect");
        disconnectButton = new JButton("Disconnect");
        UserRentalButton = new JButton("user Rentals");
        ConsumableButton = new JButton("Consumables for rentals");
        RentalInfoButton = new JButton("basic info for rentals");
        rentalAndEquipment = new JButton("Rental and Equipment");
        topPanel.add(connectButton);
        topPanel.add(disconnectButton);
        topPanel.add(rentalAndEquipment);
        topPanel.add(UserRentalButton);
        topPanel.add(ConsumableButton);
        topPanel.add(RentalInfoButton);

        // Center Panel, which displays the results
        resultsTable = new JTable();
        JScrollPane scrollPane = new JScrollPane(resultsTable);
        panel.add(scrollPane, BorderLayout.CENTER);

        // Bottom Panel (Connection Status)
        JPanel bottomPanel = new JPanel(new FlowLayout());
        statusLabel = new JLabel("Not Connected");
        bottomPanel.add(statusLabel);

        // Add Panels to Frame
        panel.add(topPanel, BorderLayout.NORTH);
        panel.add(scrollPane, BorderLayout.CENTER);
        panel.add(bottomPanel, BorderLayout.SOUTH);
        frame.add(panel);
    }

    public void display() {
        frame.setVisible(true);
    }

    public JButton getConnectButton() {
        return connectButton;
    }

    public JButton getDisconnectButton() {
        return disconnectButton;
    }

    public JButton getUserRentalButton() {
        return UserRentalButton;
    }

    public JButton getConsumableButton() {
        return ConsumableButton;
    }

    public JButton getRentalInfoButton() {
        return RentalInfoButton;
    }

    public JLabel getStatusLabel() {
        return statusLabel;
    }

    public JTable getResultsTable() {
        return resultsTable;
    }

    public JButton getRentalAndEquipment() {
        return rentalAndEquipment;
    }


}
