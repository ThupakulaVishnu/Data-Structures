Step-by-step algorithm to find the top view of a binary tree:
Step 1: Initialize required data structures.
 • Create a TreeMap to store horizontal distance → node pair.
 • The TreeMap keeps keys sorted so the result appears from left to right.
 • Create a Queue (LinkedList implementation) to perform Breadth First Search (BFS) traversal of the tree.
Step 2: Start with the root node.
 • Assign the horizontal distance (HD) of the root as 0.
 • Create a pair object containing the horizontal distance and the root node.
 • Insert this pair into the TreeMap.
 • Add this pair into the Queue for traversal.
Step 3: Traverse the binary tree using level order traversal (BFS) until the queue becomes empty.
 • Sub-step 3a: Remove the front element from the Queue.
  o Extract the horizontal distance (idx).
  o Extract the current node.
 • Sub-step 3b: Check if the current node has a left child.
  o If it exists, calculate its horizontal distance as idx - 1.
  o Create a pair object containing this distance and the left child node.
  o Add this pair into the Queue for further traversal.
  o Check if this horizontal distance is already present in the TreeMap.
   • If it is not present, insert this pair into the TreeMap.
   • If it already exists, do nothing because the topmost node at that distance is already stored.
 • Sub-step 3c: Check if the current node has a right child.
  o If it exists, calculate its horizontal distance as idx + 1.
  o Create a pair object containing this distance and the right child node.
  o Add this pair into the Queue for traversal.
  o Check if this horizontal distance already exists in the TreeMap.
   • If it is not present, insert this pair into the TreeMap.
   • If it already exists, ignore it.
Step 4: Continue the traversal until the Queue becomes empty.
 (This ensures all nodes of the tree are processed.)
Step 5: Collect the top view nodes.
 • Traverse the TreeMap from the smallest horizontal distance to the largest.
 • For each entry in the TreeMap, get the stored node.
 • Add the node’s value into an ArrayList.
Step 6: Return the ArrayList containing the top view of the binary tree.
Logic:
 • Each node is assigned a horizontal distance (HD) relative to the root.
 • TreeMap stores nodes according to their horizontal distance in sorted order.
 • Queue (LinkedList) is used to perform BFS traversal so that nodes are processed level by level.
 • For each horizontal distance, only the first node encountered is stored in the TreeMap, which represents the topmost node visible from the top view.
Time Complexity:
 Each node is visited once and inserted into the TreeMap.
 TreeMap operations take logarithmic time.
 Time Complexity = O(n log n)
Space Complexity:
 The Queue and TreeMap store nodes during traversal.
 Space Complexity = O(n)


















===========> Code <================

  /*
class Node {
    int data;
    Node left, right;

    Node(int val) {
        this.data = val;
        this.left = null;
        this.right = null;
    }
}
*/
class Solution {
    public ArrayList<Integer> topView(Node root) {
        // code here
        Map<Integer,pair> tm=new TreeMap<>();
        Queue<pair> q=new LinkedList<>();
        
        pair head=new pair(0,root);
        tm.put(0,head);
        q.offer(head);
        
        while(!q.isEmpty()){
            pair curr=q.poll();
            int idx=curr.inx;
            Node nn=curr.nod;
            
            if(nn.left!=null){
                pair hm=new pair((idx-1),nn.left);
                q.offer(hm);
                if(tm.get(idx-1)==null){
                    tm.put(idx-1,hm);
                }
            }
            
            if(nn.right!=null){
                pair hm=new pair((idx+1),nn.right);
                q.offer(hm);
                if(tm.get(idx+1)==null){
                    tm.put(idx+1,hm);
                }
            }
        }
        
        ArrayList<Integer> al=new ArrayList<>();
        for(int hgf:tm.keySet()){
            al.add(tm.get(hgf).nod.data);
        }
        
        return al;
    }
}
class pair{
    int inx;
    Node nod;
    pair(int inx,Node nod){
        this.inx=inx;
        this.nod=nod;
    }
}
