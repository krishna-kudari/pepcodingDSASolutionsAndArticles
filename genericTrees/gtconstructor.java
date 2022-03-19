import java.util.*;

public class gtconstructor {
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

  public static Node constructor(int [] array) {
      Node root =null;
      Stack<Node> st=new Stack<>();
      for(int i=0;i<array.length;i++){
        if(array[i]==-1){
            st.pop();
        }else {
            Node t=new Node();
            t.data=array[i];
            if(st.size()==0){
                root=t;
            }else{
                st.peek().children.add(t);
            }
            st.add(t);
        }
      }
      return root;
  }
  public static int size(Node node){
    // write your code here
    int size=0;
    for(Node child:node.children){
      size+=size(child);
    }
    return size+1;
  }
  public static int max(Node node){
      int max=node.data;
      for (Node childNode : node.children) {
          max=Math.max(max(childNode),max);
      }
      return max;
  }
  static int sh;
  public static int height(Node node){
      int height =-1;
       sh=-1;
      
      for (Node childNode : node.children) {
          int ch=height(childNode);
          if(ch>height){
              sh=height;
              height=ch;
          }else if(ch>sh){
              sh=ch;
          }
      }
      
      return height+1;
      
  }
  public static void levelOrder(Node node) {
      Queue<Node> que=new ArrayDeque<>();
        que.add(node);
        while(que.size()>0){
            Node temp=que.remove();
            System.out.print(temp.data+"\t");
            for (Node childNode : temp.children) {
                que.add(childNode);
            }
        }
  }
  static int level;
  public static void levelOrderLinewise(Node node) {
        Queue<Node> mq=new ArrayDeque<>();
        Queue<Node> sq=new ArrayDeque<>();
        System.out.println();
        mq.add(node);
        while(mq.size()>0){
            Node t=mq.remove();
            System.out.print(level+"->"+t.data+"\t");
            for (Node childNode : t.children) {
                sq.add(childNode);                
            }

            if(mq.size()==0){
                mq=sq;
                sq=new ArrayDeque<>();
                System.out.println();
                level++;
            }
        }
  }
  public static void levelOrderArrayList(Node node) {
      ArrayList<Node> ml=new ArrayList<>();
      ArrayList<Node> sl=new ArrayList<>();
      level=0;
      ml.add(node);
      while (ml.size()>0) {
            Node t=ml.remove(0);
            System.out.print(level+"->"+t.data+"\t");
            for(Node child:t.children){
                sl.add(child);
            }  
            if(ml.size()==0){
                ml=sl;
                sl=new ArrayList<>();
                System.out.println();
                level++;
            }        
      }

  }

  public static void main(String[] args) throws Exception {
    try (// BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        // int n = Integer.parseInt(br.readLine());
    Scanner scn = new Scanner(System.in)) {
        int n=scn.nextInt();
        int[] arr = new int[n];
        // String[] values = br.readLine().split(" ");
        
        for (int i = 0; i < n; i++) {
            arr[i]=scn.nextInt();
        }
        // for (int i = 0; i < n; i++) {
        //   arr[i] = Integer.parseInt(values[i]);
        // }

        Node root = constructor(arr);
        int sz = size(root);
        int max=max(root);
        int height=height(root);
        System.out.println(sz+"\t"+max+"\t"+height+"\t"+sh);
        levelOrder(root);
        levelOrderLinewise(root);
        levelOrderArrayList(root);
        // display(root);
    }
  }

}