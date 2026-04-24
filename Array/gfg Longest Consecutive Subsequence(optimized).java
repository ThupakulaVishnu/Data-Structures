Step 1: Create a HashSet for fast lookup.
    • Initialize Set st = new HashSet<>()
    • Purpose: store all elements for O(1) average lookup
Step 2: Insert all elements into the set.
    • For each num in arr:
      ○ Add num into st → st.add(num)
Step 3: Initialize answer variable.
    • Set maxLen = 0 → stores longest consecutive sequence length
Step 4: Traverse each element in the set.
    • For each num in st:
Step 5: Check if current number is sequence start.
    • If st does NOT contain (num − 1):
      ○ This means num is the starting point of a sequence
Step 6: Expand the sequence.
    • Set curr = num
    • Set len = 1
    • While st contains (curr + 1):
      ○ Move to next consecutive number → curr++
      ○ Increase length → len++
Step 7: Update maximum length.
    • maxLen = Math.max(maxLen, len)
Step 8: Return final answer.
    • Return maxLen → longest consecutive subsequence length
Time Complexity Analysis:
    • Inserting all elements into HashSet → O(n)
    • Each element is visited at most twice (start check + sequence expansion) → O(n)
    • Total Time Complexity → O(n) (amortized)
Space Complexity Analysis:
    • HashSet stores all elements → O(n)
    • No extra auxiliary structures → O(1) additional space
    • Total Space Complexity → O(n)














  ===========> Code <==========

  class Solution {

    // Function to return length of longest subsequence of consecutive integers.
    public int longestConsecutive(int[] arr) {
        // code here
        Set<Integer> st=new HashSet<>();
        
        for(int num:arr){
            st.add(num);
        }
        int maxLen=0;
        for(int num:st){
            if(!st.contains(num-1)){
                int curr=num;
                int len=1;
                
                while(st.contains(curr+1)){
                    curr++;
                    len++;
                }
                maxLen=Math.max(maxLen,len);
            }
        }
        return maxLen;
    }
}
