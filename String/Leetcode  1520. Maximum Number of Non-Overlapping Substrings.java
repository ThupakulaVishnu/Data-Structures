Step 1: Initialize arrays to track character positions.
           • start[26] → store first occurrence index of each character, initialize with n
           • end[26] → store last occurrence index of each character, initialize with -1
Step 2: Populate start and end arrays.
           • For k = 0 to n-1:
                     ○ c = s.charAt(k)
                     ○ start[c-'a'] = Math.min(start[c-'a'], k)
                     ○ end[c-'a'] = k
Step 3: Find valid intervals for substrings.
           • Create list intervals to store [l, r] pairs
           • For each character i = 0 to 25:
                     ○ If start[i] == n → continue
                     ○ Initialize l = start[i], r = end[i], vail = true
                     ○ For j = l to r:
                             • ch = s.charAt(j)
                             • If start[ch-'a'] < l → vail = false, break
                             • r = Math.max(r, end[ch-'a'])
                     ○ If vail → intervals.add([l, r])
Step 4: Sort intervals by end index.
           • intervals.sort((a, b) -> a[1] - b[1])
Step 5: Select non-overlapping substrings.
           • Initialize preval = -1
           • For each curr in intervals:
                     ○ If curr[0] > preval:
                             • Add substring → ans.add(s.substring(curr[0], curr[1]+1))
                             • Update preval = curr[1]
Step 6: Return result list ans.
Time Complexity Analysis:
           • Step 2 (populate start/end) → O(n)
           • Step 3 (build intervals) → O(26 * n) → O(n)
           • Step 4 (sort intervals) → O(k log k), k = number of intervals ≤ 26 → O(1) effectively
           • Step 5 (select substrings) → O(k) → O(1) effectively
           Total Time Complexity → O(n)
Space Complexity Analysis:
           • start and end arrays → O(26) → O(1)
           • intervals list → O(26) → O(1)
           • ans list → O(n) in worst case → storing substrings
           Total Space Complexity → O(n)




















  ==============> code <==============

  
class Solution {
    public List<String> maxNumOfSubstrings(String s) {
        int n=s.length();

        int[] start=new int[26];
        int[] end=new int[26];

        Arrays.fill(start,n);
        Arrays.fill(end,-1);

        for(int k=0;k<n;k++){
            char c=s.charAt(k);
            start[c-'a']=Math.min(start[c-'a'],k);
            end[c-'a']=k;
        }

        List<int[]> intervals=new ArrayList<>();

        for(int i=0;i<26;i++){
            if(start[i]==n)continue;
            int l=start[i];
            int r=end[i];
            boolean vail=true;

            for(int j=l;j<=r;j++){
                char ch=s.charAt(j);
                if(start[ch-'a']<l){
                    vail=false;
                    break;
                }
                r=Math.max(r,end[ch-'a']);
            }
            if(vail)intervals.add(new int[]{l,r}); 
        }

        List<String> ans=new ArrayList<>();

        intervals.sort((a,b)->a[1]-b[1]);

        int preval=-1;
        for(int[] curr:intervals){
            if(curr[0]>preval){
                ans.add(s.substring(curr[0],curr[1]+1));
                preval=curr[1];
            }
        }
        return ans;
    }
}
