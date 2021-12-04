package de.nordakademie.sadowski.day04.classes;


import java.io.*;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Bingo {

    //Temporäre ArrayList zum Zwischenspeichern
    private List<String> dataArray = new ArrayList<>();

    //Eingabewerte
    private List<String> eingabeArray = new ArrayList<>();

    private List<BingoBoard> boardList = new ArrayList<>();

    private int boardSize = 5;

    public Bingo() {
        readData();
        organizeData();
    }

    private void readData() {
        try (BufferedReader bufferedReader = new BufferedReader(new FileReader("src\\de\\nordakademie\\sadowski\\day04\\input\\input.txt"))){
            String line;
            while ((line = bufferedReader.readLine()) != null) {
                dataArray.add(line);
            }
        } catch (IOException e) {
            e.printStackTrace();
            System.out.println("Datei nicht gefunden.");
        }
    }

    private void organizeData(){
        eingabeArray = new ArrayList<>(Arrays.asList(dataArray.remove(0).split(",")));

        while (dataArray.size() >= 6) {
            dataArray.remove(0);
            BingoBoard bingoBoard = new BingoBoard(boardSize);

            for (int i = 0; i < boardSize; i++) {
                bingoBoard.setRows(i, dataArray.remove(0));
            }
            boardList.add(bingoBoard);
        }

    }

    public void runBingo(){
        for (String line : eingabeArray) {
            int lineValue = Integer.parseInt(line);
            for (BingoBoard bingoBoard: boardList) {
                bingoBoard.checkNumber(lineValue);
                if(bingoBoard.checkWin()){
                    System.out.println("Tag 4 (1) - Siegerreihe: " + lineValue*bingoBoard.countPoints());
                }
            }
        }
    }
}
