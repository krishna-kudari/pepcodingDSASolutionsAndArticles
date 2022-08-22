import java.io.*;
import java.util.*;

public class printAllPathsWithminCost {

   private static class Pair {
      String psf;
      int i;
      int j;

      public Pair(String psf, int i, int j) {
         this.psf = psf;
         this.i = i;
         this.j = j;
      }
   }

   public static void main(String[] args) throws Exception {
      BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
      int n = Integer.parseInt(br.readLine());
      int m = Integer.parseInt(br.readLine());
      int[][] arr = new int[n][m];

      for (int i = 0; i < n; i++) {
         String str = br.readLine();
         for (int j = 0; j < m; j++) {
            arr[i][j] = Integer.parseInt(str.split(" ")[j]);
         }
      }

      //write your code here
      for (int i = arr.length-1; i >= 0; i--) {
         for (int j = arr[0].length-1; j >= 0; j--) {
            if(i == arr.length -1 && j == arr[0].length-1){
            }
            else if(i == arr.length -1){
               arr[i][j] += arr[i][j+1];
            }else if(j == arr[0].length -1){
               arr[i][j] += arr[i+1][j];
            }else{
               arr[i][j] += Math.min(arr[i][j+1] , arr[i+1][j]);
            }
         }
      }
      System.out.println(arr[0][0]);
      Queue<Pair> que = new ArrayDeque<>();
      que.add(new Pair("",0 ,0));
      while(que.size() > 0){
         Pair rp = que.remove();
         if(rp.i == arr.length-1 && rp.j == arr[0].length-1){
            System.out.println(rp.psf);
         }else if(rp.i == arr.length-1){
            que.add(new Pair(rp.psf + 'H' , rp.i , rp.j+1));
         }else if(rp.j == arr[0].length-1){
            que.add(new Pair(rp.psf + 'V' , rp.i+1 , rp.j));
         }else{
            if(arr[rp.i][rp.j+1] > arr[rp.i+1][rp.j]){
               que.add(new Pair(rp.psf+'V' , rp.i+1 , rp.j));
            }else if(arr[rp.i][rp.j+1] < arr[rp.i+1][rp.j]){
               que.add(new Pair(rp.psf+'H' , rp.i , rp.j+1));
            }else{
               que.add(new Pair(rp.psf+'V' , rp.i+1 , rp.j));
               que.add(new Pair(rp.psf+'H' , rp.i , rp.j+1));
            }
         }
      }
      
   }

}