Step-by-step algorithm to construct binary tree from preorder and inorder traversal:
Step 1: Initialize variables.
• Create global index preinx = 0 → tracks current node in preorder
• Create hashmap hm → stores value → index mapping of inorder
Step 2: Build hashmap from inorder.
• For i = 0 to n:
 o hm.put(inorder[i], i)
Step 3: Define main function buildTree(preorder, inorder)
• Call recursive function → find(preorder, 0, n)
• Return constructed tree root
Step 4: Define recursive function find(arr, l, r)
• Step 4a: Base case
 o If l > r → return null
• Step 4b: Create root node
 o Take current preorder value → arr[preinx]
 o Create node → head = new TreeNode(arr[preinx++])
• Step 4c: Find index in inorder
 o currinx = hm.get(head.val)
• Step 4d: Build left subtree
 o Left subtree range → l to currinx - 1
 o head.left = find(arr, l, currinx - 1)
• Step 4e: Build right subtree
 o Right subtree range → currinx + 1 to r
 o head.right = find(arr, currinx + 1, r)
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










  ============>code<============
  class Solution {
    int preinx=0;
    Map<Integer,Integer> hm=new HashMap<>();
    public TreeNode buildTree(int[] preorder, int[] inorder) {
        int n=inorder.length-1;
        for(int i=0;i<=n;i++){
            hm.put(inorder[i],i);
        }

        return find(preorder,0,n);
    }
    public TreeNode find(int[] arr,int l,int r){
        if(l>r)return null;

        TreeNode head=new TreeNode(arr[preinx++]);

        int currinx=hm.get(head.val);

        head.left=find(arr,l,currinx-1);

        head.right=find(arr,currinx+1,r);

        return head;
    }
}
