Step 1: Initialize pointers and variables.
    • Set left pointer → l = 0
    • Set right pointer → r = height.length − 1
    • Initialize left max → lm = 0
    • Initialize right max → rm = 0
    • Initialize water = 0
Step 2: Traverse using two pointers.
    • While l < r:
Step 3: Compare heights at both ends.
    • If height[l] < height[r]:
      ○ Process left side
Step 4: Update left max and calculate water.
    • Update lm = max(lm, height[l])
    • Water trapped at index l → lm − height[l]
    • Add to total → water += (lm − height[l])
    • Move left pointer → l++
Step 5: Otherwise process right side.
    • Else (height[l] ≥ height[r]):
Step 6: Update right max and calculate water.
    • Update rm = max(rm, height[r])
    • Water trapped at index r → rm − height[r]
    • Add to total → water += (rm − height[r])
    • Move right pointer → r--
Step 7: Continue until pointers meet.
    • Repeat steps until l >= r
Step 8: Return final result.
    • Return water → total trapped rainwater
Time Complexity Analysis:
    • Single pass through array → O(n)
    • Total Time Complexity → O(n)
Space Complexity Analysis:
    • Only constant variables used (no extra arrays)
    • Total Space Complexity → O(1)


















============> Code <===============
  
class Solution {
    public int trap(int[] height) {
        int l=0,r=height.length-1;
        int lm=0,rm=0,water=0;
        while(l<r){
            if(height[l]<height[r]){
                lm=Math.max(lm,height[l]);
                water+=lm-height[l];
                l++;
            }else{
                rm=Math.max(rm,height[r]);
                water+=rm-height[r];
                r--;
            }
        }
        return water;
    }
}
