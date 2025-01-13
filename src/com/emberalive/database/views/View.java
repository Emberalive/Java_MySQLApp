// database/views/View.java
package com.emberalive.database.views;

import javax.swing.*;
import java.awt.*;
import java.util.Map;

public abstract class View {
    protected JPanel mainPanel;
    protected JTable resultsTable;
    protected JLabel statusLabel;
    protected JButton connectButton;
    protected JButton disconnectButton;

    public View() {
        // Initialize common components
        mainPanel = new JPanel(new BorderLayout());
        resultsTable = new JTable();
        statusLabel = new JLabel("Status: Not Connected");
        connectButton = new JButton("Connect");
        disconnectButton = new JButton("Disconnect");

        // Add these components to the mainPanel (or let child classes handle layout)
    }

    // Common getters
    public JPanel getMainPanel() {
        return mainPanel;
    }

    public JTable getResultsTable() {
        return resultsTable;
    }

    public JLabel getStatusLabel() {
        return statusLabel;
    }

    public JButton getConnectButton() {
        return connectButton;
    }

    public JButton getDisconnectButton() {
        return disconnectButton;
    }

    // Abstract methods for specific behaviors
    public abstract Map<JButton, String> getActionButtons(); // Maps buttons to queries
    public abstract void show(); // To display this view
}
