Step-by-step algorithm for reversing words in a string:

Step 1: Remove leading and trailing spaces from the string using trim().

Step 2: Initialize two variables:

end = length of the string

start = length of the string

Step 3: Create an empty StringBuilder sb to store the result.

Step 4: Traverse the string from right to left (i = length-1 to 0).

Sub-step 4a: If the current character is a space:

Set start = i.

Sub-step 4b: Check if start + 1 < end.
(This ensures there is a valid word between start and end.)

If true:

Extract substring from index (i + 1) to end.

Append this word to sb.

Append one space after the word.

Set end = start.

Sub-step 4c: Update end = start.

Step 5: After finishing the loop,
append the first word (from index 0 to end) to sb.

Step 6: Convert StringBuilder to string and return it.

Time Complexity:
The string is traversed once.
Time Complexity = O(n)

Space Complexity:
Extra space is used for StringBuilder.
Space Complexity = O(n)


              --------------> Code <------------------


  class Solution {
    public String reverseWords(String s) {
        s=s.trim();

        int end=s.length();
        int start=s.length();

        StringBuilder sb=new StringBuilder();
        for(int i=s.length()-1;i>=0;i--){
            if(s.charAt(i)==' '){
                start=i;
            }
            if(start+1<end){
                sb.append(s.substring(i+1,end)+" ");
            }
            end=start;
        }

        return sb.append(s.substring(0,end)).toString();
    }
}
