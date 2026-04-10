Step-by-step algorithm to find the single non-duplicate element:
Step 1: Initialize pointers.
• l = 0 → start of array
• r = nums.length - 1 → end of array
Step 2: Perform binary search.
• While l < r:
 o Step 2a: Calculate middle index → mid = l + (r - l)/2
 o Step 2b: Ensure mid is even → if (mid % 2 == 1) mid--
 o Step 2c: Check pair starting at mid →
  • If nums[mid] == nums[mid+1] → single element is on right → l = mid + 2
  • Else → single element is on left (including mid) → r = mid
Step 3: When l == r, the single non-duplicate element is at index l → return nums[l]
Time Complexity:
Binary search halves the search space each time → O(log n)
Time Complexity = O(log n)
Space Complexity:
Only a few variables used → O(1)
Space Complexity = O(1)













  class Solution {
    public int singleNonDuplicate(int[] nums) {
        int l=0,r=nums.length-1;
        while(l<r){
            int mid=l+(r-l)/2;

            if(mid%2==1) mid=mid-1;

            if(nums[mid]==nums[mid+1]){
                l=mid+2;
            }else{
                r=mid-1;
            }
        }

        return nums[l];
    }
}
