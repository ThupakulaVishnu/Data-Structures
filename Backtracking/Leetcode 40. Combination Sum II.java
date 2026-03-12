Step-by-step algorithm for Combination Sum II:

    Step 1: Sort the candidates array in ascending order.
    (This helps in handling duplicates and allows early stopping when the current number exceeds the target.)

    Step 2: Initialize a global list to store all valid combinations.

    Step 3: Create a temporary list to store the current combination being built.

    Step 4: Start a recursive function with parameters:
        • The sorted candidates array
        • The target sum
        • Current sum of the combination
        • Start index
        • Current combination list

    Step 5: In the recursive function:
        • Sub-step 5a: If the current sum exceeds the target, return (invalid path).
        • Sub-step 5b: If the current sum equals the target,
            o Add a copy of the current combination to the result list.
            o Return to explore other possibilities.

    Step 6: Loop through the candidates starting from the current index:
        • Sub-step 6a: Skip duplicates:
            o If the current candidate is the same as the previous candidate and it’s not the first index in this loop, continue to the next candidate.

        • Sub-step 6b: Early stopping:
            o If the current candidate is greater than the target, break the loop (no further candidates will fit).

        • Sub-step 6c: Add the current candidate to the combination list.

        • Sub-step 6d: Recurse:
            o Pass the next index (i + 1) since each candidate can be used only once.

        • Sub-step 6e: Remove the last added candidate from the combination list (backtracking) to explore other options.

    Step 7: Continue this process until all combinations are explored.

    Step 8: Return the global list containing all valid combinations.

Logic:

    • Uses backtracking to explore all possible unique combinations.
    • Duplicates are avoided by sorting and skipping consecutive equal numbers.
    • Each candidate is used only once.

Time Complexity:

    • Exponential in the worst case → O(2^n) (n = number of candidates)

Space Complexity:

    • Recursion stack + temporary combination list → O(n) (maximum depth of recursion)















                      ================> Code <=============

  class Solution {
    List<List<Integer>> al=new ArrayList<>();
    public List<List<Integer>> combinationSum2(int[] candidates, int target) {
        Arrays.sort(candidates);
        List<Integer> adj=new ArrayList<>();
        find(candidates,target,0,0,adj);
        return al;
    }
    public void find(int[] arr,int tar,int sum,int st,List<Integer> adj){
        if(sum>tar){
            return;
        }
        if(sum==tar){
            al.add(new ArrayList<>(adj));
            return;
        }
        for(int i=st;i<arr.length;i++){
            if(i>st && arr[i]==arr[i-1]){
                continue;
            }
            if(arr[i]>tar)break;
            adj.add(arr[i]);
            find(arr,tar,sum+arr[i],i+1,adj);
            adj.remove(adj.size()-1);
        }
    }
}
