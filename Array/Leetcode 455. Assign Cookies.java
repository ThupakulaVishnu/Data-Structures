Step 1: Sort both arrays.
    • Call Arrays.sort(g) → sort children greed factors
    • Call Arrays.sort(s) → sort cookie sizes
Step 2: Initialize pointers.
    • Set a = 0 → pointer for children
    • Set b = 0 → pointer for cookies
Step 3: Traverse both arrays.
    • While a < g.length AND b < s.length:
Step 4: Check if current cookie can satisfy child.
    • If s[b] >= g[a]:
      ○ Child is satisfied → move to next child → a++
Step 5: Always move cookie pointer.
    • Move to next cookie → b++
Step 6: Continue until one array ends.
    • Repeat until all children checked or cookies exhausted
Step 7: Return result.
    • Return a → number of satisfied children
Time Complexity Analysis:
    • Sorting both arrays → O(n log n + m log m)
    • Single traversal → O(n + m)
    • Total Time Complexity → O(n log n + m log m)
Space Complexity Analysis:
    • Sorting in-place → O(log n + log m) recursion stack
    • No extra data structures used
    • Total Space Complexity → O(log n + log m)



















  ==========> Code <===========

  
class Solution {
    public int findContentChildren(int[] g, int[] s) {
        Arrays.sort(g);
        Arrays.sort(s);

        int a=0,b=0;
        while(a<g.length && b<s.length){
            if(s[b]>=g[a]){
                a++;
            }
            b++;
        }
        return a;
    }
}
