Step 1: Create DP table.
    • Initialize a 2D array dp of size m × n → dp[m][n]
Step 2: Initialize base cases.
    • For each row i from 0 to m-1:
      ○ Fill entire row with 1 → Arrays.fill(dp[i], 1)
    • Reason: There is only 1 way to reach any cell in first row and first column
Step 3: Fill the DP table.
    • For i = 1 to m-1:
      ○ For j = 1 to n-1:
        • Compute number of paths:
          dp[i][j] = dp[i-1][j] + dp[i][j-1]
        • (Top cell + Left cell)
Step 4: Return final answer.
    • Return dp[m-1][n-1] → total unique paths to bottom-right cell
Time Complexity Analysis:
    • Initializing dp array → O(m × n)
    • Filling dp table → O(m × n)
    • Total Time Complexity → O(m × n)
Space Complexity Analysis:
    • DP table of size m × n → O(m × n)
    • Total Space Complexity → O(m × n)


















  ==========> Code <==========

  class Solution {
    public int uniquePaths(int m, int n) {
        int[][] dp=new int[m][n];

        for(int i=0;i<m;i++){
            Arrays.fill(dp[i],1);
        }

        for(int i=1;i<m;i++){
            for(int j=1;j<n;j++){
                dp[i][j]=dp[i-1][j]+dp[i][j-1];
            }
        }
        return dp[m-1][n-1];
    }
}
