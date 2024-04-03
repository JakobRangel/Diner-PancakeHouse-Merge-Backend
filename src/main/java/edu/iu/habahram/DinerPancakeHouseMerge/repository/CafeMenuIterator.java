package edu.iu.habahram.DinerPancakeHouseMerge.repository;

import edu.iu.habahram.DinerPancakeHouseMerge.model.MenuItem;

import java.util.Iterator;
import java.util.HashMap;

public class CafeMenuIterator implements Iterator<MenuItem> {
    private Iterator<MenuItem> iterator;
    private MenuItem lastItemReturned;

    public CafeMenuIterator(HashMap<String, MenuItem> menuItems) {
        this.iterator = menuItems.values().iterator();
        this.lastItemReturned = null;
    }

    @Override
    public boolean hasNext() {
        return iterator.hasNext();
    }

    @Override
    public MenuItem next() {
        lastItemReturned = iterator.next();
        return lastItemReturned;
    }

    @Override
    public void remove() {
        if (lastItemReturned == null) {
            throw new IllegalStateException("next() never called or already removed.");
        }
        iterator.remove();
        lastItemReturned = null; // Reset lastItemReturned to ensure remove() is called only once per call to next().
    }
}
