Step-by-step algorithm to count inversions in an array using Divide and Merge technique:

Step 1: Call a function that processes the array from index **0** to **n−1**.

Step 2: Inside the divide function, initialize a variable **inc = 0** to store the inversion count.

Step 3: Check if the left index is smaller than the right index.

* Sub-step 3a: If true, divide the array into two halves.

Step 4: Find the middle index of the current range.

Step 5: Recursively process the **left half** of the array.

* Sub-step 5a: Count inversions present completely in the left part.
* Sub-step 5b: Add that count to **inc**.

Step 6: Recursively process the **right half** of the array.

* Sub-step 6a: Count inversions present completely in the right part.
* Sub-step 6b: Add that count to **inc**.

Step 7: Merge the two sorted halves and count cross inversions.

* Sub-step 7a: Create a temporary array to store merged elements.

* Sub-step 7b: Initialize three pointers

  * One pointer for the left half
  * One pointer for the right half
  * One pointer for the temporary array

Step 8: Compare elements from the left and right halves.

* Sub-step 8a: If the left element is smaller or equal to the right element

  * Place the left element in the temporary array
  * Move the left pointer forward.

* Sub-step 8b: If the left element is greater than the right element

  * Place the right element in the temporary array
  * Move the right pointer forward.
  * Count inversions.

* Sub-step 8c: The number of inversions added is equal to the number of remaining elements in the left half.

Step 9: Continue this process until one of the halves is fully processed.

Step 10: Copy any remaining elements from the left half to the temporary array.

Step 11: Copy any remaining elements from the right half to the temporary array.

Step 12: Copy all elements from the temporary array back to the original array.

Step 13: Return the inversion count obtained during merging.

Step 14: Add the inversion counts from:

* Left half
* Right half
* Merging step

Step 15: Return the final inversion count.

Explanation of inversion:
An inversion occurs when an element on the left side is greater than an element on the right side.

Example:
If **arr[i] > arr[j]** and **i < j**, then it is an inversion.

Time Complexity:
The array is divided recursively like merge sort.
Each level performs merging in linear time.

Time Complexity = **O(n log n)**

Space Complexity:
A temporary array is used during merging.

Space Complexity = **O(n)**









                  --------------> Code <---------------

  class Solution {
    static int inversionCount(int arr[]) {
        // Code Here
        return divide(arr,0,arr.length-1);
    }
    public static int divide(int[] arr,int l,int r){
        int inc=0;
        if(l<r){
            
            int mid=l+(r-l)/2;
            
            inc+=divide(arr,l,mid);
            
            inc+=divide(arr,mid+1,r);
            
            inc+=combain(arr,l,mid,r);
        }
        return inc;
    }
    public static int combain(int[] arr,int l,int mid,int r){
        int[] com=new int[r-l+1];
        
        int i=l;
        int j=mid+1;
        int u=0;
        int inc=0;
        
        while(i<=mid && j<=r){
            if(arr[i]<=arr[j]){
                com[u++]=arr[i++];
            }else{
                com[u++]=arr[j++];
                
                inc+=(mid-i)+1;
            }
        }
        
        while(i<=mid){
            com[u++]=arr[i++];
        }
        while(j<=r){
            com[u++]=arr[j++];
        }
        
        int leftinx=l;
        
        for(int curr:com){
            arr[leftinx++]=curr;
        }
        return inc;
    }
}
