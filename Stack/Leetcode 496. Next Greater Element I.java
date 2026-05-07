Step 1: Initialize data structures.
    • Create a HashMap<Integer, Integer> hm
    • Purpose: store next greater element for each number
    • Create a Stack st
    • Purpose: maintain decreasing order of elements
Step 2: Traverse nums2 array.
    • For each element n in nums2:
Step 3: Maintain decreasing stack.
    • While stack is not empty AND n > top of stack:
      ○ Pop smaller element from stack
      ○ Map it to current element → hm.put(popped, n)
    • This ensures each element gets its next greater value
Step 4: Push current element.
    • Push n into stack → st.push(n)
Step 5: Handle remaining elements in stack.
    • While stack is not empty:
      ○ Pop element
      ○ Assign -1 in map → hm.put(element, -1)
    • Meaning: no next greater element exists
Step 6: Build result for nums1.
    • Create result array arr of size nums1.length
    • For each element nums1[i]:
      ○ arr[i] = hm.get(nums1[i])
Step 7: Return result.
    • Return arr → next greater elements for nums1
Time Complexity Analysis:
Even though the while is inside the for, the total number of pops across the entire program is ≤ n, not n per iteration.
    • Each element is pushed and popped at most once → O(n + m)
    • Building result array → O(n)
    • Total Time Complexity → O(n + m)
Space Complexity Analysis:
    • Stack stores up to m elements → O(m)
    • HashMap stores m mappings → O(m)
    • Result array stores n elements → O(n)
    • Total Space Complexity → O(n + m)










  ===============> Code <==============

  class Solution {
    public int[] nextGreaterElement(int[] nums1, int[] nums2) {
        Map<Integer,Integer> hm=new HashMap<>();
        Stack<Integer> st=new Stack<>();
        for(int n:nums2){
            while(!st.isEmpty() && n>st.peek()){
                hm.put(st.pop(),n);
            }
            st.push(n);
        }
        while(!st.isEmpty()){
            hm.put(st.pop(),-1);
        }
        int[] arr=new int[nums1.length];
        for(int i=0;i<nums1.length;i++){
            arr[i]=hm.get(nums1[i]);
        }
        return arr;
    }
}
