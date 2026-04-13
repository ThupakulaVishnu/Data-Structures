Step-by-step algorithm to construct binary tree from inorder and postorder traversal:
Step 1: Initialize variables.
• Create global index postinx → initialized to inorder.length - 1 → tracks current node in postorder
• Create hashmap hm → stores value → index mapping of inorder
Step 2: Build hashmap from inorder.
• For i = 0 to inorder.length - 1:
 o hm.put(inorder[i], i)
Step 3: Define main function buildTree(inorder, postorder)
• Call recursive function → find(postorder, 0, postinx)
• Return constructed tree root
Step 4: Define recursive function find(arr, l, r)
• Step 4a: Base case
 o If l > r → return null
• Step 4b: Create root node
 o Take current postorder value → arr[postinx]
 o Create node → head = new TreeNode(arr[postinx--])
• Step 4c: Find index in inorder
 o currinx = hm.get(head.val)
• Step 4d: Build right subtree first
 o Right subtree range → currinx + 1 to r
 o head.right = find(arr, currinx + 1, r)
• Step 4e: Build left subtree
 o Left subtree range → l to currinx - 1
 o head.left = find(arr, l, currinx - 1)
• Step 4f: Return node
 o Return head
Step 5: Final result
• Root of tree is returned from initial call
Time Complexity:
• Each node processed once → O(n)
Time Complexity = O(n)
Space Complexity:
• HashMap stores n elements → O(n)
• Recursion stack height → O(h)
Space Complexity = O(n)








  ===========> Code <==========

  class Solution {
    int postinx;
    Map<Integer,Integer> hm=new HashMap<>();
    public TreeNode buildTree(int[] inorder, int[] postorder) {
        postinx=inorder.length-1;
        for(int i=0;i<inorder.length;i++){
            hm.put(inorder[i],i);
        }

        return find(postorder,0,postinx);
    }
    public TreeNode find(int[] arr,int l,int r){
        if(l>r)return null;

        TreeNode head=new TreeNode(arr[postinx--]);

        int currinx=hm.get(head.val);

        head.right=find(arr,currinx+1,r);

        head.left=find(arr,l,currinx-1);

        return head;
    }
}
