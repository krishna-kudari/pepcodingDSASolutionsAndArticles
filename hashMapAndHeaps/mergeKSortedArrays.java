Merge K Sorted Lists
Hard

1. You are given a list of lists, where each list is sorted.
2. You are required to complete the body of mergeKSortedLists function. The function is expected to merge k sorted lists to create one sorted list.

Constraints
Space complextiy = O(k)
Time complexity = nlogk
where k is the number of lists and n is number of elements across all lists.

Format
Input
Input is managed for you

Output
Output is managed for you

Example
Sample Input

4
5
10 20 30 40 50
7
5 7 9 11 19 55 57
3
1 2 3
2
32 39

Sample Output
1 2 3 5 7 9 10 11 19 20 30 32 39 40 50 55 57 

import java.io.*;
import java.util.*;

public class Main {
   public static class Pair implements Comparable<Pair>{
      int num;
      int idx;
      int ii;
      Pair(int num  , int idx , int ii){
         this.num = num;
         this.idx = idx;
         this.ii = ii;
      }
      public int compareTo (Pair o){
         return this.num - o.num;
      }
   }
   public static ArrayList<Integer> mergeKSortedLists(ArrayList<ArrayList<Integer>> lists){
      ArrayList<Integer> rv = new ArrayList<>();

      // write your code here
      PriorityQueue<Pair> pq = new PriorityQueue<>();
      int i=0;
      for (ArrayList<Integer> lst : lists) {
         pq.add(new Pair( lst.get(0) , i , 0));
         i++;

      }
      while(pq.size()> 0){
         Pair p = pq.remove();
         rv.add(p.num);
         int idx = p.idx;
         if(p.ii+1 < lists.get(idx).size()){
            pq.add(new Pair(lists.get(p.idx).get(p.ii+1), p.idx , p.ii+1));
         }
      }
      

      return rv;
   }

   public static void main(String[] args) throws Exception {
      BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
      int k = Integer.parseInt(br.readLine());
      ArrayList<ArrayList<Integer>> lists = new ArrayList<>();
      for(int i = 0; i < k; i++){
         ArrayList<Integer> list = new ArrayList<>();

         int n = Integer.parseInt(br.readLine());
         String[] elements = br.readLine().split(" ");
         for(int j = 0; j < n; j++){
            list.add(Integer.parseInt(elements[j]));
         }

         lists.add(list);
      }

      ArrayList<Integer> mlist = mergeKSortedLists(lists);
      for(int val: mlist){
         System.out.print(val + " ");
      }
      System.out.println();
   }

}