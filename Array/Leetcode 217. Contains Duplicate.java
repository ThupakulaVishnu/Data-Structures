Step-by-step algorithm for checking if an array contains duplicates:

Step 1: Initialize an empty HashSet `hs` to store unique elements.

Step 2: Traverse each element `cur` in the array `nums`.

* Sub-step 2a: Try to add the element `cur` to the HashSet.

* Sub-step 2b: If the element cannot be added (because it already exists in the HashSet),

  * Return `true`.
    (This means a duplicate is found.)

Step 3: If all elements are processed without finding a duplicate,

* Return `false`.
  (This means all elements are unique.)

Logic:

* HashSet only stores unique values.
* Adding an existing value fails, which immediately indicates a duplicate.

Time Complexity:
Each element is checked once and HashSet operations are O(1) on average.
Time Complexity = **O(n)**

Space Complexity:
HashSet may store up to n elements.
Space Complexity = **O(n)**





  -------------> Code <-------------

  class Solution {
    public boolean containsDuplicate(int[] nums) {
        HashSet<Integer> hs=new HashSet<>();
        for(int cur:nums){
            if(!hs.add(cur)){
                return true;
            }
        }
        return false;
    }
}
