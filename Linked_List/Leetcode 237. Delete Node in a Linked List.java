Step 1: Copy value from next node.
           • Set node.val = node.next.val
Step 2: Check if the next node is the last node.
           • If node.next.next == null →
                     ○ Remove the next node by setting node.next = null
                     ○ Return
Step 3: If next node is not the last node.
           • Skip the next node by setting node.next = node.next.next
Step 4: End of operation.
Time Complexity Analysis:
           • Only constant operations are performed → O(1)
           Total Time Complexity → O(1)
Space Complexity Analysis:
           • No extra space is used → O(1)
           Total Space Complexity → O(1)



















  ================> Code <=================

  class Solution {
    public void deleteNode(ListNode node) {
        node.val=node.next.val;

        if(node.next.next==null){
            node.next=node.next.next;
            return;
        }
        node.next=node.next.next;
    }
}
