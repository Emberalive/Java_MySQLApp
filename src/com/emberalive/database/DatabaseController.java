package com.emberalive.database;

import com.emberalive.database.views.View;
import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.util.Map;

public class DatabaseController {
    private DatabaseModel model;

    public DatabaseController(DatabaseModel model) {
        this.model = model;
    }

    public void initializeView(View view) {
        view.getConnectButton().addActionListener( e ->{
            if(model.connect()) {
                view.getStatusLabel().setText("connected to database");
                view.getConnectButton().setEnabled(false);
                view.getDisconnectButton().setEnabled(true);
            } else {
                view.getStatusLabel().setText("connection failed");
            }
        });
        view.getDisconnectButton().addActionListener( e ->{
            try {
                Connection con = model.getConnection();
                if (con != null) {
                    con.close();
                    view.getConnectButton().setEnabled(true);
                    view.getDisconnectButton().setEnabled(false);
                    view.getStatusLabel().setText("Disconnected");
                    view.getResultsTable().setEnabled(false);
                }
            } catch (SQLException ex) {
                ex.printStackTrace();
            }
        });

        for (Map.Entry<JButton, String> entry : view.getActionButtons().entrySet()) {
            JButton button = entry.getKey();
            String query = entry.getValue();

            button.addActionListener(e -> executeQueryAndPopulateTable(query, view.getResultsTable()));
        }
    }

    // Executes a query and populates the JTable with the results
    private void executeQueryAndPopulateTable(String query, JTable table) {
        try {
            ResultSet rs = model.executeQuery(query);
            populateTable(rs, table);
        } catch (Exception ex) {
            JOptionPane.showMessageDialog(table, "Error: " + ex.getMessage());
        }
    }
    // Populate JTable with ResultSet data
    private void populateTable(ResultSet rs, JTable table) throws Exception {
        ResultSetMetaData metaData = rs.getMetaData();
        int columnCount = metaData.getColumnCount();
        // Table Model
        DefaultTableModel tableModel = new DefaultTableModel();
        // Add column names
        for (int i = 1; i <= columnCount; i++) {
            tableModel.addColumn(metaData.getColumnName(i));
        }
        // Add rows
        while (rs.next()) {
            Object[] row = new Object[columnCount];
            for (int i = 1; i <= columnCount; i++) {
                row[i - 1] = rs.getObject(i);
            }
            tableModel.addRow(row);
        }
        table.setModel(tableModel);
    }
}
