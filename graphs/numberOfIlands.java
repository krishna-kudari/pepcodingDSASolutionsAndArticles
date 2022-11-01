Number Of Islands
Easy

1. You are given a 2d array where 0's represent land and 1's represent water. 
     Assume every cell is linked to its north, east, west and south cell.
2. You are required to find and count the number of islands.

Constraints
None

Format
Input
Input has been managed for you

Output
Number of islands

Example
Sample Input

8
8
0 0 1 1 1 1 1 1
0 0 1 1 1 1 1 1
1 1 1 1 1 1 1 0
1 1 0 0 0 1 1 0
1 1 1 1 0 1 1 0
1 1 1 1 0 1 1 0
1 1 1 1 1 1 1 0
1 1 1 1 1 1 1 0

Sample Output
3


import java.io.*;
import java.util.*;

public class Main {
   public static void main(String[] args) throws Exception {
      BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

      int m = Integer.parseInt(br.readLine());
      int n = Integer.parseInt(br.readLine());
      int[][] arr = new int[m][n];

      for (int i = 0; i < arr.length; i++) {
         String parts = br.readLine();
         for (int j = 0; j < arr[0].length; j++) {
            arr[i][j] = Integer.parseInt(parts.split(" ")[j]);
         }
      }

      // write your code here
      ArrayList<ArrayList<ArrayList<Integer>>> ilands = new ArrayList<ArrayList<ArrayList<Integer>>>();
      for (int i = 0; i < arr.length; i++) {
         for (int j = 0; j < arr[0].length; j++) {
            if(arr[i][j] == 0){
            ArrayList<ArrayList<Integer>> ic = new ArrayList<ArrayList<Integer>>();
            tour(arr , ic , i , j);
            ilands.add(ic);
            }
         }
      }
      // System.out.println(ilands);
      System.out.println(ilands.size());
   }


   public static void tour(int[][] arr , ArrayList<ArrayList<Integer>> ic , int r , int c) {
      // if(r >= arr.length || c>= arr[0].length){
      //    // System.out.println("l");
      //    return;
      // }
      arr[r][c] = 1;
      ArrayList<Integer> co =new ArrayList<Integer>();
      co.add(r);
      co.add(c);
      ic.add(co);
      // System.out.println(ic);/
      
      if(r < arr.length && c+1< arr[0].length && arr[r][c+1] == 0){
         // System.out.println(r+" "+c);
         tour(arr , ic, r, c+1);
      }
      if(r+1 < arr.length && c< arr[0].length && arr[r+1][c] == 0){
         tour(arr, ic ,r+1 , c);
      }
      if(r < arr.length && c-1>=0 && arr[r][c-1] == 0){
         // System.out.println(r+" "+c);
         tour(arr , ic, r, c-1);
      }
      if(r-1>=0  && c>=0 && arr[r-1][c] == 0){
         // System.out.println(r+" "+c);
         tour(arr , ic, r-1, c);
      }
   }
}
