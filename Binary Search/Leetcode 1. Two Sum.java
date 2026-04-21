Step 1: Create a HashMap for storing values.
    • Initialize a HashMap<Integer, Integer> hm
    • It will store:
      ○ Key → array value (nums[i])
      ○ Value → index (i)
Step 2: Traverse the array.
    • For i = 0 to nums.length − 1:
Step 3: Check if complement exists.
    • Compute complement → (target − nums[i])
    • Check if hm contains this complement:
      ○ If hm.get(target − nums[i]) != null:
        • Return result → [index of complement, i]
Step 4: Store current element if complement not found.
    • Else:
      ○ Insert into map → hm.put(nums[i], i)
Step 5: Return empty array if no solution found.
    • Return new int[]{}
Time Complexity Analysis:
    • Each element is inserted/checked in HashMap in O(1) average time
    • Single pass through array → O(n)
    • Total Time Complexity → O(n)
Space Complexity Analysis:
    • HashMap stores at most n elements → O(n)
    • Total Space Complexity → O(n)















  ===========> Code <============

  
class Solution {
    public int[] twoSum(int[] nums, int target) {
        HashMap<Integer,Integer> hm=new HashMap<>();
        for(int i=0;i<nums.length;i++){
            if(hm.get(target-nums[i])!=null){
                return new int[]{hm.get(target-nums[i]),i};
            }else{
                hm.put(nums[i],i);
            }
        }
        return new int[]{};
    }
}
