Is Graph Cyclic
Easy

1. You are given a graph.
2. You are required to find and print if the graph is cyclic.

Constraints
None

Format
Input
Input has been managed for you

Output
true if the graph is cyclic, false otherwise

Example
Sample Input

7
6
0 1 10
1 2 10
2 3 10
3 4 10
4 5 10
5 6 10

Sample Output
false


import java.io.*;
import java.util.*;

public class Main {
   static class Pair{
      int v;
      String psf;
      Pair(int v , String psf) {
         this.v= v;
         this.psf = psf;
      }
      Pair(){}
   }
   static class Edge {
      int src;
      int nbr;
      int wt;

      Edge(int src, int nbr, int wt) {
         this.src = src;
         this.nbr = nbr;
         this.wt = wt;
      }
   }

   public static void main(String[] args) throws Exception {
      BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

      int vtces = Integer.parseInt(br.readLine());
      ArrayList<Edge>[] graph = new ArrayList[vtces];
      for (int i = 0; i < vtces; i++) {
         graph[i] = new ArrayList<>();
      }

      int edges = Integer.parseInt(br.readLine());
      for (int i = 0; i < edges; i++) {
         String[] parts = br.readLine().split(" ");
         int v1 = Integer.parseInt(parts[0]);
         int v2 = Integer.parseInt(parts[1]);
         int wt = Integer.parseInt(parts[2]);
         graph[v1].add(new Edge(v1, v2, wt));
         graph[v2].add(new Edge(v2, v1, wt));
      }

      // write your code here
      boolean vis[] =new boolean[vtces];
      for (int i = 0; i < vtces; i++) {
         
         if(vis[i] == false) {
            Queue<Pair> q = new ArrayDeque<>();
            q.add(new Pair(i , i+""));
            while(q.size()> 0){
               Pair p =q.remove();
               if(vis[p.v] == false ){
                  vis[p.v] = true;
                  // System.out.println(p.v + "2" + p.psf);
                  for(Edge e : graph[p.v]){
                     if(vis[e.nbr] == false ){
                        q.add(new Pair(e.nbr , p.psf+e.nbr));
                     }
                  }
               }else{
                  System.out.println(true);
                  return ;
               }
            }
         }
      }

      System.out.println(false);
   }
}