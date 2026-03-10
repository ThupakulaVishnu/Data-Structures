Step-by-step algorithm for Merge Sort:

Step 1: Start the sorting process by calling the divide function with the full array range (from index `l` to `r`).

Step 2: In the divide process, check if the left index is less than the right index.

* Sub-step 2a: If `l < r`, calculate the middle index.

  * The middle index divides the array into two halves.

Step 3: Recursively divide the left half of the array.

* Sub-step 3a: Call the divide process for the range from `l` to `mid`.

Step 4: Recursively divide the right half of the array.

* Sub-step 4a: Call the divide process for the range from `mid + 1` to `r`.

Step 5: After both halves are divided down to single elements, start combining them in sorted order.

Step 6: Create a temporary array to store the merged elements.

Step 7: Initialize three pointers:

* Sub-step 7a: One pointer for the left subarray starting at index `l`.
* Sub-step 7b: One pointer for the right subarray starting at index `mid + 1`.
* Sub-step 7c: One pointer for the temporary array to store merged elements.

Step 8: Compare elements from the left and right subarrays.

* Sub-step 8a: If the element from the left subarray is smaller, add it to the temporary array and move the left pointer forward.

* Sub-step 8b: Otherwise, add the element from the right subarray to the temporary array and move the right pointer forward.

Step 9: Continue comparing until one of the subarrays is completely processed.

Step 10: If elements remain in the left subarray:

* Sub-step 10a: Copy all remaining elements from the left subarray into the temporary array.

Step 11: If elements remain in the right subarray:

* Sub-step 11a: Copy all remaining elements from the right subarray into the temporary array.

Step 12: Copy all elements from the temporary array back into the original array starting from index `l`.

Step 13: Repeat this merge process for all divided parts until the entire array becomes sorted.

Time Complexity:
The array is divided into halves recursively and merging takes linear time.
Time Complexity = **O(n log n)**

Space Complexity:
An additional temporary array is used during merging.
Space Complexity = **O(n)**


              -------------> Code <------------------

  class Solution {

    void mergeSort(int arr[], int l, int r) {
        // code here
        divide(arr,l,r);
    }
    public void divide(int[] arr,int l,int r){
        if(l<r){
            int mid=l+(r-l)/2;
            
            divide(arr,l,mid);
            divide(arr,mid+1,r);
            combain(arr,l,mid,r);
        }
    }
    public void combain(int[] arr,int l,int mid,int r){
        int[] com=new int[r-l+1];
        int u=0;
        int i=l;
        int j=mid+1;
        
        while(i<=mid && j<=r){
            if(arr[i]<arr[j]){
                com[u++]=arr[i++];
            }else{
                com[u++]=arr[j++];
            }
        }
        while(i<=mid){
            com[u++]=arr[i++];
        }
        while(j<=r){
            com[u++]=arr[j++];
        }
        for(int curr:com){
            arr[l++]=curr;
        }
    }
}
