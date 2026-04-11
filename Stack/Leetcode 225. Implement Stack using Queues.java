Step-by-step algorithm to implement a stack using two queues:
Step 1: Initialize two queues.
• q1 = new LinkedList<>() → main queue holding stack elements
• q2 = new LinkedList<>() → temporary queue for push operation
________________________________________
Step 2: Define push(x) operation.
• Step 2a: Add element to temporary queue → q2.offer(x)
• Step 2b: Move all elements from q1 to q2 →
 o While !q1.isEmpty() → q2.offer(q1.poll())
• Step 2c: Swap queues →
 o temp = q1; q1 = q2; q2 = temp
 o Now q1 has new element at front, maintaining stack order
________________________________________
Step 3: Define pop() operation.
• Remove and return front of q1 → return q1.poll()
________________________________________
Step 4: Define top() operation.
• Return front of q1 without removing → return q1.peek()
________________________________________
Step 5: Define empty() operation.
• Check if q1 is empty → return q1.isEmpty()
________________________________________
Time Complexity:
• push() → moves all elements → O(n) per push
• pop() → O(1)
• top() → O(1)
• empty() → O(1)
Time Complexity = push: O(n), pop/top/empty: O(1)
Space Complexity:
• Two queues storing all elements → O(n)
Space Complexity = O(n)











  =============> Code <===============

  

 class MyStack {
    Queue<Integer> q1;
    Queue<Integer> q2;
    public MyStack() {
        q1=new LinkedList<>();
        q2=new LinkedList<>();
    }
    
    public void push(int x) {
        q2.offer(x);

        while(!q1.isEmpty()){
            q2.offer(q1.poll());
        }

        Queue<Integer> temp=q1;
        q1=q2;
        q2=temp;
    }
    
    public int pop() {
        return q1.poll();
    }
    
    public int top() {
        return q1.peek();
    }
    
    public boolean empty() {
        return q1.isEmpty();
    }
}

/**
 * Your MyStack object will be instantiated and called as such:
 * MyStack obj = new MyStack();
 * obj.push(x);
 * int param_2 = obj.pop();
 * int param_3 = obj.top();
 * boolean param_4 = obj.empty();
 */
