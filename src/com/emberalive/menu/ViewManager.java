package com.emberalive.menu;

import com.emberalive.database.DatabaseController;
import com.emberalive.database.DatabaseModel;
import com.emberalive.database.views.RentalView;
import com.emberalive.database.views.View;

public class ViewManager {

    public void startUsersGUI(){

    }

    public void startRentalGUI(){
        DatabaseModel model = new DatabaseModel();
        RentalView rv = new RentalView();
        new DatabaseController(model, rv);
        rv.display();
    }

    public void startEquipmentGUI(){

    }
}
