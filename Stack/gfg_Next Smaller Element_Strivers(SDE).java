Link --> https://www.geeksforgeeks.org/problems/immediate-smaller-element1142/1


Step 1: Initialize an empty list al to store the next smaller elements.

Step 2: Initialize an empty stack st.

Step 3: Traverse the array arr from right to left (i = n-1 to 0):

Sub-step 3a: If the stack is empty, add -1 to al.

Sub-step 3b: Otherwise, while the stack is not empty and the top of the stack is greater than or equal to arr[i], pop elements from the stack.

Sub-step 3c: After popping, if the stack is not empty, add the top of the stack to al (this is the next smaller element).

Sub-step 3d: If the stack is empty after popping, add -1 to al.

Sub-step 3e: Push arr[i] onto the stack.

Step 4: Reverse the list al because elements were added from right to left.

Step 5: Return al.

Time Complexity: O(n) – Each element is pushed and popped at most once from the stack.
Space Complexity: O(n) – For the stack and output list.


            -----------> Code <-----------

  class Solution {
    static ArrayList<Integer> nextSmallerEle(int[] arr) {
        int n=arr.length;
        ArrayList<Integer> al=new ArrayList<>();

        
        Stack<Integer> st=new Stack<>();
        for(int i=n-1;i>=0;i--){
            if(st.isEmpty()){
                al.add(-1);
            }else{
                while(!st.isEmpty() && st.peek()>=arr[i]){
                    st.pop();
                }
                if(!st.isEmpty()){
                    al.add(st.peek());
                }else{
                    al.add(-1);
                }
            }
            st.push(arr[i]);
        }
        
        Collections.reverse(al);
        return al;
    }
}
