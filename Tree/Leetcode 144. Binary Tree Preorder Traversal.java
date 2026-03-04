Step-by-step algorithm for Preorder Traversal of a Binary Tree:

Step 1: Create an empty list al to store the traversal result.

Step 2: Define a recursive function preorderTraversal(root).

Step 3: Check if root is not null.

Sub-step 3a: Add the value of the current node (root.val) to the list al.
(Process the current node first.)

Sub-step 3b: Recursively call preorderTraversal(root.left)
(Traverse the left subtree.)

Sub-step 3c: Recursively call preorderTraversal(root.right)
(Traverse the right subtree.)

Step 4: If root is null, do nothing and return.
(Base condition of recursion.)

Step 5: After all recursive calls finish, return the list al.

Traversal Order:
Root → Left → Right

Time Complexity:
Each node is visited exactly once.
Time Complexity = O(n)

Space Complexity:
Recursion stack space in worst case (skewed tree) = O(n)
In balanced tree = O(log n)
List storage = O(n)

Overall Space Complexity = O(n)






            -------------------> Code <---------------------

  class Solution {
    List<Integer> al=new ArrayList<>();
    public List<Integer> preorderTraversal(TreeNode root) {
        if(root!=null){
            al.add(root.val);
            preorderTraversal(root.left);
            preorderTraversal(root.right);
        }
        return al;
    }
}
