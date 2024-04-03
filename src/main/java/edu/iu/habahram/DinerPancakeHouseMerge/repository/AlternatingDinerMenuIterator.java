package edu.iu.habahram.DinerPancakeHouseMerge.repository;

import edu.iu.habahram.DinerPancakeHouseMerge.model.MenuItem;

import java.util.Calendar;
import java.util.Iterator;

public class AlternatingDinerMenuIterator implements Iterator<MenuItem> {
    MenuItem[] items;
    int position = 0;
    Calendar date = Calendar.getInstance();
    int dayOfWeek = date.get(Calendar.DAY_OF_WEEK);
    public AlternatingDinerMenuIterator(MenuItem[] items) {
        this.items = items;
        boolean isOddDay = false;
        switch (dayOfWeek) {
            case Calendar.MONDAY:
            case Calendar.WEDNESDAY:
            case Calendar.FRIDAY:
            case Calendar.SUNDAY:
                isOddDay = false;
                break;
            case Calendar.TUESDAY:
            case Calendar.THURSDAY:
            case Calendar.SATURDAY:
                isOddDay = true;
                break;
        }

        position = isOddDay ? 1 : 0;
        if (!isValidDay(dayOfWeek, position)) {
            position = findNextValidPosition(dayOfWeek, position);
        }
    }

    @Override
    public boolean hasNext() {
        return findNextValidPosition(dayOfWeek, position) < items.length;
    }

    @Override
    public MenuItem next() {
        MenuItem menuItem = items[position];
        position = findNextValidPosition(dayOfWeek, position + 1);
        return menuItem;
    }

    private boolean isValidDay(int dayOfWeek, int position) {
        boolean isOddPosition = position % 2 != 0;
        switch (dayOfWeek) {
            case Calendar.MONDAY:
            case Calendar.WEDNESDAY:
            case Calendar.FRIDAY:
            case Calendar.SUNDAY:
                return !isOddPosition;
            case Calendar.TUESDAY:
            case Calendar.THURSDAY:
            case Calendar.SATURDAY:
                return isOddPosition;
            default:
                return false;
        }
    }

    private int findNextValidPosition(int dayOfWeek, int startPosition) {
        for (int i = startPosition; i < items.length; i++) {
            if (isValidDay(dayOfWeek, i) && items[i] != null) {
                return i;
            }
        }
        return items.length;
    }
}
