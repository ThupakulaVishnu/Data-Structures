Step-by-step algorithm to search a target in a rotated sorted array:
Step 1: Initialize pointers.
• l = 0 → start of array
• r = nums.length - 1 → end of array
Step 2: Start binary search loop.
• While l <= r:
 o Step 2a: Calculate middle index → mid = l + (r - l)/2
 o Step 2b: Check if middle element is target
  • If nums[mid] == target → return mid
 o Step 2c: Check which half is sorted
  • If left half is sorted → nums[l] <= nums[mid]
   o If target lies in left half →
    • If nums[l] <= target < nums[mid] → r = mid - 1
   o Else → search in right half → l = mid + 1
  • Else (right half is sorted)
   o If target lies in right half →
    • If nums[mid] < target <= nums[r] → l = mid + 1
   o Else → search in left half → r = mid - 1
Step 3: If loop ends and target not found → return -1
Time Complexity:
Binary search reduces search space by half each step → O(log n)
Time Complexity = O(log n)
Space Complexity:
Only constant variables are used → O(1)
Space Complexity = O(1)


















  ============> Code <==========

  class Solution {
    public int search(int[] nums, int target) {
        int l=0,r=nums.length-1;
        while(l<=r){
            int mid=l+(r-l)/2;

            if(nums[mid]==target){
                return mid;
            }else if(nums[l]<=nums[mid]){
                if(nums[l]<=target && target<nums[mid]){
                    r=mid-1;
                }else{
                    l=mid+1;
                }
            }else{
                if(nums[mid]<target && target<=nums[r]){
                    l=mid+1;
                }else{
                    r=mid-1;
                }
            }
        }

        return -1;
    }
}

  
