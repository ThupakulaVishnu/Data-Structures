Step-by-step algorithm to merge k sorted arrays:
Step 1: Initialize variables.
• Let n = number of rows (arrays) → n = mat.length
• Let m = number of columns → m = mat[0].length
Step 2: Create a Min Heap (Priority Queue).
• Each element in heap stores → (value, row index, column index)
• Sort based on value → smallest element at top
Step 3: Insert first element of each array into heap.
• For i = 0 to n−1 →
 o Insert node → (mat[i][0], i, 0) into heap
Step 4: Initialize result list.
• Create al = new ArrayList<>()
Step 5: Process the heap until empty.
• While heap is not empty:
 o Step 5a: Remove smallest element → curr = pq.poll()
 o Step 5b: Add value to result → al.add(curr.val)
 o Step 5c: Check next element in same row
  • If curr.c + 1 < m →
   • Insert next element →
    (mat[curr.r][curr.c + 1], curr.r, curr.c + 1) into heap
Step 6: Return result list
Time Complexity:
We insert and remove each element once → total elements = n × m
Each heap operation takes O(log n)
Total time complexity = O(n × m × log n)
Time Complexity = O(n × m × log n)
Space Complexity:
Heap stores at most n elements → O(n)
Result list stores n × m elements → O(n × m)
Total space complexity = O(n × m)
Space Complexity = O(n × m)















  ================> Code <==================

  
class node{
    int val,r,c;
    node(int val,int r,int c){
        this.val=val;
        this.r=r;
        this.c=c;
    }
}
class Solution {
    public ArrayList<Integer> mergeArrays(int[][] mat) {
        // Code here
        int n=mat.length;
        int m=mat[0].length;
        
        PriorityQueue<node> pq=new PriorityQueue<>((a,b)->a.val-b.val);
        
        for(int i=0;i<n;i++){
            pq.offer(new node(mat[i][0],i,0));
        }
        
        ArrayList<Integer> al=new ArrayList<>();
        
        while(!pq.isEmpty()){
            node curr=pq.poll();
            al.add(curr.val);
            
            if(curr.c+1<m){
                pq.offer(new node(mat[curr.r][curr.c+1],curr.r,curr.c+1));
            }
            
        }
        
        return al;
    }
}
