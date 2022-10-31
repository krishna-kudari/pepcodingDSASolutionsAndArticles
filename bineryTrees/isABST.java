Is A Binary Search Tree
Easy

1. You are given a partially written BinaryTree class.
2. You are required to check if the tree is a Binary Search Tree (BST) as well. In a BST every node has a value greater than all nodes on it's left side and smaller value than all node on it's right side.
3. Input is managed for you. 

Note -> Please refer the question video for clarity.

Constraints
Time complexity must be O(n)
Space should not be more than required for recursion (call-stack)

Format
Input
Input is managed for you.

Output
true if the tree is a BST, false otherwise

Example
Sample Input

15
50 25 12 n n 37 n n 75 62 n n 87 n n

Sample Output
true

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

  private static int min(Node node) {
    if(node==null) {
      return min;
    }
    int lmin=min(node.left);
    int rmin=min(node.right);

    return Math.min(node.data,Math.min(lmin,rmin));
  }
  private static int max(Node node) {
    if(node==null) {
      return max;
    }
    int lmax=max(node.left);
    int rmax=max(node.right);

    return Math.max(node.data,Math.max(lmax,rmax));
  }
  static int min=Integer.MAX_VALUE;
  static int max=Integer.MIN_VALUE;
  public static boolean isBST(Node node) {
    if(node==null){
      return true;
    } 

    if(!isBST(node.left)) {
      return false;
    } 
    if(!isBST(node.right)) {
      return false;
    } 
    
    
    return (max(node.left)<node.data && min(node.right)>node.data);  
  }
  private static class bstPair {
    int mx;
    int mn;
    boolean flag;
    bstPair(int mx,int mn,boolean flag){
      this.mx=mx;
      this.mn=mn;
      this.flag=flag;
    }
  }
  public static bstPair isBST1(Node node) {
    if(node==null){
      return new bstPair(Integer.MIN_VALUE,Integer.MAX_VALUE,true);
    }
    if(node.left==null && node.right==null) {
      return new bstPair(node.data,node.data,true);
    }    
    bstPair lp=isBST1(node.left);
    // if(lp.flag==false){
    //   return new bstPair(max,min,false);
    // }
    bstPair rp=isBST1(node.right);
    // if(rp.flag==false){
    //   return new bstPair(max,min,false);
    // }
    boolean flag=(rp.mn>node.data && lp.mx<node.data && lp.flag && rp.flag);
    // System.out.println(flag);
    int mx=Math.max(lp.mx,Math.max(rp.mx,node.data));
    int mn=Math.min(lp.mn,Math.min(rp.mn,node.data));
    bstPair mp=new bstPair(mx,mn,flag);
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
    
    // write your code here
    // System.out.println(isBST(root)); 
    bstPair p=isBST1(root);
    System.out.println(p.flag); 
  }

}