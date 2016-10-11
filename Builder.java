import Commands.*;

import java.util.ArrayList;

/**
 * Class for build commands.
 *
 * @author Siarhei Tuzhyk
 * @version 1.0
 * @since 11.10.2016
 */
public class Builder {
    /**
     * Method for use input command to instructions.
     *
     * @param products arraylist of products
     * @param inCom    object of InputCommands class
     */
    public void commands(ArrayList<Product> products, InputCommands inCom) {
        boolean commandTrue = true;
        while (commandTrue) {
            String command = inCom.inputCommands();
            commandTrue = doCommands(command, products);
            if (commandTrue == false) {
                break;
            }
        }
    }

    /**
     * Method for use command to instructions.
     *
     * @param command  input command, which entered user
     * @param products arraylist of entered products
     * @return <>true</> if method worked without incident
     * <>else</> if command equals to 'exit'
     */
    public boolean doCommands(String command, ArrayList<Product> products) {
        // Check for count of doing command.
        int count = 0;
        boolean commandTrue = true;
        ArrayList<InstructionBuild> commands = buildCommands();
        for (InstructionBuild instruction : commands) {
            if (instruction.canDo(command)) {
                instruction.doCommand(products);
                count++;
            }
        }
        // if count = 0, that command equals to 'exit', else command not identified.
        if (count == 0) {
            if (command.equals("exit") || command.equals("Exit") || command.equals("EXIT")) {
                System.out.println("Thanks for all! Goodbye!");
                commandTrue = false;
            } else {
                System.out.println("Your command not identified.");
            }
        }
        return commandTrue;
    }

    /**
     * Method for build instruction.
     *
     * @return commands arraylist of our commands
     */
    private ArrayList<InstructionBuild> buildCommands() {
        ArrayList<InstructionBuild> commands = new ArrayList<>();
        commands.add(new AveragePriceOfAllProducts());
        commands.add(new CountTypes());
        commands.add(new CountAllProducts());
        commands.add(new AveragePriceOfType());
        return commands;
    }
}
