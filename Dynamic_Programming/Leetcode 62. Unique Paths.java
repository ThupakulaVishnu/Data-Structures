Step 1: Initialize DP table
    • Create 2D array dp[m][n]
    • dp[i][j] represents number of ways to reach cell (i, j)
Step 2: Fill first row
    • For j = 0 to n−1:
      ○ dp[0][j] = 1
    • Only one way (move right only)
Step 3: Fill first column
    • For i = 1 to m−1:
      ○ dp[i][0] = 1
    • Only one way (move down only)
Step 4: Fill remaining cells
    • For i = 1 to m−1:
      ○ For j = 1 to n−1:
Step 5: Apply recurrence relation
    • dp[i][j] = dp[i−1][j] + dp[i][j−1]
    • Ways = from top + from left
Step 6: Continue filling table
Step 7: Return result
    • Return dp[m−1][n−1]
Time Complexity Analysis:
    • Two nested loops over grid → m × n
    • Total Time Complexity → O(m × n)
Space Complexity Analysis:
    • DP table of size m × n → O(m × n)
    • Total Space Complexity → O(m × n)



















  ==========> Code <==========

  class Solution {
    public int uniquePaths(int m, int n) {
        int[][] dp=new int[m][n];

        Arrays.fill(dp[0],1);
        for(int i=1;i<m;i++){
            dp[i][0]=1;
        }

        for(int i=1;i<m;i++){
            for(int j=1;j<n;j++){   
                dp[i][j]=dp[i-1][j]+dp[i][j-1];
            }
        }

        return dp[m-1][n-1];
    }
}
