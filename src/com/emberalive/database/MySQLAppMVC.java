package com.emberalive.database;

import com.emberalive.menu.MenuController;

public class MySQLAppMVC {
    public static void main(String[] args) {
        // Initialize the DatabaseModel
        DatabaseModel model = new DatabaseModel();

        // Initialize the MenuController
        MenuController menuController = new MenuController(model);

        // Start the MenuController, which displays the MenuView
        menuController.start();
    }
}
