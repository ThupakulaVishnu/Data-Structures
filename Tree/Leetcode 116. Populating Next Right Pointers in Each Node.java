Step-by-step algorithm for connecting next pointers in a perfect binary tree:

Step 1: Initialize a pointer leftmost and set it to root.

Step 2: Repeat while:

leftmost is not null

and leftmost.left is not null
(This ensures we still have another level below.)

Step 3: Set a pointer curr equal to leftmost.
(This will traverse the current level.)

Step 4: Traverse the current level using curr:

Sub-step 4a: Connect the left child to the right child:

curr.left.next = curr.right

Sub-step 4b: Check if curr.next is not null:

If true:

Connect the right child to the next node’s left child:

curr.right.next = curr.next.left

Sub-step 4c: Move to the next node in the same level:

curr = curr.next

Step 5: After finishing the entire current level,
move down to the next level:

leftmost = leftmost.left

Step 6: Repeat the process until all levels are connected.

Step 7: Return the root node.

Logic Explanation:

First, connect nodes inside the same parent.

Then connect nodes across different parents using the next pointer.

Move level by level from top to bottom.

Time Complexity:
Each node is visited once.
Time Complexity = O(n)

Space Complexity:
No extra data structures used.
Only pointers are used.
Space Complexity = O(1)



                    -----------------> Code <----------------------

  class Solution {
    public Node connect(Node root) {
        Node leftmost = root;
        
        while (leftmost != null && leftmost.left!=null) {
            Node curr = leftmost;
            while (curr != null) {
                curr.left.next = curr.right;

                if (curr.next != null) {
                    curr.right.next = curr.next.left;
                }
                curr = curr.next;
            }
            leftmost = leftmost.left;
        }
        return root;
    }
}
