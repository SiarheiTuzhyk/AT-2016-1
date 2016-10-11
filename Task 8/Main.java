import Commands.Product;

import java.util.ArrayList;

/**
 * Main class of program. Entrance point to the program.
 * This class calls methods of other classes.
 *
 * @author Siarhei Tuzhyk
 * @version 1.0
 * @since 11.10.2016
 */
public class Main {
    /**
     * Method initialize arraylist of products, objects of InputCommands and Builder classes.
     *
     * @param args arguments from command line
     */
    public static void main(String[] args) {
        ArrayList<Product> products = new ArrayList<>();
        try {
            InputCommands inCom = new InputCommands();
            // Call method for input products from keyboard.
            products = inCom.inputParameters();
            Builder builder = new Builder();
            // Call method for use input command to instructions.
            builder.commands(products, inCom);
        } catch (Exception e) {
            System.out.println("Program error.");
        }
    }
}
