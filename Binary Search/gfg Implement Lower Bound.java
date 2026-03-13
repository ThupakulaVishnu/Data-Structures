Step-by-step algorithm to find the lower bound of a target in a sorted array:

    Step 1: Initialize two pointers low and high.
    (Set low = 0 and high = length of the array. This represents the current search range.)

    Step 2: Start a loop that continues while low < high.
    (This means there are still elements left to check in the search range.)

        • Sub-step 2a: Calculate the middle index of the current search space.
            mid = low + (high - low) / 2

        • Sub-step 2b: Compare the element at the middle index with the target.

            o If arr[mid] < target:
                Move the search space to the right side because the lower bound cannot be at mid or before it.
                Update low = mid + 1.

            o Otherwise (arr[mid] >= target):
                The possible lower bound could be at mid or before it.
                Update high = mid.

    Step 3: Repeat Step 2 until low becomes equal to high.
    (At this point the search space is reduced to a single position.)

    Step 4: Return low.
    (This index represents the first position where the element is greater than or equal to the target, which is the lower bound.)

Logic:

    • The array is sorted, so binary search can be used.
    • If the middle element is smaller than the target, the lower bound must be on the right side.
    • If the middle element is greater than or equal to the target, we keep it as a possible answer and search on the left side.

Time Complexity:

    Each iteration reduces the search space by half.
    Time Complexity = O(log n)

Space Complexity:

    No extra memory or data structures are used.
    Space Complexity = O(1)











  ===============> Code <==================

  class Solution {
    int lowerBound(int[] arr, int target) {
        // code here
        int low=0,high=arr.length;
        
        while(low<high){
            int mid=low+(high-low)/2;
            
            if(arr[mid]<target){
                low=mid+1;
            }else{
                high=mid;
            }
        }
        return low;
    }
}
