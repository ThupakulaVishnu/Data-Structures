Step 1: Initialize two pointers.
           • Set slow pointer s = head
           • Set fast pointer f = head
Step 2: Traverse the linked list.
           • While f != null AND f.next != null:
                     ○ Move slow pointer by one → s = s.next
                     ○ Move fast pointer by two → f = f.next.next
                     ○ If s == f → cycle detected, break
Step 3: Check for cycle.
           • If f == null OR f.next == null → no cycle, return false
           • Otherwise → cycle exists, return true
Time Complexity Analysis:
           • Each pointer moves through the list at most once → O(n)
           • Total Time Complexity → O(n)
Space Complexity Analysis:
           • Only two pointers used → O(1)
           • Total Space Complexity → O(1)
























  =============> Code <============

  public class Solution {
    public boolean hasCycle(ListNode head) {
        ListNode slow=head;
        ListNode fast=head;

        while(fast!=null && fast.next!=null){
            slow=slow.next;
            fast=fast.next.next;
            if(slow==fast){
                return true;
            }
        }
        return false;
    }
}
