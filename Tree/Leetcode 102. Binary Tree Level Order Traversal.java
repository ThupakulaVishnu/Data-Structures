Step-by-step algorithm for Binary Tree Level Order Traversal (BFS):
Step 1: Handle edge case.
• If root == null → return empty list
Step 2: Initialize data structures.
• Create a queue q → to store nodes
• Create result list ans → to store level-wise values
• Add root to queue → q.offer(root)
Step 3: Traverse tree level by level.
• While queue is not empty:
 o Step 3a: Get current level size
  • size = q.size()
 o Step 3b: Create list for current level
  • al = new ArrayList<>()
 o Step 3c: Process all nodes of current level
  • For i = 0 to size - 1:
   • Remove node from queue → curr = q.poll()
   • Add value to level list → al.add(curr.val)
   • If left child exists → q.offer(curr.left)
   • If right child exists → q.offer(curr.right)
 o Step 3d: Add current level to result
  • ans.add(new ArrayList<>(al))
Step 4: Return result.
• Return ans
Time Complexity:
• Each node is visited once → O(n)
Time Complexity = O(n)
Space Complexity:
• Queue stores nodes of one level → O(n) (worst case)
•	The largest level can have up to n/2 nodes.
•	Even though nodes are removed as we process them, their children are added immediately.
•	Maximum space used is dominated by the largest level → O(n)
• Output list stores all nodes → O(n)
Space Complexity = O(n)
























  =================> Code <=============

  class Solution {
    public List<List<Integer>> levelOrder(TreeNode root) {
        if(root==null){
            return new ArrayList<>();
        }
        Queue<TreeNode> q=new LinkedList<>();
        List<List<Integer>> ans=new ArrayList<>();
        q.offer(root);

        while(!q.isEmpty()){
            int size=q.size();
            List<Integer> al=new ArrayList<>();
            for(int i=0;i<size;i++){
                TreeNode curr=q.poll();
                al.add(curr.val);
                if(curr.left!=null){
                    q.offer(curr.left);
                }
                if(curr.right!=null){
                    q.offer(curr.right);
                }
            }
            ans.add(new ArrayList<>(al));
        }
        return ans;
    }
}
