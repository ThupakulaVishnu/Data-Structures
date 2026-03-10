Step-by-step algorithm to find the minimum number of platforms required for trains:

Step 1: Sort the **arrival times** array in ascending order.
Step 2: Sort the **departure times** array in ascending order.

Step 3: Initialize three variables:

* `i = 1` → pointer for arrival array
* `j = 0` → pointer for departure array
* `plat = 1` → current number of platforms needed
* `maxplat = 1` → maximum platforms needed at any time

Step 4: Traverse the arrival and departure arrays while both pointers are within bounds:

* Sub-step 4a: If the next train's arrival time is **less than or equal to** the earliest departure time:

  * Increment `plat` by 1 (a new platform is needed).
  * Move the arrival pointer `i` forward.

* Sub-step 4b: Otherwise (the next train arrives after the earliest train departs):

  * Decrement `plat` by 1 (a platform becomes free).
  * Move the departure pointer `j` forward.

* Sub-step 4c: After each step, update `maxplat` with the maximum of `maxplat` and `plat`.

Step 5: Continue until all trains are processed.

Step 6: Return `maxplat` as the minimum number of platforms required.

Logic:

* Sorting allows processing trains in chronological order.
* Incrementing and decrementing the platform count simulates platforms being occupied and freed.
* The maximum count at any point gives the required platforms.

Time Complexity:

* Sorting arrival and departure arrays → **O(n log n)**
* Traversing arrays → **O(n)**
* Total Time Complexity = **O(n log n)**

Space Complexity:

* Only a few variables are used.
* Space Complexity = **O(1)**











  
          ===============> Code <===============
class Solution {
    public int minPlatform(int arr[], int dep[]) {
        //  code here
        Arrays.sort(arr);
        Arrays.sort(dep);
        
        int i=1;
        int j=0;
        int n=arr.length;
        int plat=1;
        int maxplat=1;
        
        
        while(i<n && j<n){
            if(arr[i]<=dep[j]){
                plat++;
                i++;
            }else{
                plat--;
                j++;
            }
            maxplat=Math.max(maxplat,plat);
        }
        return maxplat;
    }
}
  
