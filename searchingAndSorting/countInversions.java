Count Inversions
Hard

1. Given an array of integers. Find the Inversion Count in the array. 
2. For an array, inversion count indicates how far (or close) the array is from being sorted. If array is already sorted then the inversion count is 0. If an array is sorted in the reverse order then the inversion count is the maximum. 
3. Formally, two elements a[i] and a[j] form an inversion if a[i] > a[j] and i < j.

Constraints
1 <= N <= 10^5
1 <= arr[i] <= 10^6

Format
Input
A number n, denoting number of elements
n number of integers, denoting elements of array

Output
Print the count of total inversions

Example
Sample Input

5
2 4 1 3 5

Sample Output
3

import java.util.*;
import java.io.*;

public class Main {

    public static void main(String[]args) {
        //write your code here
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();
        long[] arr = new long[n];
        for(int i = 0 ; i < n ; i++){
            arr[i] = sc.nextInt();
        }
        total = 0;
        mergeSort(arr , 0 , (int)n-1);
        System.out.println(total);
    }
    public static long total = 0;
    public static long[] mergeSort(long[] arr , int l , int r){
        if(l==r){
            return new long[]{arr[l]} ;
        }
        int m = (l+r)/2;
        long[] left = mergeSort(arr , l , m);
        long[] right= mergeSort(arr , m+1 ,r);
        
        int cnt = 0;
        int idx = 0;
        long[] merged = new long[(right.length+left.length)];
        int i = 0 , j = 0;
        while( i < left.length && j < right.length){
            if(left[i] <= right[j]){
                merged[idx] = left[i];
                i++;
            }else if(left[i] > right[j]){
                cnt+= left.length - i;
                merged[idx] = right[j];
                j++;
            }
            idx++;
        }
        // if(i < left.length)cnt--;
        while(i < left.length){
            merged[idx] = left[i];
            i++;
            idx++;
            // cnt+= j;
        }
        
        while(j < right.length){
            merged[idx] = right[j];
            j++;
            idx++;
        }
        total += cnt;
        return merged;
    }
}