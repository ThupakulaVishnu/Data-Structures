Step-by-step algorithm to generate all palindromic partitions of a string:
Step 1: Initialize variables.
                     • Create a result list → result = new ArrayList<>()
Step 2: Start the recursive backtracking process.
                     • Call find(s, 0, new ArrayList<>())
Step 3: Define the recursive function find(s, start, al)
                     • Base Case:
                      o If start == s.length() → add a copy of al to result → result.add(new ArrayList<>(al)) → return
                     • Recursive Case:
                      o For i from start to s.length()−1
                       • Sub-step 3a: Check if substring s[start…i] is a palindrome using ispalindrom(start, i, s)
                       • Sub-step 3b: If it is a palindrome
                        • Add substring to current list → al.add(s.substring(start, i+1))
                        • Recurse for remaining string → find(s, i+1, al)
                        • Backtrack → remove last element from al → al.remove(al.size()−1)
Step 4: Define ispalindrom(st, end, s) function
                     • While st < end
                      o If s.charAt(st) != s.charAt(end) → return false
                      o Increment st and decrement end
                     • Return true (all characters matched)
Step 5: Return the result list containing all palindromic partitions
Time Complexity:
1.	For a string of length n, there are n−1 gaps where we can cut.
2.	At each gap, we have 2 choices (cut / not cut).
3.	So total number of partitions = 2^(n−1) ≈ O(2ⁿ).
4.	In each partition, we check palindromes for substrings, but total characters processed = n.
5.	s = "abc" (n = 3)
         All possible partitions:
         a | b | c 
         a | bc 
         ab | c 
         abc 
         👉 Total = 4 = 2² = 2^(n−1)
6.	So work per partition = O(n).
                  Total Time Complexity = O(2ⁿ × n)
Space Complexity:
1.	Recursion depth goes up to n (in worst case we partition one character at a time).
2.	Temporary list al stores substrings whose total length is at most n.
Example (worst case):
Step 1: Count partitions
•	String length = 3 → gaps = 2
•	Each gap → 2 choices (cut / not cut)
•	Total partitions = 2² = 4
All partitions:
•	"a" | "a" | "a"
•	"a" | "aa"
•	"aa" | "a"
•	"aaa"
Step 2: Space for each partition
•	"a" | "a" | "a" → 3 substrings, total characters = 3
•	"a" | "aa" → 2 substrings, total characters = 3
•	"aa" | "a" → 2 substrings, total characters = 3
•	"aaa" → 1 substring, total characters = 3
•	Number of partitions × space per partition = 4 × 3 = O(2ⁿ × n) 
•	Plus recursion stack = O(n)
✅ Each partition stores at most n = 3 characters
3.	Number of partitions generated = O(2ⁿ)
4.	Each partition stores substrings whose total length = n
5.	Total space = Number of partitions × space per partition + recursion stack = O(2ⁿ × n) + O(n)
Total Space Complexity = O(2ⁿ × n) + O(n)
















  ====================> code<===================

  
class Solution {
    List<List<String>> result=new ArrayList<>();
    public List<List<String>> partition(String s) {
        find(s,0,new ArrayList<>());
        return result;
    }

    public void find(String s,int start,List<String> al){
        if(start==s.length()){
            result.add(new ArrayList<>(al));
            return;
        }

        for(int i=start;i<s.length();i++){
            if(ispalindrom(start,i,s)){
                al.add(s.substring(start,i+1));
                find(s,i+1,al);
                al.remove(al.size()-1);
            }
        }
    }

    public boolean ispalindrom(int st,int end,String s){
        while(st<end){
            if(s.charAt(st++)!=s.charAt(end--))return false;
        }
        return true;
    }
}
