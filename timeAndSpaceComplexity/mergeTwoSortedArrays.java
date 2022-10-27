Merge Two Sorted Arrays
Easy

1. You are given two sorted arrays(a,b) of integers.
2. You have to merge them and form one sorted array.
3. You have to do it in linear time complexity.

Constraints
1 <= N <= 10^8
-10^9 <= a[i],b[i] <= 10^9

Format
Input
An Integer n 
a1
a2..n integers
An integer m
b1
b2..m integers

Output
Check the sample output and question video.

Example
Sample Input

4
-2 
5 
9 
11
3
4 
6 
8

Sample Output
-2
4
5
6
8
9
11

import java.io.*;
import java.util.*;

public class Main {

  public static int[] mergeTwoSortedArrays(int[] a, int[] b){
    //write your code here
    int n1=a.length,n2=b.length;
    int i=0,j=0,k=0;
    int arr[]=new int[n1+n2];
    while(j<n2 && k<n1){
      if(a[k]<b[j]){
        arr[i]=a[k];
        k++;
      }else{
        arr[i]=b[j];
        j++;
      }
      i++;
    }while(k<n1){
      arr[i]=a[k];
      i++;k++;
    }while(j<n2){
      arr[i]=b[j];
      i++;j++;
    }
    

    return arr;
  }

  public static void print(int[] arr){
    for(int i = 0 ; i < arr.length; i++){
      System.out.println(arr[i]);
    }
  }
  public static void main(String[] args){
    Scanner scn = new Scanner(System.in);
    int n = scn.nextInt();
    int[] a = new int[n];
    for(int i = 0 ; i < n; i++){
      a[i] = scn.nextInt();
    }
    int m = scn.nextInt();
    int[] b = new int[m];
    for(int i = 0 ; i < m; i++){
      b[i] = scn.nextInt();
    }
    int[] mergedArray = mergeTwoSortedArrays(a,b);
    print(mergedArray);
  }

}

1. PROBLEM DISCUSSION :
1• You are given two sorted arrays(a,b) of integers. 2• You have to merge them and form one sorted array. 3• You have to do it in linear time complexity.


For example, let’s take two arrays : a : 2 5 12 18 20 b : 7 9 11 15 25 28 30 35 Then the sorted array that should be our answer is : 2 5 7 9 11 12 15 18 20 25 28 30 35 We can come up with a naive approach of just appending the second array after the first array and sort the new array. But in this case ,if the first array has a length ‘n1’ and the second array has a length ‘n2’ then for appending we have to perform n2 operations and for sorting, it takes at least ‘nlogn’. So this is not a very good approach. And in the question also, it is given that we have to solve this problem in linear time. Is there anything given in this question that we can take advantage of? Yes, in the question it is given that the arrays are already sorted. We can use this thing as our advantage and it will help optimize our approach. Let’s discuss the optimized approach to solve this problem.


2. APPROACH :
To solve this problem in linear time, we'll preserve two pointers that point to the smallest integer in both arrays, i.e. the first element. This is because the individual arrays are already sorted so the smallest integer is always present at the start. We'll choose the one that's smaller in comparison and add it to a new array and move the pointer to the next position in that array from where the element is selected. So let's take an example: Let’s suppose the first array is arr1[ ] = 2 5 12 18 20 And the second array is arr2[ ] = 7 9 11 15 25 28 30 35 Now, the number of elements in the first array i.e. arr1 is 5 and the number of elements in the second array i.e. arr2 is 8. We have to take a resultant array to store the sorted elements. The size of the resultant array will be 5 + 8 = 13, because it will store all the elements of arr1 and arr2. Let's take three-pointers,


● i : point to the current element of the first array i.e.arr1. ● j : point to the current element of the second array i.e.arr2. ● k : point to the currently merged array position i.e. the current position of the resultant array.


According to our example, we have a pointer ‘i’ pointing to 2(first element of arr1) and ‘j’ pointing to 7(first element of arr2). Now since 2 < 7, so final[k] = 2, and since we consider 2 we have to increment ‘i’ and also k. k will always be incremented. So initially i and j point to the 0th index of both the arrays and k points to the 0th index of the resultant array i.e. ‘final’. We have to increment the pointer of that array from where the element is selected to be inserted in the resultant array. The pointer of the final array i.e. k always increments because an element is always added to the final array.




Next, we compare 5 and 7. Again 5 is smaller than 7 (5 < 7) so final[k] = final[1] = 5. And i and k will be incremented.




Now, i is pointing to the 2nd index of arr1 i.e. at 12 and j is pointing to the 0th index of arr2 i.e. at 7. This time between 12 and 7, 7 is smaller, so final[k] = final[2] = 7. And since an element of arr2 was chosen we have to increment j. K increments always as we mentioned before.




Now, between 12 and 9, 9 is smaller. So final[k] = final[3] = 9. And since an element of arr2 was chosen, we have to increment the respective pointer of arr2 i.e. j. k increments as always.




We can see that by making greedy decisions at each point of choosing the smaller value, we are progressively travelling across the arrays and generating a new merged array that is likewise in sorted order. In the same way, we have to traverse the array until one of the two arrays gets traversed completely. When one of the arrays is completely traversed, we can simply add the rest of the elements of the other array as it is to the resultant array because those elements are already sorted. So try to continue this process until all the elements of both the arrays are added to the resultant array. In the end, you’ll see that when 20 is added to the resultant array, all the elements of the first array are added, so we can simply add the rest of the elements of the second array to the resultant array as they are already sorted.




In this way, we can get the resultant array which is sorted in linear time.


3. CODE :
Note : Now the approach to solve this problem is clear to you. So before reading the Code, I recommend that you must try to come up with the solution on your own. Now, hoping that you have tried by yourself, here is the Java code.


import java.io.*;
 
import java.util.*;
 
public class Main {
 
  public static int[] mergeTwoSortedArrays(int[] a, int[] b) {
    // write your code here
    int alen = a.length;
    int blen = b.length;
 
    int[] res = new int[alen + blen];
 
    int i = 0;
    int j = 0;
    int k = 0;
 
    // when there are elements in both the array
    while (i < alen && j < blen) {
      if (a[i] < b[j]) {
        res[k] = a[i];
        i++;
      } else {
        res[k] = b[j];
        j++;
      }
      k++; // k always increment
    }
 
 
    while (i < alen) {
      res[k] = a[i];
      i++;
      k++;
    }
 
    while (j < blen) {
      res[k] = b[j];
      j++;
      k++;
    }
 
    return res;
  }
 
  public static void print(int[] arr) {
    for (int i = 0; i < arr.length; i++) {
      System.out.println(arr[i]);
    }
  }
 
  public static void main(String[] args) {
    Scanner scn = new Scanner(System.in);
    int n = scn.nextInt();
    int[] a = new int[n];
    for (int i = 0; i < n; i++) {
      a[i] = scn.nextInt();
    }
    int m = scn.nextInt();
    int[] b = new int[m];
    for (int i = 0; i < m; i++) {
      b[i] = scn.nextInt();
    }
    int[] mergedArray = mergeTwoSortedArrays(a, b);
    print(mergedArray);
  }
 
}

In the code, you can see that there are three while loops. When the first while loop completes, this means that one of a[] or b[] has been fully iterated. However, some elements of the other one remain. As a result, we use two single loops to insert the remaining items as it is at the end of the resultant array because they are already sorted.


For more clarity of the question, watch the question video

Play Video
4. ANALYSIS :
Time Complexity :

The time complexity of this approach is O(n) where n = a.length + b.length The pointer ‘i’ moves from 0 to a.length and j moves from 0 to b.length only once. So the total number of iterations is equal to a.length + b.length(i.e. the total number of elements in both the arrays). If you're still not convinced, consider k. The pointer k only loops through the resultant array once. As a result, we can conclude that the time complexity is a.length + b.length, i.e. linear O(n).


Space Complexity :

The merged array is actually stored in a temporary array of size a.length + b.length. As a result, the space complexity of our solution is O(n), or linear.


Hope that you liked the article on “Merge Two Sorted Arrays”. Subscribe to Pepcoding’s youtube channel for more such amazing content on Data Structures & Algorithms and follow the resources available for all students in the resources section of Pepcoding’s website or in the content section on NADOS. You can suggest any improvements to the article on our telegram Channel, in the Nados doubt section or on the Youtube channel’s comment section.