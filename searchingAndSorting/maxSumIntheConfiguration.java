Max Sum In The Configuration
Medium

1. Given an array, you have to find the max sum of i*A[i] where A[i] is the element at index i in the array. 
2. The only operation allowed is to rotate(clock-wise or counter clock-wise) the array any number of times.

Constraints
1 <= N <= 10^6
1 <= arr[i] <= 10^5

Format
Input
Input is managed for you

Output
Output is managed for you

Example
Sample Input

4
8 3 1 2

Sample Output
29


import java.util.*;

public class Main {

    public static int maximise(int[]A) {
        //write your code here
        int ms = 0 , s1 = 0 , sum = 0 , n = A.length;
	    for(int i = 0 ; i < n ; i++){
	        sum += A[i];
	        s1 += A[i]*i;
	    }
        ms = s1 ;
	    for(int i = 1 ; i < n ; i++){
	        s1 = s1 + sum - (A[n-i] * n);
	        if(s1> ms)ms = s1;
	    }
	    return (int)ms;
    }

    public static void main(String[]args) {
        //input work
        Scanner scn = new Scanner(System.in);
        int n = scn.nextInt();

        int[]arr = new int[n];
        for(int i = 0 ; i < n; i++) {
            arr[i] = scn.nextInt();
        }

        int ans = maximise(arr);
        System.out.println(ans);
    }
}