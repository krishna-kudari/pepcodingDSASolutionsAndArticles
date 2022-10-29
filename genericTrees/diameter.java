Diameter Of Generic Tree
Medium

1. You are given a partially written GenericTree class.
2. You are required to find and print the diameter of tree. THe diameter is defined as maximum number of edges between any two nodes in the tree. Check the question video for clarity.
3. Input is managed for you.

Constraints
None

Format
Input
Input is managed for you

Output
diameter

Example
Sample Input

20
10 20 -50 -1 60 -1 -1 30 -70 -1 80 -1 90 -1 -1 40 -100 -1 -1 -1

Sample Output
4

import java.io.*;
import java.util.*;

public class Main {
  private static class Node {
    int data;
    ArrayList<Node> children = new ArrayList<>();
  }

  public static void display(Node node) {
    String str = node.data + " -> ";
    for (Node child : node.children) {
      str += child.data + ", ";
    }
    str += ".";
    System.out.println(str);

    for (Node child : node.children) {
      display(child);
    }
  }

  public static Node construct(int[] arr) {
    Node root = null;

    Stack<Node> st = new Stack<>();
    for (int i = 0; i < arr.length; i++) {
      if (arr[i] == -1) {
        st.pop();
      } else {
        Node t = new Node();
        t.data = arr[i];

        if (st.size() > 0) {
          st.peek().children.add(t);
        } else {
          root = t;
        }

        st.push(t);
      }
    }

    return root;
  }
  public static int height(Node node) {
    
    
    int height=-1;
    for (Node child : node.children) {
      height=Math.max(height(child),height);
      
    }
    return height+1;
  }
  static int md = 0;
  public static int diameter(Node node) {
    int size=node.children.size();
    int mh=0,smh=0;
    if(size>=2){
      for (int i = 0; i < size; i++) {
        int h=height(node.children.get(i));

        if(h>=mh){
          smh=mh;
          mh=h;
        }else if(h>smh){
          smh=h;
        }
        
      }
      int dd=mh+smh+2;
      for (Node child : node.children) {
        int d =diameter(child);
        d=Math.max(d,dd);
        md=Math.max(md,d);
      }
       return md;
    }else if(size==1){
      for (int i = 0; i < size; i++) {
        int h=height(node.children.get(i));

        if(h>=mh){
          smh=mh;
          mh=h;
        }else if(h>smh){
          smh=h;
        }

      }
      int dd=mh+smh+2;
      for (Node child : node.children) {
        int d =diameter(child);
        d=Math.max(d,dd);
        md=Math.max(md,d);
      }
       return md;
    }

    return 0;
    
  }

  public static void main(String[] args) throws Exception {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    int n = Integer.parseInt(br.readLine());
    int[] arr = new int[n];
    String[] values = br.readLine().split(" ");
    for (int i = 0; i < n; i++) {
      arr[i] = Integer.parseInt(values[i]);
    }

    Node root = construct(arr);
    // write your code here
    // System.out.println(height(root,0));
    System.out.println(diameter(root));  
  }

}