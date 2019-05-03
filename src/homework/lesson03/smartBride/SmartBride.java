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

    private void greetings() {
        System.out.println(
                "Enter path to .csv file like " +
                        "\"/home/username/package/test.csv\" " +
                        "or \"random\" to test some random dataset:");
    }

    public void inputFilePathOrRandom() {
        greetings();

        try (BufferedReader reader = new BufferedReader(new InputStreamReader(System.in))) {
            String line = reader.readLine();
            if (line.equals("random")) {
                System.out.println("Enter the number of suitor objects to generate:");
                numberOfGeneratedSuitors = Integer.parseInt(reader.readLine());
                // TODO: 02.05.19 добавить проверку введенных значений (целое, неотрицательное и тд)
            }
            else {
                isReadingFromFile = true;
                fileName = line;
                // TODO: 02.05.19 добавить проверку корректности введенного адреса
                // TODO: 02.05.19 использовать Path
            }
        }
        catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void fillArrayWithRandomDataSet() {
        for (int i = 0; i < numberOfGeneratedSuitors; i++) {
            Random random = new Random();
            Names randomName = Names.values()[new Random().nextInt(Names.values().length)];
            int randomIq = 1 + random.nextInt(200);
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
}
