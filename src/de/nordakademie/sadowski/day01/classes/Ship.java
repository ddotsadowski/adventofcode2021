package de.nordakademie.sadowski.day01.classes;

import java.awt.*;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;

public class Ship {

    //Counter Anzahl der Anstiege in den Daten
    int count = 0;

    //ArrayList um Werte aus der Input-Datei zu speichern
    private ArrayList<String> depthMeasurements = new ArrayList<>();

    //Konstruktor
    public Ship(){
        readData();
    }

    public int getCount() {
        return count;
    }

    //Liest die Daten aus der Input-Datei ein
    public void readData(){
        try (BufferedReader bufferedReader = new BufferedReader(new FileReader("src\\de\\nordakademie\\sadowski\\day01\\input\\input.txt"))){
            String line;
            while((line = bufferedReader.readLine())!= null) {
                depthMeasurements.add(line);
            }
        } catch (IOException e) {
            e.printStackTrace();
            System.out.println("Datei nicht gefunden.");
        }
    }

    public void run(){
        for(int j = 0; j < depthMeasurements.toArray().length -3; j++){
            if(Integer.parseInt(depthMeasurements.get(j))<Integer.parseInt(depthMeasurements.get(j+3))){
                count += 1;
            }
        }
    }
}
