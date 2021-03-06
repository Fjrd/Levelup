package homework.lesson02;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class QuadraticEquation {

    //variables and discriminant
    static double a, b, c, d;

    //roots
    static double x1, x2;

    public static void main(String[] args) {
        inputVariables();
        calculateDiscriminant();
        calculateAndPrintRoots();
    }


    public static void inputVariables() {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        try {
            System.out.println("Input a:");
            a = Double.parseDouble(reader.readLine());
            System.out.println("Input b:");
            b = Double.parseDouble(reader.readLine());
            System.out.println("Input c:");
            c = Double.parseDouble(reader.readLine());
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private static void calculateDiscriminant() {
        d = Math.pow(b, 2) - 4.0 * a * c;
    }

    private static void calculateAndPrintRoots() {
        if (d > 0.0){
            x1 = (-b + Math.sqrt(d)) / (2.0 * a);
            x2 = (-b - Math.sqrt(d)) / (2.0 * a);
            printTwoRoots(x1, x2);
        }
        else if (d == 0.0) {
            x1 = -b / (2.0 * a);
            printOneRoots(x1);
        }
        else
        printNoRoots();


    }

    private static void printTwoRoots(double x1, double x2) {
        System.out.println("The roots are: " + x1 + " and " + x2);

    }


    private static void printOneRoots(double x1) {
        System.out.println("The root is: " + x1);
    }


    private static void printNoRoots() {
        System.out.println("The equation has no real roots.");
    }

}
