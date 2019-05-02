package homework.lesson03.SmartBride;

import java.io.*;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.Random;

public class CSVParcer {
    String fileName = "";
    BufferedReader reader = null;
    ArrayList<Suitor> suitors = new ArrayList<Suitor>();
    int numberOfRandomSuitors = 0;
    boolean readFromFile = false;

    private void greetings() {
        System.out.println("Enter path to .csv file like \"/home/username/package/test.csv\" " +
                "or \"random\" to test some random dataset:");
    }

    public void inputFilePathOrRandom() {
        greetings();
        try (BufferedReader reader = new BufferedReader(new InputStreamReader(System.in))) {
            String line = reader.readLine();
            if (line.equals("random")) {
                System.out.println("Enter the number of suitor objects to generate:");
                numberOfRandomSuitors = Integer.parseInt(reader.readLine());
                // TODO: 02.05.19 проверка введенных значений (целое, неотрицательное и тд)
            }
            else {
                readFromFile = true;
                fileName = line;
            }

            // TODO: 02.05.19 добавить проверку корректности введенного адреса
        }
        catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void fillArrayWithRandom() {
        for (int i = 0; i < numberOfRandomSuitors; i++) {
            Random random = new Random();
            suitors.add(new Suitor((Names.values()[new Random().nextInt(Names.values().length)]).toString(), 1 + random.nextInt(200)));
        }
    }

    public void parseFile() {
        String line = "";
        try{
            reader = new BufferedReader(new FileReader(fileName));
            while ((line = reader.readLine())!= null){
                String[] tokens = line.split(",");
                suitors.add(new Suitor(tokens[0], Integer.parseInt(tokens[1])));
            }
        }
        catch (IOException e) {
            e.printStackTrace();
        }
        finally {
            try{
                reader.close();
            }
            catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

    public void sortSuitorsListByIQ() {
        class SortByIQ implements Comparator<Suitor> {
            public int compare (Suitor a, Suitor b){
                return a.getIq() - b.getIq();
            }
        }
        Collections.sort(suitors, new SortByIQ());
    }

    public void printListWithRating() {
        for (Suitor suitor : suitors){
            System.out.println(1 + suitors.indexOf(suitor)+ " " + suitor.toString());
        }
    }
}
