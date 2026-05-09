Step 1: Handle base case of recursion.
    • If stack is empty:
      ○ Return (nothing to sort)
Step 2: Remove top element.
    • Pop top element from stack → top = st.pop()
    • This reduces problem size
Step 3: Recursively sort remaining stack.
    • Call sortStack(st)
    • Now stack is sorted except for “top” element
Step 4: Insert element into correct position.
    • Call helper function find(st, top)
Step 5: Insert element in sorted stack (find function).
    • If stack is empty OR top element ≤ current element:
      ○ Push current element into stack
      ○ Return
Step 6: If stack top is greater than element.
    • Pop top element → tp = st.pop()
    • Recursively call find(st, top)
Step 7: Restore popped element.
    • After inserting correct element, push back tp
    • Maintains original order except insertion point
Step 8: Final result.
    • Stack becomes sorted in ascending order (smallest at bottom, largest at top)
Time Complexity Analysis:
    • Each element is inserted and removed multiple times due to recursion
    • For each insertion, worst case we traverse entire stack → O(n)
    • For n elements → O(n²)
    • Total Time Complexity → O(n²)
Space Complexity Analysis:
    • Recursion stack depth can go up to n → O(n)
    • No extra data structures used
    • Total Space Complexity → O(n)












  ==================> Code <==================

  
class Solution {
    public void sortStack(Stack<Integer> st) {
        // code here
        if(st.isEmpty())return;
        int top=st.pop();
        sortStack(st);
        find(st,top);
        
    }
    public void find(Stack<Integer> st,int top){
        if(st.isEmpty() || st.peek()<=top){
            st.push(top);
            return;
        }
        
        int tp=st.pop();
        find(st,top);
        st.push(tp);
    }
}
