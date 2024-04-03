package edu.iu.habahram.DinerPancakeHouseMerge.model;

import java.util.Iterator;

public class MenuItem implements Menu{
    String name;
    String description;
    boolean vegetarian;
    double price;

    public MenuItem(String name,
                    String description,
                    boolean vegetarian,
                    double price)
    {
        this.name = name;
        this.description = description;
        this.vegetarian = vegetarian;
        this.price = price;
    }

    public String getName() {
        return name;
    }

    public String getDescription() {
        return description;
    }

    public double getPrice() {
        return price;
    }

    public boolean isVegetarian() {
        return vegetarian;
    }
    public String toString() {
        return (name + ", $" + price + "\n   " + description);
    }

    @Override
    public Iterator<MenuItem> createIterator() {
        return null;
    }
}
