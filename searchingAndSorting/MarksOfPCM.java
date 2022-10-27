1. You are provided with marks of N students in Physics, Chemistry and Maths.
Perform the following 3 operations: 
a). Sort the students in Ascending order of their Physics marks.
b). Once this is done, sort the students having same marks in Physics in the descending order of their Chemistry marks.
c). Once this is also done, sort the students having same marks in Physics and Chemistry in the ascending order of their Maths marks.
2. Your task is to complete the function customSort() which takes  phy[],  chem[],  math[] . The function sorts the marks in the described order and the final changes should be made in the given arrays only.

Constraints
1 <= N <= 10000

Format
Input
Input is managed for you

Output
Output is managed for you

Example
Sample Input

10
14 1 10 3 4 2 1 10 1 11
5 12 9 6 3 10 2 9 14 10
12 3 6 5 2 10 16 32 10 4

Sample Output
1 14 10
1 12 3
1 2 16
2 10 10
3 6 5
4 3 2
10 9 6
10 9 32
11 10 4
14 5 12 

import java.util.*;
import java.io.*;

public class Main {

    public static class marks implements Comparable<marks>{
        int phy;
        int chem;
        int math;

        marks(int phy , int chem , int math){
            this.phy = phy;
            this.chem = chem;
            this.math = math;
        }

        public int compareTo(marks other){
            if(this.phy == other.phy){
                if(this.chem == other.chem){
                    return this.math - other.math;
                }else{
                    return other.chem - this.chem;
                }
            }else{
                return this.phy - other.phy;
            }
        }
    }
    /*You have to complete the body of customSort function, 
    after sorting final changes should be made in given arrays only. */
    public static void customSort(int[]phy,int[]chem,int[]math) {
        //write your code here
        marks[] arr = new marks[phy.length];
        for(int i = 0 ; i < arr.length ; i++){
            marks m = new marks(phy[i] , chem[i] , math[i]);
            arr[i] = m;
        }

        Arrays.sort(arr);
        for(int i = 0 ; i < arr.length ; i++){
            phy[i] = arr[i].phy;
            chem[i] = arr[i].chem;
            math[i] = arr[i].math;
        }
    }

    public static void main(String[]args) {
        Scanner scn = new Scanner(System.in);

        //input work
        int N = scn.nextInt();

        int[]phy = new int[N];
        int[]chem = new int[N];
        int[]math = new int[N];

        for(int i=0; i < N;i++) {
            phy[i] = scn.nextInt();
        }

        for(int i=0; i < N;i++) {
            chem[i] = scn.nextInt();
        }

        for(int i=0; i < N;i++) {
            math[i] = scn.nextInt();
        }

        customSort(phy,chem,math);

        //output
        for(int i=0; i < N;i++) {
            System.out.println(phy[i] + " " + chem[i] + " " + math[i]);
        }
    }
}