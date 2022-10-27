Merge Overlapping Interval
Medium

1. You are given a number n, representing the number of time-intervals.
2. In the next n lines, you are given a pair of space separated numbers.
3. The pair of numbers represent the start time and end time of a meeting (first number is start time and second number is end time)
4. You are required to merge the meetings and print the merged meetings output in increasing order of start time.

E.g. Let us say there are 6 meetings
1 8
5 12
14 19
22 28
25 27
27 30

Then the output of merged meetings will belongs
1 12
14 19
22 30

Note -> The given input maynot be sorted by start-time.

Constraints
1 <= n <= 10^4
0 <= ith start time < 100
ith start time < ith end time <= 100

Format
Input
Input is managed for you

Output
Print a merged meeting start time and end time separated by a space in a line
.. print all merged meetings one in each line.

Example
Sample Input

6
22 28
1 8
25 27
14 19
27 30
5 12

Sample Output
1 12
14 19
22 30

