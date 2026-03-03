Link -->  https://www.geeksforgeeks.org/problems/implement-stack-using-array/1


Step-by-step algorithm for Stack implementation using array:

---

## Constructor

Step 1: Store the maximum size of the stack in variable N.

Step 2: Create an array of size N to store stack elements.

Step 3: Initialize the top pointer `st` to -1.
(This means the stack is empty.)

---

## isEmpty

Step 1: Check if `st == -1`.

Step 2: If yes, return true.
Step 3: Otherwise, return false.

---

## isFull

Step 1: Check if `st >= N - 1`.

Step 2: If yes, return true.
Step 3: Otherwise, return false.

---

## push (Insert element)

Step 1: Check if the stack is not full (`st < N - 1`).

Step 2: If not full:

* Increase `st` by 1.
* Insert the new element at `arr[st]`.

Step 3: If full, do nothing (overflow condition).

Time Complexity: O(1)

---

## pop (Remove top element)

Step 1: Check if the stack is not empty (`st >= 0`).

Step 2: If not empty:

* Decrease `st` by 1.
  (This removes the top element logically.)

Step 3: If empty, do nothing (underflow condition).

Time Complexity: O(1)

---

## peek (Get top element)

Step 1: Check if stack is not empty (`st >= 0`).

Step 2: If not empty:

* Return `arr[st]`.

Step 3: If empty:

* Return -1.

Time Complexity: O(1)

---

## Overall Complexity

Push → O(1)
Pop → O(1)
Peek → O(1)
isEmpty → O(1)
isFull → O(1)

Space Complexity → O(N) (array size)




            -------------------> Code <-------------------------

  class myStack {
    int N;
    int[] arr;
    int st;
    public myStack(int n) {
        // Define Data Structures
        N=n;
        arr=new int[n];
        st=-1;
        
    }

    public boolean isEmpty() {
        // check if the stack is empty
        if(st==-1){
            return true;
        }else{
            return false;
        }
    }

    public boolean isFull() {
        // check if the stack is full
        if(st>=N-1){
            return true;
        }else{
            return false;
        }
    }

    public void push(int x) {
        // Inserts x at the top of the stack
        if(st<N){
            st++;
            arr[st]=x;
        }
    }

    public void pop() {
        // Removes an element from the top of the stack
        if(st>=0){
            st--;
        }
    }

    public int peek() {
        // Returns the top element of the stack
        if(st>=0 && st<N){
            return arr[st];
        }else{
            return -1;
        }
        
    }
}
