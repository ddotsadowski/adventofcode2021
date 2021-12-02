package de.nordakademie.sadowski.day02;

import de.nordakademie.sadowski.day02.classes.Ship;

public class Day02 {

    public static void run(){
        //Schiff Objekt erzeugen
        Ship a1 = new Ship();

        //Liste abarbeiten. Schiff bewegen.
        a1.move();

        //Schiffsposition holen
        int[] shipPosition = a1.getShipPosition();

        //Horizontale * Höhe ausgeben
        System.out.println("Tag 2 - Die Horizontale multipliziert mit dem Aim ergibt: " + shipPosition[0]*shipPosition[1]);
    }
}
