Step-by-step algorithm to search for a value in a Binary Search Tree (BST) using the BST property:
Step 1: Check if the current node is null or matches the target value.
 • If root == null, return null because the value is not present in the tree.
 • If root.val == val, return the current node.
  o This means the target value is found, and the subtree rooted at this node can be returned.
Step 2: Compare the target value with the current node’s value.
 • If val is smaller than root.val, the target can only exist in the left subtree.
  o Recursively call searchBST(root.left, val) and return the result.
 • If val is greater than root.val, the target can only exist in the right subtree.
  o Recursively call searchBST(root.right, val) and return the result.
Logic:
 • Uses the BST property: left child values are smaller and right child values are larger than the current node.
 • This allows skipping one entire subtree at each step, reducing unnecessary searches.
 • Recursion continues until the value is found or a null node is reached.
Time Complexity:
 • In a balanced BST, the search follows a path from root to leaf.
 • Time Complexity = O(h), where h is the height of the tree.
 • In the worst case (skewed tree), h = n, so Time Complexity = O(n).
Space Complexity:
 • Space used by recursion stack is proportional to the height of the tree.
 • Space Complexity = O(h)


















  =======================> Code <==================

  /**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode() {}
 *     TreeNode(int val) { this.val = val; }
 *     TreeNode(int val, TreeNode left, TreeNode right) {
 *         this.val = val;
 *         this.left = left;
 *         this.right = right;
 *     }
 * }
 */
class Solution {
    public TreeNode searchBST(TreeNode root, int val) {
        if(root==null)return root;
        if(root.val==val)return root;

        if(root.val>val){
            return searchBST(root.left,val);
        }

            return searchBST(root.right,val);
    }
}
