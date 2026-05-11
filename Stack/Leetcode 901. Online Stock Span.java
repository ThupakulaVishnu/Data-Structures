Step 1: Initialize data structures.
    • Create a Stack<int[]> st
      ○ Each element stores {index, price}
    • Initialize sta = 0 → represents current day index
Step 2: Process next(price).
    • Called for each incoming stock price
Step 3: Remove smaller or equal prices.
    • While stack is not empty AND st.peek()[1] ≤ price:
      ○ Pop elements from stack
    • Reason: they cannot affect span anymore
Step 4: Calculate span.
    • If stack is empty:
      ○ All previous prices are smaller → span = sta + 1
    • Else:
      ○ Span = distance from last greater element
      ○ span = sta − st.peek()[0]
Step 5: Push current element.
    • Push {sta, price} into stack
Step 6: Increment index.
    • sta++ → move to next day
Step 7: Return result.
    • Return span
Time Complexity Analysis:
    • Each element is pushed once and popped at most once
    • Total operations across all calls → O(n)
    • Amortized per operation → O(1)
Space Complexity Analysis:
    • Stack stores at most n elements → O(n)
    • Each element stored once
    • Total Space Complexity → O(n)










  =================> Code <================

  
 class StockSpanner {
    Stack<int[]> st;
    int sta;
    public StockSpanner() {
        st=new Stack<>();
        sta=0;
    }
    
    public int next(int price) {
        int ans=0;
        while(!st.isEmpty() && st.peek()[1]<=price){
            st.pop();
        }
        if(st.isEmpty()){
            ans=sta+1;
        }else{
            ans=sta-st.peek()[0];
        }
        st.push(new int[]{sta,price});
        sta++;
        return ans;
    }
}
