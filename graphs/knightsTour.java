Knights Tour
Easy

1. You are given a number n, the size of a chess board.
2. You are given a row and a column, as a starting point for a knight piece.
3. You are required to generate the all moves of a knight starting in (row, col) such that knight visits 
     all cells of the board exactly once.
4. Complete the body of printKnightsTour function - without changing signature - to calculate and 
     print all configurations of the chess board representing the route
     of knight through the chess board. Use sample input and output to get more idea.

Note -> When moving from (r, c) to the possible 8 options give first precedence to (r - 2, c + 1) and 
               move in clockwise manner to
               explore other options.
Note -> The online judge cant force you to write the function recursively but that is what the spirit of 
               question is. Write recursive and not iterative logic. The purpose of the question is to aid 
               learning recursion and not test you.

Constraints
n = 5
0 <= row < n
0 <= col < n

Format
Input
A number n
A number row
A number col

Output
All configurations of the chess board representing route of knights through the chess board starting in (row, col)
Use displayBoard function to print one configuration of the board.

import java.io.*;
import java.util.*;

public class Main {

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int size = Integer.parseInt(br.readLine());
        int row = Integer.parseInt(br.readLine());
        int col = Integer.parseInt(br.readLine());
        int [][] chess = new int[size][size];
        printKnightsTour(chess  , row  , col , 1);
        
    }

    public static void printKnightsTour(int[][] chess, int r, int c, int upcomingMove) {
        if(r < 0 || r >= chess.length || c < 0 || c >= chess[0].length || chess[r][c] > 0){
            return ;
        }else if(upcomingMove >= chess.length*chess.length ){
            chess[r][c] = upcomingMove;
            displayBoard(chess);
            chess[r][c] = 0;
            return ;
        }
        chess[r][c] = upcomingMove;
        printKnightsTour(chess , r-2 , c+1 , upcomingMove+1);
        printKnightsTour(chess , r-1 , c+2 , upcomingMove+1);
        printKnightsTour(chess , r+1 , c+2 , upcomingMove+1);
        printKnightsTour(chess , r+2 , c+1 , upcomingMove+1);
        printKnightsTour(chess , r+2 , c-1 , upcomingMove+1);
        printKnightsTour(chess , r+1 , c-2 , upcomingMove+1);
        printKnightsTour(chess , r-1 , c-2 , upcomingMove+1);
        printKnightsTour(chess , r-2 , c-1 , upcomingMove+1);
        chess[r][c] = 0;
    }

    public static void displayBoard(int[][] chess){
        for(int i = 0; i < chess.length; i++){
            for(int j = 0; j < chess[0].length; j++){
                System.out.print(chess[i][j] + " ");
            }
            System.out.println();
        }

        System.out.println();
    }
}