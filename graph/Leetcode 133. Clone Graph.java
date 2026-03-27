Step-by-step algorithm to clone a graph using DFS and HashMap:
Step 1: Initialize the required data structure.
 • Create a HashMap to store mapping from original node → cloned node.
 • This helps in avoiding duplicate cloning and handling cycles in the graph.
Step 2: Handle the base case.
 • If the given node is null, return null.
  o This means there is no graph to clone.
Step 3: Check if the current node is already cloned.
 • If the node exists in the HashMap:
  o Return the already created cloned node.
  o This avoids infinite recursion in cyclic graphs.
Step 4: Create a clone of the current node.
 • Create a new node with the same value as the original node.
 • Store this mapping in the HashMap (original → clone).
Step 5: Clone all neighbors of the current node.
 • Traverse each neighbor of the original node.
 • For every neighbor:
  o Recursively call the clone function.
  o Add the returned cloned neighbor to the neighbors list of the cloned node.
Step 6: Return the cloned node.
 • After processing all neighbors, return the cloned node.
Logic:
 • The graph is traversed using Depth First Search (DFS).
 • The HashMap ensures each node is cloned only once.
 • It also helps in correctly connecting neighbors, even in the presence of cycles.
 • Recursion builds the graph structure step by step.
Time Complexity:
 • Each node and edge is visited once.
 • Time Complexity = O(V + E)
  (where V = number of nodes, E = number of edges)
Space Complexity:
 • HashMap stores all nodes → O(V)
 • Recursion stack → O(V) in worst case
 • Total Space Complexity = O(V)











  ===============> Code <============
/*
// Definition for a Node.
class Node {
    public int val;
    public List<Node> neighbors;
    public Node() {
        val = 0;
        neighbors = new ArrayList<Node>();
    }
    public Node(int _val) {
        val = _val;
        neighbors = new ArrayList<Node>();
    }
    public Node(int _val, ArrayList<Node> _neighbors) {
        val = _val;
        neighbors = _neighbors;
    }
}
*/

class Solution {
    HashMap<Integer,Node> hm=new HashMap<>();
    public Node cloneGraph(Node node) {
        if(node==null) return node;

        if(hm.containsKey(node.val)){
            return hm.get(node.val);
        }

        Node dup=new Node(node.val);
        hm.put(node.val,dup);

        for(Node nod:node.neighbors){
            dup.neighbors.add(cloneGraph(nod));
        }

        return dup;
    }
}


  
