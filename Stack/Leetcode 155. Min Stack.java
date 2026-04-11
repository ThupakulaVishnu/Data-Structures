Step-by-step algorithm to design a stack that supports minimum in O(1):
Step 1: Initialize data structures.
• Create main stack → st (stores all elements)
• Create min stack → minst (stores minimum elements)
Step 2: Define push(val) operation.
• Step 2a: Push value into main stack → st.push(val)
• Step 2b: Update min stack
 o If minst is empty OR val <= minst.peek()
  → push into minst → minst.push(val)
Step 3: Define pop() operation.
• Step 3a: Check if top of main stack equals top of min stack
 o If st.peek().equals(minst.peek())
  → remove from minst → minst.pop()
• Step 3b: Remove from main stack → st.pop()
Step 4: Define top() operation.
• Return top of main stack → st.peek()
Step 5: Define getMin() operation.
• Return top of min stack → minst.peek()
Time Complexity:
• push() → O(1)
• pop() → O(1)
• top() → O(1)
• getMin() → O(1)
Time Complexity = O(1) for all operations
Space Complexity:
• Main stack stores all elements → O(n)
• Min stack stores minimum elements → O(n) (worst case when elements are decreasing)
Space Complexity = O(n)














  ==============> Code <=============

  

 class MinStack {
    Stack<Integer> st;
    Stack<Integer> minst;
    public MinStack() {
        st=new Stack<>();
        minst=new Stack<>();
    }
    
    public void push(int val) {
        st.push(val);

        if(minst.isEmpty() || val<=minst.peek()){
            minst.push(val);
        }
    }
    
    public void pop() {
        if(st.peek().equals(minst.peek())){
            minst.pop();
        }
        st.pop();
    }
    
    public int top() {
        return st.peek();
    }
    
    public int getMin() {
        return minst.peek();
    }
}

/**
 * Your MinStack object will be instantiated and called as such:
 * MinStack obj = new MinStack();
 * obj.push(val);
 * obj.pop();
 * int param_3 = obj.top();
 * int param_4 = obj.getMin();
 */
