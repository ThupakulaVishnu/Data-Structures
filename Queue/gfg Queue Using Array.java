Step-by-step algorithm to implement a Queue using an ArrayList:
Step 1: Define the required data structures.
 • Create a List al to store the queue elements.
 • Create an integer variable st to track the last index of the queue.
 • Create an integer variable N to store the maximum capacity of the queue.
Step 2: Initialize the queue using the constructor.
 • Create a new ArrayList for storing elements.
 • Set st = -1 to indicate the queue is empty.
 • Set N = n (maximum size of the queue).
Step 3: Check if the queue is empty.
 • Sub-step 3a: If st == -1, return true.
 • Sub-step 3b: Otherwise, return false.
Step 4: Check if the queue is full.
 • Sub-step 4a: If st == N - 1, return true.
 • Sub-step 4b: Otherwise, return false.
Step 5: Insert an element into the queue (enqueue operation).
 • Sub-step 5a: Check if the queue is not full (st < N - 1).
 • Sub-step 5b: Increment st by 1.
 • Sub-step 5c: Add the new element x to the ArrayList using al.add(x).
Step 6: Remove an element from the queue (dequeue operation).
 • Sub-step 6a: Check if the queue is not empty (st > -1).
 • Sub-step 6b: Remove the element at index 0 using al.remove(0) (front element).
 • Sub-step 6c: Decrement st by 1.
Step 7: Get the front element of the queue.
 • Sub-step 7a: If the queue is not empty (st > -1), return al.get(0).
 • Sub-step 7b: Otherwise, return -1.
Step 8: Get the rear element of the queue.
 • Sub-step 8a: If the queue is not empty (st > -1), return al.get(al.size() - 1).
 • Sub-step 8b: Otherwise, return -1.
Logic:
 • The queue follows the FIFO (First In First Out) principle.
 • Elements are inserted at the rear using enqueue.
 • Elements are removed from the front using dequeue.
 • The variable st keeps track of the last index of the queue to check empty and full conditions.
Time Complexity:
 enqueue → O(1)
 dequeue → O(n) (because removing index 0 shifts remaining elements)
 getFront → O(1)
 getRear → O(1)
Space Complexity:
 The queue stores at most N elements.
 Space Complexity = O(N)






  ==================> Code <=======================

  class myQueue {

    // Constructor
    List<Integer> al;
    int st,N;
    public myQueue(int n) {
        // Define Data Structures
        al=new ArrayList<>();
        st=-1;
        N=n;
    }

    public boolean isEmpty() {
        // Check if queue is empty
        if(st==-1){
            return true;
        }else{
            return false;
        }
    }

    public boolean isFull() {
        // Check if queue is full
        if(st==N-1){
            return true;
        }else{
            return false;
        }
    }

    public void enqueue(int x) {
        // Enqueue
        if(st<N-1){
            st++;
            al.add(x);
        }
    }

    public void dequeue() {
        // Dequeue
        if(st>-1){
            al.remove(0);
            st--;
        }
    }

    public int getFront() {
        // Get front element
        if(st>-1){
            return al.get(0);
        }
        return -1;
    }

    public int getRear() {
        // Get last element
        if(st>-1){
            return al.get(al.size()-1);
        }
        return -1;
    }
}
