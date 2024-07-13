public class Transaction {
    public Transaction(Item item, float amount)
    {
        itemBought = item;
        amountPaid = amount;
    }

    public Item getItemBought()
    {
        return itemBought;
    }

    public float getAmountPaid()
    {
        return amountPaid;
    }

    private Item itemBought;
    private float amountPaid;
}
