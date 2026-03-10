Step-by-step algorithm to find the duplicate number using Floyd’s Cycle Detection:

Step 1: Initialize two pointers called slow and fast.
Set both pointers to the starting index of the array (index 0).

Step 2: Start a loop to detect a cycle in the array.

Sub-step 2a: Move the slow pointer one step forward.

This means moving to the index represented by the value at the current slow position.

Sub-step 2b: Move the fast pointer two steps forward.

First move to the index represented by the current value.

Then again move to the index represented by that value.

Sub-step 2c: Continue moving the two pointers until both pointers meet at the same position.

Step 3: Once the two pointers meet, a cycle has been detected in the structure formed by the array values.

Step 4: Create another pointer called slow2 and initialize it at the starting index of the array.

Step 5: Now move both pointers one step at a time.

Sub-step 5a: Move slow one step forward.

Sub-step 5b: Move slow2 one step forward.

Sub-step 5c: Continue this process until both pointers meet again.

Step 6: When slow and slow2 meet, the position where they meet represents the duplicate number in the array.

Step 7: Return that value as the answer.

Explanation of the logic:
The array behaves like a linked list where each value points to another index.
Because one number is repeated, two indices eventually point to the same next index, which creates a cycle.
The Floyd cycle detection method first detects the cycle and then finds the entry point of the cycle, which corresponds to the duplicate number.

Time Complexity:
In the first phase, the slow and fast pointers move through the array until they meet inside the cycle, which takes at most n steps.

In the second phase, both pointers move one step at a time to find the start of the cycle, which again takes at most n steps.

Since both phases together take at most a linear number of steps, the overall time complexity is O(n).
Time Complexity = O(n)

Space Complexity:
Only a few pointer variables are used.
Space Complexity = O(1)



                  ---------------> Code <----------------

  class Solution {
    public int findDuplicate(int[] nums) {
        int slow=0,fast=0;
        while(true){
            slow=nums[slow];
            fast=nums[nums[fast]];
            if(slow==fast){
                break;
            }
        }

        int slow2=0;
        while(slow!=slow2){
            slow=nums[slow];
            slow2=nums[slow2];
        }
        return slow;
    }
}
