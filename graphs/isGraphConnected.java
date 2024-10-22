Is Graph Connected
Easy

1. You are given a graph.
2. You are required to find and print if the graph is connected (there is a path from 
     every vertex to every other).

Constraints
None

Format
Input
Input has been managed for you

Output
true if the graph is connected, false otherwise

Example
Sample Input

7
5
0 1 10
2 3 10
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
      boolean[] visited=new boolean[vtces];
      ArrayList<ArrayList<Integer>> comps = new ArrayList<ArrayList<Integer>>();
      for (int i = 0; i < vtces; i++) {
         if(visited[i]==false){
            ArrayList<Integer> comp = new ArrayList<Integer>();
            drawtree(graph , i , comp , visited);
            comps.add(comp);
            if(comps.size()>1){
               System.out.println(false);
               return ;
            }
         }
      }
      System.out.println(true);
   }


   public static void drawtree(ArrayList<Edge>[] graph , int src , ArrayList<Integer> comp ,boolean[] visited) {
      visited[src] = true;
      comp.add(src);

      for( Edge e: graph[src]){
         if(visited[e.nbr] == false){
            drawtree(graph , e.nbr , comp , visited);
         }
      }      
   }
}