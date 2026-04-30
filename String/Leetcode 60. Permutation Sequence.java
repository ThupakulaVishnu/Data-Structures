Step 1: Create list of numbers and compute factorial.
    • Initialize List al = new ArrayList<>()
    • Initialize fact = 1
    • For i = 1 to n:
      ○ Add i to list → al.add(i)
      ○ Update factorial → fact *= i
    • Now list contains [1, 2, 3, ..., n] and fact = n!
Step 2: Adjust k to zero-based indexing.
    • Decrement k → k = k − 1
    • Reason: easier index calculation
Step 3: Initialize result container.
    • Create StringBuilder sb = new StringBuilder()
Step 4: Build permutation one position at a time.
    • For i = n down to 1:
Step 5: Update factorial for remaining elements.
    • fact = fact / i
    • Now fact represents (i−1)!
Step 6: Find correct index for current position.
    • indx = k / fact
    • This gives which number to pick from remaining list
Step 7: Update k for next iteration.
    • k = k % fact
Step 8: Add selected element to result.
    • Append al.get(indx) to sb
    • Remove that element from list → al.remove(indx)
Step 9: Repeat until all positions are filled.
    • Continue steps 4–8 until list becomes empty
Step 10: Return final permutation.
    • Return sb.toString()
Time Complexity Analysis:
    • Building list + factorial → O(n)
    • For each of n positions, removing from ArrayList → O(n) per remove
    • Total Time Complexity → O(n²)
Space Complexity Analysis:
    • ArrayList stores n elements → O(n)
    • StringBuilder stores result → O(n)
    • Total Space Complexity → O(n)













  =========> Code <==========

  
class Solution {
    public String getPermutation(int n, int k) {
        List<Integer> al=new ArrayList<>();
        int fact=1;
        for(int i=1;i<=n;i++){
            al.add(i);
            fact*=i;
        }
        k--;
        StringBuilder sb=new StringBuilder();

        for(int i=n;i>0;i--){
            fact=fact/i;
            int indx=k/fact;
            k=k%fact;

            sb.append(al.get(indx));
            al.remove(indx);
        }

        return sb.toString();
    }
}
