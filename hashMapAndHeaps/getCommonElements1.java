Get Common Elements - 1
Easy

1. You are given a number n1, representing the size of array a1.
2. You are given n1 numbers, representing elements of array a1.
3. You are given a number n2, representing the size of array a2.
4. You are given n2 numbers, representing elements of array a2.
5. You are required to print all elements of a2 which are also present in a1 (in order of their occurence in a2). Make sure to not print duplicates (a2 may have same value present many times).

Constraints
1 <= n1, n2 <= 100
0 <= a1[i], a2[i] < 10
Time complexity should be O(n)

Format
Input
A number n1
n1 number of elements line separated
A number n2
n2 number of elements line separated

Output
All relevant elements of a2 in separate lines (no duplicacy)

Example
Sample Input

9
5
5
9
8
5
5
8
0
3
18
9
7
1
0
3
6
5
9
1
1
8
0
2
4
2
9
1
5

Sample Output
9
0
3
5
8

import java.io.*;
import java.util.*;

public class Main{

public static void main(String[] args) throws Exception {
    // write your code here

    Scanner sc = new Scanner(System.in);
    
    int n = sc.nextInt();
    HashMap<Integer , Integer> h1 = new HashMap<>();
    for (int i = 0; i < n; i++) {
        h1.put(sc.nextInt() , 1);   
    }
    
    int n2 = sc.nextInt();
    HashMap<Integer , Integer> h2 = new HashMap<>();
    for (int i = 0; i < n2; i++) {
        int val = sc.nextInt();
        // h2.put(val , 1);  
        if(h1.containsKey(val)){
            System.out.println(val);
            h1.remove(val);
            // System.out.println(x+"k");
        }

    }
    
    
 }

}