Step-by-step algorithm to find ceil in a BST:
Step 1: Initialize variable.
• Set ceil = -1 → stores the smallest value ≥ x
Step 2: Start traversal from root.
• While root != null:
 o Step 2a: If exact match found
  • If root.data == x → return root.data
 o Step 2b: If current node is less than x
  • If root.data < x →
   → Move right → root = root.right
 o Step 2c: If current node is greater than x
  • Update ceil → ceil = root.data
  • Move left → root = root.left
Step 3: Return result.
• Return ceil
Time Complexity:
• Traverse height of BST → O(h)
• Balanced BST → O(log n)
• Skewed BST → O(n)
Time Complexity = O(h)
Space Complexity:
• No extra space used → O(1)
Space Complexity = O(1)










  ========> Code <=======
  class Solution {
    int findCeil(Node root, int x) {
        // code here
        int cei=-1;
        
        while(root!=null){
            if(root.data==x){
                return x;
            }
            if(root.data<x){
                root=root.right;
            }else{
                cei=root.data;
                root=root.left;
            }
        }
        
        return cei;
    }
}
