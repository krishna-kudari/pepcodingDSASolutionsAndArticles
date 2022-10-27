Sort Dates
Easy

1. You are given an array(arr) of different dates in format DD-MM-YYYY.
2. You have to sort these dates in increasing order.

Constraints
1 <= N <= 10000
All dates are between year 0 to year 2500

Format
Input
An Integer N 
arr1
arr2..
n integers

Output
Check the sample output and question video.

Example
Sample Input

5
12041996
20101996
05061997
12041989
11081987

Sample Output
11081987
12041989
12041996
20101996
05061997

import java.io.*;
import java.util.*;

public class Main {

  public static void sortDates(String[] arr) {
    // write your code here
    int div=1000000;
    int mod=100;
    int range=32;
    countSort(arr,div,mod,range);
    div=10000;
    mod=100;
    range=13;
    countSort(arr,div,mod,range);
    div=1;
    mod=10000;
    range=2501;
    countSort(arr,div,mod,range); 

  }

  public static void countSort(String[] arr,int div, int mod, int range) {
    // write your code here
    int freq[]=new int[range];
    for(int i=0;i<arr.length;i++){
      int num=Integer.parseInt(arr[i],10);
      int dig=(num/div)%mod;
      freq[dig]++;
      
    }
    for(int j=1;j<freq.length;j++){
      freq[j]+=freq[j-1];
      // System.out.println(freq[j]);
    }
    String ans[]=new String[arr.length];
    for(int i=arr.length-1;i>=0;i--){
      int val=Integer.parseInt(arr[i],10);
      val=(val/div)%mod;
      int idx=freq[val]-1;
      ans[idx]=arr[i];
      freq[val]--;
    }
    for(int i=0;i<arr.length;i++){
      arr[i]=ans[i];
    }
  }

  public static void print(String[] arr) {
    for (int i = 0; i < arr.length; i++) {
      System.out.println(arr[i]);
    }
  }

  public static void main(String[] args) throws Exception {
    Scanner scn = new Scanner(System.in);
    int n = scn.nextInt();
    String[] arr = new String[n];
    for (int i = 0; i < n; i++) {
      String str = scn.next();
      arr[i] = str;
    }
    sortDates(arr);
    print(arr);
  }

}