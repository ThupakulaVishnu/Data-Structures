Step-by-step algorithm to find minimum insertions to make a string palindrome (optimized 1D DP):
Step 1: Initialize variables.
• Let n = s.length()
• Create 1D DP array → dp[n]
 o dp[j] = minimum insertions needed for substring ending at j
Step 2: Traverse the string in reverse for start index.
• For i = n - 2 down to 0:
 o Initialize pre = 0 (stores previous dp[j-1])
 o Step 2a: Traverse end index for substring
  • For j = i + 1 to n - 1:
   • Store current dp[j] in temp
   • Step 2b: Check characters
    • If s.charAt(i) == s.charAt(j) →
     → No insertion needed → dp[j] = pre
    • Else → characters differ → insert 1
     → dp[j] = min(dp[j], dp[j - 1]) + 1
   • Step 2c: Update pre for next iteration → pre = temp
Step 3: Final answer.
• Minimum insertions for full string → dp[n - 1]
Step 4: Return result.
• Return dp[n - 1]
________________________________________
Time Complexity:
• Two nested loops over string → O(n²)
Time Complexity = O(n²)
Space Complexity:
• Optimized 1D DP array → O(n)
Space Complexity = O(n)
















  ==============> Code <===============

  class Solution {
    public int minInsertions(String s) {
        int n=s.length();
        int[] dp=new int[n];

        for(int i=n-2;i>=0;i--){
            int pre=0;
            for(int j=i+1;j<n;j++){
                int temp=dp[j];

                if(s.charAt(i)==s.charAt(j)){
                    dp[j]=pre;
                }else{
                    dp[j]=Math.min(dp[j],dp[j-1])+1;
                }

                pre=temp;
            }
        }

        return dp[n-1];
    }
}
