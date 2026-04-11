Step-by-step algorithm to reverse nodes in k-groups:
Step 1: Count k nodes from current head.
• Initialize c = 0, thead = head
• While thead != null and c < k:
 o Move thead = thead.next
 o Increment c++
Step 2: Check if there are fewer than k nodes.
• If c < k → less than k nodes → return head (no reversal)
Step 3: Reverse k nodes.
• Initialize pointers → curr = head, pre = null, next = head
• While c > 0:
 o Save next node → next = head.next
 o Reverse current link → head.next = pre
 o Move pre → pre = head
 o Move head → head = next
 o Decrement counter → c--
Step 4: Recurse for remaining nodes.
• If next != null → curr.next = reverseKGroup(next, k)
Step 5: Return new head of reversed segment.
• return pre
Time Complexity:
•	Suppose the linked list has n nodes and group size is k.
•	The function processes the list group by group, each group containing at most k nodes.
•	For each group, the code first traverses k nodes to check if the group exists → O(k).
•	Then it reverses exactly k nodes using the inner while loop → O(k).
•	So the total time per group = O(k + k) = O(k).
•	Number of groups = n / k.
•	Total time = number of groups × time per group = (n / k) * O(k) = O(n).
•	Therefore, the overall time complexity of the function is O(n), independent of k.
Space Complexity:
•	The code uses recursion for each group of k nodes.
•	Each recursive call adds a frame to the call stack.
•	Maximum recursion depth = number of groups = n / k.
•	No other significant extra memory is used besides a few pointers (pre, next, head).
•	Therefore, space complexity = O(n / k) due to the recursion stack.
•	If implemented iteratively, the space could be reduced to O(1).



























  ===================> code <=================

  class Solution {
    public ListNode reverseKGroup(ListNode head, int k) {
        int c=0;
        ListNode thead=head;
        while(thead!=null && c<k){
            thead=thead.next;
            c++;
        }

        if(c<k)return head;

        ListNode curr=head;
        ListNode pre=null, next=head;

        while(c>0){
            next=head.next;
            head.next=pre;
            pre=head;
            head=next;
            c--;
        }

        if(next!=null){
            curr.next=reverseKGroup(next,k);
        }
        return pre;
    }
}
