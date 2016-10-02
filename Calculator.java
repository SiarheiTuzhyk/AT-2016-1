//package Homework_1;
/**
 * This program calculate amount, difference, composition and division of two numbers.
 */

public class Calculator {
    public static void main(String[] args){

        // Initialization of parameters
        double firstNumber;
        double secondNumber;
        double amount;
        double difference;
        double composition;
        double division;

        // Checking amount of numbers
        if(args.length > 2)
            System.out.println("Input more than two numbers.");
        else if(args.length < 2)
            System.out.println("Enter more numbers.");
        else{

            // Conversion from 'String' to 'double'
            firstNumber = Double.parseDouble(args[0]);
            secondNumber = Double.parseDouble(args[1]);

            // Calculating amount, difference, composition and division
            amount = calculateAmount(firstNumber,secondNumber);
            difference = calculateDifference(firstNumber,secondNumber);
            composition = calculateComposition(firstNumber,secondNumber);
            division = calculateDivision(firstNumber,secondNumber);

            // Output results to the screen
            System.out.println("Amount of two numbers: " + amount + ";\nDifference of two numbers: " + difference +
            ";\nComposition of two numbers: " + composition + ";\nDivision of two numbers: " + division + ";");
        }
    }

    // This method for calculating the amount
    public static double calculateAmount(double first, double second){
        return first+second;
    }

    // Method for calculating the difference
    public static double calculateDifference(double first, double second){
        return first-second;
    }

    // Method for calculating the composition
    public static double calculateComposition(double first, double second){
        return first*second;
    }

    // Method for calculating the division
    public static double calculateDivision(double first, double second){
        return first/second;
    }
}
