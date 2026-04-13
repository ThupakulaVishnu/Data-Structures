Step-by-step algorithm to find maximum path sum in a binary tree:
Step 1: Initialize variable.
• Create a global variable sum
• Initialize sum = root.val
Step 2: Define main function maxPathSum(root)
• Call helper function → find(root)
• Return sum
Step 3: Define recursive function find(root)
• Step 3a: Base case
 o If root == null → return 0
• Step 3b: Find left contribution
 o l = max(0, find(root.left))
 o Ignore negative paths by taking max with 0
• Step 3c: Find right contribution
 o r = max(0, find(root.right))
 o Ignore negative paths
• Step 3d: Update maximum path sum
 o Path through current node = root.val + l + r
 o sum = max(sum, root.val + l + r)
• Step 3e: Return max path for parent
 o Return one side only → max(l, r) + root.val
Step 4: Final result
• Maximum path sum is stored in sum
Time Complexity:
• Each node is visited once → O(n)
Time Complexity = O(n)
Space Complexity:
• Recursion stack height = O(h)
• Worst case (skewed tree) → O(n)
Space Complexity = O(h)
Space Complexity = O(n) (worst case)











  ============> Code <=========

  class Solution {
    int sum;
    public int maxPathSum(TreeNode root) {
        sum=root.val;
        find(root);
        return sum;
    }
    public int find(TreeNode root){
        if(root==null)return 0;

        int l=Math.max(0,find(root.left));
        int r=Math.max(0,find(root.right));
        sum=Math.max(sum,root.val+l+r);
        return Math.max(l,r)+root.val;
    }
}
