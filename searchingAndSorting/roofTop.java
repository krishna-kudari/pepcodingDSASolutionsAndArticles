Roof Top
Easy

1. You are given an array which represents heights of consecutive buildings.
2. You can move from the roof of a building to the roof of next adjacent building. 
3. You need to find the maximum number of consecutive steps you can put forward such that you gain an increase in altitude with each step.

Constraints
1 <= N <= 10^6
1 <= A[i] <= 10^5

Format
Input
Input is managed for you

Output
Output is managed for you

Example
Sample Input

7
1 4 5 2 3 2 4

Sample Output
2

import java.util.*;

public class Main {

    public static int findMaxSteps(int[]arr) {
        //write your code here
        int ms = 0 , cnt = 0;
        for (int i = 0; i < arr.length-1; i++) {
            if(arr[i] < arr[i+1]){
                cnt++;
                if(cnt > ms)ms = cnt;
            }else{
                cnt = 0;
            }
        }
        return ms;
    }

    public static void main(String[]args) {
        //input work
        Scanner scn = new Scanner(System.in);
        int n = scn.nextInt();

        int[]arr = new int[n];
        for(int i = 0 ; i < n; i++) {
            arr[i] = scn.nextInt();
        }

        int ans = findMaxSteps(arr);
        System.out.println(ans);
    }
}