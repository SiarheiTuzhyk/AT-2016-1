/**
 * This program calculate amount, difference, composition and division of two numbers.
 */
public class Calculator {
    // This method is needed to: input some argument, calculation and print results.
    public static void main (String[] args) {
        // Checking amount of numbers
        if (args.length > 2) {
            System.out.println("Input more than two numbers.");
            System.exit(1);
        } else if (args.length < 2) {
            System.out.println("Enter more numbers.");
            System.exit(1);
        } else {
            double firstNumber;
            double secondNumber;
            try {
                // Conversion from 'String' to 'double'
                firstNumber = Double.parseDouble(args[0]);
                secondNumber = Double.parseDouble(args[1]);
                // Initialization and calculating amount, difference, composition and division
                double amount;
                amount = calculateAmount(firstNumber, secondNumber);
                double difference;
                difference = calculateDifference(firstNumber, secondNumber);
                double composition;
                composition = calculateComposition(firstNumber, secondNumber);
                double division;
                division = calculateDivision(firstNumber, secondNumber);
                // Output results to the screen
                System.out.println("Amount of two numbers: " + amount + ";\nDifference of two numbers: " + difference +
                        ";\nComposition of two numbers: " + composition + ";\nDivision of two numbers: " + division + ";");
            } catch (Exception ex) {
                System.out.println("I/0 error.");
            }
        }
    }

    // This method for calculating the amount
    public static double calculateAmount(double first, double second) {
        return first + second;
    }

    // Method for calculating the difference
    public static double calculateDifference(double first, double second) {
        return first - second;
    }

    // Method for calculating the composition
    public static double calculateComposition(double first, double second) {
        return first * second;
    }

    // Method for calculating the division
    public static double calculateDivision(double first, double second) {
        if (second < 0.00001 && second > -0.00001) {
            System.out.println("You can't divide by zero! ");
            return 0;
        }
        else {
            return first / second;
        }
    }
}
