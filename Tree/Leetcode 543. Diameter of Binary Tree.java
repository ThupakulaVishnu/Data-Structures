Step-by-step algorithm to find diameter of a binary tree:
Step 1: Initialize variable.
• Create a global variable sum = 0 → stores maximum diameter
Step 2: Define main function diameterOfBinaryTree(root)
• Call helper function → find(root)
• Return sum
Step 3: Define recursive function find(root)
• Step 3a: Base case
 o If root == null → return 0
• Step 3b: Find left subtree height
 o l = find(root.left)
• Step 3c: Find right subtree height
 o r = find(root.right)
• Step 3d: Update diameter
 o Diameter at current node = l + r
 o sum = max(sum, l + r)
• Step 3e: Return height of current node
 o return max(l, r) + 1
Step 4: Final result
• Maximum diameter is stored in sum
Time Complexity:
• Each node is visited once → O(n)
Time Complexity = O(n)
Space Complexity:
• Recursion stack height = O(h)
• Worst case (skewed tree) → O(n)
Space Complexity = O(h)
Space Complexity = O(n) (worst case)




















  ============> code <==========
  class Solution {
    int sum=0;
    public int diameterOfBinaryTree(TreeNode root) {
        find(root);
        return sum;
    }
    public int find(TreeNode root){
        if(root==null)return 0;
        int l=find(root.left);
        int r=find(root.right);
        sum=Math.max(sum,l+r);
        return Math.max(l,r)+1;
    }
}
