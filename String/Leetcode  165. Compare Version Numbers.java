Step 1: Split both version strings.
    • Split version1 using "." → array v1
    • Split version2 using "." → array v2
    • Each element represents a revision number
Step 2: Find maximum length.
    • Compute ml = max(v1.length, v2.length)
    • Needed to compare all levels
Step 3: Traverse all revision levels.
    • For i = 0 to ml − 1:
Step 4: Get current numbers.
    • If i < v1.length → num1 = Integer.parseInt(v1[i])
    • Else → num1 = 0
    • If i < v2.length → num2 = Integer.parseInt(v2[i])
    • Else → num2 = 0
Step 5: Compare values.
    • If num1 < num2 → return -1
    • If num1 > num2 → return 1
Step 6: Continue if equal.
    • Move to next index
Step 7: Return result.
    • If all revisions equal → return 0
Time Complexity Analysis:
    • Splitting both strings → O(n + m)
    • Traversing all parts → O(max(n, m))
    • Parsing integers takes proportional to digits → overall bounded by string length
    • Total Time Complexity → O(n + m)
Space Complexity Analysis:
    • Arrays created after split → O(n + m)
    • No extra significant space used
    • Total Space Complexity → O(n + m)


















==============> Code <=============
  
class Solution {
    public int compareVersion(String version1, String version2) {
        String[] v1=version1.split("\\.");
        String[] v2=version2.split("\\.");

        int ml=Math.max(v1.length,v2.length);

        for(int i=0;i<ml;i++){
            int num1= i<v1.length ? Integer.parseInt(v1[i]) : 0;
            int num2= i<v2.length ? Integer.parseInt(v2[i]) : 0;

            if(num1<num2)return -1;
            if(num1>num2)return 1;
        }
        return 0;
    }
}
