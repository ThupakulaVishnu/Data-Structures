Step-by-step algorithm for DFS traversal of a graph:

Step 1: Get the number of vertices from the adjacency list:

size = adj.size()

Step 2: Create a boolean array bol of size size to track visited nodes.

Initially, all values are false.

Step 3: Create an empty ArrayList al to store the DFS traversal result.

Step 4: Call the recursive helper function:

find_dfs(0, adj, bol, al)
(Start DFS from node 0.)

Step 5: Inside the helper function find_dfs(node, adj, bol, al):

Sub-step 5a: Check if the current node is not visited:

If bol[node] == false:

Mark it as visited:
bol[node] = true

Add the node to the result list:
al.add(node)

Sub-step 5b: Traverse all adjacent nodes of the current node:

For each curr in adj.get(node):

If curr is not visited:

Recursively call:
find_dfs(curr, adj, bol, al)

Step 6: Continue recursion until all reachable nodes are visited.

Step 7: After recursion completes, return the list al.

Traversal Pattern:
Go deep into one branch before exploring other branches.

Time Complexity:
Each node is visited once.
Each edge is explored once.
Time Complexity = O(V + E)

Space Complexity:
Visited array = O(V)
Result list = O(V)
Recursion stack (worst case) = O(V)

Overall Space Complexity = O(V)





                      -----------------> Code <---------------

  class Solution {
    public ArrayList<Integer> dfs(ArrayList<ArrayList<Integer>> adj) {
        // code here
        int size=adj.size();
        boolean[] bol=new boolean[size];
        ArrayList<Integer> al=new ArrayList<>();
        find_dfs(0,adj,bol,al);
        return al;
    }
    public void find_dfs(int node,ArrayList<ArrayList<Integer>> adj,boolean[] bol,ArrayList<Integer> al){
        
        if(!bol[node]){
            bol[node]=true;
            al.add(node);
        }
        
        for(int curr:adj.get(node)){
            if(!bol[curr]){
                find_dfs(curr,adj,bol,al);
            }
        }
    }
}
