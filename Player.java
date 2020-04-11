package com.company;

import java.util.Scanner;

public class Player {
    /**
     * scanning the code that user type it
     * and change it to the location
     *
     * @return where that we want to put our Cell
     */
    public int scanning() {
        Scanner Input = new Scanner(System.in);
        int counter = 0;
        while (true) {
            if (counter > 0)
                System.out.println("\u001b[47m can't scan your code :  \u001b[0m    ");
            String str = Input.next();
            char x = str.charAt(0);
            char y = str.charAt(1);
            int x1 = Character.getNumericValue(x);
            int y1 = Character.getNumericValue(y);
            y1 -= 9;
            int numberOfCell = 6 * (x1 - 1) + y1 - 1;
            if (x1 <= 6 && y1 <= 6)
                return numberOfCell;
            counter++;
        }
    }

    /**
     * put the nuts of this board game on it .
     *
     * @param Cell nut of this board game
     * @param aim  where we want to put our nut
     * @param turn turn of the player (player1 or player2)
     */
    public void put(int[] Cell, int aim, int turn) {
        int color;
        if (turn % 2 == 0)
            color = 1;
        else
            color = -1;
        while (true) {
            if (Cell[aim] == 0) {
                Cell[aim] = color;
                break;
            }
            System.out.print("  \u001b[43m\u001b[30mit's full , try again ...\u001b[0m         ");
            aim = scanning();
            System.out.println();
        }
    }

    /**
     * i create a  test here and the answer is the side that we want to rotate it .
     * @param Cell      nuts of this board game
     */
    public void rotating(int[] Cell) {
        int sideNumber = 0;
        int counter = 0;
        Scanner Input = new Scanner(System.in);
        System.out.println();
        System.out.println();
        System.out.println();
        System.out.println("\u001b[33m1) \u001b[0m\uD83D\uDD35 \uD83D\uDD34           \u001b[33m2) \u001b[0m\uD83D\uDD34 \uD83D\uDD35           \u001b[33m3) \u001b[0m\uD83D\uDD34 \uD83D\uDD34           \u001b[33m4) \u001b[0m\uD83D\uDD34 \uD83D\uDD34 ");
        System.out.println("   \uD83D\uDD34 \uD83D\uDD34              \uD83D\uDD34 \uD83D\uDD34              \uD83D\uDD34 \uD83D\uDD35              \uD83D\uDD35 \uD83D\uDD34  ");
        System.out.println();
        System.out.print("\u001b[33m choose one of them :   \u001b[0m");
        while (sideNumber > 4 || sideNumber < 1) {
            if (counter > 0)
                System.out.println("\u001b[33mtry again ... \u001b[0m");
            sideNumber = Input.nextInt();
            counter++;
        }
        int startingPoint = makeStartingPoint(sideNumber);
        System.out.println();
        int first = 11152;
        int seccond = 11153;
        System.out.println();
        System.out.println("                      \u001b[33m1) " + (char) first + "           2) \u001b[33m" + (char) seccond);
        System.out.println();
        System.out.print("\u001b[33m choose one of them :   \u001b[0m");
        while (true) {
            int rotation = Input.nextInt();
            if (rotation == 1) {
                rotateClockwise(startingPoint, Cell);
                break;
            }
            if (rotation == 2) {
                rotateCounterClockwise(startingPoint, Cell);
                break;
            }
            System.out.println("\u001b[33mtry again ... \u001b[0m");
        }
    }

    /**
     * here we rotate the sides(rotate counter clockwise) ...
     * @param startingPoint means wich side we choose
     * @param Cell          nuts of this board game
     */
    public void rotateCounterClockwise(int startingPoint, int[] Cell) {
        int temp = Cell[startingPoint];
        Cell[startingPoint] = Cell[startingPoint + 2];
        Cell[startingPoint + 2] = Cell[startingPoint + 14];
        Cell[startingPoint + 14] = Cell[startingPoint + 12];
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

    /**
     * help to rotate the sides
     */
    public int makeStartingPoint(int aim) {
        // just put -0- for fun and omit the error ...
        int startingPoint = 0;
        if (aim == 1)
            startingPoint = 0;
        if (aim == 2)
            startingPoint = 3;
        if (aim == 3)
            startingPoint = 21;
        if (aim == 4)
            startingPoint = 18;
        return startingPoint;
    }
}
