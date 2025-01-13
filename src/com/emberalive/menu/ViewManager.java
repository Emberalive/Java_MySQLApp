package com.emberalive.menu;

import com.emberalive.database.DatabaseController;
import com.emberalive.database.DatabaseModel;
import com.emberalive.database.views.EquipmentView;
import com.emberalive.database.views.RentalView;
import com.emberalive.database.views.UserView;
import com.emberalive.database.views.View;

import java.util.HashMap;
import java.util.Map;

public class ViewManager {
    private Map<String, View> views = new HashMap<>();
    private DatabaseController controller;

    public ViewManager(DatabaseModel model) {
        this.controller = new DatabaseController(model);

        //Register the views
        views.put("Rental", new RentalView());
        views.put("Equipment", new EquipmentView());
        views.put("User", new UserView());

        for (View view : views.values()) {
            controller.initializeView(view);
        }
    }

    public void showView(String viewName) {
        if (views.containsKey(viewName)) {
            views.get(viewName).show();
        } else {
            throw new IllegalArgumentException("Unknown view name: " + viewName);
        }
    }
}
