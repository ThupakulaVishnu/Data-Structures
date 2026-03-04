Step-by-step algorithm for Postorder Traversal of a Binary Tree:

Step 1: Create an empty list al to store the traversal result.

Step 2: Define a recursive function postorderTraversal(root).

Step 3: Check if root is not null.

Sub-step 3a: Recursively call postorderTraversal(root.left)
(Traverse the left subtree first.)

Sub-step 3b: Recursively call postorderTraversal(root.right)
(Traverse the right subtree next.)

Sub-step 3c: Add the value of the current node (root.val) to the list al.
(Process the current node at the end.)

Step 4: If root is null, do nothing and return.
(Base condition of recursion.)

Step 5: After all recursive calls finish, return the list al.

Traversal Order:
Left → Right → Root

Time Complexity:
Each node is visited exactly once.
Time Complexity = O(n)

Space Complexity:
Recursion stack space in worst case (skewed tree) = O(n)
In balanced tree = O(log n)
List storage = O(n)

Overall Space Complexity = O(n)



            -------------------> Code <------------------

  class Solution {
    List<Integer> al=new ArrayList<>();
    public List<Integer> postorderTraversal(TreeNode root) {
        if(root!=null){
            postorderTraversal(root.left);
            postorderTraversal(root.right);
            al.add(root.val);
        }
        return al;
    }
}
