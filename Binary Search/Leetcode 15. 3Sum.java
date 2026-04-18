Step 1: Sort the array.
           • Call Arrays.sort(nums) to sort nums in ascending order
Step 2: Traverse the array with first pointer a.
           • For a = 0 to nums.length - 1:
                     ○ Skip duplicates → if(a > 0 && nums[a] == nums[a-1]) continue
                     ○ Initialize two pointers → b = a + 1, c = nums.length - 1
Step 3: Use two-pointer technique to find triplets.
           • While b < c:
                     ○ Compute sum → val = nums[a] + nums[b] + nums[c]
                     ○ If val < 0 → move b forward → b++
                     ○ Else if val > 0 → move c backward → c--
                     ○ Else → sum is zero:
                             • Create triplet list → [nums[a], nums[b], nums[c]]
                             • Add triplet to answer list ans
                             • Increment b → b++
                             • Skip duplicates for b → while(b < c && nums[b] == nums[b-1]) b++
Step 4: Return the result.
           • Return ans → list of unique triplets
Time Complexity Analysis:
           • Sorting → O(n log n)
           • Outer loop runs n times, inner two-pointer loop runs at most n times → O(n²)
           • Total Time Complexity → O(n²)
Space Complexity Analysis:
           • Sorting in-place → O(log n) recursion stack
           • Answer list stores triplets → O(k) for k triplets
           • Total Space Complexity → O(k + log n)


















  =============> Code <==========


  
class Solution {
    public List<List<Integer>> threeSum(int[] nums) {
        List<List<Integer>> ans=new ArrayList<>();
        Arrays.sort(nums);

        for(int a=0;a<nums.length;a++){
            if(a>0 && nums[a]==nums[a-1])continue;
            int b=a+1, c=nums.length-1;

            while(b<c){
                int val=nums[a]+nums[b]+nums[c];
                if(val<0){
                    b++;
                }else if(val>0){
                    c--;
                }else{
                    List<Integer> l=new ArrayList<>();
                    l.add(nums[a]);
                    l.add(nums[b]);
                    l.add(nums[c]);
                    ans.add(new ArrayList<>(l));
                    b++;
                    while(b<c && nums[b]==nums[b-1])b++;
                    while(b<c && nums[c]==nums[c-1])c--;
                }
            }
        }
        return ans;
    }
}
