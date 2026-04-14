Step-by-step algorithm to find kth largest element using Min Heap:
Step 1: Initialize data structures.
• Create a min heap pq
• Store k in variable kk
Step 2: Constructor KthLargest(k, nums)
• Step 2a: Assign value
 o kk = k
• Step 2b: Add elements from array
 o For each element n in nums:
  • Add to heap → pq.offer(n)
  • If heap size exceeds k
   → remove smallest → pq.poll()
• Step 2c: After processing
 o Heap contains k largest elements
 o Top of heap = kth largest
Step 3: Define add(val) method
• Step 3a: Add new value
 o pq.offer(val)
• Step 3b: Maintain heap size
 o If pq.size() > kk
  → remove smallest → pq.poll()
• Step 3c: Return kth largest
 o Return pq.peek()
Step 4: Final behavior
• Heap always stores k largest elements
• Smallest in heap = kth largest element
Time Complexity:
• Constructor:
 o For n elements → each insertion O(log k)
 → O(n log k)
• add(val):
 o Insertion + possible removal → O(log k)
Time Complexity = Constructor: O(n log k), add(): O(log k)
Space Complexity:
• Heap stores at most k elements → O(k)
Space Complexity = O(k)








  =========> Code <=========

   class KthLargest {
    PriorityQueue<Integer> pq=new PriorityQueue<>();
    int kk;
    public KthLargest(int k, int[] nums) {
        kk=k;
        for(int n:nums){
            pq.offer(n);
            if(pq.size()>k){
                pq.poll();
            }
        }
    }
    
    public int add(int val) {
        pq.offer(val);
        if(pq.size()>kk){
            pq.poll();
        }
        return pq.peek();
    }
}
