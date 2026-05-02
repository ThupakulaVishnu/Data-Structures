Step 1: Initialize result list.
    • Create List ans to store all valid sentence combinations
Step 2: Handle base condition in main function.
    • If s.length() == 0:
      ○ Return empty ans
Step 3: Start backtracking.
    • Call find(0, s.length(), s, wordDict, empty temp list)
    • temp stores current sequence of words
Step 4: Check base case in recursion.
    • If l == n (we reached end of string):
      ○ Convert temp list into sentence
      ○ Join words with spaces
      ○ Add formed sentence to ans
      ○ Return
Step 5: Try all possible splits.
    • For k = l + 1 to n:
      ○ Extract substring → str = s.substring(l, k)
Step 6: Check if substring is valid word.
    • If dict.contains(str):
      ○ Add word to current path → temp.add(str)
Step 7: Recurse for remaining string.
    • Call find(k, n, s, wordDict, temp)
Step 8: Backtrack.
    • Remove last word → temp.remove(temp.size() − 1)
Step 9: Repeat for all splits.
    • Continue trying all possible partitions of string
Step 10: Return final result.
    • Return ans → all possible valid sentences
Time Complexity Analysis:
    • At each index i, we try all possible splits from i to n → for every position we have 2 choices (cut or don’t cut), so  .                   .                  total possibilities grow like a binary tree → 2^n
    • For each recursive path, we build substrings using s.substring(l, k) which takes O(n) in worst case
    • Also, checking if a word exists in dictionary using List.contains() takes O(m) (m = size of wordDict)
    • Constructing final sentence from temp list also takes O(n) per valid solution
    • Total Time Complexity → O(2^n × n x n x m) (approx worst case)
Space Complexity Analysis:
    • Recursion depth → O(n)
    • Temporary list (path) → O(n)
    • Result storage → O(k × n) (k = number of valid sentences)
    • Total Space Complexity → O(n × k)



















  ==============> Code <==============

  
class Solution {
    List<String> ans=new ArrayList<>();
    public List<String> wordBreak(String s, List<String> wordDict) {
        if(s.length()==0)return ans;
        find(0,s.length(),s,wordDict,new ArrayList<>());
        return ans;
    }
    public void find(int l,int n,String s,List<String> dict,List<String> temp){
        if(l==n){
            StringBuilder sb=new StringBuilder();
            for(int i=0;i<temp.size();i++){
                if(i<temp.size()-1){
                    sb.append(temp.get(i)+" ");
                }else{
                    sb.append(temp.get(i));
                }
            }
            ans.add(sb.toString());
            return;
        }
        for(int k=l+1;k<=n;k++){
            String str=s.substring(l,k);
            if(dict.contains(str)){
                temp.add(str);
                find(k,n,s,dict,temp);
                temp.remove(temp.size()-1);
            }
        }
    }
}
