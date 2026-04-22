Step 1: Sort the array.
    • Call Arrays.sort(nums) to sort the array in ascending order
Step 2: Fix the first element (pointer a).
    • For a = 0 to n − 4:
      ○ Skip duplicates → if(a > 0 && nums[a] == nums[a-1]) continue
Step 3: Fix the second element (pointer b).
    • For b = a + 1 to n − 3:
      ○ Skip duplicates → if(b > a + 1 && nums[b] == nums[b-1]) continue
Step 4: Initialize two pointers.
    • Set c = b + 1 and d = n − 1
Step 5: Apply two-pointer technique.
    • While c < d:
      ○ Compute sum → sum = nums[a] + nums[b] + nums[c] + nums[d]
      ○ Use long to avoid overflow
Step 6: Check conditions.
    • If sum == target:
      ○ Create a list → [nums[a], nums[b], nums[c], nums[d]]
      ○ Add it to result list ans
      ○ Move c forward → c++
      ○ Skip duplicates for c → while(c < d && nums[c] == nums[c-1]) c++
      ○ Skip duplicates for d → while(c < d && nums[d] == nums[d+1]) d--
    • Else if sum < target:
      ○ Increase sum → c++
    • Else (sum > target):
      ○ Decrease sum → d--
Step 7: Return result.
    • Return ans → list of unique quadruplets
Time Complexity Analysis:
    • Sorting → O(n log n)
    • Outer loops (a and b) → O(n²)
    • Inner two-pointer loop → O(n)
    • Total Time Complexity → O(n³)
Space Complexity Analysis:
    • Sorting uses O(log n) stack space
    • Output list stores quadruplets → O(k)
    • Total Space Complexity → O(k + log n)


















  ==============> Code <===============

  
class Solution {
    public List<List<Integer>> fourSum(int[] nums, int target) {
        List<List<Integer>> ans=new ArrayList<>();
        int n=nums.length;

        Arrays.sort(nums);

        for(int a=0;a<=n-4;a++){
            if(a>0 && nums[a]==nums[a-1])continue;

            for(int b=a+1;b<=n-3;b++){
                if(b>a+1 && nums[b]==nums[b-1])continue;
                int c=b+1, d=n-1;
                
                while(c<d){
                    long sum=(long)nums[a]+nums[b]+nums[c]+nums[d];
                    if(sum==target){
                        List<Integer> al=new ArrayList<>();
                        al.add(nums[a]);
                        al.add(nums[b]);
                        al.add(nums[c]);
                        al.add(nums[d]);
                        ans.add(new ArrayList<>(al));
                        c++;
                        while(c<d && nums[c]==nums[c-1])c++;
                        while(c<d && nums[d]==nums[d-1])d--;
                    }else if(sum<target){
                        c++;
                    }else{
                        d--;
                    }
                }
            }
        }
        return ans;
    }
}
