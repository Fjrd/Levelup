package homework.lesson01;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class LinearEquations {

    public static void main(String[] args) {

        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        double a,b,x = 0; // a*x + b = 0
        try{
            System.out.println("Enter value of variable 'a':");
            a = Double.parseDouble(reader.readLine());
            System.out.println("Enter value of variable 'b':");
            b = Double.parseDouble(reader.readLine());
            x = (-b/a);
        } catch (IOException e) {
            e.printStackTrace();
        }
        System.out.println("x = " + x);
    }
}
