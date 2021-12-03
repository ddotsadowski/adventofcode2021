package de.nordakademie.sadowski.day03.classes;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;

public class PowerConsumption {

    //Temporäre ArrayList zum Zwischenspeichern
    private ArrayList<String> temp = new ArrayList<>();

    int gammaRate = 0;
    int epsilonRate = 0;

    public PowerConsumption(){
        readData();
    }

    public int getGammaRate() {
        return gammaRate;
    }

    public int getEpsilonRate() {
        return epsilonRate;
    }

    public void readData(){
        try (BufferedReader bufferedReader = new BufferedReader(new FileReader("src\\de\\nordakademie\\sadowski\\day03\\input\\input.txt"))){
            String line;
            while((line = bufferedReader.readLine())!= null) {
                temp.add(line);
            }
        } catch (IOException e) {
            e.printStackTrace();
            System.out.println("Datei nicht gefunden.");
        }
    }

    public ArrayList<String> getTemp() {
        return temp;
    }

    public void calculatePowerConsumption(){

        int counter1 = 0;
        int counter0 = 0;

        char[] gammaRateArray = new char[temp.get(0).length()];
        char[] epsilonRateArray = new char[temp.get(0).length()];

        for(int i = 0; i < temp.get(0).length(); i++){

            for(String temp : temp){
                //String[] line = temp.split("(?!^)");
                char cell = temp.charAt(i);
                if(cell == '0'){
                    counter0 += 1;
                } else if(cell == '1'){
                    counter1 += 1;
                }
            }

            if(counter0 > counter1) {
                gammaRateArray[i] = '0';
                epsilonRateArray[i] = '1';
            } else if (counter1 > counter0) {
                gammaRateArray[i] = '1';
                epsilonRateArray[i] = '0';
            }

            counter0 = 0;
            counter1 = 0;
        }

        gammaRate = Integer.parseInt(String.valueOf(gammaRateArray),2);
        epsilonRate = Integer.parseInt(String.valueOf(epsilonRateArray),2);
    }

}
