Step-by-step algorithm to **find the missing and repeating numbers in an array**:

Step 1: Initialize variables.
 • Let `n` be the length of the array `arr`.
 • Compute the **expected sum** of numbers from 1 to n:
  o `sum = n * (n + 1) / 2`
 • Compute the **expected sum of squares** of numbers from 1 to n:
  o `sqsum = n * (n + 1) * (2n + 1) / 6`

Step 2: Compute the actual sum and sum of squares from the array.
 • Initialize `asum = 0` and `asqsum = 0`.
 • Loop through each element `nm` in `arr`:
  o `asum += nm` → sum of elements in the array
  o `asqsum += nm * nm` → sum of squares of elements in the array

Step 3: Compute the differences between expected and actual sums.
 • Let `val1 = sum - asum` → this equals `(missing - repeating)`
 • Let `val2 = (sqsum - asqsum) / val1` → this equals `(missing + repeating)`

Step 4: Solve for missing and repeating numbers.
 • `missing = (val1 + val2) / 2`
 • `repeating = missing - val1`

Step 5: Store the results in a list.
 • Create an ArrayList `al`.
 • Add `repeating` first, then `missing`.

Step 6: Return the ArrayList.
 • This list contains the **repeating number** and the **missing number** in order.

Logic:
 • Uses **mathematical equations**:
  o Sum formula: 1 + 2 + ... + n = n*(n+1)/2
  o Sum of squares formula: 1² + 2² + ... + n² = n*(n+1)*(2n+1)/6
 • Let x = repeating, y = missing:
  o sum - actual sum = y - x → val1
  o sum of squares - actual sum of squares = y² - x² → val2 * val1
 • Solve the two equations to get x and y.

**Time Complexity:**
 • One pass through the array to compute sums → **O(n)**

**Space Complexity:**
 • Only a few variables are used → **O(1)** (excluding output list)








  -----------------> Code <---------------------

  class Solution {
    ArrayList<Integer> findTwoElement(int arr[]) {
        // code here
        int n=arr.length;
        
        
        long  sum=(long)n*(n+1)/2;
        long sqsum=(long)n*(n+1)*(2*n+1)/6;
        
        long asum=0, asqsum=0;
        
        for(int nm:arr){
            asum+=(long)nm;
            asqsum+=(long)nm*nm;
        }
        
        long val1=sum-asum;
        long val2=(sqsum-asqsum)/val1;
        
        int miss=(int)(val1+val2)/2;
        int extra=miss-(int)val1;
        
        ArrayList<Integer> al=new ArrayList<>();
        al.add(extra);
        al.add(miss);
        
        return al;
        
    }
}
