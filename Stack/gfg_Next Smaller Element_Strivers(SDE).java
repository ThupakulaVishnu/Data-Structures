Link --> https://www.geeksforgeeks.org/problems/immediate-smaller-element1142/1


Step-by-step algorithm for Next Smaller Element in an array:

Step 1: Initialize an empty ArrayList al to store the result.

Step 2: Initialize an empty Stack st to keep track of potential next smaller elements.

Step 3: Traverse the input array arr from right to left (i = n-1 to 0).

Sub-step 3a: If the stack is empty,

Add -1 to al (no smaller element exists).

Sub-step 3b: If the stack is not empty,

While the stack is not empty and the top element of the stack is greater than or equal to arr[i],

Pop the element from the stack.

After this loop:

If the stack is not empty, add the top element of the stack to al (this is the next smaller element).

If the stack is empty, add -1 to al (no smaller element exists).

Sub-step 3c: Push the current element arr[i] onto the stack.

Step 4: After finishing the traversal, reverse the ArrayList al because elements were added from right to left.

Step 5: Return al as the result containing the next smaller elements for each position.

Time Complexity:
Each element is pushed and popped from the stack at most once.
Time Complexity = O(n)

Space Complexity:
Stack and result list store up to n elements.
Space Complexity = O(n)


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
