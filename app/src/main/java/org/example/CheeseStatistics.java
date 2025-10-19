package org.example;

import java.util.*;


public class CheeseStatistics {
    private CheeseCollection collection;

    public CheeseStatistics(CheeseCollection collection) {
        this.collection = collection;
    }

    //  Count cheeses by milk treatment type (Pasteurized vs Raw)
    public void countByMilkTreatment() {
        int pasteurizedCount = 0;
        int rawCount = 0;

        for (Cheese c : collection.getAllCheeses()) {
            String treatment = c.getMilkTreatmentTypeEn().toLowerCase();
            if (treatment.contains("pasteurized")) {
                pasteurizedCount++;
            } else if (treatment.contains("raw")) {
                rawCount++;
            }
        }

        System.out.println("Milk Treatment Summary:");
        System.out.println(" - Pasteurized milk cheeses: " + pasteurizedCount);
        System.out.println(" - Raw milk cheeses: " + rawCount);
    }

    //  Count organic cheeses with moisture > 41.0%
    public void countOrganicHighMoisture() {
        int count = 0;
        for (Cheese c : collection.getAllCheeses()) {
            if (c.isOrganic() && c.getMoisturePercent() > 41.0) {
                count++;
            }
        }

        System.out.println("Organic cheeses with >41.0% moisture: " + count);
    }

    //  Find the most common milk type
    public void mostCommonMilkType() {
        Map<String, Integer> milkTypeCounts = new HashMap<>();

        for (Cheese c : collection.getAllCheeses()) {
            String milkType = c.getMilkTypeEn().trim().toLowerCase();
            milkTypeCounts.put(milkType, milkTypeCounts.getOrDefault(milkType, 0) + 1);
        }

        String mostCommon = null;
        int maxCount = 0;

        for (Map.Entry<String, Integer> entry : milkTypeCounts.entrySet()) {
            if (entry.getValue() > maxCount) {
                mostCommon = entry.getKey();
                maxCount = entry.getValue();
            }
        }

        System.out.println("Most common milk type in Canada: " +
                (mostCommon != null ? mostCommon + " (" + maxCount + " cheeses)" : "No data"));
    }
}
