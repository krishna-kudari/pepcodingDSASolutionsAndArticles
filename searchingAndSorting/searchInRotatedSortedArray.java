Search In Rotated Sorted Array
Medium

1. There is an integer array nums sorted in ascending order (with distinct values).
2. nums is rotated at an unknown pivot index k (0 

Constraints
1 <= nums.length <= 5000
-10^4 <= nums[i] <= 10^4
All values of nums are unique.
nums is guaranteed to be rotated at some pivot.
-10^4 <= target <= 10^4

Format
Input
Input is managed for you

Output
Output is managed for you

Example
Sample Input

7
4 5 6 7 0 1 2
1

Sample Output
5

import java.util.*;
import java.io.*;

public class Main {
    public static int findPivot(int[] arr ){
        int l = 0 , r = arr.length -1;
        while(l < r){
            int m = (l+r)/2;
            if(arr[m] > arr[r]){
                l = m +1;
            }else if(arr[m] < arr[r]){
                r = m;
            }else{
                r--;
            }
        }
        return r;
    }
    public static int find(int[]arr,int target){
        int pivot = findPivot(arr);

        int idx = Arrays.binarySearch(arr , 0 , pivot -1 , target);
        if(idx >= 0)return idx ;
        idx = Arrays.binarySearch(arr , pivot , arr.length-1 , target);
        if(idx >= 0)return idx;
        return -1;
    }

    public static void main(String[]args) {
        //input work
        Scanner scn = new Scanner(System.in);
        int n = scn.nextInt();
        int[]arr = new int[n];

        for(int i=0; i < n;i++) {
            arr[i] = scn.nextInt();
        }

        int target = scn.nextInt();
        int ans = find(arr,target);
        System.out.println(ans);
    }
}