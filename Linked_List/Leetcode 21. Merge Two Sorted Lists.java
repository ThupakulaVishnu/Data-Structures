Step-by-step algorithm to merge two sorted linked lists:

Step 1: Create a new dummy node.
(This node helps simplify the merging process.)

Step 2: Create another pointer called **head** and point it to the dummy node.
(This pointer will help return the final merged list.)

Step 3: Start traversing both linked lists while both lists still have nodes.

* Sub-step 3a: Compare the values of the current nodes of the two lists.

* Sub-step 3b: If the value in the first list is smaller:

  * Attach the node from the first list to the merged list.
  * Move the pointer of the first list to its next node.

* Sub-step 3c: Otherwise:

  * Attach the node from the second list to the merged list.
  * Move the pointer of the second list to its next node.

* Sub-step 3d: Move the dummy pointer forward to the newly added node.

Step 4: When one of the lists becomes empty, attach the remaining nodes of the other list.

* Sub-step 4a: If the first list still has nodes, connect all remaining nodes to the merged list.

* Sub-step 4b: Otherwise, connect the remaining nodes of the second list.

Step 5: Return the merged list starting from the node after the dummy node.

Logic:

* The dummy node acts as a starting placeholder.
* At every step, the smaller node from the two lists is attached to the result list.
* This maintains the sorted order.

Time Complexity:
Each node from both lists is visited exactly once.
Time Complexity = **O(n + m)**
(where n and m are lengths of the two lists)

Space Complexity:
No extra data structures are used.
Space Complexity = **O(1)**








              ==============> Code <==============

  class Solution {
    public ListNode mergeTwoLists(ListNode list1, ListNode list2) {
        ListNode dummy=new ListNode(0);
        ListNode head=dummy;
        while(list1!=null && list2!=null){
            if(list1.val<list2.val){
                dummy.next=list1;
                list1=list1.next;
            }else{
                dummy.next=list2;
                list2=list2.next;
            }
            dummy=dummy.next;
        }
        if(list1!=null){
            dummy.next=list1;
        }else{
            dummy.next=list2;
        }
        return head.next;
    }
}
