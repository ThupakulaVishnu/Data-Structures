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
        
        // Step 1: Initialize data structures
        ArrayList<ArrayList<Integer>> adj = new ArrayList<>();
        for(int i = 0; i < V; i++){
            adj.add(new ArrayList<>());
        }
        
        boolean[] visit = new boolean[V];
        
        // Step 2: Build the graph
        for(int[] e : edges){
            int u = e[0];
            int v = e[1];
            adj.get(u).add(v);
            adj.get(v).add(u);
        }
        
        // Step 3: Traverse all components
        for(int i = 0; i < V; i++){
            if(!visit[i]){
                if(bfs(i, adj, visit)) return true;
            }
        }
        
        // Step 7: No cycle found
        return false;
    }
    
    public boolean bfs(int start, ArrayList<ArrayList<Integer>> adj, boolean[] visit){
        
        // Step 4: Initialize queue with (node, parent)
        Queue<int[]> q = new LinkedList<>();
        q.offer(new int[]{start, -1});
        visit[start] = true;
        
        // Step 5: BFS traversal
        while(!q.isEmpty()){
            
            int[] curr = q.poll();
            int node = curr[0];
            int parent = curr[1];
            
            for(int nei : adj.get(node)){
                
                // Step 5a: If not visited
                if(!visit[nei]){
                    visit[nei] = true;
                    q.offer(new int[]{nei, node});
                }
                
                // Step 5b: If visited and not parent → cycle
                else if(nei != parent){
                    return true;
                }
            }
        }
        
        // Step 6: No cycle in this component
        return false;
    }
}
        return false;
    }
}
