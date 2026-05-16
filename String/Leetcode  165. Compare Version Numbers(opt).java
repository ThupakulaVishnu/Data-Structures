Step 1: Initialize pointers and lengths.
    • Set i = 0 for version1 and j = 0 for version2
    • Let n1 = version1.length(), n2 = version2.length()
Step 2: Traverse both strings.
    • While i < n1 OR j < n2:
Step 3: Build current number from version1.
    • Initialize num1 = 0
    • While i < n1 AND version1.charAt(i) != '.':
      ○ num1 = num1 * 10 + (digit at i)
      ○ Move i forward
Step 4: Build current number from version2.
    • Initialize num2 = 0
    • While j < n2 AND version2.charAt(j) != '.':
      ○ num2 = num2 * 10 + (digit at j)
      ○ Move j forward
Step 5: Compare both numbers.
    • If num1 < num2 → return -1
    • If num1 > num2 → return 1
Step 6: Move to next segment.
    • Increment i and j to skip '.'
Step 7: Continue until all segments are compared.
Step 8: Return result.
    • If all segments are equal → return 0
Time Complexity Analysis:
    • Each character in both strings is processed exactly once
    • No nested re-processing
    • Total Time Complexity → O(n1 + n2)
Space Complexity Analysis:
    • No extra data structures used
    • Only constant variables (num1, num2, pointers)
    • Total Space Complexity → O(1)



















  =============> Code <============
  
class Solution {
    public int compareVersion(String version1, String version2) {
        int i=0,j=0;
        int n1=version1.length(),n2=version2.length();

        while(i<n1 || j<n2){
            int num1=0,num2=0;

            while(i<n1 && version1.charAt(i)!='.'){
                num1=num1*10+(version1.charAt(i)-'0');
                i++;
            }

            while(j<n2 && version2.charAt(j)!='.'){
                num2=num2*10+(version2.charAt(j)-'0');
                j++;
            }

            if(num1<num2)return -1;
            if(num1>num2)return 1;

            i++;
            j++;

        }
        return 0;
    }
}
