/**
 Output of the array elements in the reverse order.
 */
public class CommandLineParams {
    // This method displays the arguments in the reverse order.
    public static void main(String[] args) {
        for(int i = args.length-1; i >= 0; i--) {
            // Output to the screen
            System.out.println("Argument " + i + " = " + args[i]);
        }
    }
}
