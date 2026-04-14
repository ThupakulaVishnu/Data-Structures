Step-by-step algorithm to find floor in a BST:
Step 1: Initialize variable.
• Set floor = -1 → stores the largest value ≤ x
Step 2: Start traversal from root.
• While root != null:
 o Step 2a: If exact match found
  • If root.data == x → return root.data
 o Step 2b: If current node is less than x
  • If root.data < x →
   → Update floor → floor = root.data
   → Move right → root = root.right
 o Step 2c: If current node is greater than x
  • Move left → root = root.left
Step 3: Return result.
• Return floor
Time Complexity:
• Traverse height of BST → O(h)
• Balanced BST → O(log n)
• Skewed BST → O(n)
Time Complexity = O(h)
Space Complexity:
• No extra space used → O(1)
Space Complexity = O(1)













  ============> Code <===========

  class Solution {
    public int findMaxFork(Node root, int k) {
        // code here
        int floor=-1;
        
        while(root!=null){
            if(root.data==k){
                return k;
            }
            if(root.data<k){
                floor=root.data;
                root=root.right;
            }else{
                root=root.left;
            }
        }
        
        return floor;
    }
}
