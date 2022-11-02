Shortest Path In Weights
Easy

1. You are given a graph and a source vertex. The vertices represent cities and the edges represent 
    distance in kms.
2. You are required to find the shortest path to each city (in terms of kms) from the source city along 
    with the total distance on path from source to destinations.

Note -> For output, check the sample output and question video.

Constraints
None

Format
Input
Input has been managed for you

Output
Check the sample output

Example
Sample Input

7
9
0 1 10
1 2 10
2 3 10
0 3 40
3 4 2
4 5 3
5 6 3
4 6 8
2 5 5
0

Sample Output
0 via 0 @ 0
1 via 01 @ 10
2 via 012 @ 20
5 via 0125 @ 25
4 via 01254 @ 28
6 via 01256 @ 28
3 via 012543 @ 30


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

      int src = Integer.parseInt(br.readLine());
      // write your code here
      boolean [] visited =new boolean[vtces];
      PriorityQueue<Pair> pq = new PriorityQueue<>();
      pq.add(new Pair(src , src+"" , 0));
      while(pq.size()>0){
         Pair p = pq.remove();
         if(visited[p.v] == true){
            continue;
         }
         visited[p.v] = true;
         System.out.println(p.v + " via " + p.psf + " @ " + p.wsf);
         for (Edge e : graph[p.v]) {
            if(visited[e.nbr] == false) {
               pq.add(new Pair(e.nbr , p.psf+e.nbr , p.wsf + e.wt));
            }
         }
      }
   }
   public static class Pair implements Comparable<Pair> {
      int v ;
      String psf;
      int wsf;
      Pair(int v , String psf , int wsf){
         this.v = v;
         this.psf = psf;
         this.wsf = wsf;
      }
      public int compareTo(Pair o){
         return this.wsf-o.wsf;
      }
      
   }



}