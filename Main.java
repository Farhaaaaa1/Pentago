package com.company;

public class Main {


    public static void main(String[] args) {
        int[] Cell = new int[36];
        Player user = new Player();
        Board board = new Board();
        board.firstValue(Cell);
        board.print(Cell, 4);
        System.out.println();
        System.out.println();
        System.out.println("\u001b[40m\u001b[94mchoose one of them :\u001b[0m");
        System.out.println();

        System.out.println("\u001b[33m1)\u001b[0m  \uD83D\uDD34 \uD83D\uDD34           \u001b[33m2)\u001b[0m  \uD83D\uDD35 \uD83D\uDD34           \u001b[33m3)\u001b[0m  \uD83D\uDD34 \uD83D\uDD35          \u001b[33m4)\u001b[0m  \uD83D\uDD34 \uD83D\uDD34 ");
        System.out.println("    \uD83D\uDD35 \uD83D\uDD34               \uD83D\uDD34 \uD83D\uDD34               \uD83D\uDD34 \uD83D\uDD34              \uD83D\uDD34 \uD83D\uDD35 ");
        System.out.println();
        System.out.println();
        System.out.println("\u001b[43m\u001b[30m choose one of them :\u001b[0m");
        int a = 11152 ;
        System.out.println();
        System.out.print("                      \u001b[33m1) "+(char) a);
         a = 11153 ;
        System.out.println("           2) \u001b[33m"+(char) a);
    }
}

