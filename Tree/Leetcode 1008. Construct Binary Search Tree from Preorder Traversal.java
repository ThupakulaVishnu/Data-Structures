Step-by-step algorithm to construct a BST from preorder traversal:
Step 1: Define main function bstFromPreorder(preorder)
• Step 1a: If preorder is empty → return null
• Step 1b: Create root node → head = new TreeNode(preorder[0])
• Step 1c: For each element preorder[i] where i = 1 to preorder.length - 1 → call find(head, preorder[i])
• Step 1d: Return head as the root of the BST
Step 2: Define recursive function find(head, val)
• Step 2a: Base case
 o If head == null → return new TreeNode(val)
• Step 2b: Compare value with current node
 o If val < head.val → insert into left subtree → head.left = find(head.left, val)
 o Else → insert into right subtree → head.right = find(head.right, val)
• Step 2c: Return current node → return head
Step 3: Final result
• BST is returned with head as root
Time Complexity:
• Worst case (skewed tree) → O(n²)
•	You insert n elements one by one.
•	Each insertion can take O(n) in a skewed tree.
•	Total = n × O(n) = O(n²)
• Average case (balanced tree) → O(n log n)
•	Each insertion takes O(log n).
•	Total = n × O(log n) = O(n log n)
Time Complexity = O(n²) worst, O(n log n) average
Space Complexity:
• Worst case (skewed tree) → O(n)
•	Recursion stack can go up to height n
• Average case (balanced tree) → O(log n)
•	Recursion stack height = log n
• BST itself stores n nodes → O(n)
Space Complexity = O(n)
















  ===============> Code <==============

  class Solution {
    public TreeNode bstFromPreorder(int[] preorder) {
        if(preorder.length==0){
            return null;
        }
        TreeNode head=new TreeNode(preorder[0]);

        for(int i=1;i<preorder.length;i++){
            find(head,preorder[i]);
        }
        return head;
    }
    public TreeNode find(TreeNode head,int val){
        if(head==null)return new TreeNode(val);

        if(head.val>val){
            head.left=find(head.left,val);
        }else{
            head.right=find(head.right,val);
        }

        return head;
    }
}
