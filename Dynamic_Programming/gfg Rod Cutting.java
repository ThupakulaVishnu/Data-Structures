Step 1: Initialize DP array.
           • Create a 1D array dp of size n+1 → dp[len] stores maximum profit for rod of length len
           • Set dp[0] = 0 (profit of length 0 rod is 0)
Step 2: Compute maximum profit for each rod length.
           • Loop len = 1 to n → current rod length
           • Initialize maxval = 0
           • Loop cut = 1 to len → try all possible first cut lengths
                     ○ Profit = price[cut-1] + dp[len - cut]
                     ○ Update maxval = max(maxval, profit)
           • Store maximum profit for current length → dp[len] = maxval
Step 3: Return final result.
           • Return dp[n] → maximum profit for rod of full length
Time Complexity Analysis:
           • Outer loop over len = 1…n → O(n)
           • Inner loop over cut = 1…len → O(n)
           • Total Time Complexity → O(n²)
Space Complexity Analysis:
           • DP array dp of size n+1 → O(n)
           • Total Space Complexity → O(n)

















  ============> Code <===========

  
class Solution {
    public int cutRod(int[] price) {
        // code here
        int n=price.length;
        int[] dp=new int[n+1];
        dp[0]=0;
        
        for(int len=1;len<=n;len++){
            int maxval=0;
            for(int cut=1;cut<=len;cut++){
                maxval=Math.max(price[cut-1]+dp[len-cut],maxval);
            }
            dp[len]=maxval;
        }
        
        return dp[n];
    }
}
