package Test;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;

public class CSV {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        ArrayList names = new ArrayList(20);
        ArrayList salaries = new ArrayList(20);
        while (true){
            String line = reader.readLine();
            if (line == null){
                break;
            }

            if (line.isEmpty()){
                continue;
            }

            String[] cells = line.split(",");
            if (cells.length >=2){
                String name = cells[0];
                String salary = cells[1];
            }
        }
    }
}
