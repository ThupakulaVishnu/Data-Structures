Step-by-step algorithm for BFS traversal of a graph:

Step 1: Create an empty list `al` to store the BFS traversal result.

Step 2: Call the helper function:

* `find(0, adj, al)`
  (Start BFS from node 0.)

Step 3: Inside the function `find(node, adj, al)`:

Step 4: Create a boolean array `bol` of size equal to number of vertices.

* Initialize all values as false.
* This is used to track visited nodes.

Step 5: Create an empty Queue `qu`.

Step 6: Add the starting node into the queue:

* `qu.offer(node)`

Step 7: Mark the starting node as visited:

* `bol[node] = true`

Step 8: Repeat while the queue is not empty:

* Sub-step 8a: Get the current size of the queue:

  * `size = qu.size()`
    (This represents number of nodes at current level.)

* Sub-step 8b: Traverse all nodes at this level:

  * For i from 0 to size - 1:

    * Poll the front node from the queue:

      * `nd = qu.poll()`

    * Add this node to result list:

      * `al.add(nd)`

    * Traverse all adjacent nodes of `nd`:

      * For each `curr` in `adj.get(nd)`:

        * If `curr` is not visited (`bol[curr] == false`):

          * Add `curr` to queue:
            `qu.offer(curr)`

          * Mark `curr` as visited:
            `bol[curr] = true`

Step 9: Continue until the queue becomes empty.

Step 10: After traversal completes, return the list `al`.

Traversal Pattern:
Visit all neighbors first before moving to the next level.

Time Complexity:
Each node is visited once.
Each edge is explored once.
Time Complexity = O(V + E)

Space Complexity:
Visited array → O(V)
Queue → O(V)
Result list → O(V)

Overall Space Complexity = O(V)


            --------------> Code <-----------------

  class Solution {
    public ArrayList<Integer> bfs(ArrayList<ArrayList<Integer>> adj) {
        // code here
        ArrayList<Integer> al=new ArrayList<>();
        find(0,adj,al);
        return al;
    }
    public void find(int node,ArrayList<ArrayList<Integer>> adj,ArrayList<Integer> al){
        boolean[] bol=new boolean[adj.size()];
        Queue<Integer> qu=new LinkedList<>();
        qu.offer(node);
        bol[node]=true;
        
        while(!qu.isEmpty()){
            int size=qu.size();
            
            for(int i=0;i<size;i++){
                
                int nd=qu.poll();
                al.add(nd);
                for(int curr:adj.get(nd)){
                    if(bol[curr]==false){
                        qu.offer(curr);
                        bol[curr]=true;
                    }
                    
                }
            }
        }
        
    }
}
