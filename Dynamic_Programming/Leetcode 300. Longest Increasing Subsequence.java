Step-by-step algorithm to find the length of the Longest Increasing Subsequence (LIS) using Dynamic Programming:
Step 1: Initialize the DP array.
 • Create an integer array dp of the same length as nums.
 • Set all elements of dp to 1 using Arrays.fill(dp, 1).
  o Each element represents the length of the LIS ending at that index.
  o Every single element is at least a subsequence of length 1.
Step 2: Initialize a variable to track the maximum LIS.
 • Create an integer max and set it to 1.
 • This will store the length of the longest increasing subsequence found so far.
Step 3: Traverse the array from the second element to the last.
 • For each element at index i, compare it with all previous elements.
Step 4: Compare the current element with all previous elements.
 • For every j from 0 to i-1:
  o If nums[i] > nums[j], it means nums[i] can extend the increasing subsequence ending at j.
  o Update dp[i] = Math.max(dp[i], dp[j] + 1).
   - This ensures dp[i] stores the maximum LIS length ending at index i.
Step 5: Update the global maximum LIS.
 • After processing all previous elements for i, update max = Math.max(max, dp[i]).
Step 6: After traversing the entire array, return the maximum value.
 • Return max, which represents the length of the longest increasing subsequence.
[1, 2, 3, 4, 5, 6, 7, 8]  -  worest  case
Time Complexity:
 • Two nested loops are used: outer loop for i and inner loop for j.
 • Time Complexity = O(n²), where n is the length of the array.
Space Complexity:
 • DP array dp stores the LIS length for each element.
 • Space Complexity = O(n)









  


  =============> Code <==========

class Solution {
    public int lengthOfLIS(int[] nums) {
        int n = nums.length;
        
        // Step 1: Initialize DP array
        int[] dp = new int[n];
        Arrays.fill(dp, 1);
        
        // Step 2: Initialize max
        int max = 1;
        
        // Step 3: Traverse from second element
        for (int i = 1; i < n; i++) {
            
            // Step 4: Compare with all previous elements
            for (int j = 0; j < i; j++) {
                if (nums[i] > nums[j]) {
                    dp[i] = Math.max(dp[i], dp[j] + 1);
                }
            }
            
            // Step 5: Update global max
            max = Math.max(max, dp[i]);
        }
        
        // Step 6: Return result
        return max;
    }
}
