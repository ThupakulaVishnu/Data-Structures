Step 1: Create DP array.
    • Initialize a 1D array dp of size n → dp[n]
Step 2: Initialize base case.
    • Fill entire array with 1 → Arrays.fill(dp, 1)
    • Reason: First row has only 1 way to reach each cell
Step 3: Update DP values row by row.
    • For i = 1 to m-1:
      ○ For j = 1 to n-1:
        • Update paths using:
          dp[j] = dp[j] + dp[j-1]
        • (Current dp[j] → value from top, dp[j-1] → value from left)
Step 4: Return final answer.
    • Return dp[n-1] → total unique paths
Time Complexity Analysis:
    • Outer loop runs m times, inner loop runs n times → O(m × n)
    • Total Time Complexity → O(m × n)
Space Complexity Analysis:
    • Using 1D DP array of size n → O(n)
    • Total Space Complexity → O(n)


















  ===================> Code <==================

  class Solution {
    public int uniquePaths(int m, int n) {
        int[] dp=new int[n];

        Arrays.fill(dp,1);

        for(int i=1;i<m;i++){
            for(int j=1;j<n;j++){
                dp[j]=dp[j]+dp[j-1];
            }
        }

        return dp[n-1];
    }
}
