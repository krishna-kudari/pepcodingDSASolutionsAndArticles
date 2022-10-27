Partition An Array
Easy

1. You are given an array(arr) of integers and a pivot.
2. You have to re-arrange the given array in such a way that all elements smaller or equal to pivot lie on the left side of pivot and all elements greater than pivot lie on its right side.
3. You have to achieve this in linear time.

Note -> For more information, watch question video.

Constraints
1 <= N <= 100000
-10^9 <= arr[i] <= 10^9
-10^9 <= pivot <= 10^9

Format
Input
An Integer n 
arr1
arr2..
n integers
An integer pivot

Output
Check the sample output and question video.

Example
Sample Input

5
7 
-2 
4 
1 
3
3

Sample Output
Swapping -2 and 7
Swapping 1 and 7
Swapping 3 and 4
-2 1 3 7 4

Question Video

import java.io.*;
import java.util.*;

public class Main {

  public static void partition(int[] arr, int pivot){
    //write your code here
    int i=0,j=0;
    while(i<arr.length){
      if(arr[i]<=pivot){
        swap(arr,i,j);
        j++;i++;
      }else{
        i++;
      }
    }
    
    
  }

  // used for swapping ith and jth elements of array
  public static void swap(int[] arr, int i, int j) {
    System.out.println("Swapping " + arr[i] + " and " + arr[j]);
    int temp = arr[i];
    arr[i] = arr[j];
    arr[j] = temp;
  }

  public static void print(int[] arr) {
    for (int i = 0; i < arr.length; i++) {
      System.out.print(arr[i] + " ");
    }
    System.out.println();
  }

  public static void main(String[] args) throws Exception {
    Scanner scn = new Scanner(System.in);
    int n = scn.nextInt();
    int[] arr = new int[n];
    for (int i = 0; i < n; i++) {
      arr[i] = scn.nextInt();
    }
    int pivot = scn.nextInt();
    partition(arr,pivot);
    print(arr);
  }

}

1. PROBLEM DISCUSSION
You are given an array(arr) of integers and a pivot. You have to re-arrange the given array in such a way that all elements smaller or equal to pivot lie on the left side of pivot and all elements greater than pivot lie on its right side. You have to achieve this in linear time.


2. APPROACH



Let's take the above example pivot element in this case is 1. So we have the arrange elements such that all the elements less than 1 are on the left and elements greater than 1 are on the right. So we will maintain two pointers i and j,using this we will divide the array into 3 parts.





Like in the above example we have traversed some part of the array. Elements less than or equal to pivot will be in from (0 to i-1),there are no such elements yet. Elements greater the pivot will be in from (i to j) ie. from(0 to 2) Elements in the range (j+1 to n) are unexplored ie. from(3 to 7). Now in the unexplored region we will traverse the array and one by one will visit a new element and move it to its correct region . we analyse arr[i]. If arr[i]>pivot then j is increased by 1 which means the unknown area is decreased by one and the area for greater elements is increased. Else if arr[i]<=pivot, then we swap the elements at i and j and increment both i and j by one. This decreases the unknown area by one element, less than or equal to area increases and the size of the greater than area remains the same but the area gets shifted forward.


#include<bits/stdc++.h>
using namespace std;


void swap(int arr[], int i, int j) {
  cout << "Swapping " << arr[i] << " and " << arr[j] << endl;
  int temp = arr[i];
  arr[i] = arr[j];
  arr[j] = temp;
}

void partition(int arr[], int n, int pivot) {
  int p1 = -1;
  int itr = 0;
  while (itr < n) {
    if (arr[itr] <= pivot) {
      swap(arr, itr, ++p1);
    }
    itr++;
  }
}

void print(int arr[], int n) {
  for (int i = 0; i < n; i++) {
    cout << arr[i] << " ";
  }
  cout << endl;
}

int main() {

  int n;
  cin >> n;

  int arr[n];
  for (int i = 0; i < n; i++) {
    cin >> arr[i];
  }

  int pivot;
  cin >> pivot;

  partition(arr, n, pivot);
  print(arr, n);
}
3. ANALYSIS
Time complexity O( N ). Space complexity s=O(1)


