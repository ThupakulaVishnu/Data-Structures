Link --> https://www.geeksforgeeks.org/problems/max-heap-implementation/1


Step-by-step logic of Max Heap implementation:

---

## Constructor

Step 1: Create an empty list to store heap elements.
Step 2: This list will represent a complete binary tree using array indexing.

---

## Push (Insert element)

Step 1: Add the new element at the end of the list.
(This keeps the tree complete.)

Step 2: Set curr as the index of the newly added element.

Step 3: While curr is not the root (curr > 0):

* Sub-step 3a: Find the parent index using
  parent = (curr - 1) / 2

* Sub-step 3b: If the current element is greater than its parent:

  * Swap current and parent.
  * Update curr to parent index.
    (This moves the element upward.)

* Sub-step 3c: If the parent is greater or equal, stop.
  (Heap property is satisfied.)

This maintains the Max Heap property.

Time Complexity: O(log n)
Space Complexity: O(1)

---

## Pop (Remove maximum element)

Step 1: If heap is empty, stop.

Step 2: Remove the last element from the list and store it.

Step 3: If heap is not empty after removal:

* Sub-step 3a: Place the last element at the root (index 0).

* Sub-step 3b: Set curr = 0.

* Sub-step 3c: Repeat:

  * Find left child index: 2 × curr + 1

  * Find right child index: 2 × curr + 2

  * Assume curr is the largest.

  * If left child exists and is greater than current:
    update curr to left.

  * If right child exists and is greater than current:
    update curr to right.

  * If curr changed:
    swap it with previous position.

  * If no change:
    stop.

This restores the Max Heap property downward.

Time Complexity: O(log n)
Space Complexity: O(1)

---

## Peek

Step 1: If heap is empty, return -1.
Step 2: Otherwise, return the root element (index 0).

Time Complexity: O(1)

---

## Size

Step 1: Return the size of the list.

Time Complexity: O(1)


      -------------------> Code <---------------------

  class maxHeap {
    List<Integer> al;
    // Constructor
    public maxHeap() {
        // Initialize your data members
        al=new ArrayList<>();
    }

    public void push(int x) {
        // Insert x into the heap
        al.add(x);
        int curr=al.size()-1;
        while(curr>0){
            int parent=(curr-1)/2;
            
            if(al.get(curr)>al.get(parent)){
                int temp=al.get(curr);
                al.set(curr,al.get(parent));
                al.set(parent,temp);
                
                curr=parent;
            }else{
                break;
            }
        }
    }

    public void pop() {
        // Remove the top (maximum) element
        if(al.size()==0)return;
        
        int last=al.remove(al.size()-1);
        
        if(al.size()>0){
            al.set(0,last);
            int curr=0;
            
            while(true){
                int left=curr*2+1;
                int right=curr*2+2;
                int latest=curr;
                if(left<al.size() && al.get(curr)<al.get(left)){
                    curr=left;
                }
                
                if(right<al.size() && al.get(curr)<al.get(right)){
                    curr=right;
                }
                
                if(latest!=curr){
                    int temp=al.get(curr);
                    al.set(curr,al.get(latest));
                    al.set(latest,temp);
                    
                    
                }else{
                    break;
                }
            }
        }
    }
    

    public int peek() {
        // Return the top element or -1 if empty
        if(al.size()==0){
            return -1;
        }else{
            return al.get(0);
        }
    }

    public int size() {
        // Return the number of elements in the heap
        return al.size();
    }
}
