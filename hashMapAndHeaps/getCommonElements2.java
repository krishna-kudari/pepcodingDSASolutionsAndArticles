Get Common Elements - 2
Easy

1. You are given a number n1, representing the size of array a1. 2. You are given n1 numbers, representing elements of array a1. 3. You are given a number n2, representing the size of array a2. 4. You are given n2 numbers, representing elements of array a2. 5. You are required to find the intersection of a1 and a2. To get an idea check the example below: if a1 -> 1 1 2 2 2 3 5 and a2 -> 1 1 1 2 2 4 5 intersection is -> 1 1 2 2 5 Note -> Dont assume the arrays to be sorted. Check out the question video.


Constraints
1 <= n1, n2 <= 100 0 <= a1[i], a2[i] < 10 Time complexity should be O(n)


Format
Input
A number n1 n1 number of elements line separated A number n2 n2 number of elements line separated


Output
All relevant elements of intersection in separate lines The elements of intersection should be printed in order of their occurence in a2.


Example
Sample Input

7
1
1
2
2
2
3
5
7
1
1
1
2
2
4
5

Sample Output
1
1
2
2
5

import java.io.*;

import java.util.*;

public class Main {

  public static void main(String[] args) throws Exception {
	  //Write your code here
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    int n1 = Integer.parseInt(br.readLine());
    HashMap<Integer , Integer> h1 = new HashMap<>();
    for(int i=0; i<n1 ; i++){
      int val = Integer.parseInt(br.readLine());
      if(h1.containsKey(val)){
        int of  = h1.get(val) ; 
        of+=1;
        h1.put(val , of) ;
      }else {
        h1.put(val , 1);
      }
    }
    int n2  = Integer.parseInt(br.readLine());
    for(int n = 0 ;n<n2 ;n++){
      int var =Integer.parseInt(br.readLine());
      if(h1.containsKey(var) && h1.get(var)> 0){
        System.out.println(var);
        int of  = h1.get(var) ; 
        of-=1;
        h1.put(var , of) ;
      }
    }
  }

}