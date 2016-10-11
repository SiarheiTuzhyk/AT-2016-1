package Commands;

import java.util.ArrayList;

/**
 * Class for count quantity of all products.
 *
 * @author Siarhei Tuzhyk
 * @version 1.0
 * @since 11.10.2016
 */
public class CountAllProducts extends InstructionBuild {
    /**
     * Method for doing command.
     *
     * @param products entered products
     */
    @Override
    public void doCommand(ArrayList<Product> products) {
        double count = 0;
        for (Product x : products) {
            count += x.getQuantity();
        }
        printMessage(count);
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
        return command.equals("count all");
    }

    /**
     * Method for print result of command.
     *
     * @param count quantity of all products
     */
    @Override
    public void printMessage(double count) {
        System.out.println("Quantity of all products: " + count);
    }
}
