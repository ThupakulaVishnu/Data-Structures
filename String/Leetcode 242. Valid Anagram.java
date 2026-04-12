Step-by-step algorithm to check if two strings are anagrams:
Step 1: Initialize frequency array.
• Create an array arr of size 512 → stores frequency counts for characters
Step 2: Count characters in first string s.
• For each character ch in s:
 o Increment count → arr[ch - '0']++
Step 3: Subtract characters in second string t.
• For each character ch in t:
 o Decrement count → arr[ch - '0']--
Step 4: Check if all counts are zero.
• For each value h in arr:
 o If h != 0 → strings are not anagrams → return false
Step 5: Return result.
• If all counts are zero → return true
________________________________________
Time Complexity:
• Traverse both strings once → O(n + m)
 o n = length of s, m = length of t
Time Complexity = O(n + m)
Space Complexity:
• Frequency array of size 512 → O(1) (constant size)
Space Complexity = O(1)














  ==========> Code <=========
  class Solution {
    public boolean isAnagram(String s, String t) {
        int[] arr=new int[512];

        for(char ch:s.toCharArray()){
            arr[ch-'0']++;
        }
        for(char ch:t.toCharArray()){
            arr[ch-'0']--;
        }
        for(int h:arr){
            if(h!=0)return false;
        }
        return true;
    }
}
