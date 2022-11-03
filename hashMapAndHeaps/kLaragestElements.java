K Largest Elements
Easy

1. You will be given an Array with its length
 2. You will also be given an integral value k
 3. You need to find k largest elements from the given array
 4. Input is handled for you
 5. It is a functional problem ,please do not modify main()

Constraints
1 <= N <= 100
 K <= N
 -1000 <= C[i] <= 1000

Format
Input
Input is handled for you

Output
Output MUST be in descending order

Example
Sample Input

8
44 -5 -2 41 12 19 21 -6 
2

Sample Output
44 41

import java.util.*;
 import java.lang.*;
 import java.io.*;
 class Main
{
 	 public static void main (String[] args) throws IOException
   {
 	 	 Scanner scn= new Scanner(System.in);
 	    	 int n = scn.nextInt();
 	 	 int[] num = new int[n];
 	 	 for (int i = 0; i < n; i++) {
 	 	 	 	 num[i] = scn.nextInt();
 	 	 	 }
 	 	 int k = scn.nextInt();
 	 	 solve(n,num,k);
 	}
 	 // -----------------------------------------------------
 	 // This is a functional problem. Only this function has to be written.
 	 // This function takes as input an array,n length of array and k.
 	 // It should print required output.
	public static void solve(int n,int[] arr,int k){
		//Write your code here
		PriorityQueue<Integer> pq =new PriorityQueue<>();
		for (int var : arr) {
			if(pq.size()<k){
				pq.add(var);
			}else{
				if(pq.peek() < var){
				pq.remove();
				pq.add(var);
				}
			}
		}
		print(pq);
		// Stack<Integer>st = new Stack<>();
		// while(pq.size()>0){
		// 	st.push(pq.remove());
		// }
		// while(st.size()>0){
		// 	System.out.print(st.pop()+" ");
		// }
	}
	public static void print(PriorityQueue<Integer> pq){
		if(pq.size()==0){
			return ;
		}
		int val = pq.remove();
		print(pq);
		System.out.print(val+" ");
	}
}