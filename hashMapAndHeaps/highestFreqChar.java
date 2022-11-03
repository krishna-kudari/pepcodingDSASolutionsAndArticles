Highest Frequency Character
Easy

1. You are given a string str.
2. You are required to find the character with maximum frequency.

Constraints
0 < str.length() <= 100
There will be a single character with highest frequency

Format
Input
A string str

Output
The character with highest frequency

Example
Sample Input

zmszeqxllzvheqwrofgcuntypejcxovtaqbnqyqlmrwitc

Sample Output
q

import java.io.*;
import java.util.*;

public class Main {

    public static void main(String[] args) throws Exception {
        // write your code here
        HashMap<String , Integer> freq = new HashMap<>();
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String seq = br.readLine();
        // System.out.println(seq);
        char hf = seq.charAt(0);
        int mxfreq = 1;
        for( int i=0 ; i< seq.length(); i++){
            char c = seq.charAt(i);
            if(freq.containsKey(c+"")){
                int val = freq.get(c+"");
                val++;
                if(val>mxfreq){
                    mxfreq = val;
                    hf = c;
                }
                freq.put(c+"", val);
            }else{
                freq.put(""+c, 1);
            }
        }
        System.out.println(hf);
    }

}