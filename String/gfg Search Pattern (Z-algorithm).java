Step-by-step algorithm to search for all occurrences of a pattern in a text using the Z-Algorithm:
Step 1: Construct a new combined string.
 • Concatenate the pattern, a special separator character $, and the text to form a single string.
 • The separator ensures that comparisons do not mix characters between the pattern and the text.
Step 2: Initialize required variables and data structures.
 • Let n be the length of the combined string.
 • Create an integer array (Z-array) of size n to store Z-values.
 • Initialize two pointers L and R to represent the current Z-box (matching window).
 • Create an ArrayList to store the indices where the pattern occurs in the text.
Step 3: Traverse the combined string starting from index 1.
 • For each position i, compute the length of the substring starting at i that matches the prefix of the string.
Step 4: Check if the current index is outside the Z-box.
 • Sub-step 4a: If i > R
  o Set both L and R equal to the current index i.
  o Start comparing characters between the prefix of the string and the substring starting at i.
  o Continue expanding the window while characters match.
  o Store the length of the match in the Z-array at position i.
  o Decrease R by one to correctly maintain the Z-box boundary.
Step 5: If the current index is inside the Z-box.
 • Sub-step 5a: Compute the corresponding index inside the Z-box (k = i - L).
 • Sub-step 5b: If the previously computed Z-value at index k is smaller than the remaining window size:
  o Directly copy that value into the Z-array at position i because the match is guaranteed inside the current window.
 • Sub-step 5c: Otherwise:
  o Move the left boundary L to the current index i.
  o Expand the window again by comparing characters with the prefix.
  o Increase R while characters continue matching.
  o Store the new match length in the Z-array at position i.
  o Decrease R by one after finishing the comparison.
Step 6: After computing all Z-values, search for pattern matches.
 • Traverse the Z-array completely.
 • If any value equals the length of the pattern, it means the pattern exactly matches that position in the text.
Step 7: Store the index of the occurrence.
 • Calculate the actual index in the text by subtracting the pattern length and the separator from the current index.
 • Add this index into the ArrayList storing the results.
Step 8: Return the ArrayList containing all starting indices where the pattern appears in the text.
Logic:
 • The Z-array stores the length of the longest substring starting at each index that matches the prefix of the string.
 • When a Z-value becomes equal to the pattern length, it means the pattern is found at that position in the text.
 • The Z-box (L and R) helps reuse previously computed matches and avoids unnecessary character comparisons.
 • This optimization allows the algorithm to run efficiently in linear time.
Time Complexity:
 The combined string is processed in a single pass while maintaining the Z-box.
 Time Complexity = O(n + m)
 (where n is the length of the text and m is the length of the pattern)
Space Complexity:
 An additional integer array (Z-array) is used to store Z-values.
 Space Complexity = O(n + m)



















  ================> Code <=============

  class Solution {
    public static ArrayList<Integer> search(String txt, String pat) {
        // code here
        String str=pat+"$"+txt;
        int cut=0;
        int L=0,R=0;
        int n=str.length();
        int[] len=new int[str.length()];
        
        for(int i=1;i<str.length();i++){
            if(i>R){
                L=R=i;
                while(R<n && str.charAt(R-L)==str.charAt(R)){
                    R++;
                }
                len[i]=R-L;
                R--;
            }else{
                int k=i-L;
                if(len[k]< R-i+1){
                    len[i]=len[k];
                }else{
                    L=i;
                    while(R<n && str.charAt(R-L)==str.charAt(R)){
                        R++;
                    }
                    len[i]=R-L;
                    R--;
                }
            }
        }
        ArrayList<Integer> al=new ArrayList<>();
        for(int h=0;h<len.length;h++){
            if(len[h]==pat.length()){
                al.add(h-pat.length()-1);
            }
        }
        return al;
    }
}
