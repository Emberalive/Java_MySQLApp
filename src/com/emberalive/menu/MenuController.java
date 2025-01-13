package com.emberalive.menu;

import com.emberalive.database.DatabaseModel;

public class MenuController {
    private MenuView menuView;
    private ViewManager viewManager;

    public MenuController(DatabaseModel model) {

        this.viewManager = new ViewManager(model);

        this.menuView = new MenuView(viewManager);

        menuView.getEquipmentButton().addActionListener(e -> viewManager.showView("Equipment"));
        menuView.getRentalsButton().addActionListener(e -> viewManager.showView("Rental"));
        menuView.getUsersButton().addActionListener(e -> viewManager.showView("User"));
    }
    public void start() {
        menuView.display();
    }
}
