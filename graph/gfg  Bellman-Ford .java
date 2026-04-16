Step 1: Initialize distance array.
           • Create array ans of size V
           • Fill all values with 100000000 → Arrays.fill(ans, 100000000)
           • Set source distance → ans[src] = 0
Step 2: Relax edges repeatedly.
           • Loop i = 0 to V-2 (total V-1 iterations)
           • For each edge [u, v, w] in edges:
                     ○ If ans[u] != 100000000 and ans[u] + w < ans[v] → update ans[v] = ans[u] + w
Step 3: Check for negative weight cycles.
           • For each edge [u, v, w] in edges:
                     ○ If ans[u] != 100000000 and ans[u] + w < ans[v] → return {-1} (negative cycle detected)
Step 4: Return the distance array.
           • Return ans → distances from src to all vertices
Time Complexity Analysis:
           • Step 1 (initialize distance array) → O(V)
           • Step 2 (relax edges V-1 times) → O(V * E)
           • Step 3 (check for negative cycles) → O(E)
           Total Time Complexity → O(V * E)
Space Complexity Analysis:
           • Distance array ans → O(V)
           • No other significant extra space is used
           Total Space Complexity → O(V)
















  ============> Code <===========
  // User function Template for Java

class Solution {
    public int[] bellmanFord(int V, int[][] edges, int src) {
        // code here
        List<List<int[]>> al=new ArrayList<>();
        
        for(int i=0;i<V;i++){
            al.add(new ArrayList<>());
        }
        
        for(int[] curr:edges){
            al.get(curr[0]).add(new int[]{curr[1],curr[2]});
        }
        
        int[] ans=new int[V];
        Arrays.fill(ans,(int)1e8);
        ans[src]=0;
        
        for(int i=0;i<V-1;i++){
            for(int u=0;u<V;u++){
                for(int vw[]:al.get(u)){
                    int v=vw[0], wt=vw[1];
                    
                    if(ans[u]!=(int)1e8 && ans[u]+wt<ans[v]){
                        ans[v]=ans[u]+wt;
                    }
                }
            }
        }
        
        for(int u=0;u<V;u++){
            for(int vw[]:al.get(u)){
                int v=vw[0], wt=vw[1];
                
                if(ans[u]!=(int)1e8 && ans[u]+wt<ans[v]){
                    return new int[]{-1};
                }
            }
        }
        
        return ans;
    }
}
