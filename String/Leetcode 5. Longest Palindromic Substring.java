Step-by-step algorithm to find the longest palindromic substring in a string:
Step 1: Initialize variables.
 • count to store the length of the longest palindrome found so far.
 • ol and or to store the start and end indices of the longest palindrome.
 • n as the length of the input string.
Step 2: Loop through all possible centers for the palindrome.
 • There are 2 * n - 1 possible centers (to account for both odd and even length palindromes).
 • For each center i, calculate:
  o st = i / 2 (starting index for expansion)
  o end = st + i % 2 (ending index for expansion)
Step 3: Expand around the current center.
 • While st and end are within bounds and characters at st and end are equal:
  o Expand outward by decrementing st and incrementing end.
  o Check if the current palindrome length (end - st - 1) is greater than count.
   - If yes, update ol = st, or = end, and count = end - st - 1.
Step 4: Continue checking all centers until all possibilities are exhausted.
Step 5: Return the substring from ol + 1 to or.
 (This substring represents the longest palindromic substring in the input string.)
Logic:
 • Each character and each gap between characters is considered as a potential center.
 • Expanding from the center ensures that all possible palindromes are checked efficiently.
 • The longest palindrome length and indices are updated whenever a longer palindrome is found.
Time Complexity:
 Each center expands at most n steps.
 Time Complexity = O(n²)
Space Complexity:
 No extra space besides variables for indices and counters.
 Space Complexity = O(1)









  ===========> Code <=============

  class Solution {
    public String longestPalindrome(String s) {
        int count=0;
        int ol=0;
        int or=0;
        int n=s.length();
        for(int i=0;i<2*n-1;i++){
            int st=i/2;
            int end=st+i%2;
            while(st>=0 && st<n && end>=0 && end<n && s.charAt(st)==s.charAt(end)){
                st--;
                end++;
                if(count<end-st-1){
                    ol=st;
                    or=end;
                    count=end-st-1;
                }
            }
        }
        return s.substring(ol+1,or);
    }
}
