Step 1: Initialize adjacency list.
                        • Create a list of lists al of size V
                        • For each vertex i → al.add(new ArrayList<>())
Step 2: Build graph.
                        • For each edge [u, v, w] in edges:
                                                ○ Add edge → al.get(u).add(new int[]{v, w})
                                                ○ Add reverse edge → al.get(v).add(new int[]{u, w})
Step 3: Initialize data structures.
                        • Create distance array ans of size V
                        • Initialize all values to Integer.MAX_VALUE
                        • Set source distance → ans[src] = 0
                        • Create min-heap pq → stores {node, distance}
                        • Add source → pq.offer(new int[]{src, 0})
Step 4: Process nodes using priority queue.
                        • While pq is not empty:
                                                ○ Remove minimum distance node → cur = pq.poll()
                                                ○ Extract u = cur[0], d = cur[1]
Step 5: Relax all adjacent edges.
                        • For each neighbor nei in al.get(u):
                                                ○ v = nei[0], w = nei[1]
                                                ○ If ans[u] + w < ans[v] →
                        • Update distance → ans[v] = ans[u] + w
                        • Add updated node to heap → pq.offer(new int[]{v, ans[v]})
Step 6: Repeat until all nodes are processed.
Step 7: Return distance array ans.
Time Complexity Analysis:
                        • Step 1 (initialize adjacency list) → O(V)
                        • Step 2 (build graph) → O(E)
                        • Step 4–5 (Dijkstra using priority queue) →
                        • Each node can be inserted into heap multiple times → O(E log V)
                        • Each edge is relaxed once → O(E)
                        Sparse graphs → E ~ V → log(V + E) ≈ log(2V) = log V + constant → O(log V) 
                        Dense graphs → E ~ V² → log(V + E) ≈ log(V²) = 2 log V → O(log V) ignoring constant factor
                                                 Total Time Complexity → O((V + E) log V)
Space Complexity Analysis:
                        • Adjacency list al → stores all edges → O(V + E)
                        • Distance array ans → O(V)
                        • Priority queue pq → can store up to O(E) elements
                        Total Space Complexity → O(V + E)













  =============> Code <===========

  
class Solution {
    public int[] dijkstra(int V, int[][] edges, int src) {
        // code here
        List<List<int[]>> al=new ArrayList<>();
        for(int i=0;i<V;i++){
            al.add(new ArrayList<>());
        }
        
        for(int[] curr:edges){
            al.get(curr[0]).add(new int[]{curr[1],curr[2]});
            al.get(curr[1]).add(new int[]{curr[0],curr[2]});
        }
        
        int[] ans=new int[V];
        
        PriorityQueue<int[]> pq=new PriorityQueue<>((a,b)->a[1]-b[1]);
        
        Arrays.fill(ans,Integer.MAX_VALUE);
        ans[src]=0;
        pq.offer(new int[]{src,0});
        
        while(!pq.isEmpty()){
            int[] cur=pq.poll();
            int u=cur[0];
            int d=cur[1];
            
            for(int[] nei:al.get(u)){
                int v=nei[0],w=nei[1];
                if(ans[u]+w<ans[v]){
                    ans[v]=ans[u]+w;
                    pq.offer(new int[]{v,ans[v]});
                }
            }
        }
        return ans;
    }
}
