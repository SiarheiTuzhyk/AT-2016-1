package Homework_1;

import java.util.Scanner;

/**
 *  This program is intended to identify the type of the triangle.
 */
public class Triangle {

    public static void main (String[] args){

        // Initialization of parameters
        Scanner scanner = new Scanner(System.in);
        double a;
        double b;
        double c;

        // Data input
        System.out.print("Please, enter line segments of the triangle:\nFirst segment = ");
        a = scanner.nextDouble();
        isReallyLineSegments(a); // Checking the entered number
        System.out.print("Second segment = ");
        b = scanner.nextDouble();
        isReallyLineSegments(b); // Checking the entered number
        System.out.print("Third segment = ");
        c = scanner.nextDouble();
        isReallyLineSegments(c); // Checking the entered number

        // Check the existence of a triangle
        if (isItTriangle(a,b,c))
            whatTypeOfTriangle(a,b,c); // Triangle type definition
        else{
            System.out.println("Triangle isn't exist.\nThanks for all :)");
        }
    }

    // Checking the entered number
    public static void isReallyLineSegments(double x){

        if (x <= 0) {
            System.out.print("Triangle with such line segment doesn't exist.\nThanks for all :)");
            System.exit(0);
        }
    }

    // Check the existence of a triangle
    public static boolean isItTriangle(double a, double b, double c) {

        if ((a < b + c) && (b < a + c) && (c < a + b)) {
            System.out.println("Triangle exist.");
            return true;
        }
        else
            return false;
    }

    // Triangle type definition
    public static void whatTypeOfTriangle(double a, double b, double c){
        if(a==b && b==c && a==c){
            System.out.println("It is a equilateral triangle.");
        }
        else if(isItAIsoscelesTriangle(a,b,c)){
            System.out.println("It is a isosceles triangle.");
        }
        else
            System.out.println("It is a scalene triangle.");
        System.out.println("Thanks for all :)");
    }

    // Checking on is isosceles type of triangle
    public static boolean isItAIsoscelesTriangle(double a, double b, double c){
        if((a==b && b!=c)||(b==c && a!=c)||(c==a && a!=b)){
            return true;
        }
        else
            return false;
    }
}
