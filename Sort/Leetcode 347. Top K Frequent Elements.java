Step 1: Count frequency of each element.
    • Create a HashMap<Integer, Integer> hm
    • For each number n in nums:
      ○ If n not in map → set frequency = 1
      ○ Else → increment frequency by 1
    • Result: hm stores (element → frequency)
Step 2: Convert map into list.
    • Create List<int[]> al
    • For each key n in hm:
      ○ Add {n, hm.get(n)} into list
    • Now each entry is (value, frequency)
Step 3: Sort elements by frequency.
    • Sort list in descending order of frequency
    • Comparator: b[1] − a[1]
    • Highest frequency elements come first
Step 4: Prepare result array.
    • Create int[] arr of size k
    • Initialize index u = 0
Step 5: Extract top k elements.
    • While k > 0:
      ○ Take first element from list → al.remove(0)[0]
      ○ Store into arr[u]
      ○ Increment u
      ○ Decrement k
Step 6: Return result.
    • Return arr → top k frequent elements
Time Complexity Analysis:
    • Building HashMap → O(n)
    • Creating list from map → O(m) (m = unique elements)
    • Sorting list → O(m log m)
    • Removing k elements from front (each remove shifts list) → O(k × m) worst case
    • Total Time Complexity → O(n + m log m + k × m) (can degrade due to remove(0))
Space Complexity Analysis:
    • HashMap stores m elements → O(m)
    • List stores m pairs → O(m)
    • Output array stores k elements → O(k)
    • Total Space Complexity → O(m + k)
















============> Code <===========

  class Solution {
    public int[] topKFrequent(int[] nums, int k) {
        Map<Integer,Integer> hm=new HashMap<>();
        for(int n:nums){
            if(hm.get(n)==null){
                hm.put(n,1);
            }else{
                hm.put(n,hm.get(n)+1);
            }
        }
        List<int[]> al=new ArrayList<>();
        for(int n:hm.keySet()){
            al.add(new int[]{n,hm.get(n)});
        }
        al.sort((a,b)->b[1]-a[1]);
        int[] arr=new int[k];
        int u=0;
        while(k-->0){
            arr[u++]=al.remove(0)[0];
        }
        return arr;
    }
}
