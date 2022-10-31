Iterative Pre, Post And Inorder Traversals Of Binary Tree
Easy

1. You are given a partially written BinaryTree class.
2. You are required to complete the body of iterativePrePostInTraversal function. The function is expected to print pre order, in order and post order of the tree in separate lines "(first pre, then in and finally post order)" All elements in an order must be separated by a space.
3. Input is managed for you.

Constraints
None

Format
Input
Input is managed for you

Output
pre order (elements separated by space)
in order (elements separated by space)
post order (elements separated by space)

Example
Sample Input

19
50 25 12 n n 37 30 n n n 75 62 n 70 n n 87 n n

Sample Output
50 25 12 37 30 75 62 70 87 
12 25 30 37 50 62 70 75 87 
12 30 37 25 70 62 87 75 50

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
  private static void iterativePre(Node node){
    Stack<Pair> st = new Stack<Pair>();
    st.push(new Pair(node, 1));
    while(st.size() > 0){
      Pair top = st.peek();
      if(top.state == 1){
        top.state = 2;
        System.out.print(top.node.data+" ");
      }else if(top.state == 2){
        top.state = 3;
        if(top.node.left != null){
          st.push(new Pair(top.node.left, 1));
        }
      }else if(top.state == 3){
        top.state = 4;
        if(top.node.right != null){
          st.push(new Pair(top.node.right , 1));
        }
      }else{
        st.pop();
      }
    }
    System.out.println();
  }
  private static void iterativePost(Node node){
    Stack<Pair> st = new Stack<Pair>();
    st.push(new Pair(node, 1));
    while(st.size() > 0){
      Pair top = st.peek();
      if(top.state == 3){
        top.state = 4;
        System.out.print(top.node.data+" ");
      }else if(top.state == 1){
        top.state = 2;
        if(top.node.left != null){
          st.push(new Pair(top.node.left, 1));
        }
      }else if(top.state == 2){
        top.state = 3;
        if(top.node.right != null){
          st.push(new Pair(top.node.right , 1));
        }
      }else{
        st.pop();
      }
    }
    System.out.println();
  }
  private static void iterativeIn(Node node){
    Stack<Pair> st = new Stack<Pair>();
    st.push(new Pair(node, 1));
    while(st.size() > 0){
      Pair top = st.peek();
      if(top.state == 2){
        top.state = 3;
        System.out.print(top.node.data+" ");
      }else if(top.state == 1){
        top.state = 2;
        if(top.node.left != null){
          st.push(new Pair(top.node.left, 1));
        }
      }else if(top.state == 3){
        top.state = 4;
        if(top.node.right != null){
          st.push(new Pair(top.node.right , 1));
        }
      }else{
        st.pop();
      }
    }
    System.out.println();
  }
  public static void iterativePrePostInTraversal(Node node) {
    // write your code here
    iterativePre(node);
    iterativeIn(node);
    iterativePost(node);
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
    iterativePrePostInTraversal(root);
  }

}