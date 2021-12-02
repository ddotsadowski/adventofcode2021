package de.nordakademie.sadowski.day02.classes;

import java.util.*;
import java.io.*;

public class Ship {

	//Meine Schiffs-Position (Horizontal, Tiefe, Aim)
    private int[] shipPosition= {0,0,0};
    
    //Temporäre ArrayList zum Zwischenspeichern
    private ArrayList<String> Movements = new ArrayList<>();

    //Konstruktor, liest die Datei ein (als String)
    public Ship(){
    	readData();
    }

    //Arbeitet die ArrayList ab. Speichert die Koordinaten im Array shipPositionen.
    public void move(){
		for (String movement : Movements) {
			int schrittAnzahl = Integer.parseInt(movement.substring(movement.length() - 1));
			String[] moveDirection = movement.split(" ");
			switch (moveDirection[0]) {
				case "forward" -> moveForward(schrittAnzahl);
				case "up" -> moveUp(schrittAnzahl);
				case "down" -> moveDown(schrittAnzahl);
			}
		}
    }
    
    public void readData(){
		try (BufferedReader bufferedReader = new BufferedReader(new FileReader("src\\input\\input.txt"))){
	        String line;
	        while((line = bufferedReader.readLine())!= null) {
	            Movements.add(line);
	        }
		} catch (IOException e) {
			e.printStackTrace();
			System.out.println("Datei nicht gefunden.");
		}
    }

    private void moveForward(int parameter){
        shipPosition[1] += shipPosition[2]*parameter;
        shipPosition[0] += parameter;
    }

    private void moveUp(int parameter){
        //shipPosition[1] -= parameter;
        shipPosition[2] -= parameter;
    }

    private void moveDown(int parameter){
        //shipPosition[1] += parameter;
        shipPosition[2] += parameter;
    }
    
    public int[] getShipPosition() {
    	return shipPosition;
    }
}
