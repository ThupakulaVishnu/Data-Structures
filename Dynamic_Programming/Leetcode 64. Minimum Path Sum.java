Step 1: Initialize variables.
           • n = grid.length → number of rows
           • m = grid[0].length → number of columns
           • Create a DP table dp of size n × m → int[][] dp = new int[n][m]
Step 2: Set starting point.
           • dp[0][0] = grid[0][0] → cost to reach starting cell
Step 3: Fill first row.
           • For i = 1 to m-1 → dp[0][i] = dp[0][i-1] + grid[0][i] (only move right)
Step 4: Fill first column.
           • For i = 1 to n-1 → dp[i][0] = dp[i-1][0] + grid[i][0] (only move down)
Step 5: Fill remaining DP table.
           • For i = 1 to n-1
           • For j = 1 to m-1
               ○ dp[i][j] = grid[i][j] + min(dp[i-1][j], dp[i][j-1]) → minimum path sum from top or left
Step 6: Return result.
           • Return dp[n-1][m-1] → minimum path sum to bottom-right corner
Time Complexity Analysis:
           • Two nested loops over n and m → O(n * m)
           Total Time Complexity → O(n * m)
Space Complexity Analysis:
           • DP table of size n × m → O(n * m)
           Total Space Complexity → O(n * m)





















  =================> code <=================

  
class Solution {
    public int minPathSum(int[][] grid) {
        int n=grid.length;
        int m=grid[0].length;

        int[][] dp=new int[n][m];

        dp[0][0]=grid[0][0];
        for(int i=1;i<m;i++){
            dp[0][i]=dp[0][i-1]+grid[0][i];
        }

        for(int i=1;i<n;i++){
            dp[i][0]=dp[i-1][0]+grid[i][0];
        }

        for(int i=1;i<n;i++){
            for(int j=1;j<m;j++){    
                dp[i][j]=grid[i][j]+Math.min(dp[i-1][j],dp[i][j-1]);
            }
        }

        return dp[n-1][m-1];
    }
}
