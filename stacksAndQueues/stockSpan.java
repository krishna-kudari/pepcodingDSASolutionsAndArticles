import java.io.*;
import java.util.*;

public class stockSpan{
  public static void display(int[] a){
    StringBuilder sb = new StringBuilder();

    for(int val: a){
      sb.append(val + "\n");
    }
    System.out.println(sb);
  }

public static void main(String[] args) throws Exception {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

    int n = Integer.parseInt(br.readLine());
    int[] a = new int[n];
    for(int i = 0; i < n; i++){
       a[i] = Integer.parseInt(br.readLine());
    }

    int[] span = solve(a);
    display(span);
 }

 public static int[] solve(int[] arr){
   // solve
   int nge[]=new int[arr.length];
   Stack<Integer>st=new Stack<>();
   for(int i=arr.length-1;i>=0;i--){
     while(st.size()>0 && arr[st.peek()]<arr[i]){
       nge[st.peek()]=st.peek()-i;
       st.pop();
     }
     
     st.push(i);
   }
   while(st.size()>0){
     nge[st.peek()]=st.peek()+1;
     st.pop();
   }
   return nge;
   
 }

}