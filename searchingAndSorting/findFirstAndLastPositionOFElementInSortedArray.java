1. Given an array of integers nums sorted in ascending order, find the starting and ending position of a given target value.
2. If target is not found in the array, return [-1, -1].
3. You must write an algorithm with O(log n) runtime complexity.

Constraints
0 <= nums.length <= 10^5
-10^9 <= nums[i] <= 10^9
nums is a non-decreasing array.
-10^9 <= target <= 10^9

Format
Input
Input is managed for you

Output
Output is managed for you

Example
Sample Input

7
2 2 3 3 3 4 5
3

Sample Output
2 4

import java.util.*;
import java.io.*;

public class Main {

    //return an array of size two, which contains first and last index of target.
    public static int[] find(int[]arr,int target) {
        //write your code here
        int l = 0 , r  = arr.length-1;
        int[] ans = new int[2];
        int left = -1;
        while(l <= r){
            int m = (l+r)/2;
            if(arr[m] == target){
                left = m;
                r = m-1;
            }else if(arr[m] > target){
                r = m-1;
            }else{
                l = m+1;
            }
        }
        int right = -1;
        l = 0 ; r = arr.length-1;
        while( l <= r){
            int m = (l+r)/2;
            if(arr[m] == target){
                right = m;
                l = m+1;
            }else if(arr[m] > target){
                r = m-1;
            }else{
                l = m+1;
            }
        }
        ans[0] = left;
        ans[1] = right;
        return ans;
    }

    public static void main(String[]args) {
        //input work
        Scanner scn = new Scanner(System.in);

        int n = scn.nextInt();
        int[]arr = new int[n];

        for(int i=0;i < n;i++) {
            arr[i] = scn.nextInt();
        }

        int target = scn.nextInt();

        int[]ans = find(arr,target);
        System.out.println(ans[0] + " " + ans[1]);
    }
}