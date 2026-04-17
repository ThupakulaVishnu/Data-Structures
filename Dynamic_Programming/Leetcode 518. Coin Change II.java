Step 1: Initialize DP array.
           • Create array dp of size amount+1 → int[] dp = new int[amount+1]
           • Set base case → dp[0] = 1 (one way to make amount 0 → choose nothing)
Step 2: Process each coin.
           • For each coin coin in coins:
Step 3: Update DP for current coin.
           • Loop i = coin to amount:
                      ○ Update ways → dp[i] += dp[i - coin]
Step 4: Repeat for all coins.
           • Each coin contributes to forming all possible amounts
Step 5: Return result.
           • Return dp[amount] → total number of ways to form given amount
Time Complexity Analysis:
           • Outer loop runs for each coin → O(n), where n = number of coins
           • Inner loop runs for all amounts → O(amount)
           Total Time Complexity → O(n * amount)
Space Complexity Analysis:
           • DP array dp of size amount+1 → O(amount)
           Total Space Complexity → O(amount)

















  ==============> Code <=============
  
class Solution {
    public int change(int amount, int[] coins) {
        int[] dp=new int[amount+1];
        dp[0]=1;

        for(int cout:coins){
            for(int i=cout;i<=amount;i++){
                dp[i]+=dp[i-cout];
            }
        }

        return dp[amount];
    }
}
