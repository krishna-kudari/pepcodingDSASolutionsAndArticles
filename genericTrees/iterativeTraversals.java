Iterative Preorder And Postorder Of Generic Tree
Medium

1. You are given a partially written GenericTree class. 2. You are require to complete the body of function IterativePreandPostOrder. The function does not use recursion and prints preorder and postorder of the tree. Both orders are printed in separate lines (preorder first, followed by post order in next line). Elements in an order are separated by space. 3. Input and Output is managed for you.


Constraints
None

Format
Input
Input is managed for you

Output
Elements in preorder separated by a space
Elements in postorder separated by a space

Example
Sample Input

24
10 20 -50 -1 60 -1 -1 30 70 -1 -80 110 -1 -120 -1 -1 90 -1 -1 40 -100 -1 -1 -1

Sample Output
10 20 -50 60 30 70 -80 110 -120 90 40 -100 
-50 60 20 70 110 -120 -80 90 30 -100 40 10

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
  private static class pair{
      int state;
      Node node;
      pair(Node node,int state){
        this.state=state;
        this.node=node;
      }
  }
  public static void IterativePreandPostOrder(Node node) {
    // write your code here
    String pre = "";
    String post = "";
    Stack<pair> st=new Stack<pair>();
    // pair p=new pair(node,-1);
    // st.push(p);
    LinkedList<Node> list=new LinkedList();
    list.addFirst(node);
    while(list.size()>0){
      Node nnode=list.removeFirst();
      pre+=nnode.data+" ";
      int i=0;
      for (Node child : nnode.children) {
        list.add(i,child);
        i++;
      }
    }
    list.addFirst(node);
    Node nulNode=new Node();
    // nulNode.data=null;
    list.addFirst(nulNode);int i=0;
    for (Node child : node.children) {
      
      list.add(i,child);
      i++;
    }
    while ( list.size() > 0 ) {
      node=list.removeFirst();
      if(node==nulNode){
        node=list.removeFirst();
        post+=node.data+" ";
      }
      else if(node.children.size()==0){
        post+=node.data+" ";
      }else{
        list.addFirst(node);
        list.addFirst(nulNode); i=0;
        for (Node child : node.children) {
            list.add(i,child);
            i++;
        }
      }
    }
    // while(st.size()>0){
    //   p=st.peek();
    //   node=st.peek().node;
    //   if(p.state==-1){
    //     p.state++;
    //     pre+=node.data+" ";
    //   }else if(p.state==node.children.size()){
    //     st.pop();
    //     post+=node.data+" ";
    //   }else if(p.state>=0 && p.state<node.children.size()){
    //     st.push(new pair(node.children.get(p.state),-1));
    //     p.state++;

    //   }
    // }
    System.out.println(pre);
    System.out.println(post);
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
    IterativePreandPostOrder(root);
  }

}