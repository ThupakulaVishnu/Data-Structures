Step 1: Initialize data structure
    • Create PriorityQueue pq (min-heap based on node.data)
    • Purpose: always get smallest node among lists
Step 2: Add top-level nodes
    • Traverse root using next pointer
    • Add each node into pq
Step 3: Create dummy node
    • Create Node hd = new Node(0)
    • Use head pointer to store result start
Step 4: Process priority queue
    • While pq is not empty:
Step 5: Extract minimum node
    • Remove smallest node → curr = pq.poll()
Step 6: Attach to result list
    • Link curr to bottom of result → hd.bottom = curr
    • Move hd pointer forward
Step 7: Add next bottom node
    • If curr.bottom exists:
      ○ Add curr.bottom into pq
Step 8: Continue until pq empty
Step 9: Return flattened list
    • Return head.bottom
Time Complexity Analysis:
    • Let total nodes = N, number of lists = k
    • Each node is inserted and removed from pq → O(log k)
    • Total operations for N nodes → O(N log k)
    • Total Time Complexity → O(N log k)
Space Complexity Analysis:
    • PriorityQueue stores at most k nodes → O(k)
    • No extra structures except result list
    • Total Space Complexity → O(k)

















  



  ==============> Code <===============
  class Solution {
    public Node flatten(Node root) {
        // code here
        PriorityQueue<Node> pq=new PriorityQueue<>((a,b)->a.data-b.data);
        while(root!=null){
            pq.offer(root);
            root=root.next;
        }
        Node hd=new Node(0);
        Node head=hd;
        while(!pq.isEmpty()){
            Node curr=pq.poll();
            hd.bottom=curr;
            hd=hd.bottom;
            if(curr.bottom==null)continue;
            pq.offer(curr.bottom);
        }
        return head.bottom;
    }
}
