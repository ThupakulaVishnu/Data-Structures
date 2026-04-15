Step-by-step algorithm for Topological Sort using BFS (Kahn’s Algorithm):
Step 1: Initialize adjacency list.
• Create a list of lists al of size V
• For each vertex i → al.add(new ArrayList<>())
Step 2: Initialize indegree array.
• Create array arr of size V → stores indegree of each node
• Initially all values = 0
Step 3: Build graph and indegree.
• For each edge [u, v] in edges:
 o Add edge → al.get(u).add(v)
 o Increase indegree of v → arr[v]++
Step 4: Add nodes with indegree 0 to queue.
• Create queue q
• For i = 0 to V-1:
 o If arr[i] == 0 → q.offer(i)
Step 5: Initialize result list.
• Create list ans to store topological order
Step 6: Process nodes using BFS.
• While queue is not empty:
 o Step 6a: Remove node from queue
  • nm = q.poll()
 o Step 6b: Add node to result
  • ans.add(nm)
 o Step 6c: Reduce indegree of neighbors
  • For each neighbor nei in al.get(nm)
   • Decrease indegree → arr[nei]--
   • If indegree becomes 0
    → add to queue → q.offer(nei)
Step 7: Return result.
• Return ans
Time Complexity:
• Building graph → O(E)
• Processing each node and edge once → O(V + E)
Time Complexity = O(V + E)
Space Complexity:
• Adjacency list → O(V + E)
• Indegree array → O(V)
• Queue → O(V)
• Result list → O(V)
Space Complexity = O(V + E)










  ===========> Code <=========

  class Solution {
    public ArrayList<Integer> topoSort(int V, int[][] edges) {
        // code here
         List<List<Integer>> al=new ArrayList<>();
        int[] arr=new int[V];
        
        for(int i=0;i<V;i++){
            al.add(new ArrayList<>());
        }
        
        for(int[] curr:edges){
            al.get(curr[0]).add(curr[1]);
            arr[curr[1]]++;
        }
        
        Queue<Integer> q=new LinkedList<>();
        
        for(int i=0;i<V;i++){
            if(arr[i]==0){
                q.offer(i);
            }
        }
        
        ArrayList<Integer> ans=new ArrayList<>();
        
        while(!q.isEmpty()){
            int num=q.poll();
            ans.add(num);
            
            for(int h:al.get(num)){
                arr[h]--;
                if(arr[h]==0){
                    q.offer(h);
                }
            }
        }
        
        return ans;
    }
}
