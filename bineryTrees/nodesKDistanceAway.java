Print Nodes K Distance Away
Easy

1. You are given a partially written BinaryTree class.
2. You are given a value data and a value k.
3. You are required to complete the body of printKNodesFar function. The function is expected to print all nodes which are k distance away in any direction from node with value equal to data.
4. Input is managed for you.

Constraints
None

Format
Input
Input is managed for you

Output
All nodes which are k distance away in any direction from node with value equal to data, each in a separate line

Example
Sample Input

19
50 25 12 n n 37 30 n n n 75 62 n 70 n n 87 n n
37
2

Sample Output
12
50

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
  private static Node find(Node node,int data){
    if(node.data==data){
      return node;
    }
    if(node.left!=null){
      Node n=find(node.left,data);
      if(n!=null){
        return n;
      }
    }
    if(node.right!=null){
      Node n=find(node.right,data);
      if(n!=null){
        return n;
      }
    }
    return null;
  }
  private static void printKlevelsDown(Node node, int k,Node rtrn){
    if(node==null || node==rtrn){
      return ;
    }
    // if(k<0){
    //   return;
    // }
    if(k==0){
      System.out.println(node.data);
      return;
    }
    printKlevelsDown(node.left,k-1,rtrn);
    printKlevelsDown(node.right,k-1,rtrn);
  }
  private static ArrayList<Node> nodeToRootPath(Node node, int data){
    // write your code here
    if(node.data==data){
      ArrayList<Node> res = new ArrayList<>();
      res.add(node);
      return res;
    }
    ArrayList<Node> res = new ArrayList<>();
    if(node.left!=null){
      res=nodeToRootPath(node.left, data);
      if(res.size()>0){
        res.add(node);
        return res;
      }
    }
    if(node.right!=null){
      res=nodeToRootPath(node.right, data);
      if(res.size()>0){
        res.add(node);
        return res;
      }
    }
    return res;
  }
  public static void printKNodesFar(Node node, int data, int k) {
    // write your code here
    // Node tar=find(node,data);
    // System.out.println(tar.data);
    ArrayList<Node> rtp = nodeToRootPath(node,data);
    // printKlevelsDown(rtp.get(0),k,null);
    // System.out.println();
    for (int i = 0; i <= k && i<rtp.size(); i++) {
        printKlevelsDown(rtp.get(i),k-i,i==0?null:rtp.get(i-1)); 
        // System.out.println();
          
    }
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
    int k = Integer.parseInt(br.readLine());

    Node root = construct(arr);
    printKNodesFar(root, data, k);
  }

}