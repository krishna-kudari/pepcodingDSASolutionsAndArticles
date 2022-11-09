Find Rotation Count
Easy

1. Given an ascending sorted rotated array arr of distinct integers of size N. 
2. The array is right rotated K times. 
3. Your task is to find the value of K.

Constraints
1 <= N <=10^5
1 <= arr[i] <= 10^7

Format
Input
Input is managed for you

Output
Output is managed for you

Example
Sample Input

6
5 6 1 2 3 4

Sample Output
2

import java.util.*;

public class Main {

    public static int findRotationCount(int[]arr) {
        //write your code here
        int l = 0 , r = arr.length-1;
        while(l < r){
            int m = (l+r)/2 ;
            if(arr[m] > arr[r]){
                l = m+1;
            }else if(arr[m] < arr[r]){
                r = m ;
            }else{
                r--;
            }
        }
        int pivotIdx = r;

        return r;
    }

    public static void main(String[]args) {
        //input work
        Scanner scn = new Scanner(System.in);
        int n = scn.nextInt();

        int[]arr = new int[n];
        for(int i = 0 ; i < n; i++) {
            arr[i] = scn.nextInt();
        }

        int ans = findRotationCount(arr);
        System.out.println(ans);
    }
}