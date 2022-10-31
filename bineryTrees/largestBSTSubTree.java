Largest Bst Subtree
Medium

1. You are given a partially written BinaryTree class.
2. You are required to find the root of largest sub-tree which is a BST. Also, find the number of nodes in that sub-tree.
3. Input is managed for you. 

Note -> Please refer the question video for clarity.

Constraints
Time complexity must be O(n)
Space should not be more than required for recursion (call-stack)

Format
Input
Input is managed for you.

Output
@

Example
Sample Input

15
50 25 12 n n 37 n n 75 62 n n 87 n n

Sample Output
50@7


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
  private static class bstPair {
    int mx;
    int mn;
    boolean flag;
    int size;
    int data;
    bstPair(int mx,int mn,boolean flag,int size,int data){
      this.mx=mx;
      this.mn=mn;
      this.flag=flag;
      this.size=size;
      this.data=data;
    }
  }
  public static bstPair isBST1(Node node) {
    if(node==null){
      return new bstPair(Integer.MIN_VALUE,Integer.MAX_VALUE,true,0,0);
    }
    if(node.left==null && node.right==null) {
      return new bstPair(node.data,node.data,true,1,node.data);
    }    

    bstPair lp=isBST1(node.left);
    // if(lp.flag==false){
    //   return lp;
    // }
    bstPair rp=isBST1(node.right);
    // if(rp.flag==false){
    //   return rp;
    // }
    boolean flag=(rp.mn>=node.data && lp.mx<=node.data && lp.flag && rp.flag);
    // System.out.println(flag);
    int mx=Math.max(lp.mx,Math.max(rp.mx,node.data));
    int mn=Math.min(lp.mn,Math.min(rp.mn,node.data));
    int size=lp.size+rp.size+1;
    bstPair mp=new bstPair(mx,mn,flag,size,node.data);
    if(flag==false){
      if(lp.size>rp.size){
        mp.data=lp.data;
        mp.size=lp.size;
      }else {
        mp.data=rp.data;
        mp.size=rp.size;
      }
    }
    
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
    bstPair p=isBST1(root);
    System.out.println(p.data+"@"+p.size);
    // write your code here
  }

}