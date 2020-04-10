package com.company;

public class GameSystem {
    int aim = 0;

    public static void main(String[] args) {
        int aim;
        int turn = 0;
        Player user = new Player();
        int[] Cell = new int[36];
        Board board = new Board();
        board.firstValue(Cell);
        while (true) {
            board.print(Cell,turn);
            aim = user.scanning();
            System.out.println();
            user.put(Cell, aim, turn);
            turn++ ;
            //board.print(Cell,turn);
            System.out.println();
        }
    }
}