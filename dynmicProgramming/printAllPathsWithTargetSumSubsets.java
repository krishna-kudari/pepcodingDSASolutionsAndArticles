import java.io.*;
import java.util.*;

public class printAllPathsWithTargetSumSubsets {

    public static class Pair{
        int i;
        int j;
        String psf;

        public Pair(int i, int j, String psf){
            this.i = i;
            this.j = j;
            this.psf = psf;
        }
    }
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        int[] arr = new int[n];

        for (int i = 0; i < n; i++) {
            arr[i] = Integer.parseInt(br.readLine());
        }

        int tar = Integer.parseInt(br.readLine());

        //write your code here
        boolean[][] dp = new boolean[n+1][tar+1];
        dp[0][0] = true;
        for (int i = 1; i < dp.length; i++) {
            for (int j = 0; j < dp[0].length; j++) {
                if(j == 0)dp[i][j]=true;
                else{
                    dp[i][j] = dp[i-1][j];
                    if(j-arr[i-1] >=0 && dp[i-1][j-arr[i-1]])dp[i][j]=true;
                }
                // System.out.print(dp[i][j]);
            }
            // System.out.println();
        }
        System.out.println(dp[n][tar]);

        Queue<Pair> que = new ArrayDeque<>();
        que.add(new Pair(n , tar , ""));
        while(que.size() > 0){
            Pair rp = que.remove();
            int i = rp.i , j = rp.j;
            if(i == 0 || j == 0 || dp[i][j] == false)System.out.println(rp.psf);
            else{
                boolean nc = i-1>=0 ?dp[i-1][j]:false;
                boolean c = j-arr[i-1] >= 0?dp[i-1][j-arr[i-1]] : false;
                if(dp[i][j] == c){
                    que.add(new Pair(i-1 , j- arr[i-1] , (i-1)+" "+rp.psf));
                }
                if(dp[i][j] == nc){
                    que.add(new Pair(i-1 , j , rp.psf)); 
                }
            }
            
        }

    }
}