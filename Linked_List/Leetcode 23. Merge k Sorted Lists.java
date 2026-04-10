Step-by-step algorithm to merge k sorted linked lists:
Step 1: Initialize a Min Heap (Priority Queue).
• Each element in the heap is a ListNode
• Heap is ordered by node value → smallest node at top
Step 2: Insert the head of each linked list into the heap.
• For each curr in lists array →
 o If curr != null → pq.offer(curr)
Step 3: Initialize dummy node and pointer for result.
• ans = new ListNode(0) → dummy head
• temp = ans → pointer to build merged list
Step 4: Process the heap until empty.
• While heap is not empty:
 o Step 4a: Remove smallest node → curr = pq.poll()
 o Step 4b: Append it to merged list →
  • temp.next = curr
  • Move pointer → temp = temp.next
 o Step 4c: If the removed node has a next node →
  • Insert next node into heap → pq.offer(temp.next)
Step 5: Return merged list
• return ans.next → skip dummy head
Time Complexity:
• Let k = number of lists, n = total number of nodes across all lists
• Each node is inserted and removed from heap once → O(log k) per operation
• Total operations = n → Total time = O(n log k)
Time Complexity = O(n log k)
Space Complexity:
• Heap stores at most k nodes at a time → O(k)
• Merged list uses O(n) for the nodes themselves (already existing)
• Total extra space = O(k)
Space Complexity = O(k)



















  ==============> Code <=============
  class Solution {
    public ListNode mergeKLists(ListNode[] lists) {
        PriorityQueue<ListNode> pq=new PriorityQueue<>((a,b)->a.val-b.val);

        for(ListNode curr:lists){
            if(curr!=null)pq.offer(curr);
        }

        ListNode ans=new ListNode(0);
        ListNode temp=ans;

        while(!pq.isEmpty()){
            ListNode curr=pq.poll();
            temp.next=curr;
            temp=temp.next;

            if(temp.next!=null){
                pq.offer(temp.next);
            }
        }

        return ans.next;
    }
}
