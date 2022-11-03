Longest Consecutive Sequence Of Elements
Hard

1. You are given a number n, representing the size of array a.
2. You are given n numbers, representing elements of array a.
3. You are required to print the longest sequence of consecutive elements in the array (ignoring duplicates).

Note -> In case there are two sequences of equal length (and they are also the longest), then print the one for which the starting point of which occurs first in the array.

Constraints
1 <= n <= 30
0 <= n1, n2, .. n elements <= 15

Format
Input
A number n
n1
n2
.. n number of elements

Output
Elements of longest sequence of consecutive elements of array in separate lines (ignoring duplicates)

Example
Sample Input

17
12
5
1
2
10
2
13
7
11
8
9
11
8
9
5
6
11

Sample Output
5
6
7
8
9
10
11
12
13

import java.io.*;
import java.util.*;

public class Main{

public static void main(String[] args) throws Exception {
    // write your code here
    Scanner scn = new Scanner(System.in);
    int t = scn.nextInt();
    HashMap<Integer , Boolean> hm = new HashMap<>();
    for(int i=0 ; i<t ;i++){
        hm.put(scn.nextInt() , true);
    }

    Set<Integer> keys = hm.keySet();
    for(Integer val : keys){
        if(hm.containsKey(val-1)){
            hm.put(val , false);
        }
    }
    // System.out.println(hm);
    ArrayList<Integer> lst = new ArrayList<>();
    for(Integer val : keys){
        
        if(hm.get(val)){
            ArrayList<Integer> ls = new ArrayList<>();
            ls.add(val);
            while(hm.containsKey(++val)){
                ls.add(val);
            }
            if(ls.size()>lst.size()){
                lst = ls;
            }
        }
    }
    for(int i=0; i< lst.size();i++){
        System.out.println(lst.get(i));
    }
 }

}