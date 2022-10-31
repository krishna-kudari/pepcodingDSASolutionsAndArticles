Remove Node From Bst
Medium

1. You are given a partially written BST class.
2. You are required to complete the body of remove function. "remove" function is expected to remove a new node with given data to the tree and return the new root.
3. Input and Output is managed for you. 

Note -> Please watch the question video to figure out the algorithm required for deletion. It specifies some requirements of the question as well.

Constraints
None

Format
Input
Input is managed for you

Output
Output is managed for you

Example
Sample Input

15
50 25 12 n n 37 n n 75 62 n n 87 n n
62

Sample Output
25 


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
  static boolean flag=false;
  public static Node max(Node node) {
     if(node==null){
       return null;
     }
     Node max=max(node.right);
     if(max==null){

       return node;
     }
    if(flag==false){
      node.right=max.left;
      flag=true;
    }
     return max;
  }
  public static Node remove(Node node, int data) {
    // write your code here
    if(node.data==data){
      if(node.left==null && node.right==null){
        return null;
      }
      else if(node.left==null){
        return node.right;
      }else if(node.right==null){
        return node.left;
      }
      else{

        Node t= max(node.left);
        Node nn=new Node(t.data,node.left,node.right);
        
        return nn;
      }
    }

    if(node.data>data){
      node.left=remove(node.left,data);
    }else{
      node.right=remove(node.right,data);
    }
    return node;
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

    int data = Integer.parseInt(br.readLine());

    Node root = construct(arr);
    root = remove(root, data);

    display(root);
  }

}