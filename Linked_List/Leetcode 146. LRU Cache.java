Step-by-step algorithm for implementing an LRU (Least Recently Used) Cache using a Doubly Linked List and Array Map:

Step 1: Initialize data structures in the constructor:
 • Create an array map[] to store key → Node mappings for O(1) access.
 • Initialize a counter cc to track current number of elements in cache.
 • Set max_val as the capacity of the cache.
 • Create two dummy nodes head and tail.
 • Connect them so that head points to tail and tail points back to head.
  
Step 2: Implement the get operation:
 • Check if map[key] == null
  o If true: return -1
  o Else:
   - Get node curr = map[key]
   - Remove it using del(curr)
   - Add it to front using add(curr)
   - Return curr.val
  
Step 3: Implement the put operation:
 • Check if map[key] == null
  o If key does NOT exist:
   - Create new node curr = new Node(key, value)
   - Store it in map[key]
   - If cc + 1 <= max_val: increment cc
   - Else:
    • Remove LRU node → tail.pre
    • Remove mapping → map[tail.pre.key] = null
    • Delete node using del(tail.pre)
   - Add new node using add(curr)
  o If key EXISTS:
   - Get node curr = map[key]
   - Remove it using del(curr)
   - Update value curr.val = value
   - Add it again using add(curr)

Step 4: Handle node removal (del function):
 • Update pointers:
  - curr.pre.next = curr.next
  - curr.next.pre = curr.pre
    
Step 5: Handle node insertion at front (add function):
 • Insert after head:
  - curr.pre = head
  - curr.next = head.next
  - head.next.pre = curr
  - head.next = curr
    
Logic Explanation:
 • Doubly Linked List maintains usage order.
 • Most recently used node is near head.
 • Least recently used node is near tail.
 • Array map[] provides O(1) access.
 • On every get/put, node moves to front.
 • When full, remove node before tail.
    
Time Complexity:
 • get() = O(1)
 • put() = O(1)
    
Space Complexity:
 • O(max_val)









  ==========> Code <=============



  class Node{
    Node pre;
    Node next;
    int key,val;
    Node(int key,int val){
        this.key=key;
        this.val=val;
    }
}

class LRUCache {
    Node map[]; 
    int max_val;
    int cc=0;
    Node head=new Node(0,0);
    Node tail=new Node(0,0);
    public LRUCache(int capacity) {
        map=new Node[10001];
        max_val=capacity;

        head=new Node(0,0);
        tail=new Node(0,0);

        head.next=tail;
        tail.pre=head;
    }
    
    public int get(int key) {
        if(map[key]==null)return -1;

        Node curr=map[key];
        del(curr);
        int num=curr.val;
        add(curr);
        return num;
    }
    
    public void put(int key, int value) {
        if(map[key]==null){
            Node curr=new Node(key,value);
            map[key]=curr;
            if(cc+1<=max_val){
                cc++;
            }else{
                map[tail.pre.key]=null;
                del(tail.pre);
            }
            add(curr);
        }else{
            Node curr=map[key];
            del(curr);
            curr.val=value;
            add(curr);
        }
    }

    public void del(Node curr){
        curr.pre.next=curr.next;
        curr.next.pre=curr.pre;
    }

    public void add(Node curr){
        curr.pre=head;
        head.next.pre=curr;
        curr.next=head.next;
        head.next=curr;
    }
}

/**
 * Your LRUCache object will be instantiated and called as such:
 * LRUCache obj = new LRUCache(capacity);
 * int param_1 = obj.get(key);
 * obj.put(key,value);
 */
