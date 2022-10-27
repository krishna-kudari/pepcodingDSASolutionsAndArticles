Sliding Window Maximum
Hard

1. You are given a number n, representing the size of array a.
2. You are given n numbers, representing the elements of array a.
3. You are given a number k, representing the size of window.
4. You are required to find and print the maximum element in every window of size k.

e.g.
for the array [2 9 3 8 1 7 12 6 14 4 32 0 7 19 8 12 6] and k = 4, the answer is [9 9 8 12 12 14 14 32 32 32 32 19 19 19]

Constraints
0 <= n < 100000
-10^9 <= a[i] <= 10^9
0 < k < n

Format
Input
Input is managed for you

Output
Maximum of each window in separate line

class Solution {
    public int[] maxSlidingWindow(int[] nums, int k) {
        int[] nge = new int[nums.length];
        Stack<Integer> st = new Stack<>();
        nge[nums.length-1] = nums.length;
        st.push(nums.length-1);
        
        for(int i = nums.length-2; i>= 0 ; i--){
            while(st.size() > 0 && nums[i] >= nums[st.peek()]){
                st.pop();
            }
            
            if(st.size() == 0){
                nge[i] = nums.length;
            }else{
                nge[i] = st.peek();
            }
            
            st.push(i);
        }
        int[] ans = new int[nums.length-k+1];
        int j = 0;
        for(int i = 0 ; i <= nums.length-k ; i++){
            if(j < i){
                j = i;
            }
            
            while(nge[j] < i+k){
                j = nge[j];
                
            }
            ans[i] = nums[j];
            System.out.println(nums[j]);
        }
        return ans;
        
    }
}