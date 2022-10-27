1. Given an array of integers nums, calculate the pivot index of this array.
2. The pivot index is the index where the sum of all the numbers strictly to the left of the index is equal to the sum of all the numbers strictly to the index's right.
3. If the index is on the left edge of the array, then the left sum is 0 because there are no elements to the left. This also applies to the right edge of the array.
4. Return the leftmost pivot index. If no such index exists, return -1.

Constraints
1 <= nums.length <= 104
-1000 <= nums[i] <= 1000

Format
Input
Input is managed for you

Output
Output is managed for you

Example
Sample Input

6
1 7 3 6 5 6

Sample Output
3

import java.util.*;
import java.io.*;

public class Main {

    public static int pivot_index(int[]arr) {
        //write your code here
        if(arr.length <= 1)return 0;
        int[] leftPrefixSum = new int[arr.length];
        int[] rightPrefixSum = new int[arr.length];
        leftPrefixSum[0] = arr[0];
        for(int i = 1 ; i < arr.length ; i++){
            leftPrefixSum[i] = leftPrefixSum[i-1] + arr[i];
        }
        rightPrefixSum[arr.length-1] = arr[arr.length-1];
        for(int i = arr.length-2 ; i >= 0 ; i--){
            rightPrefixSum[i] = rightPrefixSum[i+1] + arr[i];
        }
        if(rightPrefixSum[1] == 0){
            return 0;
        }
        for(int i = 1 ; i<arr.length-1 ; i++){
            if(leftPrefixSum[i-1] == rightPrefixSum[i+1])return i;
        }
        if(leftPrefixSum[arr.length-2] == 0)return arr.length-1;
        return -1;
    }

    public static void main(String[]args) {
        //input work
        Scanner scn = new Scanner(System.in);
        int n = scn.nextInt();

        int[]arr = new int[n];

        for(int i=0; i < arr.length;i++) {
            arr[i] = scn.nextInt();
        }

        int pi = pivot_index(arr);
        System.out.println(pi);
    }
}