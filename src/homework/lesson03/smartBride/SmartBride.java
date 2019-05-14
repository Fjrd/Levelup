package homework.lesson03.smartBride;

import java.io.*;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.Random;

public class SmartBride {
    private ArrayList<Suitor> suitors = new ArrayList<>();
    private BufferedReader reader = null;

    public void greetings() {
        System.out.println(
                "Enter path to .csv file like " +
                        "\"/home/username/package/test.csv\" " +
                        "or \"random\" to test some random dataset:");
    }

    public void printListWithRating() {
        for (Suitor suitor : suitors) {
            System.out.println(1 + suitors.indexOf(suitor)+ " " + suitor.toString());
        }
    }


    public void sortSuitorsListByIQ() {
        class SortByIq implements Comparator<Suitor> {
            public int compare (Suitor a, Suitor b) {
                return -(a.getIq() - b.getIq());
            }
        }
        Collections.sort(suitors, new SortByIq());
    }

    public void fillArrayWithRandomDataSet(int number) {
        for (int i = 0; i < number; i++) {
            Names randomName = Names.values()[new Random().nextInt(Names.values().length)];
            int randomIq = 60 + new Random().nextInt(140);
            suitors.add(new Suitor(randomName.toString(), randomIq));
        }
    }

    public void parseCSVFile(Path path) {
        String line = "";
        try {
            reader = new BufferedReader(new FileReader(String.valueOf(path)));

            // TODO: 05.05.19 data validation

            while ((line = reader.readLine())!= null) {
                String[] parts = line.split(",");
                suitors.add(new Suitor(parts[0], Integer.parseInt(parts[1])));
            }
        }
        catch (IOException e) {
            e.printStackTrace();
        }
        finally {
            closeInputStream();
        }
    }


    public String inputNewCommand() {
        try {
            reader = new BufferedReader(new InputStreamReader(System.in));
            String line = reader.readLine();
            return line;
        }
        catch (IOException e) {
            e.printStackTrace();
            return null;
        }

//        finally {
//            try {
//                reader.close();
//            } catch (IOException e) {
//                e.printStackTrace();
//            }
//        }

    }

    public void identifyCommand() {
        while (true) {
            String command = inputNewCommand();

            //if command is "random"
            if (command.equals("random")) {
                System.out.println("Enter the number of suitor objects to generate:");
                while (true) {
                    String number = inputNewCommand();
                    if (isInteger(number) && isPositive(number)) {
                        fillArrayWithRandomDataSet(Integer.parseInt(number));
                        break;
                    } else {
                        System.out.println("Number of suitors must be an integer above zero, try again:");
                    }
                }
                closeInputStream();
                break;

                //if command is a path to file
            } else if (Files.exists(Paths.get(command))) {
                parseCSVFile(Paths.get(command));
                closeInputStream();
                break;
            }

            //if command unknown
            else {
                System.out.println("unknown command or such file does not exist, try again:");
            }
        }
    }

    private static boolean isInteger(String str) {
        try
        {
            Integer.parseInt(str);
        }
        catch(NumberFormatException nfe)
        {
            return false;
        }
        return true;
    }

    private static boolean isPositive(String str) {
        return (Integer.parseInt(str) >= 0);
    }

    private void closeInputStream() {
        try {
            reader.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
