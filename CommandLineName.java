/**
 * Input name from command line and print next message "HELLO, 'name' "
 */
public class CommandLineName {
    // This method displays next message "HELLO, 'name' ", where 'name' - input argument from command line
    public static void main(String[] args){
        // Checking input parameters
        if(args.length > 1)
            System.out.println("You entered more than one name.");
        else if(args.length < 1)
            System.out.println("You need enter one name.");
        else {
            String name = args[0];
            // Output to the screen
            System.out.println("Hello, " + name);
        }
    }
}
