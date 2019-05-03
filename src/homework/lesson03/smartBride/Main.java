package homework.lesson03.smartBride;

public class Main {
    public static void main(String[] args) {

        SmartBride smartBride = new SmartBride();
        smartBride.greetings();
        System.out.println(smartBride.inputNewCommand());
        System.out.println(smartBride.inputNewCommand());
        /*smartBride.identifyCommand();

        if (smartBride.isReadingFromFile)
            smartBride.parseCSVFile();
        else
            smartBride.fillArrayWithRandomDataSet();

        smartBride.sortSuitorsListByIQ();
        smartBride.printListWithRating();

         */
    }
}
