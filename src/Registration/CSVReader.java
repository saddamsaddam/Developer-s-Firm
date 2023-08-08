package Registration;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

public class CSVReader {
    public static void main(String[] args) {
        String csvFile = "E:\\pdf/certificatedata2.csv";
        String line;
        String csvSplitBy = ",";
         boolean isFirstLine = true; // Flag to track the first line

        List<String> firstColumn = new ArrayList<>();
        List<String> secondColumn = new ArrayList<>();

        try (BufferedReader br = new BufferedReader(new InputStreamReader(new FileInputStream(csvFile), "UTF-8"))) {
            while ((line = br.readLine()) != null) {
                if (isFirstLine) {
                    isFirstLine = false;
                    continue; // Skip the first line
                }

                String[] data = line.split(csvSplitBy);
                if (data.length >= 2) {
                    firstColumn.add(data[0]);
                    secondColumn.add(data[1]);
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }

        // Using StringBuilder to display the data
        StringBuilder firstColumnData = new StringBuilder();
        for (String data : firstColumn) {
            firstColumnData.append(data).append(", ");
        }

        StringBuilder secondColumnData = new StringBuilder();
        for (String data : secondColumn) {
            secondColumnData.append(data).append(", ");
        }

        // Remove the trailing ", " from the StringBuilder
        if (firstColumnData.length() > 2) {
            firstColumnData.setLength(firstColumnData.length() - 2);
        }
        if (secondColumnData.length() > 2) {
            secondColumnData.setLength(secondColumnData.length() - 2);
        }

        System.out.println("First Column Data:");
        System.out.println(firstColumnData);

        System.out.println("\nSecond Column Data:");
        System.out.println(secondColumnData);
    }
}
