Step 1: Ensure binary search on smaller array.
    • If nums1.length > nums2.length:
      ○ Swap nums1 and nums2
    • Reason: minimize binary search range
Step 2: Initialize variables.
    • Let n = nums1.length, m = nums2.length
    • Set l = 0, h = n (search space on nums1)
Step 3: Perform binary search.
    • While l ≤ h:
Step 4: Partition both arrays.
    • cutA = middle index of nums1 → l + (h − l)/2
    • cutB = (n + m + 1)/2 − cutA
    • Ensures left half contains half of total elements
Step 5: Get boundary elements.
    • lA = left element of nums1 partition
      ○ If cutA == 0 → −∞
    • rA = right element of nums1 partition
      ○ If cutA == n → +∞
    • lB = left element of nums2 partition
      ○ If cutB == 0 → −∞
    • rB = right element of nums2 partition
      ○ If cutB == m → +∞
Step 6: Check correct partition.
    • If lA ≤ rB AND lB ≤ rA:
      ○ Correct partition found
Step 7: Compute median.
    • If (n + m) is even:
      ○ Median = (max(lA, lB) + min(rA, rB)) / 2
    • Else:
      ○ Median = max(lA, lB)
Step 8: Adjust binary search.
    • Else if lA > rB:
      ○ Move left → h = cutA − 1
    • Else:
      ○ Move right → l = cutA + 1
Step 9: Return result.
    • Return computed median
Time Complexity Analysis:
    • Binary search is applied only on smaller array of size n
    • Each step halves the search space → log n iterations
    • All operations inside loop are constant time → O(1)
    • Total Time Complexity → O(log(min(n, m)))
Space Complexity Analysis:
    • No extra data structures used
    • Only a few variables (cutA, cutB, lA, rA, etc.) → constant space
    • Total Space Complexity → O(1)


















==========> Code <==========

  
class Solution {
    public double findMedianSortedArrays(int[] nums1, int[] nums2) {
        if(nums1.length>nums2.length){
            int[] temp=nums1;
            nums1=nums2;
            nums2=temp;
        }
        int n=nums1.length, m=nums2.length;
        
        int l=0,h=nums1.length;

        while(l<=h){
            int cutA=l+(h-l)/2;
            int cutB=((n+m+1)/2)-cutA;

            int lA= (cutA==0) ? Integer.MIN_VALUE : nums1[cutA-1];
            int rA= (cutA==n) ? Integer.MAX_VALUE : nums1[cutA];

            int lB= (cutB==0) ? Integer.MIN_VALUE : nums2[cutB-1];
            int rB= (cutB==m) ? Integer.MAX_VALUE : nums2[cutB];

            if(lA<=rB && lB<=rA){
                if((n+m)%2==0){
                    return ((double)Math.max(lA,lB)+(double)Math.min(rA,rB))/2;
                }
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
