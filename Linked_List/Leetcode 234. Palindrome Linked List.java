Step 1: Handle base cases.
    • If head == null OR head.next == null:
      ○ Return true (a single node or empty list is always a palindrome)
Step 2: Find the middle of the linked list.
    • Initialize two pointers:
      ○ slow = head
      ○ fast = head
    • Move pointers:
      ○ While fast != null AND fast.next != null:
        • slow = slow.next (moves 1 step)
        • fast = fast.next.next (moves 2 steps)
    • Result: slow will be at middle of the list
Step 3: Reverse the second half of the list.
    • Initialize pre = null
    • While slow != null:
      ○ Store next node → next = slow.next
      ○ Reverse link → slow.next = pre
      ○ Move pre forward → pre = slow
      ○ Move slow forward → slow = next
    • Result: pre is head of reversed second half
Step 4: Compare both halves.
    • Initialize:
      ○ first = head (start of first half)
      ○ second = pre (start of reversed second half)
    • While second != null:
      ○ If first.val != second.val → return false
      ○ Move both pointers forward
        • first = first.next
        • second = second.next
Step 5: If all values match.
    • Return true → linked list is a palindrome
Time Complexity Analysis:
    • Finding middle → O(n)
    • Reversing second half → O(n/2) ≈ O(n)
    • Comparing halves → O(n/2) ≈ O(n)
    • Total Time Complexity → O(n)
Space Complexity Analysis:
    • Only pointer variables used (no extra data structures)
    • In-place reversal → O(1) auxiliary space
    • Total Space Complexity → O(1)






















  ==============> Code <================

  /**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode() {}
 *     ListNode(int val) { this.val = val; }
 *     ListNode(int val, ListNode next) { this.val = val; this.next = next; }
 * }
 */
class Solution {
    public boolean isPalindrome(ListNode head) {
        if(head==null || head.next==null)return true;

        ListNode slow=head;
        ListNode fast=head;
        while(fast!=null && fast.next!=null){
            slow=slow.next;
            fast=fast.next.next;
        }

        ListNode pre=null;
        while(slow!=null){
            ListNode next=slow.next;
            slow.next=pre;
            pre=slow;
            slow=next;
        }

        ListNode first=head;
        ListNode second=pre;


        while(second!=null){
            if(first.val!=second.val){
                return false;
            }
            first=first.next;
            second=second.next;
        }
        return true;
    }
}
