package behavioral.iterator;


import behavioral.strategy.Item;

public class ItemCollection implements Collection
{
    static final int MAX_ITEMS = 10;
    int numberOfItems = 0;
    Item[] items;

    public ItemCollection()
    {
        items = new Item[MAX_ITEMS];
    }

    public void addItem(String str, int price)
    {
        Item item = new Item(str, price);
        if (numberOfItems >= MAX_ITEMS)
            System.err.println("Full");
        else
        {
            items[numberOfItems] = item;
            numberOfItems = numberOfItems + 1;
        }
    }

    public Iterator createIterator()
    {
        return new ItemIterator(items);
    }
}