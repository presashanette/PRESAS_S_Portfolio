import java.util.*;

/**
 * This class is in charge of handling the functions related to the Regular
 * Vending Machine.
 */
public class RegularVM {
  /**
   * This constructor sets the default slotLimit to 12, and initializes
   * the slots array to the size slotLimit. It also initializes the cash
   * register that will be used.
   */
  public RegularVM() {
    this.slotLimit = 12;
    slots = new Slot[slotLimit];
    cashRegister = new CashRegister();

    setItemChoices();
  }

  /**
   * This method initializes each item that the user can choose from
   * when stocking the vending machine.
   */
  public void setItemChoices () {
    int i=0;
    itemChoices[i] = new Item("Beef",250, 250, "beef.png", "Topping with beef...");
    i++;
    itemChoices[i] = new Item("Chashu Pork", 72, 150, "chashuPork.png", "Topping with chashu pork...");
    i++;
    itemChoices[i] = new Item("Egg", 55, 25, "egg.png", "Topping with egg...");
    i++;
    itemChoices[i] = new Item("Fish Cake", 110, 120, "fishCake.png", "adding fish cake...");
    i++;
    itemChoices[i] = new Item("Fried Tofu", 270, 120, "friedTofu.png", "Topping with fried tofu...");
    i++;
    itemChoices[i] = new Item("Gyoza", 285, 200, "gyoza.png", "adding gyoza...");
    i++;
    itemChoices[i] = new Item("Noodles", 138, 175, "noodles.png", "Blanching noodles...");
    i++;
    itemChoices[i] = new Item("Pork Tonkatsu", 313, 200, "porkTonkatsu.png", "Topping with pork tonkatsu...");
    i++;
    itemChoices[i] = new Item("Rice", 130, 50, "rice.png", "adding rice...");
    i++;
    itemChoices[i] = new Item("Shrimp", 85, 250, "shrimp.png", "Topping with shrimp...");
    i++;
    itemChoices[i] = new Item("Smoked Salmon", 117, 250, "smokedSalmon.png", "Topping with smoked salmon...");
    i++;
    itemChoices[i] = new Item("Tempura", 150, 300, "tempura.png", "Topping with tempura...");
    i++;
    itemChoices[i] = new Item("Assorted Sushi", 580, 700, "sushi.png", "adding sushi...");
    i++;
    itemChoices[i] = new Item("Seaweed Chips", 166, 100, "seaweed.png", "adding seaweed chips...");
    i++;
    itemChoices[i] = new Item("Karaage", 230, 250, "karaage.png", "Topping with karaage...");
    i++;
    itemChoices[i] = new Item("Spam Musubi", 328, 200, "spamMusubi.png", "adding spam musibi...");
    i++;
    itemChoices[i] = new Item("Onigiri", 230, 100, "onigiri.png", "adding onigiri...");
    i++;
    itemChoices[i] = new Item("Udon", 310, 200, "udon.png", "Topping with udon...");
    i++;
    itemChoices[i] = new Item("Takoyaki", 420, 120, "takoyaki.png", "adding takoyaki...");
    i++;
    itemChoices[i] = new Item("Sashimi", 120, 280, "sashimi.png", "adding sashimi...");
    i++;
    itemChoices[i] = new Item("Yakitori", 423, 180, "yakitori.png", "adding yakitori...");
    i++;
    itemChoices[i] = new Item("Okonomiyaki", 570, 150, "okonomiyaki.png", "adding okonomiyaki...");
    i++;
    itemChoices[i] = new Item("Oden", 300, 120, "oden.png", "adding oden...");
    i++;
    itemChoices[i] = new Item("Soba", 100, 150, "soba.png", "adding soba...");
  }


  /**
   * This method is in charge of the buying process, it dispenses
   * the item and calls the methods involved to decrease the stocks
   * of the item.
   *
   * @param index index of the item in the vending machine
   */
  public void dispenseItem(int index) {

    if (slots[index].getNumOfItems() == 0)
    {
      slots[index] = null;
    }
    else
      slots[index].decreaseItems();
  }

  /**
   * This method returns the slots array of the vending machine.
   *
   * @return the slots array of the vending machine
   */
  public Slot[] getSlots() {
    return slots;
  }

  /**
   * This method sets the index of the slot to be accessed.
   *
   * @param slotIndex index of the slot to be accessed
   */
  public void setSlotIndex(int slotIndex) {
    this.slotIndex = slotIndex;
  }

  /**
   * This method assigns an item to a slot. It also checks
   * if the item to be added is already a duplicate.
   * If the slot index reaches the end, it rechecks all the
   * slots if there is an empty one.
   *
   * @param item       item to be kept in the slot
   * @param numOfItems number of stocks kept in the slot
   * @return 1 if the addition of the item to the slot was successful, 0 otherwise
   */
  public int setSlot(Item item, int numOfItems) {
    //to avoid adding the same item twice
    for(int i = 0; i < slotIndex; i++)
      if(item == slots[i].getItem())
        return 0;

    //to set the item to a slot
    if (slotIndex < slotLimit && numOfItems > 0 && numOfItems <= slotCapacity) {
      slots[slotIndex] = new Slot(item, numOfItems, slotCapacity);
      slotIndex++;
      return 1;
    }

    else if (slotIndex == slotLimit && numOfItems <= slotCapacity) // looks for an empty slot
    {
      for (int i = 0; i < slotLimit; i++) {
        if (slots[i].getNumOfItems() == 0) {
          slots[i] = new Slot(item, numOfItems, slotCapacity);
          slotIndex--;
          return 1;
        }
      }
    }
    return 0;
  }

  /**
   * This method sets the capacity of each slot.
   *
   * @param capacity maximum number of stocks per slot
   * @return 1 if the capacity is valid, 0 otherwise
   */
  public int setCapacityPerSlot (int capacity) {
    int result = 0;

    if (capacity >= 10) {
      this.slotCapacity = capacity;
      result = 1;
    } else if (capacity < 10) {
      result = 0;
    }
    return result;
  }

  /**
   * This method handles the restocking of the item given in the parameter.
   * The total sales is reset to 0 after restocking.
   *
   * @param index  index of the item to be restocked
   * @param addAmt amount of stocks to be added
   */
  public void restockItem(int index, int addAmt) {
    slots[index].restock(addAmt);
    cashRegister.setTotalSales(0);
  }

  /**
   * This method checks if the slots array is empty.
   *
   * @return true if the array is empty, false otherwise
   */
  public boolean isEmpty() {
    return slots[0] == null;
  }

  /**
   * This method empties the slots array.
   */
  public void emptySlots () {
    Arrays.fill(slots, null);
  }

  /**
   * This method gives access to the cash register.
   *
   * @return the instance of cash register
   */
  public CashRegister accessCashRegister () {
    return cashRegister;
  }

  /**
   * This method returns the item choices for the
   * vending machine.
   *
   * @return item choices array
   */
  public Item[] getItemChoices()
  {
    return itemChoices;
  }


  /** slots that store the items in the vending machine */
  protected Slot[] slots;
  /** limit on the number of slots in the vending machine*/
  private int slotLimit;
  /** payment involved in the buying process */
  private CashRegister cashRegister;
  /** index of the slot to be accessed */
  private int slotIndex = 0;
  /** maximum capacity per slot */
  private int slotCapacity;
  /** array of items to choose from for the contents of the vending machine */
  protected Item[] itemChoices = new Item[24];
}