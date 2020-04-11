package com.company;

public class GameSystem {
    int aim = 0;
    int[] startTracingFromTopLeft = {6, 1, 0};
    int[] startTracingFromTopRight = {4, 5, 11};

    public static void main(String[] args) {
        int aim;
        int turn = 0;
        Player user = new Player();
        int[] Cell = new int[36];
        Board board = new Board();
        GameSystem pentago = new GameSystem();
        board.firstValue(Cell);
        while (true) {
            board.print(Cell, turn);
            System.out.println();
            System.out.print("  \u001b[33mput your nut :   \u001b[0m");
            aim = user.scanning();
            System.out.println();
            System.out.println();
            user.put(Cell, aim, turn);
            if (pentago.referee(Cell) != 100) {
                board.print(Cell, turn);
                break;
            }
            System.out.println();
            System.out.println();
            board.print(Cell, turn);
            user.rotating(Cell);
            if (pentago.referee(Cell)!= 100) {
                board.print(Cell, turn);
                break;
            }
            turn++;
            //board.print(Cell,turn);
            System.out.println();
        }
        System.out.println(pentago.referee(Cell));
        System.out.println("tamaaaaam");
    }

    /**
     * method to check we have winner or not
     *
     * @param Cell board of the game
     * @return we have winner or not
     */
    public int referee(int[] Cell) {
        int winner = 0;
        boolean finish = false;
        int i = 0;
        int sum = 0;
        for (int k = 0; k < 6; ++k) {
            sum = 0;
            for (i = k * 6 + 1; i < 6 + k * 6; ++i) {
                if (Cell[i] * Cell[i - 1] == 1)
                    sum++;
                if (sum == 4) {
                    int color = Cell[i];
                    finish = true;
                    if (winner <= 0 && color>0)
                        winner ++ ;
                    if (winner >= 0 && color<0)
                        winner -- ;
                }
                if (Cell[i] * Cell[i - 1] == -1)
                    sum = 1;
                if (Cell[i] * Cell[i - 1] == 0)
                    sum = 0;
            }
        }
        for (int k = 0; k < 6; ++k) {
            sum = 0;
            for (i = k + 6; i <= 30 + k; i += 6) {
                if (Cell[i] * Cell[i - 6] == 1)
                    sum++;
                if (sum == 4) {
                    int color = Cell[i];
                    finish = true;
                    if (winner <= 0 && color>0)
                        winner ++ ;
                    if (winner >= 0 && color<0)
                        winner -- ;
                }
                if (Cell[i] * Cell[i - 6] == -1)
                    sum = 1;
                if (Cell[i] * Cell[i - 6] == 0)
                    sum = 0;
            }
        }
        for (int k :
                startTracingFromTopLeft) {
            sum = 0;
            for (i = k + 7; i <= 28 + k; i += 7) {
                if (Cell[i] * Cell[i - 7] == 1)
                    sum++;
                if (sum == 4) {
                    int color = Cell[i];
                    finish = true;
                    if (winner <= 0 && color>0)
                        winner ++ ;
                    if (winner >= 0 && color<0)
                        winner -- ;
                }
                if (Cell[i] * Cell[i - 7] == -1)
                    sum = 1;
                if (Cell[i] * Cell[i - 7] == 0)
                    sum = 0;
            }
        }
        for (int k :
                startTracingFromTopRight) {
            sum = 0;
            for (i = k + 5; i <= 4 * 5 + k; i += 5) {
                if (Cell[i] * Cell[i - 5] == 1)
                    sum++;
                if (sum == 4) {
                    int color = Cell[i];
                    finish = true;
                    if (winner <= 0 && color>0)
                        winner ++ ;
                    if (winner >= 0 && color<0)
                        winner -- ;
                }
                if (Cell[i] * Cell[i - 5] == -1)
                    sum = 1;
                if (Cell[i] * Cell[i - 5] == 0)
                    sum = 0;
            }
        }
        if(finish)
            return winner ;
        else
            return 100 ;
    }
}
