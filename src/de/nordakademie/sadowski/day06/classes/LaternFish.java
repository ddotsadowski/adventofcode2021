package de.nordakademie.sadowski.day06.classes;

import de.nordakademie.sadowski.functions.DataReader;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import java.util.stream.LongStream;

public class LaternFish {

    List<Integer> lifeCount = new ArrayList<>();

    public LaternFish(){
        readData();
    }

    private void readData(){
        DataReader dataReader = new DataReader();
        lifeCount = Arrays.stream(dataReader.readData("src\\de\\nordakademie\\sadowski\\day06\\input\\input.txt")
                .get(0)
                .split(","))
                .map(Integer::parseInt)
                .collect(Collectors.toList());
    }
    
    public void runMultiplying(int daysCounter){

        long[] counter = new long[9];

        for (Integer count : lifeCount){
            counter[count]++;
        }

        for (int i = 0; i < daysCounter; i++) {
            long[] temp = new long[counter.length];

            for (int j = 0; j < counter.length; j++) {
                if(j>0){
                    temp[j-1] += counter[j];
                } else{
                    temp[8] += counter[j];
                    temp[6] += counter[j];
                }
            }
            counter = temp.clone();
        }
        System.out.println("Tag 6 - Anzahl der Laternenfische: " + LongStream.of(counter).sum());
    }
}
