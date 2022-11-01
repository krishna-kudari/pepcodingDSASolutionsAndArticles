Perfect Friends
Easy

1. You are given a number n (representing the number of students). Each student will have an id 
     from 0 to n - 1.
2. You are given a number k (representing the number of clubs)
3. In the next k lines, two numbers are given separated by a space. The numbers are ids of 
     students belonging to same club.
4. You have to find in how many ways can we select a pair of students such that both students are 
     from different clubs.

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
0 1
2 3
4 5
5 6
4 6

Sample Output
16


import java.io.*;
import java.util.*;

public class Main {
   public static class Edge{
      int src;
      int nbr;

   }

   public static void main(String[] args) throws Exception {
      BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

      int n = Integer.parseInt(br.readLine());
      int k = Integer.parseInt(br.readLine());
      
      // write your code here
      ArrayList<Edge>[] graph = new ArrayList[n];
      for (int i = 0; i < n; i++) {
         graph[i]= new ArrayList<>();
      }
      for (int i = 0; i < k; i++) {
         String[] p = br.readLine().split(" ");
         int v1 = Integer.parseInt(p[0]);
         int v2 = Integer.parseInt(p[1]);
         
         Edge e =new Edge();
         e.src = v1;
         e.nbr = v2;
         Edge ne = new Edge();
         ne.src = v2;
         ne.nbr = v1;
         graph[v1].add(e);
         graph[v2].add(ne);
      }
      boolean[] visited = new boolean[n];
      ArrayList<ArrayList<Integer>> comps = new ArrayList<ArrayList<Integer>>();
      for(int i=0 ; i< n ;i++){
         if(visited[i] ==false){
            ArrayList<Integer> comp = new ArrayList<Integer>();
            tour(graph , i , n-1 , comp , visited );
            comps.add(comp);
         }
      }
      int cnt=0;
      for(int i=0; i < comps.size() ;i++){
         for( int j= i+1; j< comps.size() ;j++){
            cnt+=comps.get(i).size()*comps.get(j).size();
         }
      }
      System.out.println(cnt);
   }
   public static void tour(ArrayList<Edge>[] graph , int src ,int dest , ArrayList<Integer> comp , boolean[] visited ) {
      visited[src] = true;
      comp.add(src);
      for (Edge e : graph[src]) {
         if(visited[e.nbr] == false) {
            tour(graph , e.nbr , dest , comp ,visited );
         }
      }
   }

}
// import java.io.*;
// import java.util.*;

// public class Main {
//    static class Edge {
//       int src;
//       int nbr;
//       int wt;

//       Edge(int src, int nbr, int wt) {
//          this.src = src;
//          this.nbr = nbr;
//          this.wt = wt;
//       }
//    }

//    public static void main(String[] args) throws Exception {
//       BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

//       int vtces = Integer.parseInt(br.readLine());
//       ArrayList<Edge>[] graph = new ArrayList[vtces];
//       for (int i = 0; i < vtces; i++) {
//          graph[i] = new ArrayList<>();
//       }

//       int edges = Integer.parseInt(br.readLine());
//       for (int i = 0; i < edges; i++) {
//          String[] parts = br.readLine().split(" ");
//          int v1 = Integer.parseInt(parts[0]);
//          int v2 = Integer.parseInt(parts[1]);
//          int wt = Integer.parseInt(parts[2]);
//          graph[v1].add(new Edge(v1, v2, wt));
//          graph[v2].add(new Edge(v2, v1, wt));
//       }

//       ArrayList<ArrayList<Integer>> comps = new ArrayList<>();
      
//       // write your code here
//       boolean [] visited = new boolean[vtces+1];
//       getConnectedComps(graph , comps , visited , 0 , vtces);
//       System.out.println(comps);
//    }

//    public static void getConnectedComps(ArrayList<Edge>[] graph, ArrayList<ArrayList<Integer>> comps , boolean [] visited , int src , int dest) {
//       if(src>= dest ){
//          visited[dest] = true;
         
//          return;
//       }
      
//       visited[src]=true;
//       for (int i=0 ; i<graph[src].size() ; i++) {
//          Edge e= graph[src].get(i);
//          if(visited[e.nbr] == false && e.nbr!=dest) getConnectedComps(graph , comps , visited , e.nbr , dest);
//          else if(i==graph[src].size()-1 && visited[dest] == false){
            
//             ArrayList<Integer> con = new ArrayList<Integer>(); 
//             for( int j=0;j<visited.length ; j++ ) {
//                if(visited[j] == true) {
//                   con.add(j);
//                   visited[j] = false;
//                }
//             }
            
//             comps.add(con);
//             getConnectedComps( graph , comps , visited , e.src+1 , dest) ;
//          }
         
//       }
//    }
// }