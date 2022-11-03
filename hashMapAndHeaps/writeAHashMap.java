Write Hashmap
Easy

1. You are required to complete the code of our Hashmap class. Please watch the question video carefully. The theoretical details of required functionality is explained in detail there. Implement the functions to achieve what is explained in the theoretical discussion in question video.
2. Input and Output is managed for you.

Constraints
None

Format
Input
Input is managed for you

Output
Output is managed for you

Example
Sample Input

put India 135
put Aus 5
put Canada 3
display
get China
remove Aus
get Aus
containsKey US
put US 10
put UK 20
remove US
containsKey US
put Pak 80
put China 200
display
put Utopia 0
display
put Nigeria 3
display
put India 138
display
put Sweden 1
display
put finland 20
display
quit

Sample Output
Display Begins
Bucket0 .
Bucket1 .
Bucket2 Canada@3 .
Bucket3 India@135 Aus@5 .
Display Ends
null
5
null
false
10
false
Display Begins
Bucket0 .
Bucket1 .
Bucket2 Canada@3 UK@20 Pak@80 .
Bucket3 India@135 China@200 .
Display Ends
Display Begins
Bucket0 Utopia@0 .
Bucket1 .
Bucket2 Canada@3 UK@20 Pak@80 .
Bucket3 India@135 China@200 .
Display Ends
Display Begins
Bucket0 Utopia@0 .
Bucket1 .
Bucket2 Canada@3 UK@20 Pak@80 .
Bucket3 India@135 China@200 Nigeria@3 .
Display Ends
Display Begins
Bucket0 Utopia@0 .
Bucket1 .
Bucket2 Canada@3 UK@20 Pak@80 .
Bucket3 India@138 China@200 Nigeria@3 .
Display Ends
Display Begins
Bucket0 Utopia@0 Sweden@1 .
Bucket1 .
Bucket2 Canada@3 UK@20 Pak@80 .
Bucket3 India@138 China@200 Nigeria@3 .
Display Ends
Display Begins
Bucket0 Utopia@0 .
Bucket1 .
Bucket2 Pak@80 finland@20 .
Bucket3 .
Bucket4 Sweden@1 .
Bucket5 .
Bucket6 Canada@3 UK@20 .
Bucket7 India@138 China@200 Nigeria@3 .
Display Ends


import java.io.*;
import java.util.*;

public class Main {

  public static class HashMap<K, V> {
    private class HMNode {
      K key;
      V value;

      HMNode(K key, V value) {
        this.key = key;
        this.value = value;
      }
    }

    private int size; // n
    private LinkedList<HMNode>[] buckets; // N = buckets.length

    public HashMap() {
      initbuckets(4);
      size = 0;
    }

    private void initbuckets(int N) {
      buckets = new LinkedList[N];
      for (int bi = 0; bi < buckets.length; bi++) {
        buckets[bi] = new LinkedList<>();
      }
    }
    private void rehash() throws Exception {
        LinkedList<HMNode>[] oba = buckets;

        initbuckets(oba.length*2);
        size = 0 ;
        for(int i=0 ; i< oba.length ; i++){
            for (HMNode node : oba[i]) {
                put(node.key , node.value);
            }
        }
    }
    private int hashfn(K key) {
        int hc = key.hashCode();
        return Math.abs(hc)%buckets.length;
    }
    private int getIndexwithinBucket(K key , int bi){
        int di = 0 ; 
        for (HMNode node : buckets[bi]) {
            if(node.key.equals(key)){
                return di;
            }
            di++;
        }
        return -1;
    }
    public void put(K key, V value) throws Exception {
      // write your code here
      int bi = hashfn(key);
      int di = getIndexwithinBucket(key , bi);
      if(di != -1){
          HMNode node  = buckets[bi].get(di);
          node.value = value;
      }else{
          HMNode node = new HMNode(key , value);
          buckets[bi].add(node);
          size++;
      }

      double lamda = (size*1.0) / buckets.length;
      if(lamda > 2.0){
          rehash();
      }
    }

    public V get(K key) throws Exception {
      // write your code here
      int bi = hashfn(key);
      int di = getIndexwithinBucket(key , bi);
      if(di != -1){
          HMNode node  = buckets[bi].get(di);
          return node.value;
      }
      else{
          return null;
      }
    }

    public boolean containsKey(K key) {
      // write your code here
      int bi = hashfn(key );
      int di = getIndexwithinBucket(key , bi );
      if(di != -1){
          return true;
      }else{
          return false; 
      }
    }

    public V remove(K key) throws Exception {
      // write your code here
      int bi = hashfn(key);
      int di = getIndexwithinBucket(key , bi);
      if(di != -1){
          HMNode node=  buckets[bi].remove(di);
          size--;
          return node.value;
      }else {
          return null;
      }
    }

    public ArrayList<K> keyset() throws Exception {
      // write your code here
      ArrayList<K> keys = new ArrayList<K>();
      for(int bi = 0 ; bi < buckets.length ; bi++){
          for (HMNode node : buckets[bi]) {
              keys.add(node.key);
          }
      }
      return  keys;
    }

    public int size() {
      // write your code here
      return size;
    }

   public void display() {
      System.out.println("Display Begins");
      for (int bi = 0; bi < buckets.length; bi++) {
        System.out.print("Bucket" + bi + " ");
        for (HMNode node : buckets[bi]) {
          System.out.print( node.key + "@" + node.value + " ");
        }
        System.out.println(".");
      }
      System.out.println("Display Ends");
  }
}

  public static void main(String[] args) throws Exception {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    HashMap<String, Integer> map = new HashMap();

    String str = br.readLine();
    while (str.equals("quit") == false) {
      if (str.startsWith("put")) {
        String[] parts = str.split(" ");
        String key = parts[1];
        Integer val = Integer.parseInt(parts[2]);
        map.put(key, val);
      } else if (str.startsWith("get")) {
        String[] parts = str.split(" ");
        String key = parts[1];
        System.out.println(map.get(key));
      } else if (str.startsWith("containsKey")) {
        String[] parts = str.split(" ");
        String key = parts[1];
        System.out.println(map.containsKey(key));
      } else if (str.startsWith("remove")) {
        String[] parts = str.split(" ");
        String key = parts[1];
        System.out.println(map.remove(key));
      } else if (str.startsWith("size")) {
        System.out.println(map.size());
      } else if (str.startsWith("keyset")) {
        System.out.println(map.keyset());
      } else if (str.startsWith("display")) {
        map.display();
      }
      str = br.readLine();
    }
  }
}