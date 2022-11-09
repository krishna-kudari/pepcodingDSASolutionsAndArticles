Find The Smallest Divisor Given A Threshold
Medium

1. Given an array of integers nums and an integer threshold, we will choose a positive integer divisor, divide all the array by it, and sum the divisions result. Find the smallest divisor such that the result mentioned above is less than or equal to threshold.
2. Each result of the division is rounded to the nearest integer greater than or equal to that element. (For example: 7/3 = 3 and 10/2 = 5).
3. It is guaranteed that there will be an answer.

Constraints
1 <= nums.length <= 5 * 10^4
1 <= nums[i] <= 10^6
nums.length <= threshold <= 10^6

Format
Input
Input is managed for you

Output
Output is managed for you
 

Example
Sample Input

4
1 2 5 9
6

Sample Output
5

import java.util.*;
import java.io.*;

public class Main {
    public static int getDivisionSum(int[]nums , int divisor){
        int sum = 0;
        for(int i = 0 ; i < nums.length ; i++){
            int quotient = (int)Math.ceil(nums[i]*1.0/divisor);
            sum += quotient;
        }
        return sum ;
    }
    public static int findSmallestDivisor(int[]nums,int th) {
        //write your code here
        int l = 1 , r = getMax(nums);
        int ans = r ;
        while(l < r){
            int m = (l+r)/2;
            int quotientSum = getDivisionSum(nums , m);
            if(quotientSum > th){
                l = m+1;
            }else{
                ans = m;
                r = m-1;
            }
            // System.out.println(quotientSum);
        }
        return ans;
    }
    public static int getMax(int[] nums){
        int max = 1;
        for (int i : nums) {
            if(i > max)max = i;
        }
        return max;
    }
    public static void main(String[]args) {
        Scanner scn = new Scanner(System.in);
        //input work
        int n = scn.nextInt();
        int[]nums = new int[n];

        for(int i=0 ; i < n ; i++) {
            nums[i] = scn.nextInt();
        }

        int th = scn.nextInt();

        int speed = findSmallestDivisor(nums,th);
        System.out.println(speed);
    }
}