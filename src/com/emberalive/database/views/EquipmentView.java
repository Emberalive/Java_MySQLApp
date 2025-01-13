package com.emberalive.database.views;

import javax.swing.*;
import javax.swing.border.Border;
import java.awt.*;
import java.util.HashMap;
import java.util.Map;

public class EquipmentView extends View {
    private JButton patTestButton, availableEquipmentButton, allEquipCat, electricalEquipButton, foodCateringEquipButton,
            officeSuppliesButton;

    public EquipmentView() {
        super();

        patTestButton = new JButton("PatTest Date");
        allEquipCat = new JButton("All Equipment categories");
        availableEquipmentButton = new JButton("Available Equipment");
        electricalEquipButton = new JButton("Electrical Equipment");
        foodCateringEquipButton = new JButton("Food Catering Equipment");
        officeSuppliesButton = new JButton("Office Supplies");

        JPanel topPanel = new JPanel();
        topPanel.add(disconnectButton);
        topPanel.add(connectButton);
        topPanel.add(patTestButton);
        topPanel.add(allEquipCat);
        topPanel.add(availableEquipmentButton);
        topPanel.add(electricalEquipButton);
        topPanel.add(foodCateringEquipButton);
        topPanel.add(officeSuppliesButton);

        // Center Panel, which displays the results
        mainPanel.add(topPanel, BorderLayout.NORTH);
        mainPanel.add(new JScrollPane(resultsTable), BorderLayout.CENTER); // From parent View
        mainPanel.add(statusLabel, BorderLayout.SOUTH);
    }

    @Override
    public Map<JButton, String> getActionButtons(){
        //Map buttons to queries specific to this view
        Map<JButton, String> actionButtons = new HashMap<>();
        actionButtons.put(patTestButton, "SELECT * FROM `pattestDate_rennual`");
        actionButtons.put(allEquipCat, "SELECT categoryName FROM tcategories");
        actionButtons.put(availableEquipmentButton, "SELECT * FROM `available_equipment`");
        actionButtons.put(electricalEquipButton, "SELECT ec.equipID, e.eName\n" +
                "FROM tequipment_categories ec\n" +
                "INNER JOIN tcategories c ON ec.categoryID = c.categoryID\n" +
                "INNER JOIN tequipment e ON ec.equipID = e.equipID\n" +
                "WHERE c.categoryID = 2");
        actionButtons.put(foodCateringEquipButton, "SELECT ec.equipID, e.eName\n" +
                "FROM tequipment_categories ec\n" +
                "INNER JOIN tcategories c ON ec.categoryID = c.categoryID\n" +
                "INNER JOIN tequipment e ON ec.equipID = e.equipID\n" +
                "WHERE c.categoryID = 6;");
        actionButtons.put(officeSuppliesButton, "SELECT ec.equipID\n" +
                "FROM tequipment_categories ec\n" +
                "INNER JOIN tcategories c ON ec.categoryID = c.categoryID\n" +
                "WHERE c.categoryID = 9");
        return actionButtons;
    }
    @Override
    public void show() {
        // Display this view
        JFrame frame = new JFrame("Equipment view");
        frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        frame.setContentPane(mainPanel);
        frame.setSize(800, 600);
        frame.setVisible(true);
    }
}
