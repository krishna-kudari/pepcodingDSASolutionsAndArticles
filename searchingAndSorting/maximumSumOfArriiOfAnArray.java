Maximize Sum Of Arr[i]*i Of An Array
Easy

1. Given an array arr of N integers. 
2. Your task is to write a program to find the maximum value of sum of arr[i]*i, where i = 0,1,2,...,n-1.
3. You are allowed to rearrange the elements of the array.

Constraints
1 <= N <= 10^6
1 <= arr[i] <= 10^5

Format
Input
Input is managed for you

Output
Output is managed for you

Example
Sample Input

5
2 3 1 5 4

Sample Output
40

import java.util.*;

public class Main {

    public static int maximise(int[]arr) {
        //write your code here
        Arrays.sort(arr);
        int sum = 0;
        for(int i=  1 ; i<arr.length ; i++){
            sum += arr[i]*i;
        }
        return sum;
    }

    public static void main(String[]args) {
        //input work
        Scanner scn = new Scanner(System.in);
        int n = scn.nextInt();

        int[]arr = new int[n];
        for(int i = 0 ; i < n; i++) {
            arr[i] = scn.nextInt();
        }

        int ans = maximise(arr);
        System.out.println(ans);
    }
}