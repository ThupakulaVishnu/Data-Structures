Step-by-step algorithm for Inorder Traversal of a Binary Tree:

Step 1: Create an empty list al to store the traversal result.

Step 2: Define a recursive function inorderTraversal(root).

Step 3: Check if root is not null.

Sub-step 3a: Recursively call inorderTraversal(root.left)
(This visits all nodes in the left subtree.)

Sub-step 3b: Add the value of the current node (root.val) to the list al.
(This processes the current node.)

Sub-step 3c: Recursively call inorderTraversal(root.right)
(This visits all nodes in the right subtree.)

Step 4: If root is null, do nothing and return.
(Base condition of recursion.)

Step 5: After all recursive calls finish, return the list al.

Traversal Order:
Left → Root → Right

Time Complexity:
Each node is visited exactly once.
Time Complexity = O(n)

Space Complexity:
Recursion stack space in worst case (skewed tree) = O(n)
In balanced tree = O(log n)
List storage = O(n)

Overall Space Complexity = O(n)


      ---------------------------> Code <---------------------------------

  class Solution {
    List<Integer> al=new ArrayList<>();
    public List<Integer> inorderTraversal(TreeNode root) {
        if(root!=null){
            inorderTraversal(root.left);
            al.add(root.val);
            inorderTraversal(root.right);
        }
        return al;
    }
}
