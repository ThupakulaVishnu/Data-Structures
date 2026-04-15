Step 1: Initialize adjacency list.
           • Create a list of lists al of size V
           • For each vertex i → al.add(new ArrayList<>())
Step 2: Build graph.
           • For each edge [u, v] in edges:
                     ○ Add edge → al.get(u).add(v)
Step 3: Initialize data structures.
           • Create result list ans → to store topological order
           • Create boolean array vist of size V → all values false
           • Create stack st → to temporarily store DFS order
Step 4: Perform DFS on each vertex.
           • For i = 0 to V-1:
                     ○ If vist[i] is false → call find(i, vist, st, al)
Step 5: DFS function find(node, vist, st, al).
           • Mark node as visited → vist[node] = true
           • For each neighbor nei in al.get(node):
                     ○ If vist[nei] is false → recursively call find(nei, vist, st, al)
           • Push node to stack → st.push(node)
Step 6: Build final topological order.
           • While stack st is not empty:
                     ○ Pop from stack and add to ans → ans.add(st.pop())
Step 7: Return result list ans.
Time Complexity Analysis:
           Step 1 (Initialize adjacency list) → O(V)
           Step 2 (Build graph from edges) → O(E) because each edge is processed once
           Step 4–5 (DFS) →
                     • Each vertex is visited once → O(V)
                     • For each vertex, all outgoing edges are checked once → O(E)
           Total Time Complexity → O(V + E)
Space Complexity Analysis:
           Adjacency list al → stores all vertices and edges → O(V + E)
           Visited array vist → O(V)
           Stack st for DFS → in worst case, recursion depth = number of vertices → O(V)
           Result list ans → stores all vertices → O(V)
           Total Space Complexity → O(V + E)























  ==============> Code <==========

  class Solution {
    List<List<Integer>> al=new ArrayList<>();
    public ArrayList<Integer> topoSort(int V, int[][] edges) {
        // code here
        
        for(int i=0;i<V;i++){
            al.add(new ArrayList<>());
        }
        
        for(int[] arr:edges){
            al.get(arr[0]).add(arr[1]);
        } 
        
        boolean[] bol=new boolean[V];
        
        Stack<Integer> st=new Stack<>();
        
        for(int i=0;i<V;i++){
            if(!bol[i]){
                find(i,bol,st);
            }
        }
        
        ArrayList<Integer> al=new ArrayList<>();
        
        while(!st.isEmpty()){
            al.add(st.pop());
        }
        
        return al;
    }
    public void find(int node,boolean[] bol,Stack<Integer> st){
        bol[node]=true;
        
        for(int j:al.get(node)){
            if(!bol[j]){
                find(j,bol,st);
            }
        }
        
        st.push(node);
    }
}
