Step 1: Initialize DP table.
           • Create a 2D array dp of size (n+1) × (m+1) → int[][] dp = new int[n+1][m+1]
           • dp[i][j] will represent the minimum number of operations to convert word1[0…i-1] to word2[0…j-1]
Step 2: Fill base cases.
           • For i = 0 to n → dp[i][0] = i (delete all characters from word1)
           • For j = 0 to m → dp[0][j] = j (insert all characters of word2)
Step 3: Fill the DP table.
           • Loop i = 1 to n
           • Loop j = 1 to m
           • If word1.charAt(i-1) == word2.charAt(j-1) → dp[i][j] = dp[i-1][j-1] (no operation needed)
           • Else → dp[i][j] = 1 + min(dp[i-1][j-1], dp[i-1][j], dp[i][j-1])
               ○ dp[i-1][j-1] → replace
               ○ dp[i-1][j] → delete
               ○ dp[i][j-1] → insert
Step 4: Return result.
           • Return dp[n][m] → minimum number of operations to convert word1 to word2
Time Complexity Analysis:
           • Two nested loops over n and m → O(n * m)
           Total Time Complexity → O(n * m)
Space Complexity Analysis:
           • DP table of size (n+1) × (m+1) → O(n * m)
           Total Space Complexity → O(n * m)























  ==================> Code <===============

  
class Solution {
    public int minDistance(String word1, String word2) {
        int n=word1.length();
        int m=word2.length();
        int[][] dp=new int[n+1][m+1];

        for(int i=0;i<=n;i++)dp[i][0]=i;
        for(int j=0;j<=m;j++)dp[0][j]=j;

        for(int i=1;i<=n;i++){
            for(int j=1;j<=m;j++){
                if(word1.charAt(i-1)==word2.charAt(j-1)){
                    dp[i][j]=dp[i-1][j-1];
                }else{
                    dp[i][j]=1+Math.min(dp[i-1][j-1],
                                    Math.min(dp[i-1][j],dp[i][j-1]));
                }
            }
        }

        return dp[n][m];
    }
}
