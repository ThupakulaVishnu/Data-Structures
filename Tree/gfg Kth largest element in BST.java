Step-by-step algorithm to find kth largest element in a BST (reverse inorder traversal):
Step 1: Initialize variables.
• Create global variable cout = 0 → counts visited nodes
• Create global variable ans = -1 → stores kth largest value
Step 2: Define main function kthLargest(root, k)
• Call helper function → find(root, k)
• Return ans
Step 3: Define recursive function find(root, k)
• Step 3a: Base case
 o If root == null → return
• Step 3b: Traverse right subtree (largest elements first)
 o Call → find(root.right, k)
• Step 3c: Process current node
 o Increment count → cout++
 o If cout == k →
  • Set answer → ans = root.data
  • Return
• Step 3d: Traverse left subtree
 o Call → find(root.left, k)
Step 4: Final result
• kth largest element is stored in ans
Time Complexity:
• Reverse inorder traversal visits nodes → O(n)
Time Complexity = O(n)
Space Complexity:
• Recursion stack height → O(h)
• Worst case (skewed tree) → O(n)
Space Complexity = O(h)
Space Complexity = O(n) (worst case)










  ===========> Code <==========
  class Solution {
    int cout=0;
    int ans=-1;
    // return the Kth largest element in the given BST rooted at 'root'
    public int kthLargest(Node root, int k) {
        // Your code here
        find(root,k);
        return ans;
    }
    public void find(Node root,int k){
        if(root==null) return;
        
        find(root.right,k);
        
        cout++;
        if(cout==k){
            ans=root.data;
            return;
        }
        
        find(root.left,k);
    }
}
