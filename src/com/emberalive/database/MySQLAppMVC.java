package com.emberalive.database;

import com.emberalive.menu.MenuController;
import com.emberalive.menu.MenuView;
import com.emberalive.menu.ViewManager;

public class MySQLAppMVC {
    public static void main(String[] args) {
        ViewManager vm = new ViewManager();
        MenuView mv = new MenuView(vm);
        MenuController controller = new MenuController(mv, vm);
        mv.display();
    }
}
