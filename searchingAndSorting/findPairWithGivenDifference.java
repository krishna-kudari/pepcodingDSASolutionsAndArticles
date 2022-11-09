Find Pair With Given Difference
Medium

1. Given an array arr of size n, you need to write a program to find if there exists a pair of elements in the array whose difference is equals to target.
2. If there exists such a pair print it, otherwise print -1.

Constraints
1 <= target <= 10^4
1 <= arr[i], n <= 10^5

Format
Input
Input is managed for you

Output
Output is managed for you

Example
Sample Input

6
5 2 3 80 5 20
78

Sample Output
2 80

import java.util.*;
import java.io.*;

public class Main {


    public static void findPair(int[]arr,int target) {
        //write your code here
        HashSet<Integer> set = new HashSet<>();
        for (int ai : arr) {
            set.add(ai);
        }
        for (int ai : arr) {
            if(ai < target){
                if(set.contains(ai+target)){
                  System.out.println(ai + " " + (ai+target));  
                  return ;
                }
            }else{
                if(set.contains(ai-target)){
                    System.out.println((ai-target) + " " + ai);
                    return ;
                }
            }
        }
        System.out.println(-1);
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
        findPair(arr,target);
    }
}