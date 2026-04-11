Step-by-step algorithm to implement a queue using two stacks:
Step 1: Initialize two stacks.
• s1 = new Stack<>() → used for enqueue (push) operations
• s2 = new Stack<>() → used for dequeue (pop/peek) operations
Step 2: Define push(x) operation (enqueue).
• Add element to s1 → s1.push(x)
Step 3: Define pop() operation (dequeue).
• Step 3a: If s2 is empty → move all elements from s1 to s2 to reverse order →
 o While !s1.isEmpty() → s2.push(s1.pop())
• Step 3b: Remove and return top of s2 → return s2.pop()
Step 4: Define peek() operation (front of queue).
• Step 4a: If s2 is empty → move all elements from s1 to s2 →
 o While !s1.isEmpty() → s2.push(s1.pop())
• Step 4b: Return top of s2 without removing → return s2.peek()
Step 5: Define empty() operation.
• Return true if both stacks are empty → return s1.isEmpty() && s2.isEmpty()
Time Complexity:
• push() → O(1)
• pop() → amortized O(1) (each element moved from s1 → s2 at most once)
• peek() → amortized O(1)
• empty() → O(1)
Time Complexity = push: O(1), pop/peek/empty: O(1) amortized
Space Complexity:
• Two stacks store all elements → O(n)
Space Complexity = O(n)













  ===========> Code <==========

  

 class MyQueue {
    Stack<Integer> s1;
    Stack<Integer> s2;
    public MyQueue() {
        s1=new Stack<>();
        s2=new Stack<>();
    }
    
    public void push(int x) {
        s1.push(x);
    }
    
    public int pop() {
        if(s2.isEmpty()){
            while(!s1.isEmpty()){
                s2.push(s1.pop());
            }
        }
        return s2.pop();
    }
    
    public int peek() {
        if(s2.isEmpty()){
            while(!s1.isEmpty()){
                s2.push(s1.pop());
            }
        }
        return s2.peek();
    }
    
    public boolean empty() {
        return s1.isEmpty() && s2.isEmpty();
    }
}

/**
 * Your MyQueue object will be instantiated and called as such:
 * MyQueue obj = new MyQueue();
 * obj.push(x);
 * int param_2 = obj.pop();
 * int param_3 = obj.peek();
 * boolean param_4 = obj.empty();
 */
