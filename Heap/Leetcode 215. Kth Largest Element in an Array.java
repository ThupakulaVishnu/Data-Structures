Step-by-step algorithm to find the kᵗʰ largest element in an array using a min-heap:
    Step 1: Create a min-heap (priority queue).
    (This heap will store at most k largest elements seen so far.)
    Step 2: Traverse each element in the array nums.
        • Sub-step 2a: Add the current element n to the heap.
            qu.offer(n)
        • Sub-step 2b: If the heap size exceeds k, remove the smallest element.
            qu.poll()
        (This ensures the heap always contains only the k largest elements.)
    Step 3: After processing all elements, the root of the heap contains the kᵗʰ largest element.
    Step 4: Return qu.peek().
    (This is the kᵗʰ largest element in the array.)
Logic:
    • A min-heap of size k is maintained.
    • Smaller elements are removed when the heap exceeds size k.
    • The smallest element in the heap (root) is the kᵗʰ largest element in the array.
Time Complexity:
    Inserting each element into the heap takes O(log k).
    For n elements, total complexity = O(n log k)
Space Complexity:
    The heap stores at most k elements.
    Space Complexity = O(k)









                      ============> Code <================

  class Solution {
    public int findKthLargest(int[] nums, int k) {
        PriorityQueue<Integer> qu=new PriorityQueue<>();
        for(int n:nums){
            qu.offer(n);
            if(qu.size()>k){
                qu.poll();
            }
        }
        return qu.peek();
    }
}
