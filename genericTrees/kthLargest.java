Kth Largest Element In Tree
Medium

1. You are given a partially written GenericTree class.
2. You are given a number k. You are required to find and print the kth largest value in the tree.
3. Input and Output is managed for you.

Constraints
None

Format
Input
Input is managed for you

Output
Output is managed for you

Example
Sample Input

24
10 20 -50 -1 60 -1 -1 30 70 -1 -80 110 -1 -120 -1 -1 90 -1 -1 40 -100 -1 -1 -1
8

Sample Output
10

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

  
  static int ceil;
  static int floor;
  private static void ceilAndFloor(Node node, int data) {
    // Write your code here
    if(node.data>data){
        ceil=Math.min(ceil,node.data);

    }
    else if(node.data<data){
        floor=Math.max(floor,node.data);
    }

    for (Node child : node.children) {
        ceilAndFloor(child,data);
    }
  }
  static int ans=Integer.MAX_VALUE;
  public static int kthlarge(Node node,int k) {
     

      while ( k>0 ) {
          ceilAndFloor(node,ans);
          ans=floor;
          ceil = Integer.MAX_VALUE;
          floor = Integer.MIN_VALUE;
          // System.out.println(ans);
          k--;
      }
      return ans;
  }

  public static void main(String[] args) throws Exception {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    int n = Integer.parseInt(br.readLine());
    int[] arr = new int[n];
    String[] values = br.readLine().split(" ");
    for (int i = 0; i < n; i++) {
      arr[i] = Integer.parseInt(values[i]);
    }

    int data = Integer.parseInt(br.readLine());

    Node root = construct(arr);
    ceil = Integer.MAX_VALUE;
    floor = Integer.MIN_VALUE;
    // ceilAndFloor(root, data);
    System.out.println( kthlarge(root,data));
    // System.out.println("CEIL = " + ceil);
    // System.out.println("FLOOR = " + floor);
  }

}