package behavioral.iterator;

import behavioral.strategy.Item;

public class ItemBar {
    ItemCollection itemCollection;
    public ItemBar(ItemCollection itemCollection) {
        this.itemCollection = itemCollection;
    }

    public void printItemsPrices() {
        Iterator iterator = itemCollection.createIterator();
        System.out.println("-------NOTIFICATION BAR------------");
        while (iterator.hasNext()) {
            Item n = (Item) iterator.next();
            System.out.println(n.getPrice());
        }
    }
}
