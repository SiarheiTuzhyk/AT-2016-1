import Commands.*;

import java.util.ArrayList;

/**
 * Class for build commands.
 *
 * @author Siarhei Tuzhyk
 * @version 1.1
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
        boolean willNextEnterOfCommand = true;
        while (willNextEnterOfCommand) {
            String command = inCom.inputCommands();
            int count = executeCommands(command, products);
            willNextEnterOfCommand = checkExecutionOfCommand(count, command);
        }
    }

    /**
     * Method for use command to instructions.
     *
     * @param command  input command, which entered user
     * @param products arraylist of entered products
     */
    public int executeCommands(String command, ArrayList<Product> products) {
        // Check count of command execution
        int count = 0;
        ArrayList<InstructionBuild> commands = buildCommands();
        for (InstructionBuild instruction : commands) {
            if (instruction.canExecute(command, products)) {
                count++;
            }
        }
        return count;
    }

    /**
     * Method for check number of command execution.
     *
     * @param count   number of command execution
     * @param command entered command
     * @return <>true</> if method worked without incident
     * <>else</> if method worked with incident
     */
    private boolean checkExecutionOfCommand(int count, String command) {
        boolean commandTrue = true;
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
