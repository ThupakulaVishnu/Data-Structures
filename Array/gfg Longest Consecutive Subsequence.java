Step 1: Sort the array.
    • Call Arrays.sort(arr) to sort elements in ascending order
Step 2: Initialize variables.
    • Set maxLen = 1 → stores maximum length of consecutive sequence
    • Set count = 1 → tracks current consecutive sequence length
Step 3: Traverse the array.
    • For i = 1 to arr.length − 1:
Step 4: Check for consecutive elements.
    • If arr[i] == arr[i−1] + 1:
      ○ Increment count → count++
Step 5: Handle duplicates.
    • Else if arr[i] == arr[i−1]:
      ○ Skip duplicate → continue
Step 6: Reset count if sequence breaks.
    • Else:
      ○ Reset count = 1
Step 7: Update maximum length.
    • maxLen = Math.max(maxLen, count)
Step 8: Return result.
    • Return maxLen → length of longest consecutive subsequence
Time Complexity Analysis:
    • Sorting takes O(n log n)
    • Single traversal takes O(n)
    • Total Time Complexity → O(n log n)
Space Complexity Analysis:
    • Sorting in-place (Java) → O(log n) recursion stack
    • No extra data structures used
    • Total Space Complexity → O(log n)












  =================> Code <=================
class Solution {

    // Function to return length of longest subsequence of consecutive integers.
    public int longestConsecutive(int[] arr) {
        // code here
        Arrays.sort(arr);
        
        int maxLen=1;
        int cout=1;
        
        for(int i=1;i<arr.length;i++){
            if(arr[i]==arr[i-1]+1){
                cout++;
            }else if(arr[i]==arr[i-1]){
                continue;
            }else{
                cout=1;
            }
            maxLen=Math.max(maxLen,cout);
        }
        return maxLen;
    }
}
