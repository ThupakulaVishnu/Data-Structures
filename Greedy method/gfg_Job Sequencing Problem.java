Step-by-step algorithm for Job Sequencing with Maximum Profit:

Step 1: Let **n** be the number of jobs (length of the deadline array).

Step 2: Create a 2D array to store job information.

* Sub-step 2a: For each job, store its **deadline** and **profit** in the array.

Step 3: While inserting the jobs, also find the **maximum deadline** among all jobs.

* Sub-step 3a: Initialize a variable `max` to track the largest deadline.
* Sub-step 3b: Update it whenever a larger deadline is found.

Step 4: Sort all jobs in **descending order of profit**.

* Sub-step 4a: The job with the highest profit should appear first.
* Sub-step 4b: This ensures that we always try to schedule the most profitable job first.

Step 5: Initialize two variables:

* Sub-step 5a: `maxprof` to store the **total profit**.
* Sub-step 5b: `count` to store the **number of jobs done**.

Step 6: Create an array of size **max + 1** to represent time slots for jobs.

* Sub-step 6a: Initialize all slots with **-1** to indicate that they are empty.

Step 7: Traverse all jobs one by one (in sorted profit order).

Step 8: For each job:

* Sub-step 8a: Get its **deadline** and **profit**.

Step 9: Try to schedule the job in the latest possible free slot before its deadline.

* Sub-step 9a: Start checking from the job’s deadline and move backward.

* Sub-step 9b: If a slot is empty:

  * Assign the job to that slot.
  * Add its profit to `maxprof`.
  * Increase `count` by 1.
  * Stop checking further slots for that job.

Step 10: If no slot is free before the deadline, skip the job.

Step 11: Repeat the process for all jobs.

Step 12: After scheduling all possible jobs, create a result list.

* Sub-step 12a: Add the **number of jobs done** to the list.
* Sub-step 12b: Add the **maximum total profit** to the list.

Step 13: Return the result list.

Time Complexity:

* Sorting jobs = **O(n log n)**
* For each job, checking slots up to deadline = **O(n)** in worst case

Overall Time Complexity = **O(n²)** (worst case)

Space Complexity:

* Extra arrays used for jobs and slots.

Space Complexity = **O(n)**








                      =================> Code <=================


  class Solution {
    public ArrayList<Integer> jobSequencing(int[] deadline, int[] profit) {
        // code here
        int n=deadline.length;
        int[][] arr=new int[n][2];
        int max=0;
        for(int i=0;i<n;i++){
            arr[i][0]=deadline[i];
            arr[i][1]=profit[i];
            max=Math.max(max,arr[i][0]);
        }
        
        Arrays.sort(arr,(a,b)->Integer.compare(b[1],a[1]));
        
        int maxprof=0;
        int count=0;
        
        int[] proft=new int[max+1];
        
        Arrays.fill(proft,-1);
        
        for(int i=0;i<n;i++){
            int d=arr[i][0];
            int p=arr[i][1];
            
            for(int j=d;j>0;j--){
                if(proft[j]==-1){
                    proft[j]=p;
                    maxprof+=p;
                    count++;
                    break;
                }
            }
        }
        
        ArrayList<Integer> al=new ArrayList<>();
        al.add(count);
        al.add(maxprof);
        
        return al;
    }
}
