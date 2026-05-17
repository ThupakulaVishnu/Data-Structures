Step 1: Initialize data structures.
    • Create TreeMap<Integer, List<int[]>> tm
      ○ Key → column index
      ○ Value → list of {row, node value}
    • Create Queue q for BFS traversal
Step 2: Start BFS traversal.
    • Add root node into queue → (root, row=0, col=0)
Step 3: Process nodes level by level.
    • While queue is not empty:
      ○ Remove current pair from queue
      ○ Extract node, row, col
Step 4: Store node in map.
    • If column not present → create new list
    • Add {row, node.val} into tm.get(col)
Step 5: Add children to queue.
    • If left child exists:
      ○ Add (node.left, row+1, col−1)
    • If right child exists:
      ○ Add (node.right, row+1, col+1)
Step 6: Traverse columns in sorted order.
    • TreeMap automatically keeps columns sorted
Step 7: Sort nodes inside each column.
    • For each column list:
      ○ Sort based on:
        • First by row (ascending)
        • If rows equal → by value (ascending)
Step 8: Build result list.
    • For each sorted list:
      ○ Extract only node values
      ○ Add to result list
Step 9: Return final result.
    • Return list of lists (vertical traversal)
Time Complexity Analysis:
    • BFS traversal visits all nodes → O(n)
    • Insertion into TreeMap → O(log n) per node → O(n log n)
    • Sorting each column: total elements across all columns = n → O(n log n)
    • Total Time Complexity → O(n log n)
Space Complexity Analysis:
    • TreeMap stores all nodes → O(n)
    • Queue stores nodes for BFS → O(n)
    • Auxiliary lists for result → O(n)
    • Total Space Complexity → O(n)


















  =============> Code <==============

  class Solution {
    public List<List<Integer>> verticalTraversal(TreeNode root) {
        TreeMap<Integer,List<int[]>> tm=new TreeMap<>();
        Queue<pair> q=new LinkedList<>();

        q.offer(new pair(root,0,0));

        while(!q.isEmpty()){
            pair curr=q.poll();
            TreeNode node=curr.node;
            int row=curr.row, col=curr.col;

            if(tm.get(col)==null){
                tm.put(col,new ArrayList<>());
            }
            tm.get(col).add(new int[]{row,node.val});

            if(node.left!=null){
                q.offer(new pair(node.left,row+1,col-1));
            }

            if(node.right!=null){
                q.offer(new pair(node.right,row+1,col+1));
            }
        }

        List<List<Integer>> ans=new ArrayList<>();

        for(int col:tm.keySet()){
            List<int[]> aal=tm.get(col);

            aal.sort((a,b)->{
                if(a[0]==b[0])return a[1]-b[1];
                       return a[0]-b[0]; 
            });
            
            List<Integer> temp=new ArrayList<>();
            for(int[] tp:aal){
                temp.add(tp[1]);
            }

            ans.add(new ArrayList<>(temp));
        }
        return ans;
    }
}
class pair{
    TreeNode node;
    int row;
    int col;
    pair(TreeNode node,int row,int col){
        this.node=node;
        this.row=row;
        this.col=col;
    }
}
