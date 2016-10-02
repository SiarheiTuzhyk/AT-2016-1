//package Homework_1;

/**
 * This program is intended for search roots of a quadratic equation.
 */
import java.util.*;

public class QuadraticEquation {

    public static void main(String[] args){

        // Initialization of parameters
        Scanner scanner = new Scanner(System.in);
        double a;
        double b;
        double c;

        // Data input
        System.out.print("Please, enter coefficients of quadratic equation:\na = ");
        a = scanner.nextDouble();
        if (a == 0) {
            System.out.print("You entered 'a' = 0.\nThanks for all :)");
            //a = scanner.nextInt();
            System.exit(0);
        }
        System.out.print("b = ");
        b = scanner.nextDouble();
        System.out.print("c = ");
        c = scanner.nextDouble();
        System.out.println("Your quadratic equation is: ("+a+")x^2 + ("+b+")x + ("+c+")");

        // Operation for searching roots of quadratic equation
        searchRootsOfQuadraticEquation(a,b,c);
    }

    public static void searchRootsOfQuadraticEquation(double a, double b, double c){

        // Initialization of parameters
        double firstRoot;
        double secondRoot;
        double delta = Math.pow(b,2) - 4*a*c;

        // Search roots under certain conditions
        if(delta > 0){
            firstRoot = (-b+Math.sqrt(delta))/(2*a);
            secondRoot = (-b-Math.sqrt(delta))/(2*a);
            System.out.println("Roots of quadratic equation:\nFirst root = " + firstRoot + ";\nSecond root = " + secondRoot + ";");

        }
        else if(delta == 0){
            firstRoot = (-b);
            firstRoot /= (2*a);
            //secondRoot = firstRoot;
            //System.out.println("Roots of quadratic equation:\nFirst root = " + firstRoot + ";\nSecond root = " + secondRoot + ";");
            System.out.println("Root of quadratic equation:\nRoot = " + firstRoot + ";");
        }
        else if(delta < 0){
            System.out.println("Quadratic equation has no real roots.");
        }
    }
}
