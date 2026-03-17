Step-by-step algorithm to find the top k sum pairs from two arrays:
Step 1: Sort both arrays a and b in ascending order.
(This ensures the largest elements are at the end of each array.)
Step 2: Initialize variables.
• Let n = a.length - 1 (index of the last element in array a).
• Create a max-heap (priority queue) pq to store sum and indices.
• Create a HashSet hs to track visited index pairs.
Step 3: Add the initial pair of largest elements to the heap.
• pq.offer([a[n] + b[n], n, n])
• Add the pair of indices to the HashSet hs.add(n + "#" + n)
Step 4: Initialize an empty ArrayList res to store the top k sums.
Step 5: Repeat until k sums are extracted:
• Sub-step 5a: Extract the largest sum from the heap.
 curr = pq.poll()
 sum = curr[0], i = curr[1], j = curr[2]
• Sub-step 5b: Add sum to the result list res.
• Sub-step 5c: Check the next possible pair by decrementing i (moving left in array a).
 o If i-1 >= 0 and (i-1)#j is not in hs:
  - Add new pair [a[i-1] + b[j], i-1, j] to the heap.
  - Add (i-1)#j to the HashSet.
• Sub-step 5d: Check the next possible pair by decrementing j (moving left in array b).
 o If j-1 >= 0 and i#(j-1) is not in hs:
  - Add new pair [a[i] + b[j-1], i, j-1] to the heap.
  - Add i#(j-1) to the HashSet.
Step 6: After extracting k sums, return the ArrayList res.
(This list contains the top k largest sum pairs.)
Logic:
• By sorting arrays, the largest sums are formed from the largest elements.
• A max-heap ensures we always extract the current largest sum.
• HashSet prevents processing the same index pair more than once.
• By exploring i-1 and j-1, we efficiently generate the next largest sums without checking all combinations.
Time Complexity:
Sorting both arrays = O(n log n + m log m)
Heap operations for k elements = O(k log k)
Total Time Complexity = O(n log n + m log m + k log k)
Space Complexity:
Heap and HashSet store at most k pairs.
Space Complexity = O(k)




  ==============> Code <===============

  class Solution {
    public ArrayList<Integer> topKSumPairs(int[] a, int[] b, int k) {
        // code here
        Arrays.sort(a);
        Arrays.sort(b);
        
        int n=a.length-1;
        
        PriorityQueue<int[]> pq=new PriorityQueue<>((x,y)->y[0]-x[0]);
        HashSet<String> hs=new HashSet<>();
        
        pq.offer(new int[]{a[n]+b[n],n,n});
        hs.add(n+"#"+n);
        
        ArrayList<Integer> res=new ArrayList<>();
        while(k-->0){
            
            int[] curr=pq.poll();
            
            int sum=curr[0];
            int i=curr[1];
            int j=curr[2];
            
            res.add(sum);
            
            if(i-1>=0 && !hs.contains((i-1)+"#"+j)){
                pq.offer(new int[]{a[i-1]+b[j],i-1,j});
                hs.add((i-1)+"#"+j);
            }
            
            if(j-1>=0 && !hs.contains(i+"#"+(j-1))){
                pq.offer(new int[]{a[i]+b[j-1],i,j-1});
                hs.add(i+"#"+(j-1));
            }
        }
        
        return res;
    }
}
