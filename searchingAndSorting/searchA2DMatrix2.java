1. Write an efficient algorithm that searches for a target value in an m x n integer matrix. The matrix has the following properties:
a). Integers in each row are sorted in ascending from left to right.
b). Integers in each column are sorted in ascending from top to bottom.

Constraints
m == matrix.length
n == matrix[i].length
1 <= n, m <= 300
-10^9 <= matix[i][j] <= 10^9
-10^9 <= target <= 10^9

Format
Input
Input is managed for you

Output
Output is managed for you

Example
Sample Input

5 5
1 4 7 11 15
2 5 8 12 20
4 6 9 16 22
10 13 14 17 24
18 21 23 26 30
12

Sample Output
true

import java.util.*;
import java.io.*;

public class Main {

    /*your task is to complete this function which returns true if target exists in the matrix
    else return false*/
    public static boolean search(int[][]matrix,int target) {
        //write your code here
        int n = matrix.length , m = matrix[0].length;
        int i = 0 , j = m-1;
        while(i < n && j >=0 ){
            if(matrix[i][j] < target){
                i++;
            }
            else if(matrix[i][j] > target){
                j--;
            }
            else{
                return true;
            }
        }
        return false;
    }

    public static void main(String[]args) {
        //input work
        Scanner scn = new Scanner(System.in);
        int m = scn.nextInt();
        int n = scn.nextInt();

        int[][]matrix = new int[m][n];

        for(int i=0; i < m;i++) {
            for(int j=0; j < n;j++) {
                matrix[i][j] = scn.nextInt();
            }
        }

        int target = scn.nextInt();

        boolean isFound = search(matrix,target);
        System.out.println(isFound);

    }
}