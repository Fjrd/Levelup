package homework.lesson03.SmartBride;

public class Main {
    public static void main(String[] args) {

        CSVParcer csvParcer = new CSVParcer();
        csvParcer.inputFilePathOrRandom();

        if (csvParcer.readFromFile)
            csvParcer.parseFile();
        else
            csvParcer.fillArrayWithRandom();

        csvParcer.sortSuitorsListByIQ();
        csvParcer.printListWithRating();
    }
}
