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
     * @param Cell nut of this board game
     * @param aim   where we want to put our nut
     * @param turn  turn of the player (player1 or player2)
     */
    public void put(int[] Cell, int aim, int turn) {
        int color;
        if (turn % 2 == 0)
            color = 1;
        else
            color = -1;
        Cell[aim] = color;
    }
    public void rotating(int Cell)
    {
        System.out.println();
        System.out.println();
        System.out.println("choose one of them :");
        System.out.println();
        System.out.println("\uD83D\uDD34 \uD83D\uDD34           \uD83D\uDD35 \uD83D\uDD34           \uD83D\uDD34 \uD83D\uDD35           \uD83D\uDD34 \uD83D\uDD34 ");
        System.out.println("\uD83D\uDD35 \uD83D\uDD34           \uD83D\uDD34 \uD83D\uDD34           \uD83D\uDD34 \uD83D\uDD34           \uD83D\uDD34 \uD83D\uDD35 ");
        System.out.println("   1                    2                   3                   4");
    }
}
