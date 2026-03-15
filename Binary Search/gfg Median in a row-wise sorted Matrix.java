
Step-by-step algorithm to find the median in a row-wise sorted matrix:

    Step 1: Find the number of rows and columns.
    (Set R = number of rows and C = number of columns in the matrix.)

    Step 2: Initialize two variables l and h.
    (Set l = +∞ and h = -∞. These will store the minimum and maximum possible values in the matrix.)

    Step 3: Traverse each row of the matrix to determine the global minimum and maximum values.

        • Sub-step 3a: For every row i, compare the first element of the row with l.
            Update l = min(l, mat[i][0]).

        • Sub-step 3b: Compare the last element of the row with h.
            Update h = max(h, mat[i][C-1]).

    (This works because every row in the matrix is sorted.)

    Step 4: Calculate the position of the median in the sorted order of all elements.

        desired = (R * C + 1) / 2

    (This represents the index of the median element if all matrix elements were sorted.)

    Step 5: Start binary search on the value range between l and h.
    (We search for the smallest value whose position is the median.)

        • Sub-step 5a: Compute the middle value.
            mid = l + (h - l) / 2

        • Sub-step 5b: Count how many elements in the matrix are less than or equal to mid.

            o Initialize count = 0.

            o For each row i in the matrix:
                Add the number of elements ≤ mid using the upper bound function.
                count += upperbound(mat[i], mid)

    Step 6: Compare the count with the desired median position.

        • Sub-step 6a: If count < desired:
            The median must be larger than mid.
            Update l = mid + 1.

        • Sub-step 6b: Otherwise (count ≥ desired):
            The median could be mid or a smaller value.
            Update h = mid.

    Step 7: Repeat Steps 5 and 6 until l becomes equal to h.
    (This means the exact median value has been found.)

    Step 8: Return l.
    (This value represents the median of the matrix.)

---

Step-by-step algorithm for the upper bound function used inside the median calculation:

    Step 1: Initialize two pointers l and h.
    (Set l = 0 and h = length of the array.)

    Step 2: Start a loop while l < h.

        • Sub-step 2a: Calculate the middle index.
            mid = l + (h - l) / 2

        • Sub-step 2b: Compare the element at mid with the target.

            o If arr[mid] ≤ target:
                Move to the right half.
                Update l = mid + 1.

            o Otherwise (arr[mid] > target):
                Move to the left half.
                Update h = mid.

    Step 3: Repeat until l == h.

    Step 4: Return l.
    (This gives the number of elements less than or equal to the target.)

---

Time Complexity:

    Binary search runs on the value range and each iteration processes all rows using binary search.
    Time Complexity = O(log(max − min) × R × log C)

Space Complexity:

    No additional data structures are used.
    Space Complexity = O(1)










                  =================> Code <====================

  class Solution {
    public int median(int[][] mat) {
        // code here
        int R=mat.length;
        int C=mat[0].length;
        
        int l=Integer.MAX_VALUE;
        int h=Integer.MIN_VALUE;
        
        for(int i=0;i<mat.length;i++){
            l=Math.min(l,mat[i][0]);
            h=Math.max(h,mat[i][C-1]);
        }
        
        int desired=(R*C+1)/2;
        
        while(l<h){
            int mid=l+(h-l)/2;
            
            int cout=0;
            
            for(int i=0;i<R;i++){
                cout+=upperbound(mat[i],mid);
            }
            
            if(cout<desired){
                l=mid+1;
            }else{
                h=mid;
            }
        }
        return l;
    }
    public int upperbound(int[] arr,int tar){
        int l=0, h=arr.length;
        
        while(l<h){
            int mid=l+(h-l)/2;
            
            if(arr[mid]<=tar){
                l=mid+1;
            }else{
                h=mid;
            }
        }
        return l;
    }
}
