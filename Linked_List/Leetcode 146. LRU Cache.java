Step-by-step algorithm for implementing an LRU (Least Recently Used) Cache using a Doubly Linked List and Hash Map:
Step 1: Initialize data structures in the constructor:
 • Create a Hash Map (or array map) to store key → Node mappings, which allows O(1) access to nodes.
 • Initialize a counter cout to track the current number of elements in the cache.
 • Set max_val to the capacity of the cache to know the maximum limit.
 • Create two dummy nodes called head and tail to simplify insertion and deletion operations.
 • Connect the dummy nodes so that head points to tail and tail points back to head, forming an empty Doubly Linked List.
Step 2: Implement the get operation:
 • Check if the requested key exists in the Hash Map.
  o If the key does not exist:
   - Return -1 to indicate that the value is not present in the cache.
  o If the key exists:
   - Retrieve the corresponding node from the Hash Map.
   - Move this node to the front of the Doubly Linked List because it has now been recently accessed.
   - Return the value stored in that node.
Step 3: Implement the put operation:
 • Check whether the key already exists in the Hash Map.
  o If the key does not exist:
   - Create a new node containing the given key and value.
   - Insert the key → node mapping into the Hash Map.
   - Add this node to the front of the Doubly Linked List since it is the most recently used element.
   - If the cache size is still less than the capacity, increment the counter.
   - If the cache is already full:
    • Remove the least recently used node, which is the node just before the tail in the list.
    • Also remove that node’s key from the Hash Map.
  o If the key already exists:
   - Retrieve the node from the Hash Map.
   - Move this node to the front of the Doubly Linked List to mark it as recently used.
   - Update the value stored in that node.
Step 4: Handle node removal from the Doubly Linked List:
 • Adjust the previous node’s next pointer and the next node’s previous pointer so that they bypass the node being removed.
 • This effectively removes the node from the list without breaking the linked structure.
Step 5: Handle node insertion at the front of the Doubly Linked List:
 • Insert the node immediately after the head dummy node.
 • Update the next and previous pointers of the node and its neighboring nodes to maintain the correct list structure.
Logic Explanation:
 • The Doubly Linked List maintains the usage order of cache elements.
 • The most recently used node is kept near the head, while the least recently used node is kept near the tail.
 • The Hash Map allows direct access to nodes using their keys in constant time.
 • Whenever a node is accessed or inserted, it is moved to the front of the list.
 • When the cache exceeds capacity, the node near the tail (least recently used) is removed.
Time Complexity:
 • Both get and put operations run in O(1) time because the Hash Map provides constant-time lookup and the Doubly Linked List allows constant-time insertion and deletion.
Space Complexity:
 • The Hash Map and Doubly Linked List together store at most max_val elements.
 • Space Complexity = O(max_val)








  ==========> Code <=============

  class Node{
    int key,val;
    Node next=null,prev=null;
    Node(int key,int val){
        this.key=key;
        this.val=val;
    }
}
class LRUCache {
    Node[] map;
    int cout;
    int max_val;
    Node head,tail;
    public LRUCache(int capacity) {
        map=new Node[10000];
        cout=0;
        max_val=capacity;
        head=new Node(0,0);
        tail=new Node(0,0);

        head.next=tail;
        tail.prev=head;
    }
    
    public int get(int key) {
        if(map[key]==null)return -1;
        Node curr=map[key];
        int value=curr.val;
        del(curr);
        addNode(curr);
        return value;
    }
    
    public void put(int key, int value) {
        if(map[key]==null){
            Node curr= new Node(key,value);
            map[key]= curr;
            if(cout<max_val){
                cout++;
            }else{
                map[tail.prev.key]=null;
                del(tail.prev);
            }
            addNode(curr);
        }else{
            Node curr=map[key];
            del(curr);
            addNode(curr);
            curr.val=value;
        }
    }

    public void del(Node curr){
        curr.prev.next=curr.next;
        curr.next.prev=curr.prev;
    }

    public void addNode(Node curr){
        curr.next=head.next;
        head.next.prev=curr;
        curr.prev=head;
        head.next=curr;
    }
}

/**
 * Your LRUCache object will be instantiated and called as such:
 * LRUCache obj = new LRUCache(capacity);
 * int param_1 = obj.get(key);
 * obj.put(key,value);
 */
