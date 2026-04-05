Step-by-step algorithm to solve the Fractional Knapsack problem using a greedy approach:
Step 1: Initialize variables.
             • Let n = number of items → n = val.length
             • Create an array of items → items[n]
Step 2: Populate the items array.
             • For each index i from 0 to n−1
                          o Create an item object with value val[i] and weight wt[i]
                          o Compute ratio = val[i] / wt[i]
Step 3: Sort items by value-to-weight ratio in descending order.
             • Use Arrays.sort with comparator → higher ratio items first
Step 4: Initialize profit = 0
Step 5: Traverse the sorted items array.
             • For each item i from 0 to n−1
              o Sub-step 5a: If item weight ≤ capacity
               • Take the whole item → capacity -= item.wt
               • Add value to profit → profit += item.val
              o Sub-step 5b: Else (item weight > capacity)
               • Take fraction of item → profit += (capacity / item.wt) * item.val
               • Break the loop (knapsack is full)
Step 6: Return total profit
  
Time Complexity:
       1.	Creating the items array → O(n)
       2.	Sorting items by ratio → O(n log n)
       3.	Traversing the array to fill knapsack → O(n)
          Total Time Complexity = O(n log n)
Space Complexity:
      1.	Array of item objects → O(n)
      2.	Other variables use constant space
          Total Space Complexity = O(n)

















      ================> Code <============

  class Solution {
    public double fractionalKnapsack(int[] val, int[] wt, int capacity) {
        // code here
        int n=val.length;
        item[] items=new item[n];
        
        for(int i=0;i<n;i++){
            items[i]=new item(val[i],wt[i]);
        }
        
        Arrays.sort(items,(a,b)->Double.compare(b.ratio,a.ratio));
        
        double profit=0;
        
        for(int i=0;i<n;i++){
            if(items[i].wt<=capacity){
                capacity-=items[i].wt;
                profit+=items[i].val;
            }else{
                profit+=((double)capacity/items[i].wt)*items[i].val;
                break;
            }
        }
        return profit;
    }
}
class item{
    int val=0,wt=0;
    double ratio=0;
    item(int val,int wt){
        this.val=val;
        this.wt=wt;
        this.ratio=(double)val/wt;
    }
}
