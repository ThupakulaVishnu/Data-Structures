Step-by-step algorithm for Right Side View of a Binary Tree:

Step 1: Create an empty list `al` to store the right side view elements.

Step 2: Call a helper function `right(root, al, 0)` where:

* `root` is the root node.
* `al` is the result list.
* `currDepth` starts from 0.

Step 3: Inside the helper function, check if `root` is null.

* Sub-step 3a: If root is null, return immediately.
  (Base condition of recursion.)

Step 4: Check if `currDepth == al.size()`.

* Sub-step 4a: If true:

  * Add `root.val` to the list `al`.
    (This ensures we add the first node seen at this depth.)

Step 5: Recursively call the helper function for the right subtree:

* `right(root.right, al, currDepth + 1)`
  (Visit right side first.)

Step 6: Recursively call the helper function for the left subtree:

* `right(root.left, al, currDepth + 1)`
  (Visit left side after right.)

Step 7: Continue this process until all nodes are visited.

Step 8: Return the list `al` containing the rightmost node at each depth.

Reasoning:
Since we visit the right child before the left child,
the first node encountered at each depth is the visible node from the right side.

Time Complexity:
Each node is visited exactly once.
Time Complexity = O(n)

Space Complexity:
Recursion stack space:

* Worst case (skewed tree) = O(n)
* Balanced tree = O(log n)

Result list storage = O(n)

Overall Space Complexity = O(n)



                ------------> Code <-------------

  class Solution {
    public List<Integer> rightSideView(TreeNode root) {
        List<Integer> al=new ArrayList<>();
        right(root,al,0);
        return al;
    }
    public void right(TreeNode root,List<Integer> al,int currDepth){
        if(root==null){
            return;
        }

        if(currDepth==al.size()){
            al.add(root.val);
        }

        right(root.right,al,currDepth+1);
        right(root.left,al,currDepth+1);
    }
}
