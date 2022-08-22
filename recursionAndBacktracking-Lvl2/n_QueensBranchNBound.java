import java.util.*;

public class n_QueensBranchNBound
{

    public static void main(String[] args) throws Exception {
        try (Scanner scn = new Scanner(System.in)) {
          int n = scn.nextInt();
          boolean[][] board = new boolean[n][n];
          // write your code here

          int[] cols = new int[n];
          int[] normaldiagonal = new int[(2 * n - 1)];
          int[] reversediagonal = new int[(2 * n - 1)];
          branchAndBound(board, 0, cols, normaldiagonal, reversediagonal, "");
        }
    }

  public static void branchAndBound(boolean [][] board , int row , int[] cols , int[]ndiag , int[] revdiag , String asf){
    if(row == board.length){
      System.out.println(asf+".");
      return;
    }
    
    for(int i=0;i<board[row].length;i++){
      if( 
        board[row][i] == false &&
        cols[i] == 0 &&
        ndiag[row+i] == 0 &&
        revdiag[row-i+board.length-1] == 0
      ){
        board[row][i] = true;
        cols[i] = 1;
        ndiag[row+i] = 1;
        revdiag[row-i+board.length-1] = 1;
        branchAndBound(board , row+1 , cols , ndiag , revdiag , asf+row+"-"+i+", ");
        board[row][i] = false;
        cols[i] = 0 ;
        ndiag[row+i] = 0;
        revdiag[row-i+board.length-1] = 0;
      }
    }
  }
}
