Find Minimum In Rotated Sorted Array
Easy

1. Suppose an array of length n sorted in ascending order is rotated between 1 and n times.
2. Notice that rotating an array [a[0], a[1], a[2], ..., a[n-1]] 1 time results in the array [a[n-1], a[0], a[1], a[2], ..., a[n-2]].
3. Given the sorted rotated array nums of unique elements, return the minimum element of this array.
4. You must write an algorithm that runs in O(log n) time.

Constraints
n == nums.length
1 <= n <= 5000
-5000 <= nums[i] <= 5000
All the integers of nums are unique.
nums is sorted and rotated between 1 and n times.

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
1

import java.util.*;

public class Main {

    public static int findMinimum(int[]arr) {
        //write your code here
        int l = 0 , r = arr.length-1;
        while(l < r){
            int  m = (l+r)/2;
            if(arr[m] > arr[r]){
                l = m+1 ;
            }else if(arr[m] < arr[r]){
                r = m;
            }else{
                r--;
            }
        }
        return arr[r];
    }

    public static void main(String[]args) {
        //input work
        Scanner scn = new Scanner(System.in);
        int n = scn.nextInt();

        int[]arr = new int[n];
        for(int i = 0 ; i < n; i++) {
            arr[i] = scn.nextInt();
        }

        int ans = findMinimum(arr);
        System.out.println(ans);
    }
}