Diameter Of A Binary Tree
Easy

1. You are given a partially written BinaryTree class.
2. You are required to complete the body of diameter1 function. The function is expected to return the number of edges between two nodes which are farthest from each other in terms of edges.
3. Input and Output is managed for you.

Constraints
None

Format
Input
Input is managed for you.

Output
Output is managed for you.

Example
Sample Input

19
50 25 12 n n 37 30 n n n 75 62 n 70 n n 87 n n

Sample Output
6


import java.io.*;
import java.util.*;

public class Main {
  public static class Node {
    int data;
    Node left;
    Node right;

    Node(int data, Node left, Node right) {
      this.data = data;
      this.left = left;
      this.right = right;
    }
  }

  public static class Pair {
    Node node;
    int state;

    Pair(Node node, int state) {
      this.node = node;
      this.state = state;
    }
  }

  public static Node construct(Integer[] arr) {
    Node root = new Node(arr[0], null, null);
    Pair rtp = new Pair(root, 1);

    Stack<Pair> st = new Stack<>();
    st.push(rtp);

    int idx = 0;
    while (st.size() > 0) {
      Pair top = st.peek();
      if (top.state == 1) {
        idx++;
        if (arr[idx] != null) {
          top.node.left = new Node(arr[idx], null, null);
          Pair lp = new Pair(top.node.left, 1);
          st.push(lp);
        } else {
          top.node.left = null;
        }

        top.state++;
      } else if (top.state == 2) {
        idx++;
        if (arr[idx] != null) {
          top.node.right = new Node(arr[idx], null, null);
          Pair rp = new Pair(top.node.right, 1);
          st.push(rp);
        } else {
          top.node.right = null;
        }

        top.state++;
      } else {
        st.pop();
      }
    }

    return root;
  }

  public static void display(Node node) {
    if (node == null) {
      return;
    }

    String str = "";
    str += node.left == null ? "." : node.left.data + "";
    str += " <- " + node.data + " -> ";
    str += node.right == null ? "." : node.right.data + "";
    System.out.println(str);

    display(node.left);
    display(node.right);
  }

  public static int height(Node node) {
    if (node == null) {
      return -1;
    }

    int lh = height(node.left);
    int rh = height(node.right);

    int th = Math.max(lh, rh) + 1;
    return th;
  }
  static int dia=0;
  public static int diameter1(Node node) {
    // write your code here
    int dch=-1;
    int sdch=-1;
    if(node.left!=null){
      int ch=diameter1(node.left);
      if(ch>dch){
        sdch=dch;
        dch=ch;
      }
      else if(ch>sdch){
        sdch=ch;
      }
    }
    if(node.right!=null){
      int ch=diameter1(node.right);
      if(ch>dch){
        sdch=dch;
        dch=ch;
      }
      else if(ch>sdch){
        sdch=ch;
      }
    }
    dia=Math.max(dch+sdch+2,dia);
    return dch+1;
  }
  public static int diam(Node node) {
    if(node==null ){
      return 0;
    }
    int lh=height(node.left);
    int rh=height(node.right);
    int md=lh+rh+2;int ld=0,rd=0;
    if(lh-rh>=2){
      ld=diam(node.left);
    }
    if(rh-lh>=2){
      rd=diam(node.right);
    }
    
    
    return Math.max(md,Math.max(ld,rd));    
  }
  private static class diaPair {
    int height;
    int dia;
    diaPair(int height,int dia){
      this.height=height;
      this.dia=dia;
    }
  }
  public static diaPair diameter2(Node node) {
    if(node==null){
      return new diaPair(-1,0);
    }
    diaPair lp=diameter2(node.left);
    diaPair rp=diameter2(node.right);
    
    int mh=Math.max(lp.height,rp.height)+1;
    int md=Math.max(lp.height+rp.height+2,Math.max(lp.dia,rp.dia));
    return new diaPair(mh,md);
    
  }

  public static void main(String[] args) throws Exception {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    int n = Integer.parseInt(br.readLine());
    Integer[] arr = new Integer[n];
    String[] values = br.readLine().split(" ");
    for (int i = 0; i < n; i++) {
      if (values[i].equals("n") == false) {
        arr[i] = Integer.parseInt(values[i]);
      } else {
        arr[i] = null;
      }
    }

    Node root = construct(arr);

    int diameter = 0;
    // diameter = diameter1(root);
    // diameter = diam(root);
    diameter = diameter2(root).dia;
    System.out.println(diameter);
  }

}