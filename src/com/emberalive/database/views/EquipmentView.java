package com.emberalive.database.views;

import javax.swing.*;
import java.awt.*;

public class EquipmentView implements View {
    private JFrame frame;
    private JButton patTestButton, availableEquipmentButton, allEquipCat, electricalEquipButton, foodCateringEquipButton,
            officeSuppliesButton, connectButton, disconnectButton;
    private JLabel statusLabel;
    private JTable resultsTable;
    public EquipmentView() {
        frame = new JFrame("Rentals");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(800, 600);

        // Layout
        JPanel panel = new JPanel(new BorderLayout());

        // top panel, the pre-defined query buttons
        JPanel topPanel = new JPanel(new FlowLayout());
        connectButton = new JButton("Connect");
        disconnectButton = new JButton("Disconnect");
        patTestButton = new JButton("PatTest Date");
        allEquipCat = new JButton("All Equipment categories");
        availableEquipmentButton = new JButton("Available Equipment");
        electricalEquipButton = new JButton("Electrical Equipment");
        foodCateringEquipButton = new JButton("Food Catering Equipment");
        officeSuppliesButton = new JButton("Office Supplies");
        topPanel.add(connectButton);
        topPanel.add(disconnectButton);
        topPanel.add(patTestButton);
        topPanel.add(allEquipCat);
        topPanel.add(availableEquipmentButton);
        topPanel.add(electricalEquipButton);
        topPanel.add(foodCateringEquipButton);
        topPanel.add(officeSuppliesButton);

        // Center Panel, which displays the results
        resultsTable = new JTable();
        JScrollPane scrollPane = new JScrollPane(resultsTable);
        panel.add(scrollPane, BorderLayout.CENTER);

        JPanel bottomPanel = new JPanel(new FlowLayout());
        statusLabel = new JLabel("Not Connected");
        bottomPanel.add(statusLabel);

        panel.add(topPanel, BorderLayout.NORTH);
        panel.add(scrollPane, BorderLayout.CENTER);
        panel.add(bottomPanel, BorderLayout.SOUTH);
        frame.add(panel);
    }

    public void display() { frame.setVisible(true);}

    public JButton getConnectButton() {return connectButton;}

    public JButton getDisconnectButton() {return disconnectButton;}

    public JButton getPatTestButton() {return patTestButton;}

    public JButton getAllEquipCatButton() {return allEquipCat;}

    public JButton getAvailableEquipmentButton() {return availableEquipmentButton;}

    public JButton getElectricalEquipButton() {return electricalEquipButton;}

    public JButton getFoodCateringEquipButton() {return foodCateringEquipButton;}

    public JButton getOfficeSuppliesButton() {return officeSuppliesButton;}
}
