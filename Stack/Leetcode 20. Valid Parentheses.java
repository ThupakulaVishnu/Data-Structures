Step 1: Initialize stack.
    • Create a Stack st
    • Purpose: store opening brackets in order
Step 2: Traverse the string.
    • For each character ch in string s:
Step 3: Push opening brackets.
    • If ch is '(', '{', or '[':
      ○ Push into stack → st.push(ch)
Step 4: Handle closing brackets.
    • Else (ch is ')', '}', or ']'):
Step 5: Check stack is not empty.
    • If stack is empty:
      ○ Return false (no matching opening bracket)
Step 6: Match top of stack.
    • If top of stack matches current closing bracket:
      ○ '(' matches ')'
      ○ '[' matches ']'
      ○ '{' matches '}'
      ○ Then pop from stack
Step 7: Handle mismatch case.
    • If top does not match current closing bracket:
      ○ Return false immediately
Step 8: After traversal check stack.
    • If stack is empty → return true
    • Else → return false (unmatched opening brackets remain)
Time Complexity Analysis:
    • Each character is processed once → O(n)
    • Stack operations (push/pop/peek) are O(1)
    • Total Time Complexity → O(n)
Space Complexity Analysis:
    • Stack can store up to n characters in worst case → O(n)
    • No other extra data structures used
    • Total Space Complexity → O(n)















=============> Code <==============

  
class Solution {
    public boolean isValid(String s) {
        Stack<Character> st=new Stack<>();
        for(char ch:s.toCharArray()){
            if(ch=='(' || ch=='{' || ch=='['){
                st.push(ch);
            }else if(!st.isEmpty()){
                if(st.peek()=='(' && ch==')' || st.peek()=='{' && ch=='}' || st.peek()=='[' && ch==']'){
                    st.pop();
                }else{
                    return false;
                }
            }else{
                st.push(ch);
            }
        }
        if(st.isEmpty()){
            return true;
        }
        return false;
    }
}
