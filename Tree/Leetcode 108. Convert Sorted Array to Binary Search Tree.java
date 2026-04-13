Step-by-step algorithm to construct a height-balanced BST from a sorted array:
Step 1: Define main function sortedArrayToBST(nums)
• Call recursive function → find(nums, 0, nums.length - 1)
• Return constructed BST root
Step 2: Define recursive function find(arr, l, r)
• Step 2a: Base case
 o If l > r → return null
• Step 2b: Find middle element
 o mid = l + (r - l) / 2
 o Middle element becomes root → head = new TreeNode(arr[mid])
• Step 2c: Build left subtree
 o Left range → l to mid - 1
 o head.left = find(arr, l, mid - 1)
• Step 2d: Build right subtree
 o Right range → mid + 1 to r
 o head.right = find(arr, mid + 1, r)
• Step 2e: Return node
 o Return head
Step 3: Final result
• Root of BST is returned from initial call
Time Complexity:
• Each element processed once → O(n)
Time Complexity = O(n)
Space Complexity:
• Recursion stack height = O(log n) (balanced tree)
The recursion stack stores nodes from root down to current leaf. 
For a balanced BST, the height = log₂(n). 
So at any moment, the stack holds at most log₂(n) nodes. 
Therefore, space complexity = O(log n).













  ===========> Code <=========
  class Solution {
    public TreeNode sortedArrayToBST(int[] nums) {
        return find(nums,0,nums.length-1);
    }
    public TreeNode find(int[] arr,int l,int r){
        if(l>r) return null;

        int mid=l+(r-l)/2;

        TreeNode head=new TreeNode(arr[mid]);

        head.left=find(arr,l,mid-1);

        head.right=find(arr,mid+1,r);

        return head;

    }
}
