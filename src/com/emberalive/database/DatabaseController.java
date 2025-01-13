package com.emberalive.database;

import com.emberalive.database.views.RentalView;
import com.emberalive.database.views.View;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;

public class DatabaseController {
    private DatabaseModel model;
    private RentalView rv;

    public enum TargetView{
        RENTAL_VIEW,
        USERS_VIEW,
        EQUIPMENTS_VIEW
    }


    public DatabaseController(DatabaseModel model, RentalView rv) {
        this.model = model;
        this.rv = rv;

        // Add listeners for the "Connect" button

        view.getConnectButton().addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                if (model.connect()) {
                    view.getStatusLabel().setText("Connected to Database");
                    view.getConnectButton().setEnabled(false);
                    view.getDisconnectButton().setEnabled(true);
                } else {
                    view.getStatusLabel().setText("Connection Failed");
                }
            }
        });

        //ActionListeners for RentalView
        rv.getDisconnectButton().addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                model.disconnect(view);
            }
        });
        rv.getUserRentalButton().addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                executeQueryAndPopulateTable("SELECT * FROM `UserRentals`");
            }
        });
        rv.getConsumableButton().addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                executeQueryAndPopulateTable("SELECT categoryName FROM tcategories");
            }
        });
        rv.getRentalInfoButton().addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                executeQueryAndPopulateTable("SELECT userID, rentalNo, collection, returned FROM tRental");
            }
        });
        rv.getRentalAndEquipment().addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                executeQueryAndPopulateTable("SELECT r.userID, r.rentalNo, rl.copyID FROM tRental r\n" +
                        "INNER JOIN tRentalLine rl ON r.rentalNo = rl.rentalNo");
            }
        });
    }

    public void selectTargetView (TargetView enumval){
        switch (enumval){
            case RENTAL_VIEW:

        }
    }


    // Executes a query and populates the JTable with the results
    private void executeQueryAndPopulateTable(String query) {
        try {
            ResultSet rs = model.executeQuery(query);
            populateTable(rs, view.getResultsTable());
        } catch (Exception ex) {
            JOptionPane.showMessageDialog(view.getResultsTable(), "Error: " + ex.getMessage());
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
