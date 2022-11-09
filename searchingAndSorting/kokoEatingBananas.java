Koko Eating Bananas
Medium

1. Koko loves to eat bananas. There are n piles of bananas, the ith pile has piles[i] bananas. The guards have gone and will come back in h hours.
2. Koko can decide her bananas-per-hour eating speed of k. Each hour, she chooses some pile of bananas and eats k bananas from that pile. If the pile has less than k bananas, she eats all of them instead and will not eat any more bananas during this hour.
3. Koko likes to eat slowly but still wants to finish eating all the bananas before the guards return.
4. Return the minimum integer k such that she can eat all the bananas within h hours.

Constraints
1 <= piles.length <= 10^4
piles.length <= h <= 10^9
1 <= piles[i] <= 10^9

Format
Input
Input is managed for you

Output
Output is managed for you

Example
Sample Input

4
3 6 7 11
8

Sample Output
4

import java.util.*;
import java.io.*;

public class Main {
    public static int getHours(int[] piles , int k){
        int h = 0;
        for(int i= 0 ; i < piles.length ; i++){
            h += Math.ceil(1.0*piles[i] / k);
        }
        return h;
    }
    public static int minEatingSpeed(int[]piles,int h) {
        //write your code here
        int max = 1 ;
        for(int i : piles){
            if(i > max)max = i;
        }
        int l = 1 , r = max ;
        while( l <= r){
            int k = (l+r)/2 ;
            int hours = getHours(piles , k);
            if(hours > h){
                l = k+1;
            }
            else {
                r = k-1;
            }
        }
        return l;
    }

    public static void main(String[]args) {
        Scanner scn = new Scanner(System.in);
        //input work
        int n = scn.nextInt();
        int[]piles = new int[n];

        for(int i=0 ; i < n ; i++) {
            piles[i] = scn.nextInt();
        }

        int h = scn.nextInt();

        int speed = minEatingSpeed(piles,h);
        System.out.println(speed);
    }
}