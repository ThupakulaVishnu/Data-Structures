Step-by-step algorithm to find minimum insertions to make a string palindrome (DP):
Step 1: Initialize variables.
• Let n = s.length()
• Create DP table → dp[n][n]
 o dp[i][j] = minimum insertions needed to make substring s[i…j] palindrome
Step 2: Fill DP table based on substring length.
• For len = 2 to n:
 o Step 2a: Traverse all substrings of length len
  • For i = 0 to n - len:
   • j = i + len - 1
 o Step 2b: If characters match
  • If s.charAt(i) == s.charAt(j) →
   → No new insertion needed
   → dp[i][j] = dp[i + 1][j - 1]
 o Step 2c: If characters do not match
  • Take minimum of two choices:
   → Insert at left OR insert at right
   → dp[i][j] = min(dp[i][j - 1], dp[i + 1][j]) + 1
Step 3: Final answer.
• Minimum insertions for full string → dp[0][n - 1]
Step 4: Return result.
• Return dp[0][n - 1]
Time Complexity:
• Two nested loops over string length → O(n²)
Time Complexity = O(n²)
Space Complexity:
• DP table of size n × n → O(n²)
Space Complexity = O(n²)











  =================> code<==================

  
class Solution {
    public int minInsertions(String s) {
        int n=s.length();

        int[][] dp=new int[n][n];

        for(int len=2;len<=n;len++){
            for(int i=0;i<=n-len;i++){
                int j=i+len-1;

                if(s.charAt(i)==s.charAt(j)){
                    dp[i][j]=dp[i+1][j-1];
                }else{
                    dp[i][j]=Math.min(dp[i][j-1],dp[i+1][j])+1;
                }
            }
        }

        return dp[0][n-1];
    }
}
