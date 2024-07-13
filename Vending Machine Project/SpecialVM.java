import java.util.ArrayList;

/** This class is in charge of handling the slots,
 * items, and logic of a special vending machine
 */
public class SpecialVM extends RegularVM {

    /**
     * every item in a cuztomized product is stored here
     */
    private ArrayList<Item> cart = new ArrayList<>();

    /**
     * This constructor sets the default value of special vending machine by
     * calling its parent's class constructor. It also sets the Item choices for the users
     */
    public SpecialVM () {
        super();

        setItemChoices();
    }


    /**
     * This method overrides the method in RegularVM and initializes its own itemChoices array
     */
    @Override
    public void setItemChoices () {

        Item[] itemChoices = getItemChoices();

        int i=0;
        itemChoices[i] = new Item("Beef",250, 250, "beef.png", "Topping with beef...", true);
        i++;
        itemChoices[i] = new Item("Chashu Pork", 72, 150, "chashuPork.png", "Topping with chashu pork...", true);
        i++;
        itemChoices[i] = new Item("Egg", 55, 25, "egg.png", "Topping with egg...", true);
        i++;
        itemChoices[i] = new Item("Fish Cake", 110, 120, "fishCake.png", "Adding fish cake...", true);
        i++;
        itemChoices[i] = new Item("Fried Tofu", 270, 120, "friedTofu.png", "Topping with fried tofu...", true);
        i++;
        itemChoices[i] = new Item("Gyoza", 285, 200, "gyoza.png", "Adding gyoza...", true);
        i++;
        itemChoices[i] = new Item("Noodles", 138, 175, "noodlesSpecial.png", "Blanching noodles...", false);
        i++;
        itemChoices[i] = new Item("Cucumber", 16, 10, "cucumber.png", "Slicing cucumber...", false);
        i++;
        itemChoices[i] = new Item("Rice", 130, 50, "rice.png", "Adding rice...", true);
        i++;
        itemChoices[i] = new Item("Shrimp", 85, 250, "shrimp.png", "Topping with shrimp...", true);
        i++;
        itemChoices[i] = new Item("Smoked Salmon", 117, 250, "smokedSalmon.png", "Topping with smoked salmon...", false);
        i++;
        itemChoices[i] = new Item("Tempura", 150, 300, "tempura.png", "Topping with tempura...", true);
        i++;
        itemChoices[i] = new Item("Green Onion", 32, 50, "greenOnion.png", "Topping with green onions...", false);
        i++;
        itemChoices[i] = new Item("Sesame Oil", 884, 50, "sesameOil.png", "Adding sesame oil...", false);
        i++;
        itemChoices[i] = new Item("Nori", 35, 50, "nori.png", "Adding nori...", false);
        i++;
        itemChoices[i] = new Item("Black Pepper", 5, 10, "pepper.png", "Adding black pepper...", false);
        i++;
        itemChoices[i] = new Item("Ukokkei Broth", 50, 200, "broth.png", "Heating ukokkei broth...", false);
        i++;
        itemChoices[i] = new Item("Sesame Seeds", 52, 20, "sesameSeeds.png", "Topping with sesame seeds...", false);
        i++;
        itemChoices[i] = new Item("Tonkotsu Broth", 357, 200, "broth.png", "Heating tonkotsu broth...", false);
        i++;
        itemChoices[i] = new Item("Miso Broth", 40, 150, "broth.png", "Heating miso broth...", false);
        i++;
        itemChoices[i] = new Item("Yakitori", 423, 180, "yakitori.png", "Adding yakitori...", true);
        i++;
        itemChoices[i] = new Item("Shio Broth", 42, 150, "broth.png", "Heating shio broth...", false);
        i++;
        itemChoices[i] = new Item("Tuna", 132, 80, "tuna.png", "Adding tuna...", false);
        i++;
        itemChoices[i] = new Item("Soba", 100, 150, "soba.png", "Adding soba...", true);
    }

    /**
     * This method displays the preparation done on the items selected by the user
     * to create the customized product.
     *
     * @param index the index of the item to be printed
     *
     * @return string preparation of an item
     */
    public String displayPrep (int index) {
        return slots[index].getItem().getPrep() + "\n";
    }

    /**
     * This method computes the total amount to be paid by the user/buyer
     *
     * @return the total amount to be paid by the user
     */
    public float computeTotal () {
        float total = 0;

        for(int i = 0; i < cart.size(); i++) {
            total += cart.get(i).getPrice();
        }
        return total;
    }

    /**
     * This method computes the total calories from the items picked by the user/buyer
     *
     * @return cal returns the total calories of the customized product
     */
    public float computeCal () {
        int cal = 0;

        for(int i = 0; i < cart.size(); i++) {
            cal += cart.get(i).getCalories();
        }
        return cal;
    }

    /**
     * This method add the items to the cart
     *
     * @param item is the item to be added to the cart
     */
    public void addItem (Item item) {
        cart.add(item);
    }

    /**
     * This method returns the cart
     *
     * @return the cart where the items selected are stored
     */
    public ArrayList<Item> getCart () {
        return cart;
    }

    /**
     * This method clear the contents of the cart
     */
    public void removeAllItem () {
        cart.clear();
    }
}