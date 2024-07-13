import java.util.ArrayList;

/**
 * This class represents each slot in the vending machine
 */
public class Slot
{
    /**
     * This constructor initializes the item in a slot,
     * the number of stocks in it, and the capacity of each slot.
     * The count for the quantity sold is initialized to 0.
     * The initial number of stocks supplied is recorded as the
     * starting inventory of the item. Instances of the item is
     * also created and added to the list of stocks of the item.
     *
     * @param item the item assigned to the slot
     * @param numOfItems number of stocks of the item
     * @param capacity maximum number of items per slot
     */
    public Slot (Item item, int numOfItems, int capacity)
    {
        this.numOfItems = numOfItems;
        this.item = item;
        this.capacity = capacity;
        soldCount=0;
        startInventory = numOfItems;
        stocks = new ArrayList<>();

        //adds instances of the item to the stocks array
        for(int i=0; i<numOfItems; i++)
        {
            stocks.add(item);
        }
    }

    /**
     * This method returns the item in the slot.
     *
     * @return item assigned to the slot
     */
    public Item getItem ()
    {
        return item;
    }

    /**
     * This method returns the number of items in the slot
     *
     * @return number of items in the slot
     */
    public int getNumOfItems ()
    {
        return numOfItems;
    }

    /**
     * This method returns the starting inventory
     * of the item
     *
     * @return the initial stock of the item
     */
    public int getStartInventory()
    {
        return startInventory;
    }

    /**
     * This method returns the maximum capacity of each slot.
     *
     * @return maximum capacity of each slot
     */
    public int getCapacity()
    {
        return capacity;
    }

    /**
     * This method decreases the number of items in the slot
     * by 1, and destroys an instance of it. It also adds to
     * the count of the quantity sold
     */
    public void decreaseItems ()
    {
        numOfItems--;
        stocks.remove(stocks.lastIndexOf(item));
        soldCount++;
    }

    /**
     * This method restocks the items in the slot by the amount
     * to be added given in the parameter.
     *
     * @param addAmt amount of stocks to be added
     */
    public void restock (int addAmt)
    {
        numOfItems += addAmt;

        for (int i=0; i<addAmt; i++)
        {
            stocks.add(item);
        }

        startInventory = numOfItems;
    }

    /** item to be placed in the slot */
    private Item item;
    /** number of stocks in the slot*/
    private int numOfItems;
    /** number of stocks sold*/
    private int soldCount;
    /** starting number of stocks of the item */
    private int startInventory;
    /** maximum capacity of each slot */
    private int capacity;
    /** stock of items in each slot */
    private ArrayList<Item> stocks;
}