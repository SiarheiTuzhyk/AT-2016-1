import Commands.Product;

import java.util.ArrayList;
import java.util.Scanner;

/**
 * Class for input information.
 *
 * @author Siarhei Tuzhyk
 * @version 1.0
 * @since 11.10.2016
 */
public class InputCommands {
    /**
     * Method for input products.
     *
     * @return products arraylist with entered products
     */
    public ArrayList<Product> inputParameters() {
        ArrayList<Product> products = new ArrayList<>();
        boolean inputProducts = true;
        while (inputProducts) {
            System.out.println("Please, input your product: ");
            // Calls method for input fields of Product class.
            products.add(inputProduct());
            // Repeat input of products.
            System.out.println("Would you like add some product to your basket?\nYes - y    No - others symbols");
            inputProducts = canDoNextCommand();
        }
        return products;
    }

    /**
     * Method for input fields of Product class.
     *
     * @return new object of Product class
     */
    private Product inputProduct() {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter type of product: ");
        String type = scanner.nextLine();
        System.out.print("Enter name of product: ");
        String name = scanner.nextLine();
        System.out.print("Enter product quantity: ");
        int quantity = scanner.nextInt();
        System.out.print("Enter price of product: ");
        double price = scanner.nextDouble();
        return (new Product(type, name, quantity, price));
    }

    /**
     * Mathod for input command from command line.
     *
     * @return command for instruction.
     */
    public String inputCommands() {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Please, input your command: ");
        String command = scanner.nextLine();
        return command;
    }

    /**
     * Method for check desire of the user to enter next product or command.
     *
     * @return <>true</> if user choose input more products or commands
     * <>false</> otherwise
     */
    public boolean canDoNextCommand() {
        Scanner scanner = new Scanner(System.in);
        String inputCommand = scanner.nextLine();
        return (inputCommand.equals("y") || inputCommand.equals("yes")
                || inputCommand.equals("Yes")
                || inputCommand.equals("YES"));
    }
}
