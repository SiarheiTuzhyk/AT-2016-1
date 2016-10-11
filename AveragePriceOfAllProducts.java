package Commands;

import java.util.ArrayList;

/**
 * Class for calculation average price of all products.
 *
 * @author Siarhei Tuzhyk
 * @version 1.1
 * @since 11.10.2016
 */
public class AveragePriceOfAllProducts extends InstructionBuild {
    private final String COMMAND = "average price";

    /**
     * Method for doing command.
     *
     * @param products entered products
     */
    @Override
    public void doCommand(ArrayList<Product> products) {
        double averagePrice = 0;
        int quantity_all = 0;
        for (Product x : products) {
            int quantity = x.getQuantity();
            quantity_all += quantity;
            double averagePriceOfGoods = quantity * x.getPrice();
            averagePrice += averagePriceOfGoods;
        }
        averagePrice /= quantity_all;
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
        if (command.equals(COMMAND)) {
            doCommand(products);
        }
        return command.equals(COMMAND);
    }

    /**
     * Method for print result of command.
     *
     * @param averagePrice average price of all products
     */
    @Override
    public void printMessage(double averagePrice) {
        System.out.println("Average price of all products: " + averagePrice);
    }
}
