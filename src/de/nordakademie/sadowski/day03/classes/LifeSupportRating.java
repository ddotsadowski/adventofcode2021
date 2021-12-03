package de.nordakademie.sadowski.day03.classes;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.lang.reflect.Array;
import java.util.ArrayList;

public class LifeSupportRating {

    //Temporäre ArrayList zum Zwischenspeichern
    private ArrayList<String> dataArray = new ArrayList<>();

    private ArrayList<String> ergebnisMengeOxygenGeneratorRating = new ArrayList<>();
    private ArrayList<String> ergebnisMengeCo2ScrubberRating = new ArrayList<>();

    int oxygenGeneratorRating = 0;
    int co2ScrubberRating = 0;

    public LifeSupportRating() {
        readData();
    }

    public int getOxygenGeneratorRating() {
        return oxygenGeneratorRating;
    }

    public int getCo2ScrubberRating() {
        return co2ScrubberRating;
    }

    public ArrayList<String> getDataArray() {
        return dataArray;
    }

    public void readData() {
        try (BufferedReader bufferedReader = new BufferedReader(new FileReader("src\\de\\nordakademie\\sadowski\\day03\\input\\input.txt"))) {
            String line;
            while ((line = bufferedReader.readLine()) != null) {
                dataArray.add(line);
            }
        } catch (IOException e) {
            e.printStackTrace();
            System.out.println("Datei nicht gefunden.");
        }
    }

    public void calculateLifeSupportRating() {
        calculateOxygenGeneratorRating();
        calculateCo2ScrubberRating();
    }

    private void calculateOxygenGeneratorRating() {

        int counter1;
        int counter0;
        int mostCommonValue;

        ergebnisMengeOxygenGeneratorRating = new ArrayList<>(dataArray);
        ergebnisMengeCo2ScrubberRating = new ArrayList<>(dataArray);

        //Spaltenweise Schleife
        for (int indexColumn = 0; indexColumn < dataArray.get(0).length(); indexColumn++) {

            //Counter beim Spalten-Wechsel auf 0 setzen
            counter1 = 0;
            counter0 = 0;

            //Zeilenweise 0 und 1 zählen
            for (String indexLine : ergebnisMengeOxygenGeneratorRating) {
                //String[] line = temp.split("(?!^)");
                char cell = indexLine.charAt(indexColumn);
                if (cell == '0') {
                    counter0 += 1;
                } else if (cell == '1') {
                    counter1 += 1;
                }
            }

            if (counter1 >= counter0) {
                mostCommonValue = 1;
            } else {
                mostCommonValue = 0;
            }

            if(ergebnisMengeOxygenGeneratorRating.toArray().length > 1) {
                ergebnisMengeOxygenGeneratorRating = new ArrayList<>(determineGreaterRatings(ergebnisMengeOxygenGeneratorRating, indexColumn, mostCommonValue));
            }
        }
        oxygenGeneratorRating = Integer.parseInt(ergebnisMengeOxygenGeneratorRating.get(0), 2);
    }

    public void calculateCo2ScrubberRating() {

        int counter1;
        int counter0;
        int mostCommonValue;

        ergebnisMengeCo2ScrubberRating = new ArrayList<>(dataArray);

        //Spaltenweise Schleife
        for (int indexColumn = 0; indexColumn < dataArray.get(0).length(); indexColumn++) {

            //Counter beim Spalten-Wechsel auf 0 setzen
            counter1 = 0;
            counter0 = 0;

            //Zeilenweise 0 und 1 zählen
            for (String indexLine : ergebnisMengeCo2ScrubberRating) {
                //String[] line = temp.split("(?!^)");
                char cell = indexLine.charAt(indexColumn);
                if (cell == '0') {
                    counter0 += 1;
                } else if (cell == '1') {
                    counter1 += 1;
                }
            }

            if (counter1 >= counter0) {
                mostCommonValue = 1;
            } else {
                mostCommonValue = 0;
            }

            if(ergebnisMengeCo2ScrubberRating.toArray().length > 1){
                ergebnisMengeCo2ScrubberRating = new ArrayList<>(determineSmallerRatings(ergebnisMengeCo2ScrubberRating, indexColumn, mostCommonValue));
            }
        }
        co2ScrubberRating = Integer.parseInt(ergebnisMengeCo2ScrubberRating.get(0), 2);
    }

    private ArrayList<String> determineGreaterRatings(ArrayList<String> dataArray, int index, int mostCommonValue) {
        ArrayList<String> ratingsArray = new ArrayList<>();
        for (String line : dataArray) {
            if (line.charAt(index) == Integer.toString(mostCommonValue).charAt(0)) {
                ratingsArray.add(line);
            }
        }
        return ratingsArray;
    }

    private ArrayList<String> determineSmallerRatings(ArrayList<String> dataArray, int index, int mostCommonValue) {
        ArrayList<String> ratingsArray = new ArrayList<>();
        for (String line : dataArray) {
            if (line.charAt(index) != Integer.toString(mostCommonValue).charAt(0)) {
                ratingsArray.add(line);
            }
        }
        return ratingsArray;
    }
}