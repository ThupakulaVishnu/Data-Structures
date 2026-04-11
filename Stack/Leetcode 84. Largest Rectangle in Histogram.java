Step-by-step algorithm to find the largest rectangle in a histogram using stack:
Step 1: Initialize variables.
• Create a stack → st to store indices
• Set maxArea = 0
Step 2: Traverse all bars including one extra iteration.
• For i = 0 to heights.length:
 o Step 2a: Get current height
  • If i < heights.length → ch = heights[i]
  • Else → ch = 0 (to empty the stack)
 o Step 2b: Process stack while current height is smaller
  • While stack is not empty AND ch < heights[st.peek()]:
   • Sub-step 2b-i: Pop index from stack → get height
    • ht = heights[st.pop()]
   • Sub-step 2b-ii: Calculate width
    • If stack is empty → width = i
    • Else → width = i - st.peek() - 1
   • Sub-step 2b-iii: Calculate area and update max
    • maxArea = max(maxArea, ht * width)
 o Step 2c: Push current index into stack → st.push(i)
Step 3: After loop ends, return maxArea
Time Complexity:
Each index is pushed and popped at most once → O(n)
Time Complexity = O(n)
Space Complexity:
Stack stores indices → O(n)
Space Complexity = O(n)
















  ============> Code <==========
class Solution {
    public int largestRectangleArea(int[] heights) {
        Stack<Integer> st=new Stack<>();
        int maxArea=0;
        for(int i=0;i<=heights.length;i++){
            int ch=0;
            if(i<heights.length){
                ch=heights[i];
            }
            while(!st.isEmpty() && ch<heights[st.peek()]){
                int ht=heights[st.pop()];
                int width=0;
                if(st.isEmpty()){
                    width=i;
                }else{
                    width=i-st.peek()-1;
                }
                maxArea=Math.max(maxArea,ht*width);
            }
            st.push(i);
        }
        return maxArea;
    }
}
