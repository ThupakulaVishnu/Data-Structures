Step-by-step algorithm to solve the M-Coloring problem:
Step 1: Initialize graph adjacency list.
• Create result = new ArrayList<>() of size v → one list for each vertex
Step 2: Fill adjacency list using edges.
• For each edge [u, v] in edges →
 o result.get(u).add(v)
 o result.get(v).add(u)
Step 3: Initialize color array.
• colour = new int[v] → all zeros initially (0 means uncolored)
Step 4: Start backtracking recursion.
• Call find(0, v, m, colour) → start coloring from node 0
Step 5: Define recursive function find(node, v, m, colour)
• Base Case: If node == v → all nodes colored → return true
• Step 5a: Try all colors from 1 to m for current node:
 o If issafe(node, i, colour) → number i can be assigned safely
  • Assign color → colour[node] = i
  • Recurse for next node → find(node+1, v, m, colour)
  • If recursion returns true → valid coloring found → return true
  • Else → backtrack → colour[node] = 0
• Step 5b: If no color fits → return false
Step 6: Define function issafe(node, col, colour)
• For each adjacent vertex v of node →
 o If colour[v] == col → return false (conflict)
• If no conflicts → return true
Step 7: Return true if coloring is possible, else false
________________________________________
Time Complexity:
For each node, we try m colors → O(m) per node
Let V = number of vertices
Worst-case time complexity = O(m^V)
Time Complexity = O(m^V)
Space Complexity:
Recursion stack can go up to V → O(V)
Color array uses O(V) space
Adjacency list uses O(V + E) space
Total space complexity = O(V + V + E) = O(V + E)
Space Complexity = O(V + E)





















class Solution {
    List<List<Integer>> result=new ArrayList<>();
    boolean graphColoring(int v, int[][] edges, int m) {
        // code here
        
        for(int i=0;i<v;i++){
            result.add(new ArrayList<>());
        }
        
        for(int[] c:edges){
            result.get(c[0]).add(c[1]);
            result.get(c[1]).add(c[0]);
        }
        
        int[] colour=new int[v];
        
        return find(0,v,m,colour);
    }
    public boolean find(int node,int v,int m,int[] colur){
        if(node==v){
            return true;
        }
        for(int i=1;i<=m;i++){
            if(issafe(node,i,colur)){
                colur[node]=i;
                
                if(find(node+1,v,m,colur))return true;
                
                colur[node]=0;
            }
        }
        return false;
    }
    public boolean issafe(int node,int col,int[] colur){
        for(int v:result.get(node)){
            if(colur[v]==col)return false;
        }
        return true;
    }
}
