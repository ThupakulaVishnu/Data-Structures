Step-by-step algorithm to find kth smallest element in a BST (optimized inorder traversal):
Step 1: Initialize variables.
       • Create global variable cout = 0 → counts visited nodes
       • Create global variable ans = -1 → stores kth smallest value
       • Create global variable found = false → stops traversal after finding answer
Step 2: Define main function kthSmallest(root, k)
       • Call helper function → find(root, k)
       • Return ans
Step 3: Define recursive function find(root, k)
       • Step 3a: Base case
        o If root == null → return
       • Step 3b: Traverse left subtree
        o Call → find(root.left, k)
       • Step 3c: Early stopping check
        o If found == true → return
       • Step 3d: Process current node
        o Increment count → cout++
        o If cout == k →
         • Set answer → ans = root.val
         • Set found = true
         • Return
       • Step 3e: Traverse right subtree
        o Call → find(root.right, k)
Step 4: Final result
       • kth smallest element is stored in ans
Time Complexity:
       • O(h) → going from root to the leftmost node (height of tree)
       • O(k) → visiting nodes in inorder until reaching the k-th element
       👉 Total = O(h + k)
Space Complexity:
       • Recursion stack height → O(h)
       • Worst case (skewed tree) → O(n)














  ==========> Code <===========

  class Solution {
    int ans=0,cout=0;
    boolean found=false;
    public int kthSmallest(TreeNode root, int k) {
        find(root,k);
        return ans;
    }
    public void find(TreeNode root,int k){
        if(root==null)return;

        find(root.left,k);

        if(found)return;

        cout++;
        if(cout==k){
            ans=root.val;
            found=true;
            return;
        }

        find(root.right,k);
    }
}
