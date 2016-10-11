package Commands;

import java.util.ArrayList;

/**
 * Class for calculation average price of certain type of products.
 *
 * @author Siarhei Tuzhyk
 * @version 1.1
 * @since 11.10.2016
 */
public class AveragePriceOfType extends InstructionBuild {
    private final String PREFIX = "average price ";
    // Field of class
    private String type;

    /**
     * Method for doing command.
     *
     * @param products entered products
     */
    @Override
    public void doCommand(ArrayList<Product> products) {
        double averagePrice = 0;
        double quantityOfType = 0;
        for (Product x : products) {
            if (x.getType().equals(type)) {
                int quantity = x.getQuantity();
                quantityOfType += quantity;
                double averagePriceOfType = quantity * x.getPrice();
                averagePrice += averagePriceOfType;
            }
        }
        averagePrice /= quantityOfType;
        printMessage(averagePrice);
    }

    /**
     * Checking command for this class.
     *
     * @param command  entered command
     * @param products entered products
     * @return <>true</> if class can do this command
     * <>false</> otherwise
     */
    @Override
    public boolean canExecute(String command, ArrayList<Product> products) {
        if (command.startsWith(PREFIX)) {
            this.type = command.substring(PREFIX.length());
            doCommand(products);
            return true;
        } else {
            return false;
        }
    }

    /**
     * Method for print result of command.
     *
     * @param averagePrice average price of certain type of products
     */
    @Override
    public void printMessage(double averagePrice) {
        System.out.println("Average price of " + this.type + " product: " + averagePrice);
    }
}
