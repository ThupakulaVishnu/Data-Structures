Step-by-step algorithm to find maximum depth of a binary tree (DFS recursion):
Step 1: Define function maxDepth(root)
Step 2: Handle base case.
• If root == null → return 0
Step 3: Recursively find depth of left subtree.
• leftDepth = maxDepth(root.left)
Step 4: Recursively find depth of right subtree.
• rightDepth = maxDepth(root.right)
Step 5: Calculate current node depth.
• Take maximum of left and right depths and add 1
 → depth = max(leftDepth, rightDepth) + 1
Step 6: Return result.
• Return depth
Time Complexity:
• Each node is visited once → O(n)
Time Complexity = O(n)
Space Complexity:
• Recursion stack height = height of tree → O(h)
• Worst case (skewed tree) → O(n)
Space Complexity = O(h)
Space Complexity = O(n) (worst case)














  ===============> Code <=============


class Solution {
    public int maxDepth(TreeNode root) {
        if(root==null){
            return 0;
        }
        return Math.max(maxDepth(root.left),maxDepth(root.right))+1;
    }
}
