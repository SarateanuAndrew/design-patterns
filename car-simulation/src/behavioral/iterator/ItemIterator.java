package behavioral.iterator;

import behavioral.strategy.Item;

public class ItemIterator implements Iterator {
    Item[] items;

    // maintains curr pos of iterator over the array
    int pos = 0;

    // Constructor takes the array of items are
    // going to iterate over.
    public ItemIterator(Item[] items) {
        this.items = items;
    }

    public Object next() {
        // return next element in the array and increment pos
        Item item = items[pos];
        pos += 1;
        return item;
    }

    public boolean hasNext() {
        if (pos >= items.length ||
                items[pos] == null)
            return false;
        else
            return true;
    }
}
