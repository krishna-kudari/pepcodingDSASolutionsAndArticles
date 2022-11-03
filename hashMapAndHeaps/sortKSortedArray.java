Sort K-sorted Array
Easy

1. You are given a number n, representing the size of array a.
2. You are given n numbers, representing elements of array a.
3. The array is nearly sorted. Every element is at-max displaced k spots left or right to its position in the sorted array. Hence it is being called k-sorted array.
4. You are required to sort and print the sorted array.

Note -> You can use at-max k extra space and nlogk time complexity.

Constraints
1 <= n <= 30
0 <= n1, n2, .. n elements <= 100
0 < k <= n

Format
Input
Input is managed for you

Output
Print the elements of sorted array in separate lines.

Example
Sample Input

9
3
2
4
1
6
5
7
9
8
3

Sample Output
1
2
3
4
5
6
7
8
9

import java.io.*;
import java.util.*;

public class Main {

   public static void main(String[] args) throws Exception {
      BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
      int n = Integer.parseInt(br.readLine());
      int[] arr = new int[n];

      for (int i = 0; i < n; i++) {
         arr[i] = Integer.parseInt(br.readLine());
      }

      int k = Integer.parseInt(br.readLine());
      // write your code here
      PriorityQueue<Integer> pq = new PriorityQueue<>();
      for (int var : arr) {
         if(pq.size()<k+2){
            pq.add(var);
         }
         else{
            System.out.println(pq.remove());
            pq.add(var);
         }
      }
      while(pq.size()>0){
         System.out.println(pq.remove());
      }
   }

}