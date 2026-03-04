Step-by-step algorithm to flatten a binary tree into a linked list (in-place):

Step 1: Initialize a pointer curr and set it to root.

Step 2: Repeat while curr is not null:

Sub-step 2a: Check if curr.left is not null.

If left child exists:

Sub-step 2a(i): Store the left child in a temporary pointer
temp = curr.left

Sub-step 2a(ii): Store the same node in another pointer
templ = temp
(This keeps reference to the start of left subtree.)

Sub-step 2a(iii): Move to the rightmost node of the left subtree:

While temp.right is not null:

Move temp = temp.right

Sub-step 2a(iv): Attach the original right subtree to the
rightmost node of the left subtree:

temp.right = curr.right

Sub-step 2a(v): Make the left subtree the new right subtree:

curr.right = templ

Sub-step 2a(vi): Set the left child of current node to null:

curr.left = null

Sub-step 2b: Move to the next node in the flattened structure:

curr = curr.right

Step 3: Continue until all nodes are processed.

Final Result:
The tree is converted into a linked list using right pointers only.
The order will follow preorder traversal:
Root → Left → Right

Time Complexity:
Each node is visited once.
Time Complexity = O(n)

Space Complexity:
No extra data structures are used.
Only pointer variables are used.
Space Complexity = O(1)


              ---------------> Code <---------------

  class Solution {
    public void flatten(TreeNode root) {
        TreeNode curr=root;

        while(curr!=null){
            if(curr.left!=null){
                TreeNode temp=curr.left;
                TreeNode templ=temp;
                while(temp.right!=null){
                    temp=temp.right;
                }

                temp.right=curr.right;
                curr.right=templ;
                curr.left=null;
            }
            curr=curr.right;
        }
    }
}
