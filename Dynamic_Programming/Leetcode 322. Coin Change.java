Step 1: Initialize DP array.
           • Create array dp of size amount+1 → int[] dp = new int[amount+1]
           • Fill all values with amount+1 → Arrays.fill(dp, amount+1) (acts as infinity)
           • Set base case → dp[0] = 0 (0 coins needed for amount 0)
Step 2: Build solution for all amounts.
           • Loop i = 1 to amount
           • For each coin coin in coins:
                      ○ If coin <= i →
           • Update → dp[i] = min(dp[i], dp[i - coin] + 1)
Step 3: Check final result.
           • If dp[amount] > amount → return -1 (not possible to form amount)
           • Else → return dp[amount]
Time Complexity Analysis:
           • Outer loop runs amount times → O(amount)
           • Inner loop runs for each coin → O(n), where n = number of coins
           Total Time Complexity → O(amount * n)
Space Complexity Analysis:
           • DP array dp of size amount+1 → O(amount)
           Total Space Complexity → O(amount)




















  =============> Code<==========

  
class Solution {
    public int coinChange(int[] coins, int amount) {
        int[] dp=new int[amount+1];
        Arrays.fill(dp,amount+1);
        dp[0]=0;

        for(int i=1;i<=amount;i++){
            for(int cout:coins){
                if(cout<=i){
                    dp[i]=Math.min(dp[i],dp[i-cout]+1);
                }
            }
        }

        return dp[amount]>amount ? -1 : dp[amount];
    }
}
