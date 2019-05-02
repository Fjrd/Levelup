package homework.lesson03.smartBride;

public class Main {
    public static void main(String[] args) {

        CSVParser csvParser = new CSVParser();
        csvParser.inputFilePathOrRandom();

        if (csvParser.isReadingFromFile)
            csvParser.parseCSVFile();
        else
            csvParser.fillArrayWithRandom();

        csvParser.sortSuitorsListByIQ();
        csvParser.printListWithRating();
    }
}
