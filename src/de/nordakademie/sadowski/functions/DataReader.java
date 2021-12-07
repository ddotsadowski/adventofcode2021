package de.nordakademie.sadowski.functions;

import java.io.BufferedReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

/**
 * Liest Daten aus einer Input-Textdatei in einer ArrayList<String> ein und gibt diese zurück.
 */

public class DataReader {

    public List<String> readData(String filePath) {
        List<String> dataArray = new ArrayList<>();
        try (BufferedReader bufferedReader = new BufferedReader(new java.io.FileReader(filePath))){
            String line;
            while ((line = bufferedReader.readLine()) != null) {
                dataArray.add(line);
            }
        } catch (IOException e) {
            e.printStackTrace();
            System.out.println("Datei nicht gefunden.");
        }
        return dataArray;
    }
}