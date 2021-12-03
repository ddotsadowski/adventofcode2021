package de.nordakademie.sadowski.day03;

import de.nordakademie.sadowski.day03.classes.LifeSupportRating;
import de.nordakademie.sadowski.day03.classes.PowerConsumption;

public class Day03 {

    public static void run(){

        //Task 1
        PowerConsumption powerConsumption = new PowerConsumption();
        powerConsumption.calculatePowerConsumption();
        System.out.println("Tag 3 (1) - Power-Consumption: " + powerConsumption.getEpsilonRate() * powerConsumption.getGammaRate());

        //Task 2
        LifeSupportRating lifeSupportRating = new LifeSupportRating();
        lifeSupportRating.calculateLifeSupportRating();
        System.out.println("Tag 3 (2) - Life-Support-Rating: " + lifeSupportRating.getOxygenGeneratorRating()*lifeSupportRating.getCo2ScrubberRating());
    }
}