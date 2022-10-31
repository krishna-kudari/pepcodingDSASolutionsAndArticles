Is Balanced Tree
Easy

1. You are given a partially written BinaryTree class.
2. You are required to check if the tree is balanced. A binary tree is balanced if for every node the gap between height's of it's left and right subtree is not more than 1.
3. Input is managed for you. 

Note -> Please refer the question video for clarity.

Constraints
Time complexity must be O(n)
Space should not be more than required for recursion (call-stack)

Format
Input
Input is managed for you.

Output
true if the tree is balanced, false otherwise

Example
Sample Input

21
50 25 12 n n 37 30 n n 51 n n 75 62 60 n n 70 n n n

Sample Output
false

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
  private static class balPair {
    int height;
    boolean isbal;
  }
  public static balPair isBalanced(Node node) {
    if(node==null){
      balPair bp=new balPair();
      bp.height=-1;
      bp.isbal=true;
      return bp;
    }
    balPair lp = isBalanced(node.left);
    if(!lp.isbal){
      return lp;
    }
    balPair rp = isBalanced(node.right);
    if(!rp.isbal){
      return rp;
    }
    int mh=Math.max(lp.height,rp.height)+1;
    
    balPair mp=new balPair();
    mp.height=mh;
    mp.isbal=(Math.abs(lp.height-rp.height)<=1);
    return mp;
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
    balPair p=isBalanced(root);
    System.out.println(p.isbal);
    // write your code here
  }

}