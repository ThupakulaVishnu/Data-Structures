Step 1: Initialize base case.
    • Set result = "1"
    • This is the first sequence
Step 2: Build sequence from 2 to n.
    • For i = 2 to n:
Step 3: Initialize new string builder.
    • Create StringBuilder sb
    • Initialize count = 1
Step 4: Traverse previous result string.
    • For j = 1 to result.length() − 1:
Step 5: Count repeating characters.
    • If result.charAt(j) == result.charAt(j−1):
      ○ Increment count → count++
Step 6: Handle change in character.
    • Else:
      ○ Append count → sb.append(count)
      ○ Append previous character → sb.append(result.charAt(j−1))
      ○ Reset count = 1
Step 7: Append last group.
    • After loop ends:
      ○ Append count
      ○ Append last character of result
Step 8: Update result.
    • result = sb.toString()
Step 9: Repeat until nth sequence.
    • Continue building sequences iteratively
Step 10: Return final result.
    • Return result
Time Complexity Analysis:
    • Outer loop runs from 2 to n → n iterations
    • For each iteration, we traverse the current string (say length = L) → O(L)
    • Length of string grows every iteration (not constant), so total work is cumulative
    • Total Time Complexity → O(n × L) (where L = length of final string, approx exponential growth)

Space Complexity Analysis:
    • We store the current sequence string of length L
    • StringBuilder also holds similar size temporarily
    • No extra structures apart from this
    • Total Space Complexity → O(L)


















  ==============> Code <===========

  class Solution {
    public String countAndSay(int n) {
        String result="1";

        for(int len=2;len<=n;len++){
            StringBuilder sb=new StringBuilder();
            int count=1;

            for(int j=1;j<result.length();j++){
                if(result.charAt(j)==result.charAt(j-1)){
                    count++;
                }else{
                    sb.append(count);
                    sb.append(result.charAt(j-1));
                    count=1;
                }
            }

            sb.append(count);
            sb.append(result.charAt(result.length()-1));

            result=sb.toString();
        }
        return result;
    }
}
