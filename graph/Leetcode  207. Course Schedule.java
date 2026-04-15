Step 1: Initialize adjacency list
• Create a list of lists al to represent graph of course dependencies.
• For each course i from 0 to numCourses-1 → al.add(new ArrayList<>()).
Step 2: Build graph
• For each prerequisite pair [a, b] in prerequisites → add a as a neighbor of b in al → al.get(b).add(a)
 (This means to take course a, you must first complete course b)
Step 3: Initialize visit array
• visit array of size numCourses
 o 0 → unvisited
 o 1 → visiting (in current DFS path)
 o 2 → visited (no cycle detected)
Step 4: DFS for each course
• For each course i from 0 to numCourses-1
 o Call find(i, al, visit)
 o If find returns false → cycle detected → return false
Step 5: Define DFS function find(node, al, visit)
• Step 5a: Check for cycle
 o If visit[node] == 1 → node is in current DFS path → cycle → return false
• Step 5b: Already safe
 o If visit[node] == 2 → node already processed → return true
• Step 5c: Mark node as visiting → visit[node] = 1
• Step 5d: Visit neighbors
 o For each neighbor nei in al.get(node)
  • If find(nei, al, visit) returns false → return false
• Step 5e: Mark node as visited → visit[node] = 2 → return true
Step 6: Return result
• If all DFS calls return true → return true → all courses can be finished
Time Complexity:
• Building adjacency list → O(P), P = number of prerequisites
• DFS traversal → O(V + E), V = numCourses, E = number of edges (prerequisites)
• Total time = O(V + E)
Space Complexity:
• Adjacency list → O(V + E)
• Visit array → O(V)
• Recursion stack → O(V) in worst case (all nodes in a single DFS path)
• Total space = O(V + E)



















  ============>Code<===========

  class Solution {
    List<List<Integer>> al=new ArrayList<>();
    public boolean canFinish(int numCourses, int[][] prerequisites) {
        for(int i=0;i<numCourses;i++){
            al.add(new ArrayList<>());
        }

        for(int[] arr:prerequisites){
            al.get(arr[1]).add(arr[0]);
        }

        int[] bol=new int[numCourses];

        for(int i=0;i<numCourses;i++){
            if(find(i,bol))return false;
        }
        return true;
    }
    public boolean find(int node,int[] bol){
        if(bol[node]==1)return true;
        if(bol[node]==2)return false;

        bol[node]=1;

        for(int j:al.get(node)){
            if(find(j,bol))return true;
        }

        bol[node]=2;
        return false;
    }
}
