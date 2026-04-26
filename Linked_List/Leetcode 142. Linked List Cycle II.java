Step 1: Handle edge case.
    • If head == null:
      ○ Return null (no cycle possible in empty list)
Step 2: Initialize two pointers (Floyd’s Cycle Detection).
    • slow = head
    • fast = head
Step 3: Detect if cycle exists.
    • While fast != null AND fast.next != null:
      ○ Move slow one step → slow = slow.next
      ○ Move fast two steps → fast = fast.next.next
      ○ If slow == fast:
        • Cycle detected → break loop
Step 4: Check if cycle exists or not.
    • If fast == null OR fast.next == null:
      ○ Return null (no cycle found)
Step 5: Find the starting point of the cycle.
    • Initialize two pointers:
      ○ n1 = head
      ○ n2 = slow (meeting point inside cycle)
Step 6: Move both pointers step by step.
    • While n1 != n2:
      ○ Move n1 → n1 = n1.next
      ○ Move n2 → n2 = n2.next
Step 7: Return result.
    • Return n1 → starting node of the cycle
Time Complexity Analysis:
    • Cycle detection (Floyd’s algorithm) → O(n)
    • Finding cycle start → O(n)
    • Total Time Complexity → O(n)
Space Complexity Analysis:
    • Only constant pointers used (slow, fast, n1, n2)
    • No extra data structures
    • Total Space Complexity → O(1)



















  =================> Code <=================
  public class Solution {
    public ListNode detectCycle(ListNode head) {
        if(head==null)return head;

        ListNode slow=head;
        ListNode fast=head;
        while(fast!=null && fast.next!=null){
            slow=slow.next;
            fast=fast.next.next;
            if(slow==fast){
                break;
            }
        }

        if(fast==null || fast.next==null)return null;

        ListNode n1=head;
        ListNode n2=slow;

        while(n1!=n2){
            n1=n1.next;
            n2=n2.next;
        }

        return n1;
    }
}
