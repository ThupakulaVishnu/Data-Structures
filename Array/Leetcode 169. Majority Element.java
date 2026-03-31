Step-by-step algorithm to find the majority element using Boyer-Moore Voting Algorithm:
Step 1: Initialize variables.
• Set cand = 0 (candidate for majority element)
• Set count = 0
Step 2: Traverse each element in the array nums.
• Sub-step 2a: If count == 0
 o Update candidate → cand = current element
• Sub-step 2b: If current element == cand
 o Increment count → count++
• Sub-step 2c: Else (current element != cand)
 o Decrement count → count--
Step 3: Continue this process for all elements in the array.
Step 4: After traversal, cand will hold the majority element.
Step 5: Return cand as the answer.
  
Time Complexity:
1.	The array is traversed once.
2.	Each operation inside the loop takes constant time.
3.	Total time = O(n).
Time Complexity = O(n)
  
Space Complexity:
Only two variables (cand and count) are used.
Space Complexity = O(1)






  ==============> Code <=============

  class Solution {
    public int majorityElement(int[] nums) {
        int cand=0;
        int cout=0;

        for(int n:nums){
            if(cout==0){
                cand=n;
            }

            if(n==cand){
                cout++;
            }else{
                cout--;
            }
        }

        return cand;
    }
}
