import java.util.InputMismatchException;
import java.util.Scanner;
import java.util.ArrayList;

import java.util.concurrent.*;

import static java.lang.String.valueOf;

/**
 * This class is in charge of payment processes in the vending machine.
 */
public class CashRegister {

    /**
     * This constructor sets total sales, summary sales and denominations to their default values respectively.
     */
    public CashRegister () {
        totalSales = 0;
        for(int i = 0; i < 9; i++) {
            replenishChange(denomination[i], 0);
        }
    }

    /**
     * This method receives the payment and amount to be paid by the user and check if its right.
     * It also checks if there's enough change, if necessary.
     *
     * @param amountToPay the total amount to be paid by the user
     * @param tempPay the payment of the user
     *
     * @return true if the payment is correct and there's enough change if needed. Otherwise returns false
     */
    public boolean receivePaymentModel (float amountToPay, ArrayList<Float> tempPay) {
        int[] counts = {0, 0, 0, 0, 0, 0, 0, 0, 0};
        float payment = 0;

        for (int i = 0; i < 9; i++)
            for(int j = 0; j < tempPay.size(); j++)
                if (tempPay.get(j) == denomination[i]) {
                    payment += tempPay.get(j);
                    replenishChange(denomination[i], 1);
                }

        if(amountToPay == payment) {
            totalSales += amountToPay;
            denominationList.add("Change: 0");
            denominationList.add("Remaining balance:");
            denominationList.add("P1: " + getDenomination(0));
            denominationList.add("P5: " + getDenomination(1));
            denominationList.add("P10: " + getDenomination(2));
            denominationList.add("P20: " + getDenomination(3));
            denominationList.add("P50: " + getDenomination(4));
            denominationList.add("P100: " + getDenomination(5));
            denominationList.add("P200: " + getDenomination(6));
            denominationList.add("P500: " + getDenomination(7));
            denominationList.add("P1000: " + getDenomination(8));
            return true;
        }
        else if (amountToPay > payment) {
            denominationList.add("Payment Processing Issue");
            denominationList.add("Sorry, the payment is not enough.");
            denominationList.add("Your payment will be returned to you promptly");
            denominationList.add("Please try again.");
            denominationList.add("--------------------");
            giveMoneyModel(payment);
            return false;
        }
        else if(isEnoughChange(payment-amountToPay, counts)) {
            totalSales += amountToPay;
            giveMoneyModel(payment-amountToPay);
            return true;
        }
        else {
            denominationList.add("Payment Processing Issue");
            denominationList.add("Sorry, change is not enough");
            denominationList.add("Your payment will be returned to you promptly");
            denominationList.add("Please try again later.");
            denominationList.add("--------------------");
            giveMoneyModel(payment);
            return false;
        }
    }

    /**
     * This method returns the money to the user
     *
     * @param amt is the amoumt to be returned to the user
     *
     * @return the money or change of the user
     */
    public float giveMoneyModel (float amt) {
        int[] count = {0, 0, 0, 0, 0, 0, 0, 0, 0};
        String text = "";

        if(isEnoughChange(amt, count)) {
            for(int i = 8; i >= 0; i--) {
                if(count[i] != 0) {
                    text = "Denomination " + denomination[i] + ".0: " + count[i];
                    denominationList.add(text);
                    decreaseChange(denomination[i], count[i]);
                    count[i] = 0;
                }
            }

            denominationList.add("Remaining balance:");
            denominationList.add("P1: " + getDenomination(0));
            denominationList.add("P5: " + getDenomination(1));
            denominationList.add("P10: " + getDenomination(2));
            denominationList.add("P20: " + getDenomination(3));
            denominationList.add("P50: " + getDenomination(4));
            denominationList.add("P100: " + getDenomination(5));
            denominationList.add("P200: " + getDenomination(6));
            denominationList.add("P500: " + getDenomination(7));
            denominationList.add("P1000: " + getDenomination(8));
        }
        return amt;
    }

    /**
     * This method returns the denominationList
     *
     * @return Arraylist<String> where the denomination texts are stored
     */
    public ArrayList<String> getDisplayText () {
        return denominationList;
    }

    /**
     * This method clears the content of denomination list
     */
    public void setDenominationList () {
        denominationList.clear();
    }

    /**
     * This method checks if there's enough change for the transaction to proceed.
     *
     * @param change change of the customer.
     * @param count array which contains the count per denomination
     * @return true if there's enough change. Otherwise, false.
     */
    public boolean isEnoughChange(float change, int[] count) {

        for(int i = 8; i >= 0; i--) {
            while (denomination[i] <= change) {
                count[i]++;
                if(count[i] <= getDenomination(i)) {
                    change -= denomination[i];
                }
                else {
                    count[i]--;
                    break;
                }
            }
        }

        if(change == 0)
            return true;
        else return false;
    }

    /**
     * This method returns the computed total amount in the vending machine
     *
     * @return the total mooney in the vending machine
     */
    public float getTotalMoney () {
        return  (p1Count.size() + p5Count.size() * 5 + p10Count.size() * 10 + p20Count.size() * 20 + p50Count.size() * 50 +
                p100Count.size() * 100 + p200Count.size() * 200 + p500Count.size() * 500 + p1000Count.size() * 1000);
    }

    /**
     * This method returns the number of 1 peso coin
     *
     * @return ArrayList of 1 peso coin
     */
    public ArrayList<Money> getP1() {
        return p1Count;
    }

    /**
     * This method returns the number of 5 peso coin
     *
     * @return ArrayList of 5 peso coin
     */
    public ArrayList<Money> getP5 () {
        return p5Count;
    }

    /**
     * This method returns the number of 10 peso coin
     *
     * @return ArrayList of 10 peso coin
     */
    public ArrayList<Money> getP10 () {
        return p10Count;
    }

    /**
     * This method returns the number of 20 peso bill
     *
     * @return ArrayList of 20 peso bill
     */
    public ArrayList<Money> getP20 () {
        return p20Count;
    }

    /**
     * This method returns the number of 50 peso bill
     *
     * @return ArrayList of 50 peso bill
     */
    public ArrayList<Money> getP50 () {
        return p50Count;
    }

    /**
     * This method returns the number of 100 peso bill
     *
     * @return ArrayList of 100 peso bill
     */
    public ArrayList<Money> getP100 () {
        return p100Count;
    }

    /**
     * This method returns the number of 200 peso bill
     *
     * @return ArrayList of 200 peso bill
     */
    public ArrayList<Money> getP200 () {
        return p200Count;
    }

    /**
     * This method returns the number of 500 peso bill
     *
     * @return ArrayList of 500 peso bill
     */
    public ArrayList<Money> getP500 () {
        return p500Count;
    }

    /**
     * This method returns the number of 1000 peso bill
     *
     * @return ArrayList of 1000 peso bill
     */
    public ArrayList<Money> getP1000 () {
        return p1000Count;
    }

    /**
     * This method sets the value of totalSales
     *
     * @param amount amount to be set
     */
    public void setTotalSales (float amount) {
        totalSales = amount;
    }

    /**
     * This method clears the arraylist of all denomination and sets it to zero
     */
    public void setChange () {
        getP1().clear();
        getP5().clear();
        getP10().clear();
        getP20().clear();
        getP50().clear();
        getP100().clear();
        getP200().clear();
        getP500().clear();
        getP1000().clear();

        for(int i = 0; i < 9; i++) {
            replenishChange(denomination[i], 0);
        }
    }


    //maintenance functions
    /**
     * Replenishes the count of a specific denomination of change in the vending machine.
     *
     * This method increases the count of a specific denomination of change in the vending machine
     * by the specified amount.
     *
     * @param denomination the denomination of the change (e.g., 1, 5, 10, etc.)
     * @param amt the amount to replenish for the specified denomination
     */
    public void replenishChange (int denomination, int amt) {
        switch (denomination) {
            case 1 -> {
                for (int i = 0; i < amt; i++)
                    p1Count.add(new Money(1));
            }
            case 5 -> {
                for (int i = 0; i < amt; i++)
                    p5Count.add(new Money(5));
            }
            case 10 -> {
                for (int i = 0; i < amt; i++)
                    p10Count.add(new Money(10));
            }
            case 20 -> {
                for (int i = 0; i < amt; i++)
                    p20Count.add(new Money(20));
            }
            case 50 -> {
                for (int i = 0; i < amt; i++)
                    p50Count.add(new Money(50));
            }
            case 100 -> {
                for (int i = 0; i < amt; i++)
                    p100Count.add(new Money(100));
            }
            case 200 -> {
                for (int i = 0; i < amt; i++)
                    p200Count.add(new Money(200));
            }
            case 500 -> {
                for (int i = 0; i < amt; i++)
                    p500Count.add(new Money(500));
            }
            case 1000 -> {
                for (int i = 0; i < amt; i++)
                    p1000Count.add(new Money(1000));
            }
            default -> throw new IllegalStateException("Unexpected value: " + denomination);
        }
    }

    /**
     * Decreases the count of a specific denomination of change in the vending machine.
     *
     * This method decreases the count of a specific denomination of change in the vending machine
     * by the specified amount.
     *
     * @param denomination the denomination of the change (e.g., 1, 5, 10, etc.)
     * @param amt the amount to replenish for the specified denomination
     */
    public void decreaseChange(int denomination, int amt) {
        ArrayList<Money> targetList;

        switch (denomination) {
            case 1:
                targetList = p1Count;
                break;
            case 5:
                targetList = p5Count;
                break;
            case 10:
                targetList = p10Count;
                break;
            case 20:
                targetList = p20Count;
                break;
            case 50:
                targetList = p50Count;
                break;
            case 100:
                targetList = p100Count;
                break;
            case 200:
                targetList = p200Count;
                break;
            case 500:
                targetList = p500Count;
                break;
            case 1000:
                targetList = p1000Count;
                break;
            default:
                throw new IllegalStateException("Unexpected value: " + denomination);
        }

        int listSize = targetList.size();
        if (amt > listSize) {
            throw new IllegalArgumentException("The amount to decrease is greater than the number of available coins.");
        }

        // Iterate in reverse and remove elements from the list
        for (int i = listSize - 1; i >= listSize - amt; i--) {
            targetList.remove(i);
        }
    }


    /**
     * This method returns specific denomination count
     *
     * @param denomination specific denomination
     * @return specific denomination count
     */
    public int getDenomination (int denomination) {
        return switch (denomination) {
            case 0 -> getP1().size();
            case 1 -> getP5().size();
            case 2 -> getP10().size();
            case 3 -> getP20().size();
            case 4 -> getP50().size();
            case 5 -> getP100().size();
            case 6 -> getP200().size();
            case 7 -> getP500().size();
            case 8 -> getP1000().size();
            default -> throw new IllegalStateException("Unexpected value: " + denomination);
        };
    }

    /**
     * This method returns the total sales.
     *
     * @return total sales of the vending machine
     */
    public float getTotalSales() {
        return totalSales;
    }

    //ATTRIBUTES
    /** denomination of the change */
    private static int[] denomination = {1, 5, 10, 20, 50, 100, 200, 500, 1000};
    /** Arraylist containing the texts */
    private ArrayList<String> denominationList = new ArrayList<>();
    /** 1 peso count */
    private ArrayList<Money> p1Count = new ArrayList<Money>();
    /** 5 peso count */
    private ArrayList<Money> p5Count = new ArrayList<Money>();
    /** 10 peso count */
    private ArrayList<Money> p10Count = new ArrayList<Money>();
    /** 20 peso count */
    private ArrayList<Money> p20Count = new ArrayList<Money>();
    /** 50 peso count */
    private ArrayList<Money> p50Count = new ArrayList<Money>();
    /** 100 peso count */
    private ArrayList<Money> p100Count = new ArrayList<Money>();
    /** 200 peso count */
    private ArrayList<Money> p200Count = new ArrayList<Money>();
    /** 500 peso count */
    private ArrayList<Money> p500Count = new ArrayList<Money>();
    /** 1000 peso count */
    private ArrayList<Money> p1000Count = new ArrayList<Money>();
    /** total sales accumulated in the vending machine */
    private float totalSales;
}