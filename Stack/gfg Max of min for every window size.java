Step 1: Initialize variables and arrays.
    • Let n = arr.length
    • Create left[] array → stores previous smaller element index
    • Create right[] array → stores next smaller element index
    • Create Stack st for monotonic stack
Step 2: Find previous smaller element (left boundary).
    • For i = 0 to n−1:
      ○ While stack is not empty AND arr[st.top] ≥ arr[i]:
        • Pop from stack
      ○ If stack is empty → left[i] = −1
      ○ Else → left[i] = st.peek()
      ○ Push current index i into stack
Step 3: Find next smaller element (right boundary).
    • Clear stack
    • For i = n−1 to 0:
      ○ While stack is not empty AND arr[st.top] ≥ arr[i]:
        • Pop from stack
      ○ If stack is empty → right[i] = n
      ○ Else → right[i] = st.peek()
      ○ Push index i into stack
Step 4: Compute maximum for every window size.
    • Create result array res[n] and fill with −∞
    • For each index i from 0 to n−1:
      ○ Compute length where arr[i] is minimum:
        • len = right[i] − left[i] − 1
      ○ Update answer for that window size:
        • res[len−1] = max(res[len−1], arr[i])
Step 5: Fill remaining gaps.
    • Traverse res from right to left:
      ○ res[i] = max(res[i], res[i+1])
    • Ensures smaller window answers are at least as large as bigger ones
Step 6: Convert result to list.
    • Create ArrayList
    • Add all elements of res into list
Step 7: Return final result.
    • Return ArrayList containing maximum of minimums for every window size
Time Complexity Analysis:
    • Finding left boundaries using stack → O(n)
    • Finding right boundaries using stack → O(n)
    • Filling result array → O(n)
    • Final traversal → O(n)
    • Total Time Complexity → O(n)
Space Complexity Analysis:
    • Stack stores indices → O(n)
    • left[] array → O(n)
    • right[] array → O(n)
    • result array → O(n)
    • Output list → O(n)
    • Total Space Complexity → O(n)



















  ======================> Code <======================

class Solution {
    public ArrayList<Integer> maxOfMins(int[] arr) {
        // code here
        int n=arr.length;
        Stack<Integer> st=new Stack<>();
        
        int[] left=new int[n];
        for(int i=0;i<n;i++){
            while(!st.isEmpty() && arr[st.peek()]>=arr[i]){
                st.pop();
            }
            if(st.isEmpty()){
                left[i]=-1;
            }else{
                left[i]=st.peek();
            }
            st.push(i);
        }
        st.clear();
        int[] right=new int[n];
        for(int i=n-1;i>=0;i--){
            while(!st.isEmpty() && arr[st.peek()]>=arr[i]){
                st.pop();
            }
            if(st.isEmpty()){
                right[i]=n;
            }else{
                right[i]=st.peek();
            }
            st.push(i);
        }
        
        int[] ans=new int[n];
        for(int i=0;i<n;i++){
            int len=right[i]-left[i]-1;
            ans[len-1]=Math.max(ans[len-1],arr[i]);
        }
        
        for(int i=n-2;i>=0;i--){
            ans[i]=Math.max(ans[i],ans[i+1]);
        }
        
        ArrayList<Integer> result=new ArrayList<>();
        for(int k:ans){
            result.add(k);
        }
        
        return result;
    }
}
