Is Graph Bipartite
Easy

1. You are given a graph.
2. You are required to find and print if the graph is bipartite

Note -> A graph is called bipartite if it is possible to split its vertices in two sets of mutually 
               exclusive and exhaustive vertices such that all edges are across sets.

Constraints
None

Format
Input
Input has been managed for you

Output
true if the graph is bipartite, false otherwise

Example
Sample Input

7
8
0 1 10
1 2 10
2 3 10
0 3 10
3 4 10
4 5 10
5 6 10
4 6 10

Sample Output
false


import java.io.*;
import java.util.*;

public class Main {
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
      int [] visited = new int [vtces];
      Arrays.fill(visited , -1);
      for(int i=0; i < vtces ;i++){
         if(visited[i] == -1){
            boolean cd = detectBipartate(graph , i , visited);
            if(cd == false){
               System.out.println(false);
               return;
            }
         }
      }

      System.out.println(true);
      return;
   }
   public static boolean detectBipartate(ArrayList<Edge>[] graph , int src , int[] visited){
   ArrayDeque<Pair> q= new ArrayDeque<>();
   q.add(new Pair(src , src+"" , 0));
   while(q.size()>0){
      Pair p = q.removeFirst();
      if(visited[p.v] != -1){
         //cycle detected
         if((visited[p.v] - p.lvl)%2 != 0){
            return false;
         }
      }else{
         //mark*
         visited[p.v]  = p.lvl;
         // add nbr
         for (Edge e : graph[p.v]) {
            if(visited[e.nbr] == -1){
               q.add(new Pair(e.nbr , p.psf+e.nbr , p.lvl+1));
            }
         }
      }
   }
   return true;
}

public static class Pair{
   int v; 
   String psf;
   int lvl;
   Pair(int v , String psf , int lvl){
      this.v = v;
      this.psf = psf;
      this.lvl = lvl;
   }
   Pair(){}
}
}