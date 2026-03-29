Step-by-step algorithm to find the length of the Longest Increasing Subsequence (LIS) using Binary Search (Patience Sorting method):
Step 1: Initialize the required data structure.
 • Create a dynamic list al (ArrayList) to store elements of the current subsequence.
 • This list will not store the actual LIS but helps track the minimum possible tail of increasing subsequences of different lengths.
Step 2: Traverse each number in the input array nums.
 • For every num in nums, we decide where it fits in al.
Step 3: Perform binary search on al.
 • Initialize l = 0 and r = al.size() - 1.
 • While l <= r:
  o Compute mid = l + (r - l)/2.
  o If al.get(mid) < num, it means num can extend subsequences beyond mid.
   - Update l = mid + 1.
  o Otherwise (al.get(mid) >= num), num can replace an element to form a smaller tail:
   - Update r = mid - 1.
Step 4: Update the subsequence list.
 • After the binary search, l gives the position to place num.
 • Sub-step 4a: If l < al.size(), replace al[l] with num.
  o This maintains the smallest possible tail for increasing subsequences of length l+1.
 • Sub-step 4b: If l == al.size(), append num to al.
  o This increases the length of the potential longest increasing subsequence.
Step 5: Continue this process for all numbers in nums.
 • The list al grows or updates dynamically to maintain minimum possible tails.
Step 6: Return the length of al.
 • al.size() represents the length of the longest increasing subsequence.
Logic:
 • al maintains smallest tail elements for increasing subsequences of various lengths.
 • Replacing elements using binary search ensures that future numbers have more potential to extend subsequences.
 • This does not store the actual LIS but correctly calculates its length.
Time Complexity:
 • Each number requires a binary search in al of size at most n. (Binary search for n elements so).
 • Time Complexity = O(n log n)
Space Complexity:
 • List al stores at most n elements.
 • Space Complexity = O(n)
























  ====================> Code <=================
  class Solution {
    public int lengthOfLIS(int[] nums) {
        ArrayList<Integer> al=new ArrayList<>();
        for(int n:nums){
            int l=0, r=al.size()-1;

            while(l<=r){
                int mid=l+(r-l)/2;
                if(al.get(mid)<n){
                    l=mid+1;
                }else{
                    r=mid-1;
                }
            }

            if(l<al.size()){
                al.set(l,n);
            }else{
                al.add(n);
            }
        }
        return al.size();
    }
}
