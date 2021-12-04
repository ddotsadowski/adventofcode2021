package de.nordakademie.sadowski.day04.classes;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Arrays;

public class BingoBoard {
    private int boardSize;
    //Enthält die Boards (5x5)
    private int[][] bingoBoard;
    //Speichert die Positionen der genannten Zahlen (als 1)
    private boolean[][] bingo;

    public BingoBoard(int boardSize){
        this.boardSize = boardSize;
        bingoBoard = new int[boardSize][boardSize];
        bingo = new boolean[boardSize][boardSize];
    }

    public void setRows(int rowNumber, String boardLine){
        boardLine = boardLine.trim();
        boardLine = boardLine.replaceAll("  ", " ");
        String[] numbers = boardLine.split(" ");
        for(int i = 0; i < numbers.length; i++){
                bingoBoard[rowNumber][i] = Integer.parseInt(numbers[i]);
        }
    }

    public void checkNumber(int number){
        for (int i = 0; i < boardSize; i++) {
            for (int j = 0; j < boardSize; j++) {
                if(number == bingoBoard[i][j]){
                    bingo[i][j] = true;
                }
            }
        }
    }

    public boolean checkWin(){
        for(int i = 0; i < boardSize; i++){
            boolean win = true;
            for (int j = 0; j < boardSize; j++) {
                win = win && bingo[i][j];
            }
            if(win) {
                return true;
            }
        }

        for(int i = 0; i < boardSize; i++){
            boolean win = true;
            for (int j = 0; j < boardSize; j++) {
                win = win && bingo[j][i];
            }
            if(win) {
                return true;
            }
        }

        return false;
    }

    public int countPoints() {
        int points = 0;
        for (int i = 0; i < boardSize; i++) {
            for (int j = 0; j < boardSize; j++) {
                if(!bingo[i][j]) {
                    points += bingoBoard[i][j];
                }
            }
        }
        return points;
    }
}
