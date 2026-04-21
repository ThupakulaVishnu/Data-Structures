Step 1: Define the problem approach (Modified Merge Sort).
    • Use divide and conquer technique (Merge Sort)
    • While merging, count “reverse pairs” where:
      ○ arr[i] > 2 × arr[j] and i < j
Step 2: Start the recursive sort function.
    • Call sort(0, nums.length − 1, nums)
    • If l >= r → return (base case, single element)
Step 3: Divide the array.
    • Compute mid = l + (r − l) / 2
    • Recursively sort left half → sort(l, mid, arr)
    • Recursively sort right half → sort(mid+1, r, arr)
Step 4: Count reverse pairs (important step).
    • Call reverse(l, mid, r, arr)
    • Initialize pointer j = mid + 1
    • For each i from l to mid:
      ○ While j ≤ r AND arr[i] > 2 × arr[j]:
        • Move j forward → j++
      ○ Add valid pairs count → count += (j − (mid + 1))
    • This works because both halves are sorted
Step 5: Merge the sorted halves.
    • Call combain(l, mid, r, arr)
    • Create temporary array com[] of size (r − l + 1)
Step 6: Merge process (two pointers).
    • Set i = l, u = mid + 1, idx = 0
    • While i ≤ mid AND u ≤ r:
      ○ If arr[i] < arr[u] → add arr[i] to com
      ○ Else → add arr[u] to com
    • Copy remaining elements of left half
    • Copy remaining elements of right half
    • Copy com[] back into original array
Step 7: Return final result.
    • Return count → total reverse pairs
Time Complexity Analysis:
    • Each merge sort level processes all elements → O(n)
    • Number of levels → O(log n)
    • Total Time Complexity → O(n log n)
Space Complexity Analysis:
    • Temporary array used during merge → O(n)
    • Recursive stack depth → O(log n)
    • Total Space Complexity → O(n)


















  ================> Code <===============

  
class Solution {
    int count=0;
    public int reversePairs(int[] nums) {
        sort(0,nums.length-1,nums);
        return count;
    }
    public void sort(int l,int r,int[] arr){
        if(l>=r)return;

        int mid=l+(r-l)/2;
        sort(l,mid,arr);
        sort(mid+1,r,arr);
        reverse(l,mid,r,arr);
        combain(l,mid,r,arr);
    }
    public void reverse(int l,int mid,int r,int[] arr){
        int j=mid+1;

        for(int i=l;i<=mid;i++){
            while(j<=r && (long)arr[i] > (long)arr[j]*2){
                j++;
            }
            count+=(j-(mid+1));
        }
    }
    public void combain(int l,int mid,int r,int[] arr){
        int n1=mid-l+1;
        int n2=r-mid;
        int[] com=new int[n1+n2];
        int ll=l;
        int u=mid+1;
        int inx=0;
        while(l<=mid && u<=r){
            if(arr[l]<arr[u]){
                com[inx++]=arr[l++];
            }else{
                com[inx++]=arr[u++];
            }
        }

        while(l<=mid)com[inx++]=arr[l++];
        while(u<=r)com[inx++]=arr[u++];

        for(int jh:com){
            arr[ll++]=jh;
        }
    }
}
