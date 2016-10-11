package Commands;

import java.util.ArrayList;

/**
 * Class for calculation average price of all products.
 *
 * @author Siarhei Tuzhyk
 * @version 1.0
 * @since 11.10.2016
 */
public class AveragePriceOfAllProducts extends InstructionBuild {
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
     * @param command entered command
     * @return <>true</> if class can do this command
     * <>false</> otherwise
     */
    @Override
    public boolean canDo(String command) {
        return command.equals("average price");
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
