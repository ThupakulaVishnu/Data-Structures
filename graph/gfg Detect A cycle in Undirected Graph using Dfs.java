Step-by-step algorithm to detect a cycle in an undirected graph using DFS:
Step 1: Initialize the required data structures.
 • Create an Adjacency List (List of Lists) to represent the graph.
 • Create a boolean array (bol[]) to track visited nodes.
Step 2: Build the graph from the given edges.
 • For each edge (u, v):
  o Add v to the adjacency list of u.
  o Add u to the adjacency list of v.
 • This ensures the graph is undirected.
Step 3: Traverse all vertices to handle disconnected components.
 • Loop through each node from 0 to V-1.
 • If a node is not visited, start DFS from that node.
 • If DFS detects a cycle, return true.
Step 4: Start DFS traversal with parent tracking.
 • Pass three values to DFS:
  o Current node (st)
  o Parent node (par)
  o Visited array and adjacency list
Step 5: Mark the current node as visited.
 • Set bol[st] = true.
Step 6: Traverse all adjacent nodes of the current node.
 • Sub-step 6a: If the neighbor is not visited:
  o Recursively call DFS for that neighbor.
  o Pass current node as the parent.
  o If the recursive call returns true, propagate true upward.
 • Sub-step 6b: If the neighbor is already visited and not the parent:
  o A cycle is detected.
  o Return true immediately.
Step 7: If all neighbors are processed and no cycle is found.
 • Return false.
Step 8: If all components are checked and no cycle is found.
 • Return false.
Logic:
 • Uses Depth First Search (DFS) to explore the graph.
 • In an undirected graph, visiting a node again does not always mean a cycle.
 • A cycle exists only when a visited node is reached that is not the parent.
 • Parent tracking prevents false cycle detection.
Time Complexity:
 • Each node and edge is visited once.
 • Time Complexity = O(V + E)
Space Complexity:
 • Adjacency list → O(V + E)
 • Visited array → O(V)
 • Recursion stack → O(V)
 • Total Space Complexity = O(V + E)











  ======================> Code <=====================

  class Solution {
    public boolean isCycle(int V, int[][] edges) {
        // Code here
        int E=edges.length;
        
        ArrayList<List<Integer>> al=new ArrayList<>();
        for(int i=0;i<V;i++){
            al.add(new ArrayList<>());
        }
        
        for(int i=0;i<E;i++){
            al.get(edges[i][0]).add(edges[i][1]);
            al.get(edges[i][1]).add(edges[i][0]);
        }
        
        boolean[] bol=new boolean[V];
        
        for(int i=0;i<V;i++){
            if(!bol[i]){
                if(find(al,i,-1,bol))return true;
            }
        }
        return false;
    }
    public boolean find(ArrayList<List<Integer>> al,int st,int par,boolean[] bol){
        
        bol[st]=true;
        
        for(int u:al.get(st)){
            if(!bol[u]){
                if(find(al,u,st,bol))return true;
            }else if(u!=par){
                return true;
            }
        }
        return false;
        
    }
}
