/**
 * This class represents the money in the vending machine
 */
public class Money {

    /** This is the value of the money */
    private double value;

    /**
     * This constructor is responsible for setting the value of the money
     *
     * @param value is the value to be set to the money
     */
    public Money (double value) {
        if(value > 0)
            this.value = value;
    }
}
