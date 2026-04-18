Step 1: Initialize DP table.
           • Create a 2D boolean array dp of size (n+1) × (sum+1)
           • dp[i][j] represents whether a subset of first i elements can form sum j
Step 2: Set base cases.
           • For i = 0 to n → dp[i][0] = true (sum 0 is always possible with empty subset)
           • For j = 1 to sum → dp[0][j] = false (no elements cannot form positive sum)
Step 3: Fill DP table.
           • Loop i = 1 to n
           • Loop j = 1 to sum
           • If arr[i-1] <= j →
                      ○ Include or exclude current element →
                      ○ dp[i][j] = dp[i-1][j] || dp[i-1][j - arr[i-1]]
           • Else →
                      ○ Cannot include current element → dp[i][j] = dp[i-1][j]
Step 4: Return result.
           • Return dp[n][sum] → whether subset with given sum exists
Time Complexity Analysis:
           • Two nested loops over n and sum → O(n * sum)
           Total Time Complexity → O(n * sum)
Space Complexity Analysis:
           • DP table of size (n+1) × (sum+1) → O(n * sum)
           Total Space Complexity → O(n * sum)






















  ====================> Code <=============

  
class Solution {

    static Boolean isSubsetSum(int arr[], int sum) {
        // code here
        int n=arr.length;
        
        boolean[][] dp=new boolean[n+1][sum+1];
        
        for(int i=0;i<=n;i++){
            dp[i][0]=true;
        }
        
        for(int i=1;i<=n;i++){
            for(int j=1;j<=sum;j++){
                if(arr[i-1]<=j){
                    dp[i][j]=dp[i-1][j] || dp[i-1][j-arr[i-1]];
                }else{
                    dp[i][j]=dp[i-1][j];
                }
            }
        }
        
        return dp[n][sum];
    }
}
