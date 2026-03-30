Step-by-step algorithm to search a target element in a 2D sorted matrix using Binary Search:
Step 1: Initialize variables.
• Let r be the number of rows in the matrix.
• Let c be the number of columns in the matrix.
Step 2: Treat the 2D matrix as a 1D sorted array.
• Set two pointers:
 o l = 0
 o h = r × c − 1
Step 3: Start a loop while l ≤ h.
• Sub-step 3a: Find the middle index.
 o mid = l + (h − l) / 2
• Sub-step 3b: Convert 1D index to 2D indices.
 o rw = mid / c
 o cl = mid % c
• Sub-step 3c: Compare with target.
 o If matrix[rw][cl] == target → return true
 o If matrix[rw][cl] < target → l = mid + 1
 o If matrix[rw][cl] > target → h = mid − 1
Step 4: If not found, return false.
Time Complexity:
1.	Binary search runs on r × c elements.
2.	Each step halves the search space.
3.	Total time = O(log(r × c)).
Time Complexity = O(log(r × c))
Space Complexity:
Only constant variables are used.
Space Complexity = O(1)
















  ===================> Code <==============

  class Solution {
    public boolean searchMatrix(int[][] matrix, int target) {
        int r=matrix.length;
        int c=matrix[0].length;

        int l=0;
        int h=r*c-1;

        while(l<=h){
            int mid=l+(h-l)/2;

            int rw=mid/c;
            int cl=mid%c;

            if(matrix[rw][cl]==target){
                return true;
            }else if(matrix[rw][cl]<target){
                l=mid+1;
            }else{
                h=mid-1;
            }
        }

        return false;
    }
}
