Step-by-step algorithm to find all elements appearing more than ⌊n/3⌋ times using Boyer-Moore Voting Algorithm (Extended):
Step 1: Initialize variables.
• Set n1 = 0, c1 = 0 (first candidate and its count)
• Set n2 = 0, c2 = 0 (second candidate and its count)
Step 2: Traverse each element in the array nums (first pass).
• Sub-step 2a: If current element == n1
 o Increment c1 → c1++
• Sub-step 2b: Else if current element == n2
 o Increment c2 → c2++
• Sub-step 2c: Else if c1 == 0
 o Assign new candidate → n1 = current element
 o Set count → c1 = 1
• Sub-step 2d: Else if c2 == 0
 o Assign new candidate → n2 = current element
 o Set count → c2 = 1
• Sub-step 2e: Else
 o Decrement both counts → c1-- and c2--
Step 3: After first pass, n1 and n2 are potential candidates.
Step 4: Reset counts.
• Set c1 = 0
• Set c2 = 0
Step 5: Traverse the array again to count actual frequencies (second pass).
• Sub-step 5a: If element == n1 → increment c1
• Sub-step 5b: Else if element == n2 → increment c2
Step 6: Check which candidates satisfy the condition.
• Let m = ⌊n / 3⌋
• Sub-step 6a: If c1 > m → add n1 to result list
• Sub-step 6b: If c2 > m → add n2 to result list
Step 7: Return the result list containing majority elements.

Time Complexity:
1.	First pass takes O(n).
2.	Second pass takes O(n).
3.	Total time = O(n).
Time Complexity = O(n)
Space Complexity:
Only a few variables are used (excluding output list).
Space Complexity = O(1)










  ===================> Code <===================

  class Solution {
    List<Integer> al=new ArrayList<>();
    public List<Integer> majorityElement(int[] nums) {
        int n1=0, c1=0;
        int n2=0, c2=0;

        for(int n:nums){
            if(n1==n){
                c1++;
            }else if(n2==n){
                c2++;
            }else if(c1==0){
                n1=n;
                c1=1;
            }else if(c2==0){
                n2=n;
                c2=1;
            }else{
                c1--;
                c2--;
            }
        }

        c1=0;
        c2=0;
        for(int u:nums){
            if(n1==u){
                c1++;
            }else if(n2==u){
                c2++;
            }
        }

        int m=nums.length/3;
        if(c1>m)al.add(n1);
        if(c2>m)al.add(n2);

        return al;
    }
}
