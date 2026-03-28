Step-by-step algorithm to detect a cycle in an undirected graph using BFS:
Step 1: Initialize the required data structures.
 • Create an Adjacency List (ArrayList of ArrayList) to represent the graph.
 • Create a boolean array (visit[]) to track visited nodes.
 • Use a Queue (LinkedList) for BFS traversal.
Step 2: Build the graph from the given edges.
 • For each edge (u, v):
  o Add v to the adjacency list of u.
  o Add u to the adjacency list of v.
 • This is because the graph is undirected.
Step 3: Traverse all nodes to handle disconnected components.
 • Loop through all vertices from 0 to V-1.
 • If a node is not visited, start BFS from that node.
 • If BFS detects a cycle, return true.
Step 4: Start BFS traversal.
 • Insert a pair into the Queue containing:
  o Current node
  o Parent node (initialize parent as -1 for the starting node)
 • Mark the starting node as visited.
Step 5: Process nodes using BFS.
 • While the queue is not empty:
  o Remove the front element (current node and its parent).
 • Traverse all adjacent neighbors of the current node:
  • Sub-step 5a: If the neighbor is not visited:
   o Mark it as visited.
   o Add it to the queue with the current node as its parent.
  • Sub-step 5b: If the neighbor is already visited and is NOT the parent:
   o A cycle is detected.
   o Return true immediately.
Step 6: If BFS completes without finding a cycle.
 • Return false for that component.
Step 7: If all components are processed and no cycle is found.
 • Return false.
Time Complexity:
         Building adjacency list → O(V + E)
         BFS traversal (each node & edge once) → O(V + E)
       ✅ Overall Time Complexity = O(V + E)
Space Complexity:
 • Adjacency list → O(V + E)
 • Visited array → O(V)
 • Queue → O(V)
 • Total Space Complexity = O(V + E)























  ===============> code <==============



  class Solution {
    public boolean isCycle(int V, int[][] edges) {
        
        ArrayList<ArrayList<Integer>> adj = new ArrayList<>();
        for(int i = 0; i < V; i++){
            adj.add(new ArrayList<>());
        }
        
        // Build graph
        for(int[] e : edges){
            adj.get(e[0]).add(e[1]);
            adj.get(e[1]).add(e[0]);
        }
        
        boolean[] vis = new boolean[V];
        
        for(int i = 0; i < V; i++){
            if(!vis[i]){
                if(bfs(adj, i, vis)) return true;
            }
        }
        return false;
    }
    
    public boolean bfs(ArrayList<ArrayList<Integer>> adj, int start, boolean[] vis){
        
        Queue<int[]> q = new LinkedList<>();
        q.offer(new int[]{start, -1}); // {node, parent}
        vis[start] = true;
        
        while(!q.isEmpty()){
            int[] curr = q.poll();
            int node = curr[0];
            int parent = curr[1];
            
            for(int nei : adj.get(node)){
                if(!vis[nei]){
                    vis[nei] = true;
                    q.offer(new int[]{nei, node});
                } 
                else if(nei != parent){
                    return true; // cycle found
                }
            }
        }
        
        return false;
    }
}
