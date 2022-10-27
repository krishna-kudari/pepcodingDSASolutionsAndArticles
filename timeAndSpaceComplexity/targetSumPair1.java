Target Sum Pair 1
Easy

1. You are given an array(arr) of distinct integers and a target. 2. You have to print all the pairs having their sum equal to the target.


Constraints
1 <= N <= 10000 -10^9<= arr[i] <= 10^9


Format
Input
An Integer N arr1 arr2.. n integers An integer target


Output
Check the sample output and question video.


Example
Sample Input

12
9 
-48 
100 
43 
84 
74 
86 
34 
-37 
60 
-29 
44
160

Sample Output
60, 100
74, 86

import java.io.*;
import java.util.*;

public class Main {

  public static void targetSumPair(int[] arr, int target){
    //write your code here
    Arrays.sort(arr);
    int i=0,j=arr.length-1;
    while(i<j){
      int sum=arr[i]+arr[j];
      // System.out.println(target);
      if(sum>target){
        j--;
      }else if(sum<target){
        i++;
      }else{
        System.out.println(arr[i]+", "+arr[j]);
        i++;
        j--;
      }
    }

  }
  public static void main(String[] args) throws Exception {
    Scanner scn = new Scanner(System.in);
    int n = scn.nextInt();
    int[] arr = new int[n];
    for(int i = 0 ;i < n; i++){
      arr[i] = scn.nextInt();
    }
    int target = scn.nextInt();
    targetSumPair(arr,target);
  }

}