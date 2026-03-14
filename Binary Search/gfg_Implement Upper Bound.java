Step-by-step algorithm to find the upper bound of a target in a sorted array:
Step 1: Initialize two pointers low and high.
 • Set low = 0.
 • Set high = length of the array.
 (This defines the search range.)
Step 2: Start a loop that continues while low < high.
 (This means there are still elements left to search.)
 • Sub-step 2a: Calculate the middle index of the current search range.
  The middle index is obtained by dividing the search space into two halves.
 • Sub-step 2b: Compare the element at the middle index with the target.
  o If the middle element is less than or equal to the target:
   The upper bound cannot be at this position because we need the first element strictly greater than the target.
   So move the search space to the right side.
  o Otherwise (the middle element is greater than the target):
   This element could be the upper bound or a smaller valid position may exist on the left side.
   So continue searching on the left half.
Step 3: Repeat Step 2 until low becomes equal to high.
 (The search space keeps shrinking until only one position remains.)
Step 4: Return low.
 (This index represents the first position where the element is strictly greater than the target, which is the upper bound.)
Logic:
 • Binary search is used because the array is sorted.
 • If the middle element is less than or equal to the target, the upper bound must be on the right side.
 • If the middle element is greater than the target, it may be the answer, so we continue searching on the left side.
Time Complexity:
 Each iteration reduces the search space by half.
 Time Complexity = O(log n)
Space Complexity:
 No extra data structures are used.
 Space Complexity = O(1)










                  ===========> Code <===========


  class Solution {
    int upperBound(int[] arr, int target) {
        // code here
        int low=0;
        int high=arr.length;
        
        while(low<high){
            int mid=low+(high-low)/2;
            
            if(arr[mid]<=target){
                low=mid+1;
            }else{
                high=mid;
            }
        }
        return low;
    }
}
