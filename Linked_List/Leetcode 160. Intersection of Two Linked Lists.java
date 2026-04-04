Step-by-step algorithm to find the intersection node of two singly linked lists:
Step 1: Initialize two pointers.
                      • Set h1 = headA
                      • Set h2 = headB
Step 2: Traverse both lists simultaneously until they meet.
                      • Loop while h1 != h2
                                             o Sub-step 2a: If h1 == null → move h1 to headB
                                             o Sub-step 2b: Else if h2 == null → move h2 to headA
                                             o Sub-step 2c: Else → move both pointers one step forward
                                              • h1 = h1.next
                                              • h2 = h2.next
Step 3: When h1 == h2, the intersection is found (could be null if no intersection).
Step 4: Return h1 as the intersection node.
Time Complexity:
1.	Each pointer traverses at most two lengths of the lists.
2.	Total time = O(m + n), where m and n are lengths of the lists.
                      Time Complexity = O(m + n)
Space Complexity:
                      Only two pointer variables are used.
                      Space Complexity = O(1)










  ==================> Code <==================
  public class Solution {
    public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
        ListNode h1=headA;
        ListNode h2=headB;

        while(h1!=h2){
            if(h1==null){
                h1=headB;
            }else if(h2==null){
                h2=headA;
            }else{
                h1=h1.next;
                h2=h2.next;
            }
        }

        return h1;
    }
}
