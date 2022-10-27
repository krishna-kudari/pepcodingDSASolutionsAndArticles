Largest Area Histogram
Hard

1. You are given a number n, representing the size of array a. 2. You are given n numbers, representing the height of bars in a bar chart. 3. You are required to find and print the area of largest rectangle in the histogram. e.g. for the array [6 2 5 4 5 1 6] -> 12


Constraints
0 <= n < 20 0 <= a[i] <= 10


Format
Input
Input is managed for you


Output
A number representing area of largest rectangle in histogram


Example
Sample Input

7
6
2
5
4
5
1
6

Sample Output
12

Question Video

import java.io.*;
import java.util.*;

public class Main{
  

   public static void main(String[] args) throws Exception {
       BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

       int n = Integer.parseInt(br.readLine());
      int[] a = new int[n];
      for(int i = 0; i < n; i++){
          a[i] = Integer.parseInt(br.readLine());
      }

    // code
      int nser[]=new int[n];
      int nsel[]=new int[n];
      nsel[0]=-1;
      nser[n-1]=n;
      Stack<Integer>st=new Stack<>();
      st.push(0);
      for(int i=1;i<n;i++){
         if(a[i]>a[st.peek()]){
             nsel[i]=st.peek();
          
         }else{
            while(st.size()>0 &&a[st.peek()]>=a[i]){
               st.pop();
            }if(st.size()==0){
               nsel[i]=-1;
            }else{
               nsel[i]=st.peek();
            }
         }
         st.push(i);
      }
      // for(int i=0;i<n;i++){
      //    System.out.println(nsel[i]);
      // }
      while(st.size()>0){
         st.pop();
      }
      st.push(n-1);
      for(int i=n-2;i>=0;i--){
         if(a[i]>a[st.peek()]){
             nser[i]=st.peek();
             
         }else{
            while(st.size()>0 &&a[st.peek()]>=a[i]){
               st.pop();
            }if(st.size()==0){
               nser[i]=n;
            }else{
               nser[i]=st.peek();
            }
         }
         st.push(i);
      }
      // for(int i=0;i<n;i++){
      //    System.out.println(nsel[i]+"\t"+nser[i]);
      // }
      int maxarea=0;
      for(int i=0;i<n;i++){
         int length=a[i];
         int bridth=(nser[i]-nsel[i])-1;
         int area=length*bridth;
         maxarea=Math.max(area,maxarea);
      }
      System.out.println(maxarea);
   }
}