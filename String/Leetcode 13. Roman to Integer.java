Step-by-step algorithm to convert Roman number to Integer:
Step 1: Initialize mapping.
• Create a hashmap hm to store Roman values:
 o I → 1
 o V → 5
 o X → 10
 o L → 50
 o C → 100
 o D → 500
 o M → 1000
Step 2: Initialize result.
• Set result = 0
Step 3: Traverse the string.
• For i = 0 to s.length() - 1:
 o Step 3a: Get value of current character
  • val = hm.get(s.charAt(i))
 o Step 3b: Check next character condition
  • If i + 1 < s.length() AND val < hm.get(s.charAt(i+1))
   → subtract value → result -= val
 o Step 3c: Otherwise
   → add value → result += val
Step 4: Return result.
• Return result
Time Complexity:
• Traversing string once → O(n)
Time Complexity = O(n)
Space Complexity:
• HashMap stores constant 7 entries → O(1)
Space Complexity = O(1)










  ============> Code<============
  class Solution {
    public int romanToInt(String s) {
        Map<Character,Integer> hm=new HashMap<>();
        hm.put('I',1);
        hm.put('V',5);
        hm.put('X',10);
        hm.put('L',50);
        hm.put('C',100);
        hm.put('D',500);
        hm.put('M',1000);

        int sum=0;
        for(int i=0;i<s.length();i++){
            int val=hm.get(s.charAt(i));

            if(i+1<s.length() && val<hm.get(s.charAt(i+1))){
                sum-=val;
            }else{
                sum+=val;
            }
        }
        return sum;
    }
}
