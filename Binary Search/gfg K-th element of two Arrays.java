Step 1: Ensure binary search on smaller array.
    • If a.length > b.length:
      ○ Swap arrays a and b
    • Reason: apply binary search on smaller array for efficiency
Step 2: Initialize variables.
    • Let n = a.length, m = b.length
    • Set search range:
      ○ l = max(0, k − m)
      ○ h = min(k, n)
    • Ensures valid partition sizes
a = [5,6,7]   (size 3)
b = [1,2,3,4] (size 4)
k = 5 
If we started from l = 0
cutA = 0
cutB = 5
b has only 4 elements
This split is impossible
By starting l = 1
cutA = 1
cutB = 4
This is the first valid combination
Step 3: Perform binary search.
    • While l ≤ h:
Step 4: Partition both arrays.
    • cutA = l + (h − l)/2
    • cutB = k − cutA
    • Total elements in left side = k
Step 5: Get boundary elements.
    • lA = (cutA == 0) ? −∞ : a[cutA − 1]
    • rA = (cutA == n) ? +∞ : a[cutA]
    • lB = (cutB == 0) ? −∞ : b[cutB − 1]
    • rB = (cutB == m) ? +∞ : b[cutB]
Step 6: Check correct partition.
    • If lA ≤ rB AND lB ≤ rA:
      ○ Correct partition found
Step 7: Return k-th element.
    • Return max(lA, lB) → k-th smallest element
Step 8: Adjust binary search.
    • Else if lA > rB:
      ○ Move left → h = cutA − 1
    • Else:
      ○ Move right → l = cutA + 1
Step 9: Return fallback.
    • If not found (edge case) → return −1
Time Complexity Analysis:
    • Binary search runs on smaller array of size n
    • Each step halves search space → log n iterations
    • Each iteration does constant work → O(1)
    • Total Time Complexity → O(log(min(n, m)))
Space Complexity Analysis:
    • No extra data structures used
    • Only constant variables used (cutA, cutB, etc.)
    • Total Space Complexity → O(1)

















  ==============> Code <==============

  
class Solution {
    public int kthElement(int a[], int b[], int k) {
        // code here
        if(a.length>b.length){
            int[] temp=a;
            a=b;
            b=temp;
        }
        int n=a.length, m=b.length;
        int l=Math.max(0,k-m);
        int h=Math.min(k,n);
        
        while(l<=h){
            
            int cutA=l+(h-l)/2;
            int cutB=k-cutA;
            
            int lA= (cutA==0) ? Integer.MIN_VALUE : a[cutA-1];
            int rA= (cutA==n) ? Integer.MAX_VALUE : a[cutA];
            
            int lB= (cutB==0) ? Integer.MIN_VALUE : b[cutB-1];
            int rB= (cutB==m) ? Integer.MAX_VALUE : b[cutB];
            
            if(lA<=rB && lB<=rA){
                return Math.max(lA,lB);
            }else if(lA>rB){
                h=cutA-1;
            }else{
                l=cutA+1;
            }
        }
        return -1;
    }
}
