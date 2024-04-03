package edu.iu.habahram.DinerPancakeHouseMerge.model;

import java.util.ArrayList;

public class Menu extends MenuComponent{
    ArrayList<MenuComponent> menuComponents = new ArrayList<MenuComponent>();
    String name;
    String description;

    public Menu(String name, String description) {
        this.name = name;
        this.description = description;
    }

    public void add(MenuComponent menuComponent) {
        menuComponents.add(menuComponent);
    }

    public void remove(MenuComponent menuComponent) {
        menuComponents.remove(menuComponent);
    }

    public MenuComponent getChild(int i) {
        return (MenuComponent)menuComponents.get(i);
    }

    public String getName() {
        return name;
    }

    public String getDescription() {
        return description;
    }

    public MenuItem[] getItems() {
        ArrayList<MenuItem> itemsList = new ArrayList<>();
        collectMenuItems(this, itemsList);
        return itemsList.toArray(new MenuItem[0]);
    }

    private void collectMenuItems(MenuComponent menuComponent, ArrayList<MenuItem> itemsList) {
        if (menuComponent instanceof Menu) {
            Menu menu = (Menu) menuComponent;
            for (MenuComponent component : menu.menuComponents) {
                collectMenuItems(component, itemsList);
            }
        } else if (menuComponent instanceof MenuItem) {
            itemsList.add((MenuItem) menuComponent);
        }
    }
}