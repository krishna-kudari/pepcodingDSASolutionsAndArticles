Write Priority Queue Using Heap
Easy

1. You are required to complete the code of our Priority Queue Class using the heap data structure. Please watch the question video carefully. The theoretical details of required functionality is explained in detail there. Implement the functions to achieve what is explained in the theoretical discussion in question video.
2. Here is the list of functions that you are supposed to complete:
    2.1. add -> Should accept new data.
    2.2. remove -> Should remove and return smallest value, if available or print 
     "Underflow" otherwise and return -1.
     2.3. peek -> Should return smallest value, if available or print "Underflow" 
     otherwise and return -1.
     2.4. size -> Should return the number of elements available.
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

add 10
add 20
add 30
add 40
peek
add 50
peek
remove
peek
remove
peek
remove
peek
remove
peek
quit

Sample Output
10
10
10
20
20
30
30
40
40
50


import java.io.*;
import java.util.*;

public class Main {

  public static class PriorityQueue {
    ArrayList<Integer> data;

    public PriorityQueue() {
      data = new ArrayList<>();
    }

    public void add(int val) {
      // write your code here
      int i=0,j=data.size()-1;
      while(i<j){
        int m =(i+j)/2;
        if(data.get(m)<val){
          i=m+1;
        }else{
          j=m-1;
        }
      }
      if(data.size()==0){
        data.add(val);
        return;
      }
      if(data.get(i)>val){data.add(i , val);}
      else{data.add(i+1 ,val);} 
      
    }

    public int remove() {
      // write your code here
      if(data.size()==0){ System.out.println("Underflow"); return -1;}
      return data.remove(0);
    }

    public int peek() {
      // write your code here
      if(data.size()==0){ System.out.println("Underflow"); return -1;}
      return data.get(0);
    }

    public int size() {
      // write your code here
      return data.size();
    }
  }

  public static void main(String[] args) throws Exception {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    PriorityQueue qu = new PriorityQueue();

    String str = br.readLine();
    while (str.equals("quit") == false) {
      if (str.startsWith("add")) {
        int val = Integer.parseInt(str.split(" ")[1]);
        qu.add(val);
      } else if (str.startsWith("remove")) {
        int val = qu.remove();
        if (val != -1) {
          System.out.println(val);
        }
      } else if (str.startsWith("peek")) {
        int val = qu.peek();
        if (val != -1) {
          System.out.println(val);
        }
      } else if (str.startsWith("size")) {
        System.out.println(qu.size());
      }
      str = br.readLine();
    }
  }
}

