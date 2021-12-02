package de.nordakademie.sadowski.day01;

import de.nordakademie.sadowski.day01.classes.Ship;

public class Day01 {

        public static void run(){
            Ship ship = new Ship();
            ship.run();
            int count = ship.getCount();
            System.out.println("Tag 1 - Anzahl der Anstiege: " + count);
        }
}