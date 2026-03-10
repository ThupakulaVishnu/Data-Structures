Step-by-step algorithm to remove the Nth node from the end of a linked list:

Step 1: Create a new dummy node and connect it before the head of the list.
(This helps handle edge cases like removing the first node.)

Step 2: Set the next pointer of the dummy node to the head node.

Step 3: Initialize two pointers:

* **slow pointer**
* **fast pointer**

Both pointers start from the dummy node.

Step 4: Move the fast pointer forward **n + 1 steps**.

* Sub-step 4a: This creates a gap of **n nodes** between the slow and fast pointers.

Step 5: Start moving both pointers together.

* Sub-step 5a: Move the slow pointer one step forward.

* Sub-step 5b: Move the fast pointer one step forward.

Step 6: Continue this process until the fast pointer becomes null.

Step 7: At this point:

* The slow pointer will be positioned **just before the node that needs to be removed**.

Step 8: Remove the target node.

* Sub-step 8a: Update the next pointer of the slow node so that it skips the node to be deleted and connects directly to the next node after it.

Step 9: Return the head of the updated linked list.

* Sub-step 9a: Since a dummy node was used, return the node next to the dummy node.

Time Complexity:
The list is traversed only once.
Time Complexity = **O(n)**

Space Complexity:
Only pointer variables are used.
Space Complexity = **O(1)**






                            ===============> Code <===============

  class Solution {
    public ListNode removeNthFromEnd(ListNode head, int n) {
        ListNode dummy=new ListNode(0);
        dummy.next=head;

        ListNode slow=dummy;
        ListNode fast=dummy;

        for(int i=0;i<=n;i++){
            fast=fast.next;
        }

        while(fast!=null){
            slow=slow.next;
            fast=fast.next;
        }

        slow.next=slow.next.next;

        return dummy.next;
    }
}
