package Commands;

import java.util.ArrayList;

/**
 * Class for count types of products
 *
 * @author Siarhei Tuzhyk
 * @version 1.0
 * @since 11.10.2016
 */
public class CountTypes extends InstructionBuild {
    /**
     * Method for doing command.
     *
     * @param products entered products
     */
    @Override
    public void doCommand(ArrayList<Product> products) {
        ArrayList<String> types = new ArrayList<>();
        int count;
        for (Product x : products) {
            types.add(x.getType());
        }
        count = searchRepeatTypes(types);
        printMessage(types.size() - count);
    }

    /**
     * Method for search repeat types of products.
     *
     * @param types entered types
     * @return repeatCount number of repeat types
     */
    private int searchRepeatTypes(ArrayList<String> types) {
        int repeatCount = 0;
        for (int i = 0; i < types.size(); i++) {
            for (int j = i + 1; j < types.size(); j++) {
                if (types.get(i).equals(types.get(j))) {
                    ++repeatCount;
                }
            }
        }
        return repeatCount;
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
        return command.equals("count types");
    }

    /**
     * Method for print result of command.
     *
     * @param count types of product
     */
    @Override
    public void printMessage(double count) {
        System.out.println("Count of types: " + count);
    }
}
