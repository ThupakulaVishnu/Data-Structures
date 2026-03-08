Link --> https://www.geeksforgeeks.org/problems/immediate-smaller-element1142/1


Step-by-step algorithm for finding Next Smaller Element (NSE) in an array:

Step 1: Initialize an empty ArrayList `al` of the same size as `arr`.

* Fill all positions with -1 initially.
  (This handles elements that do not have a smaller element to their right.)

Step 2: Initialize an empty Stack `st` to keep track of potential next smaller elements.

Step 3: Traverse the array from right to left (i = arr.length - 1 to 0).

* Sub-step 3a: While the stack is not empty and the top of the stack (`st.peek()`) is greater than or equal to `arr[i]`:

  * Pop elements from the stack.
    (Remove elements that cannot be the next smaller for `arr[i]`.)

* Sub-step 3b: After the loop, check if the stack is not empty:

  * If true:

    * The top of the stack (`st.peek()`) is the next smaller element for `arr[i]`.
    * Update `al[i] = st.peek()`

* Sub-step 3c: Push `arr[i]` onto the stack.
  (It may be the next smaller element for elements to the left.)

Step 4: After finishing the traversal, return the ArrayList `al`.

Logic:

* Stack always contains potential "next smaller elements" in decreasing order from top to bottom.
* We traverse from right to left to find the first smaller element on the right for each array element.

Time Complexity:
Each element is pushed and popped at most once.
Time Complexity = O(n)

Space Complexity:
Stack and result list can store up to n elements.
Space Complexity = O(n)



            -----------> Code <-----------

class Solution {
    static ArrayList<Integer> nextSmallerEle(int[] arr) {
        // code here
        ArrayList<Integer> al=new ArrayList<>();
        for(int i=0;i<arr.length;i++){
            al.add(-1);
        }
        Stack<Integer> st=new Stack<>();
        
        for(int i=arr.length-1;i>=0;i--){
            while(!st.isEmpty() && st.peek()>=arr[i]){
                st.pop();
            }
            
            if(!st.isEmpty()){
                al.set(i,st.peek());
            }
            st.push(arr[i]);
        }
        return al;
    }
}
