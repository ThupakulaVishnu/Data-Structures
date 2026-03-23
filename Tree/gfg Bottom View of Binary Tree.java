Step-by-step algorithm to find the bottom view of a binary tree:
Step 1: Initialize required data structures.
 • Create a TreeMap to store the horizontal distance and the corresponding node pair.
 • The TreeMap automatically keeps the keys sorted from left to right.
 • Create a Queue (LinkedList implementation) to perform level order traversal (BFS) of the tree.
Step 2: Start with the root node.
 • Assign the horizontal distance of the root as 0.
 • Create a pair object containing the horizontal distance and the root node.
 • Insert this pair into the TreeMap.
 • Add this pair into the Queue.
Step 3: Traverse the tree using Breadth First Search (BFS) until the queue becomes empty.
 • Sub-step 3a: Remove the front pair from the Queue.
  o Extract the horizontal distance (hd).
  o Extract the current node.
 • Sub-step 3b: Check if the current node has a left child.
  o If yes, calculate the horizontal distance of the left child as hd - 1.
  o Create a new pair object containing this distance and the left child node.
  o Insert this pair into the TreeMap (this may overwrite the previous node at that horizontal distance).
  o Add this pair into the Queue for further traversal.
 • Sub-step 3c: Check if the current node has a right child.
  o If yes, calculate the horizontal distance of the right child as hd + 1.
  o Create a new pair object containing this distance and the right child node.
  o Insert this pair into the TreeMap (this updates the bottom-most node at that horizontal distance).
  o Add this pair into the Queue.
Step 4: Continue the traversal until the Queue becomes empty.
 (This ensures all nodes of the tree are processed.)
Step 5: Collect the bottom view nodes.
 • Traverse the TreeMap from the smallest horizontal distance to the largest.
 • For each horizontal distance, get the stored pair from the TreeMap.
 • Add the node value from that pair into the result list (ArrayList).
Step 6: Return the ArrayList containing the bottom view of the binary tree.
Logic:
 • Each node is assigned a horizontal distance (HD) relative to the root node.
 • TreeMap keeps horizontal distances sorted so that the final result appears from leftmost to rightmost.
 • Queue (LinkedList) is used to perform level order traversal (BFS) of the tree.
 • Whenever a node appears at the same horizontal distance, it replaces the previous value in the TreeMap, ensuring that the lowest (bottom-most) node remains stored.
Time Complexity:
 Each node is visited once and inserted into the TreeMap.
 TreeMap operations take logarithmic time.
 Time Complexity = O(n log n)
Space Complexity:
 The Queue and TreeMap store nodes during traversal.
 Space Complexity = O(n)




      ===========> Code <===========

  /*
class Node {
    int data;
    Node left;
    Node right;

    Node(int data) {
        this.data = data;
        left = null;
        right = null;
    }
}
*/

class Solution {
    public ArrayList<Integer> bottomView(Node root) {
        // code here
        Map<Integer,pair> n=new TreeMap<>();
        Queue<pair> q=new LinkedList<>();
        
        pair nm=new pair(0,root);
        n.put(0,nm);
        q.offer(nm);
        
        while(!q.isEmpty()){
            pair a=q.poll();
            int hd=a.inx;
            Node curr=a.nod;
            
            if(curr.left!=null){
                pair b=new pair(hd-1,curr.left);
                n.put(hd-1,b);
                q.offer(b);
                
            }
            if(curr.right!=null){
                pair b=new pair(hd+1,curr.right);
                n.put(hd+1,b);
                q.offer(b);
            }
            
        }
        
        ArrayList<Integer> al=new ArrayList<>();
        for(int nh:n.keySet()){
            al.add(n.get(nh).nod.data);
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
