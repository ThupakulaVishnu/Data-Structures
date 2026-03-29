Step-by-step algorithm to find the Longest Common Subsequence (LCS) using space-optimized Dynamic Programming:
Step 1: Ensure the shorter string is used for the DP array.
 • Compare lengths of text1 and text2.
 • Swap them if text1 is shorter than text2.
 • This reduces the size of the DP array to O(min(n, m)).
Step 2: Initialize the DP array.
 • Create a 1D array dp of size text2.length() + 1, initialized to 0.
 • dp[j] stores the length of LCS for the current row and the first j characters of text2.
Step 3: Traverse the longer string text1.
 • Loop through each character i from 1 to text1.length().
 • Maintain a variable prev to store the value of dp[j-1] from the previous iteration.
  o This represents the top-left diagonal value in the 2D DP table.
Step 4: Traverse the shorter string text2.
 • Loop through each character j from 1 to text2.length().
 • Store the current dp[j] in a temporary variable temp before updating.
Step 5: Update the DP array.
 • Sub-step 5a: If characters match
  o If text1[i-1] == text2[j-1]:
   - Set dp[j] = 1 + prev.
   - prev corresponds to the previous diagonal value.
 • Sub-step 5b: If characters do not match
  o Set dp[j] = Math.max(dp[j], dp[j-1]).
   - dp[j] is from the previous row (top)
   - dp[j-1] is from the current row (left)
Step 6: Update prev for the next iteration.
 • After updating dp[j], set prev = temp.
 • This ensures the diagonal value is preserved for the next column.
Step 7: Repeat Steps 4–6 for all characters in text1.
Step 8: Return the final result.
 • dp[text2.length()] contains the length of the Longest Common Subsequence.
Logic:
 • Uses a 1D DP array instead of 2D by keeping track of the previous diagonal value (prev).
 • Matching characters extend the subsequence using the diagonal value.
 • Non-matching characters take the maximum from top or left, as in standard LCS.
 • This approach optimizes space from O(n*m) to O(min(n, m)).
Time Complexity:
 • Two nested loops over the lengths of the strings.
 • Time Complexity = O(n × m)
Space Complexity:
 • Only a 1D DP array of size min(n, m) + 1 is used.
 • Space Complexity = O(min(n, m))

















================> Code <================

class Solution {
    public int longestCommonSubsequence(String text1, String text2) {
        if(text2.length()>text1.length()){
            String temp=text2;
            text2=text1;
            text1=temp;
        }

        int[] arr=new int[text2.length()+1];

        for(int i=1;i<=text1.length();i++){
            int pre=0;
            for(int j=1;j<=text2.length();j++){
                int temp=arr[j];
                if(text1.charAt(i-1)==text2.charAt(j-1)){
                    arr[j]=pre+1;
                }else{
                    arr[j]=Math.max(arr[j-1],temp);
                }
                pre=temp;
            }
        }
        return arr[text2.length()];
    }
}
