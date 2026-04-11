Step-by-step algorithm to find maximum in sliding window of size k:
Step 1: Initialize variables.
• Let n = nums.length
• Create result array → ans of size n - k + 1
• Create deque dq to store indices (will maintain decreasing order of values)
Step 2: Traverse the array.
• For i = 0 to n - 1:
 o Step 2a: Remove indices out of current window
  • If deque is not empty AND dq.peekFirst() <= i - k
   → remove from front → dq.pollFirst()
 o Step 2b: Maintain decreasing order in deque
  • While deque is not empty AND nums[dq.peekLast()] < nums[i]
   → remove from back → dq.pollLast()
 o Step 2c: Add current index
  • dq.offer(i)
 o Step 2d: Store result when window is valid
  • If i >= k - 1
   → ans[i - k + 1] = nums[dq.peekFirst()]
Step 3: Return result array ans
Time Complexity:
• Each element is added to deque once → O(n)
• Each element is removed from deque at most once → O(n)
Time Complexity = O(n)
Space Complexity:
• Deque stores at most k indices → O(k)
• Output array → O(n - k + 1)
Space Complexity = O(k) + O(n - k + 1)
Space Complexity = O(n)









================> Code <===========

  
class Solution {
    public int[] maxSlidingWindow(int[] nums, int k) {
        int n=nums.length;
        Deque<Integer> dq=new ArrayDeque<>();
        int[] ans=new int[n-k+1];

        for(int i=0;i<nums.length;i++){
            while(!dq.isEmpty() && dq.peekFirst()<=i-k){
                dq.pollFirst();
            }
            while(!dq.isEmpty() && nums[dq.peekLast()]<nums[i]){
                dq.pollLast();
            }
            dq.offer(i);
            if(i>=k-1){
                ans[i-k+1]=nums[dq.peekFirst()];
            }
        }
        return ans;
    }
}




  =============> Code <=============

  
