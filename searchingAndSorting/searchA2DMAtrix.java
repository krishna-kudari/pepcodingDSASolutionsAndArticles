1. Write an efficient algorithm that searches for a value in a m x n matrix. This matrix has the following properties:
a). Integers in each row are sorted from left to right.
b). The first integer of each row is greater than the last integer of the previous row.

Constraints
m == matrix.length
n == matrix[i].length
1 <= m, n <= 100
-10^4 <= matrix[i][j], target <= 10^4

Format
Input
Input is managed for you

Output
Output is managed for you

Example
Sample Input

5 4
1 3 5 7
10 11 16 20
23 30 34 60
62 63 65 68
71 72 74 80
65

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
        int i = 0;
        while(i < n && matrix[i][m-1] <target ){
            i++;
        }
        if(i == n)return false;
        int l = 0 , r = m-1;
        while(l <= r){
            int mid = (l+r)/2;
            if(matrix[i][mid] == target){
                return true;
            }else if(matrix[i][mid] < target){
                l = mid+1;
            }else{
                r = mid-1;
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