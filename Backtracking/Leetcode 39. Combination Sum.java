Step-by-step algorithm for Combination Sum problem:

    Step 1: Initialize a global list to store all valid combinations.

    Step 2: Create a temporary list to store the current combination being built.

    Step 3: Start a recursive function with parameters:
        • The candidates array
        • The target sum
        • Current sum of the combination
        • Start index
        • Current combination list

    Step 4: In the recursive function:
        • Sub-step 4a: If the current sum exceeds the target, return (invalid path).
        • Sub-step 4b: If the current sum equals the target,
            o Add a copy of the current combination to the result list.
            o Return to explore other possibilities.

    Step 5: Loop through the candidates starting from the current index:
        • Sub-step 5a: Add the current candidate to the combination list.
        • Sub-step 5b: Recurse:
            o If adding the candidate does not exceed the target, allow reusing the same candidate by passing the same index.
            o Otherwise, move to the next index to avoid exceeding the target.
        • Sub-step 5c: Remove the last added candidate from the combination list (backtracking) to explore other options.

    Step 6: Continue this process until all combinations are explored.

    Step 7: Return the global list containing all valid combinations.

Logic:
    • Uses backtracking to explore all possible combinations.
    • Candidates can be used multiple times, but the sum should not exceed the target.
    • Backtracking ensures all combinations are explored without duplicates.

Time Complexity:
    • Exponential in the worst case because all combinations are explored → O(2^t) (t = target value in worst scenario).

Space Complexity:
    • Space used for recursion stack + temporary combination list → O(target) (maximum depth of recursion).



  =================> Code <===================

  class Solution {
    List<List<Integer>> al=new ArrayList<>();
    public List<List<Integer>> combinationSum(int[] candidates, int target) {
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
            adj.add(arr[i]);
            if(sum+arr[i]<=tar){
                find(arr,tar,sum+arr[i],i,adj);
            }else{
                find(arr,tar,sum+arr[i],i+1,adj);
            }           
            adj.remove(adj.size()-1);
        }
    }
}
