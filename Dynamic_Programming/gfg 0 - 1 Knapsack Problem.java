Step 1: Initialize DP table.
           • Create a 2D array dp of size (n+1) × (W+1) → int[][] dp = new int[n+1][W+1]
           • dp[i][w] will represent the maximum value achievable using first i items and capacity w
Step 2: Fill the DP table.
           • Loop i = 0 to n (items)
           • Loop w = 0 to W (weights)
           • If i == 0 or w == 0 → dp[i][w] = 0 (base case)
           • Else if wt[i-1] <= w → dp[i][w] = max(val[i-1] + dp[i-1][w - wt[i-1]], dp[i-1][w])
           • Else → dp[i][w] = dp[i-1][w] (cannot include current item)
Step 3: Return result.
           • Return dp[n][W] → maximum value achievable with all items and capacity W
Time Complexity Analysis:
           • Two nested loops over items (n) and weight (W) → O(n * W)
           Total Time Complexity → O(n * W)
Space Complexity Analysis:
           • DP table of size (n+1) × (W+1) → O(n * W)
           Total Space Complexity → O(n * W)











===========> Code <============

  class Solution {
    public int knapsack(int W, int val[], int wt[]) {
        // code here
        int n=val.length;
        int[][] dp=new int[n+1][W+1];
        
        for(int i=0;i<=n;i++){
            for(int j=0;j<=W;j++){
                if(i==0 || j==0)continue;
                if(j<wt[i-1]){
                    dp[i][j]=dp[i-1][j];
                }else{
                    dp[i][j]=Math.max(dp[i-1][j],dp[i-1][j-wt[i-1]]+val[i-1]);
                }
            }
        }
        return dp[n][W];
    }
}
