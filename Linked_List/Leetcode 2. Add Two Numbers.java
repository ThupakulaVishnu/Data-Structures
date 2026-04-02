Step 1: Initialize variables.
           • Create a dummy node → `dummy = new ListNode(0)`
           • Set `curr = dummy` (to build the result list)
           • Initialize `carry = 0`

Step 2: Traverse the lists until all nodes and carry are processed.
           • Loop while `l1 != null` OR `l2 != null` OR `carry != 0`
           • Sub-step 2a: Initialize sum with carry → `sum = carry`
           • Sub-step 2b: Add value from `l1` if present →
                     ○ If `l1 != null` → `sum += l1.val`, `l1 = l1.next`
           • Sub-step 2c: Add value from `l2` if present →
                     ○ If `l2 != null` → `sum += l2.val`, `l2 = l2.next`
           • Sub-step 2d: Update carry and create new node →
                     ○ `carry = sum / 10`
                     ○ `curr.next = new ListNode(sum % 10)`
                     ○ Move `curr` → `curr = curr.next`

Step 3: Return the result.
           • Return `dummy.next` → result list

Time Complexity Analysis:
           • Each node of both lists is visited once → O(max(n, m))
           Total Time Complexity → O(max(n, m))

Space Complexity Analysis:
           • New linked list is created for result → O(max(n, m))
           Total Space Complexity → O(max(n, m))
















  =============> Code <==============

  class Solution {
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        ListNode dummy=new ListNode(0);
        ListNode curr=dummy;
        int carry=0;

        while(l1!=null || l2!=null || carry!=0){
            int sum=carry;

            if(l1!=null){
                sum+=l1.val;
                l1=l1.next;
            }

            if(l2!=null){
                sum+=l2.val;
                l2=l2.next;
            }
            
            carry=sum/10;
            dummy.next=new ListNode(sum%10);
            dummy=dummy.next;
        }
                                                                        
        return curr.next;
    }
}
