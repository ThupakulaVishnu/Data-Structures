Step-by-step algorithm to find the Longest Common Subsequence (LCS) using Dynamic Programming:
Step 1: Initialize variables.
 • Let n be the length of text1.
 • Let m be the length of text2.
Step 2: Create a DP table.
 • Create a 2D array dp of size (n+1) × (m+1).
 • This table will store the length of LCS for different prefixes of the two strings.
 • Initialize all values to 0.
Step 3: Traverse both strings.
 • Use two loops:
  o Outer loop runs from i = 1 to n.
  o Inner loop runs from j = 1 to m.
Step 4: Compare characters of both strings.
 • Sub-step 4a: If characters match
  o If text1[i-1] == text2[j-1]:
   - Increase the LCS length by 1 from the previous diagonal value.
   - Update dp[i][j] = 1 + dp[i-1][j-1].
 • Sub-step 4b: If characters do not match
  o Take the maximum of two possibilities:
   - Exclude current character from text1 → dp[i-1][j]
   - Exclude current character from text2 → dp[i][j-1]
   - Update dp[i][j] with the maximum of these two values.
Step 5: Continue filling the DP table.
 • Repeat Step 4 for all values of i and j.
 • Each cell represents the LCS length for prefixes of both strings.
Step 6: Return the final result.
 • The value at dp[n][m] gives the length of the Longest Common Subsequence.
Logic:
 • The DP table stores solutions of smaller subproblems.
 • If characters match, we extend the previous subsequence.
 • If they don’t match, we take the best possible subsequence by excluding one character.
 • The solution builds up from smaller prefixes to the full strings.
Time Complexity:
 • Two nested loops over lengths of the strings.
 • Time Complexity = O(n × m)
Space Complexity:
 • A 2D DP array of size (n+1) × (m+1) is used.
 • Space Complexity = O(n × m)



















  =================> Code <==============

  class Solution {
    public int longestCommonSubsequence(String text1, String text2) {
        int n=text1.length();
        int m=text2.length();
        int[][] dp=new int[n+1][m+1];
        for(int i=1;i<n+1;i++){
            for(int j=1;j<m+1;j++){
                if(text1.charAt(i-1)==text2.charAt(j-1)){
                    dp[i][j]=1+dp[i-1][j-1];
                }else{
                    dp[i][j]=Math.max(dp[i-1][j],dp[i][j-1]);
                }
            }
        }
        return dp[n][m];
    }
}
