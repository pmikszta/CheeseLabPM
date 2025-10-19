
package org.example;

import java.io.*;
import java.util.*;

public class App {
    public static void main(String[] args) {
        // CSV file path
        String fileName = "cheese_data.csv";

        List<Cheese> cheeseList = CheeseCSVReader.readCheeseData(fileName);
        CheeseCollection collection = new CheeseCollection(cheeseList);

        String outputFile = "output.txt";

        try (PrintWriter writer = new PrintWriter(new FileWriter(outputFile))) {
             // Run statistics and output to both console and file
             CheeseStatistics stats = new CheeseStatistics(collection);

            System.out.println("\n=== Cheese Statistics ===");
            writer.println("\n=== Cheese Statistics ===");

            // Count by milk treatment
            stats.countByMilkTreatment(System.out, writer);

            // Count organic high moisture
            stats.countOrganicHighMoisture(System.out, writer);

            // Most common milk type
            stats.mostCommonMilkType(System.out, writer);

            System.out.println("\nStatistics also written to " + outputFile);

        } catch (IOException e) {
            System.err.println("Error writing to file: " + e.getMessage());
        }
    }
}
