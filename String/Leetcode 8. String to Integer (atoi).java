Step-by-step algorithm to implement myAtoi (string to integer conversion):
Step 1: Trim the string.
• Remove leading and trailing whitespaces → s = s.trim()
• If string is empty → return 0
Step 2: Initialize variables.
• inx = 0 → index for traversal
• sign = 1 → default positive sign
Step 3: Handle optional sign.
• If s.charAt(inx) is '-' or '+' →
 o If '-' → sign = -1
 o If '+' → sign = 1
 o Move to next index → inx++
Step 4: Initialize integer limits and result.
• max = Integer.MAX_VALUE
• min = Integer.MIN_VALUE
• num = 0
Step 5: Traverse digits and build number.
• While inx < s.length() AND s.charAt(inx) is digit:
 o Step 5a: Convert character to digit → n = s.charAt(inx++) - '0'
 o Step 5b: Check for overflow
  • If num > (max - n) / 10 →
   → If sign == -1 → return min
   → Else → return max
 o Step 5c: Update number → num = num * 10 + n
Step 6: Return final value.
• Return num * sign
Time Complexity:
• Traverse string once → O(n)
Time Complexity = O(n)
Space Complexity:
• Only constant variables used → O(1)
Space Complexity = O(1)












  ============> Code <=========
  

class Solution {
    public int myAtoi(String s) {
        s=s.trim();

        if(s.length()<=0) return 0;

        int inx=0;
        int sign=1;
        if(s.charAt(inx)=='-' || s.charAt(inx)=='+'){
            sign= s.charAt(inx)=='-' ? -1 : 1;
            inx++;
        }

        int max=Integer.MAX_VALUE;
        int min=Integer.MIN_VALUE;
        int num=0;
        while(inx<s.length() && Character.isDigit(s.charAt(inx))){
            int n=s.charAt(inx++)-'0';
            if(num>(max-n)/10){
                return sign==-1 ? min : max;
            }
            num=(num*10)+(n);
        }
        return num*sign;
    }
}
