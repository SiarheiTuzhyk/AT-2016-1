package Commands;

/**
 * Class of product.
 *
 * @author Siarhei Tuzhyk
 * @version 1.0
 * @since 11.10.2016
 */
public class Product {
    //Fields of class
    private String type;
    private String name;
    private int quantity;
    private double price;

    /**
     * Constructor of Product class
     *
     * @param type     entered type of product
     * @param name     entered name of product
     * @param quantity entered quantity of product
     * @param price    entered price of product
     */
    public Product(String type, String name, int quantity, double price) {
        this.type = type;
        this.name = name;
        this.quantity = quantity;
        this.price = price;
    }

    /**
     * Method for get type of product
     *
     * @return type of product
     */
    public String getType() {
        return type;
    }

    /**
     * Method for get quantity of product
     *
     * @return quantity of product
     */
    public int getQuantity() {
        return quantity;
    }

    /**
     * Method for get price of product
     *
     * @return price of product
     */
    public double getPrice() {
        return price;
    }
}
