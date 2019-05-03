package homework.lesson03.smartBride;

import java.io.*;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.Random;

public class SmartBride {
    String fileName = "";
    ArrayList<Suitor> suitors = new ArrayList<Suitor>();
    int numberOfGeneratedSuitors = 0;
    boolean isReadingFromFile = false;

    public void greetings() {
        System.out.println(
                "Enter path to .csv file like " +
                        "\"/home/username/package/test.csv\" " +
                        "or \"random\" to test some random dataset:");
    }

    public String inputNewCommand(){
        try (BufferedReader reader = new BufferedReader(new InputStreamReader(System.in))){
            String line = reader.readLine();
            return line;
        }
        catch (IOException e) {
            e.printStackTrace();
            return null;
        }
    }



    public void identifyCommand() {
        String command = inputNewCommand();
        if (command.equals("random")) {
            System.out.println("Enter the number of suitor objects to generate:");
            String number = inputNewCommand();
            System.out.println(number);
            //if (isInteger(line) && isAboveZero(line)){
            //    numberOfGeneratedSuitors = Integer.parseInt(line);
            //}
            //else
                System.out.println("Number must be above zero, try again:");

        }
        else {
            isReadingFromFile = true;
            fileName = command;
            // TODO: 03.05.19 path 
        }
    }


    public void fillArrayWithRandomDataSet() {
        for (int i = 0; i < numberOfGeneratedSuitors; i++) {
            Names randomName = Names.values()[new Random().nextInt(Names.values().length)];
            int randomIq = 60 + new Random().nextInt(140);
            suitors.add(new Suitor(randomName.toString(), randomIq));
        }
    }

    public void parseCSVFile() {
        String line = "";
        try(BufferedReader reader = new BufferedReader(new FileReader(fileName))){
            while ((line = reader.readLine())!= null){
                String[] parts = line.split(",");
                suitors.add(new Suitor(parts[0],
                        Integer.parseInt(parts[1])));
            }
        }
        catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void sortSuitorsListByIQ() {
        class SortByIq implements Comparator<Suitor> {
            public int compare (Suitor a, Suitor b){
                return -(a.getIq() - b.getIq());
            }
        }
        Collections.sort(suitors, new SortByIq());
    }

    public void printListWithRating() {
        for (Suitor suitor : suitors){
            System.out.println(1 + suitors.indexOf(suitor)+ " " + suitor.toString());
        }
    }

    public static boolean isInteger(String str)
    {
        try
        {
            int integer = Integer.parseInt(str);
        }
        catch(NumberFormatException nfe)
        {
            return false;
        }
        return true;
    }

    public static boolean isAboveZero(String str){
        if (Integer.parseInt(str) >= 0)
            return true;
        return false;
    }
}
