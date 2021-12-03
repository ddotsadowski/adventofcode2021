package de.nordakademie.sadowski.day03;

import de.nordakademie.sadowski.day03.classes.PowerConsumption;

public class Day03 {

    public static void run(){
        PowerConsumption powerConsumption = new PowerConsumption();
        powerConsumption.calculatePowerConsumption();
        System.out.println("Tag 3 (1) - Power-Consumption: " + powerConsumption.getEpsilonRate() * powerConsumption.getGammaRate());
    }
}
