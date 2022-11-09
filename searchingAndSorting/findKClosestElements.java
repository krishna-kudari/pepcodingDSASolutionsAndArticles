Find K Closest Elements
Medium

1. Given a sorted integer array arr, two integers k and x, return the k closest integers to x in the array. The result should also be sorted in ascending order.
2. An integer a is closer to x than an integer b if:
        |a - x| < |b - x|, or
        |a - x| == |b - x| and a < b

Constraints
1 <= k <= arr.length
1 <= arr.length <= 10^4
arr is sorted in ascending order.
-10^4 <= arr[i], x <= 10^4

Format
Input
Input is managed for you

Output
Output is managed for you

Example
Sample Input

6
10 20 30 40 50 60
3 
45

Sample Output
30 40 50

import java.util.*;
import java.io.*;

public class Main {

    /*find ''k'' closest element to ''x'' and return answer list*/
    /*elements in answer list should be in ascending order*/
    public static ArrayList<Integer> findClosest(int[]arr,int k,int x) {
        //write your code here
        int pos = Arrays.binarySearch(arr , 0 , arr.length-1, x );
        if(pos < 0 )pos = (-pos) -1;
        
        ArrayList<Integer> list = new ArrayList<>();
        int l = pos-1 , r = pos;
        int cnt = 0;
        // System.out.println(pos );
        while(l >= 0 && r < arr.length && cnt < k){
            int d1 = Math.abs(arr[l] - x) ;
            int d2 = Math.abs(arr[r] - x) ;
            if(d1 <= d2){
                list.add(arr[l]);
                l--;
                cnt++;
            }else if(d1 > d2){
                list.add(arr[r]);
                r++;
                cnt++;
            }
        }
        
        while(l >= 0 && cnt < k){
            list.add(arr[l]);
            l--;
            cnt++;
        }
        
        while(r < arr.length && cnt < k){
            list.add(arr[r]);
            r++;
            cnt++;
        }
        Collections.sort(list);
        return list;
    }

    public static void main(String[]args) {

        //input work
        Scanner scn = new Scanner(System.in);
        int n = scn.nextInt();

        int[]arr = new int[n];

        for(int i=0; i < n;i++) {
            arr[i] = scn.nextInt();
        }

        int k = scn.nextInt();
        int x = scn.nextInt();

        ArrayList<Integer>ans = findClosest(arr,k,x);

        for(int val : ans) {
            System.out.print(val + " ");
        }

    }
}