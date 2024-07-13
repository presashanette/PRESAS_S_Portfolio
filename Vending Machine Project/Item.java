/**
 * This class represents the items in the vending machine.
 */
public class Item {

  /**
   * This constructor initializes name, calories, price,
   * image filename, preparation text, and states whether
   * the item can be sold individually or not.
   *
   * @param name name of the item
   * @param calories calories content of the item
   * @param price price of the item
   * @param imagePath filename of the image of the item
   * @param prep text to be printed when item is being prepared
   * @param isSoldIndiv status if the item can be sold individually
   */
  public Item(String name, int calories, float price, String imagePath, String prep, boolean isSoldIndiv) {
    this(name, calories, price, imagePath, prep);
    this.isSoldIndiv = isSoldIndiv;
  }

  /**
   * This constructor initializes the name, calories, price,
   * image filename, and preparation text of the item.
   *
   * @param name name of the item
   * @param calories calories content of the item
   * @param price price of the item
   * @param imagePath filename of the image of the item
   * @param prep text to be printed when item is being prepared
   */
  public Item(String name, int calories, float price, String imagePath, String prep) {
    this.name = name;
    if (calories > 0)
      this.calories = calories;
    setPrice(price);
    this.imagePath = imagePath;
    this.prep = prep;
  }

  /**
   * This method returns the name of the item.
   *
   * @return name of the item
   */
  public String getName() {
    return name;
  }

  /**
   * This method returns the calories in the item
   *
   * @return calories content of the item
   */
  public int getCalories() {
    return calories;
  }

  /**
   * This method returns the price of the item
   *
   * @return price of the item
   */
  public float getPrice() {
    return price;
  }

  /**
   * This method returns the preparation text of the item.
   *
   * @return the text to print while preparing the item
   */
  public String getPrep()
  {
    return prep;
  }

  /**
   * This method returns the filename of the image
   * of the item.
   *
   * @return the filename of the image of the item
   */
  public String getImagePath()
  {
    return imagePath;
  }

  // maintenance function
  /**
   * This method sets the price of the item, only if it's positive.
   *
   * @param price price of the item
   * @return 1 if the price is valid, 0 otherwise
   */
  public int setPrice(float price) {
    if (price > 0)
    {
      this.price = price;
      return 1;
    }

    return 0;

  }

  /**
   * This method returns the status of the item,
   * if it can be sold individually or not.
   *
   * @return if the item can be sold individually or not
   */
  public boolean getIsSoldIndiv() {
    return isSoldIndiv;
  }

  /** name of the item */
  private String name;
  /** calories content of the item */
  private int calories;
  /** price of the item */
  private float price;
  /** text to display when preparing the item */
  private String prep;
  /** filename of the image of the item */
  private String imagePath;
  /** status if the item can be sold individually */
  private boolean isSoldIndiv;
}