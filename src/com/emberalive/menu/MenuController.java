package com.emberalive.menu;

public class MenuController {
    private MenuView mv;
    private ViewManager vm;
    public MenuController(MenuView mv, ViewManager vm) {
        this.vm = vm;
        this.mv = mv;

        mv.getEquipmentButton().addActionListener(e -> {vm.startEquipmentGUI();});
        mv.getRentalsButton().addActionListener(e -> {vm.startRentalGUI();});
        mv.getUsersButton().addActionListener(e -> {vm.startUsersGUI();});
    }
}
