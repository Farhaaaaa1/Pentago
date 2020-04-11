package com.company;

import com.sun.deploy.security.SelectableSecurityManager;

import java.util.Arrays;

public class Board {
    /**
     * in this method we give all the Cells first value wich is -0-
     *
     * @param Cell Cells of the Pentago
     */
    public void firstValue(int[] Cell) {
        Arrays.fill(Cell, 0);
    }

    public void print(int[] Cell, int turn) {
        System.out.println("\u001b[43m\u001b[30m    A     B     C       D     E     F    \u001b[0m");
        for (int i = 0; i < 3; ++i) {
            if (i == 1) {
                System.out.print("\u001b[43m\u001b[30m 2\u001b[0m  " + printingTheNuts(Cell[i * 6]) + "  |  " + printingTheNuts(Cell[i * 6 + 1]) + "  |  " + printingTheNuts(Cell[i * 6 + 2]) +
                        "  \u001b[0m\u001b[43m   \u001b[0m  " + printingTheNuts(Cell[i * 6 + 3]) + "  |  " + printingTheNuts(Cell[i * 6 + 4])
                        + "  |  " + printingTheNuts(Cell[i * 6 + 5]) + "  \u001b[43m\u001b[33m  \u001b[0m ");
                if (turn % 2 == 0)
                    System.out.println("     \u001b[43m\u001b[30m Player1's turn \u001b[0m  ");
                else
                    System.out.println("     \u001b[33m Player1's turn \u001b[0m  ");
            } else if (i == 2) {
                System.out.print("\u001b[43m\u001b[30m 3\u001b[0m  " + printingTheNuts(Cell[i * 6]) + "  |  " + printingTheNuts(Cell[i * 6 + 1]) + "  |  " + printingTheNuts(Cell[i * 6 + 2]) +
                        "  \u001b[0m\u001b[43m   \u001b[0m  " + printingTheNuts(Cell[i * 6 + 3]) + "  |  " + printingTheNuts(Cell[i * 6 + 4])
                        + "  |  " + printingTheNuts(Cell[i * 6 + 5]) + "  \u001b[43m\u001b[33m  \u001b[0m ");
                if (turn % 2 == 1)
                    System.out.println("     \u001b[43m\u001b[30m Player2's turn \u001b[0m  ");
                else
                    System.out.println("    \u001b[33m  Player2's turn \u001b[0m  ");

            } else
                System.out.println("\u001b[43m\u001b[30m 1\u001b[0m  " + printingTheNuts(Cell[i * 6]) + "  |  " + printingTheNuts(Cell[i * 6 + 1]) + "  |  " + printingTheNuts(Cell[i * 6 + 2]) +
                        "  \u001b[0m\u001b[43m   \u001b[0m  " + printingTheNuts(Cell[i * 6 + 3]) + "  |  " + printingTheNuts(Cell[i * 6 + 4])
                        + "  |  " + printingTheNuts(Cell[i * 6 + 5]) + "  \u001b[43m\u001b[33m  \u001b[0m  ");
            if (i < 2)
                System.out.println("\u001b[43m\u001b[33m  \u001b[0m-----+-----+-----\u001b[43m\u001b[33m+-+\u001b[0m-----+-----+-----\u001b[43m\u001b[33m  \u001b[0m ");

        }
        System.out.println("\u001b[43m                                         \u001b[0m");
        for (int i = 3; i < 6; ++i) {
            System.out.println("\u001b[43m\u001b[30m " + (i + 1) + "\u001b[0m  " + printingTheNuts(Cell[i * 6]) + "  |  " + printingTheNuts(Cell[i * 6 + 1]) + "  |  " + printingTheNuts(Cell[i * 6 + 2]) +
                    "  \u001b[0m\u001b[43m   \u001b[0m  " + printingTheNuts(Cell[i * 6 + 3]) + "  |  " + printingTheNuts(Cell[i * 6 + 4])
                    + "  |  " + printingTheNuts(Cell[i * 6 + 5]) + "  \u001b[43m\u001b[33m  \u001b[0m  ");
            if (i < 5)
                System.out.println("\u001b[43m\u001b[33m+ \u001b[0m-----+-----+-----\u001b[43m\u001b[33m+-+\u001b[0m-----+-----+-----\u001b[43m\u001b[33m  \u001b[0m ");

        }
        System.out.println("\u001b[43m\u001b[33m                                         \u001b[0m");
    }

    public char printingTheNuts(int n) {
        int a;
        if (n == 0)
            a = ' ';
        else if (n == 1) {
            a = 9711;
        } else
            a = 9679;
        return (char) a;
    }

    /**
     * here we rotate the sides(rotate counter clockwise) ...
     *
     * @param startingPoint means wich side we choose
     * @param Cell          nuts of this board game
     */
    public void rotateCounterClockwise(int startingPoint, int[] Cell) {
        int temp = Cell[startingPoint];
        Cell[startingPoint] = Cell[startingPoint + 2];
        Cell[startingPoint + 2] = Cell[startingPoint + 8];
        Cell[startingPoint + 8] = Cell[startingPoint + 12];
        Cell[startingPoint + 12] = temp;

        temp = Cell[startingPoint + 1];
        Cell[startingPoint + 1] = Cell[startingPoint + 8];
        Cell[startingPoint + 8] = Cell[startingPoint + 13];
        Cell[startingPoint + 13] = Cell[startingPoint + 6];
        Cell[startingPoint + 6] = temp;

    }

    /**
     * here we rotate the sides(rotate  clockwise) ...
     *
     * @param startingPoint means wich side we choose
     * @param Cell          nuts of this board game
     */
    public void rotateClockwise(int startingPoint, int[] Cell) {
        int temp = Cell[startingPoint];
        Cell[startingPoint] = Cell[startingPoint + 12];
        Cell[startingPoint + 12] = Cell[startingPoint + 14];
        Cell[startingPoint + 14] = Cell[startingPoint + 2];
        Cell[startingPoint + 2] = temp;

        temp = Cell[startingPoint + 1];
        Cell[startingPoint + 1] = Cell[startingPoint + 6];
        Cell[startingPoint + 6] = Cell[startingPoint + 13];
        Cell[startingPoint + 13] = Cell[startingPoint + 8];
        Cell[startingPoint + 8] = temp;

    }
}