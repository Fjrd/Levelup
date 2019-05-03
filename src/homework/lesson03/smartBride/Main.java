package homework.lesson03.smartBride;

public class Main {
    public static void main(String[] args) {

        SmartBride smartBride = new SmartBride();
        smartBride.inputFilePathOrRandom();

        if (smartBride.isReadingFromFile)
            smartBride.parseCSVFile();
        else
            smartBride.fillArrayWithRandomDataSet();

        smartBride.sortSuitorsListByIQ();
        smartBride.printListWithRating();
    }
}
