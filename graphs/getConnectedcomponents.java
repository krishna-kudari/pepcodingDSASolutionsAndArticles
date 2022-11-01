Get Connected Components Of A Graph
Easy

1. You are given a graph. 2. You are required to find and print all connected components of the graph.


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
5
0 1 10
2 3 10
4 5 10
5 6 10
4 6 10

Sample Output
[[0, 1], [2, 3], [4, 5, 6]]



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

      ArrayList<ArrayList<Integer>> comps = new ArrayList<>();
      
      // write your code here
      boolean [] visited = new boolean[vtces+1];
      getConnectedComps(graph , comps , visited , 0 , vtces);
      System.out.println(comps);
   }

   public static void getConnectedComps(ArrayList<Edge>[] graph, ArrayList<ArrayList<Integer>> comps , boolean [] visited , int src , int dest) {
      if(src>= dest ){
         visited[dest] = true;
         
         return;
      }
      
      visited[src]=true;
      for (int i=0 ; i<graph[src].size() ; i++) {
         Edge e= graph[src].get(i);
         if(visited[e.nbr] == false && e.nbr!=dest) getConnectedComps(graph , comps , visited , e.nbr , dest);
         else if(i==graph[src].size()-1 && visited[dest] == false){
            
            ArrayList<Integer> con = new ArrayList<Integer>(); 
            for( int j=0;j<visited.length ; j++ ) {
               if(visited[j] == true) {
                  con.add(j);
                  visited[j] = false;
               }
            }
            
            comps.add(con);
            getConnectedComps( graph , comps , visited , e.src+1 , dest) ;
         }
         
      }
   }
}