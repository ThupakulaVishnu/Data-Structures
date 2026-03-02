Step-by-step algorithm for ChangeKey in a Max Heap:

Step 1: Check if the given index is valid.
If index is less than 0 or greater than or equal to heap size, stop the process.

Step 2: Store the old value present at the given index.

Step 3: Replace the value at the given index with the new value.

Step 4: Compare the new value with the old value.

Case 1: If the new value is greater than the old value
(This means the key increased, so we need to heapify up.)

* Sub-step 4a: Set curr = index.

* Sub-step 4b: While curr > 0:

  * Find parent index: parent = (curr - 1) / 2

  * If value at curr is greater than value at parent:

    * Swap curr and parent.
    * Update curr = parent.

  * Otherwise, stop.

(This restores the Max Heap property upward.)

Case 2: If the new value is smaller than the old value
(This means the key decreased, so we need to heapify down.)

* Sub-step 4c: Set curr = index.

* Sub-step 4d: Repeat:

  * Find left child index: left = 2 × curr + 1

  * Find right child index: right = 2 × curr + 2

  * Assume curr is the largest (store it in largest).

  * If left exists and value at left is greater than value at largest:

    * Update largest = left.

  * If right exists and value at right is greater than value at largest:

    * Update largest = right.

  * If largest is not equal to curr:

    * Swap curr and largest.
    * Update curr = largest.

  * Otherwise, stop.

(This restores the Max Heap property downward.)

Step 5: End the process.

Time Complexity:
In worst case, element moves from leaf to root or root to leaf.
Height of heap = log n
Time Complexity = O(log n)

Space Complexity:
Only a few variables are used.
Space Complexity = O(1)




                  ------------------> Code <---------------


  import java.util.*;

class sample {

    public static void main(String[] args) {
        List<Integer> al = new ArrayList<>();
        int[] arr = { 50, 20, 70, 10, 90, 40, 60, 80, 15, 5 };
        for (int i = 0; i < arr.length; i++) {
            al.add(arr[i]);
            int curr = al.size() - 1;
            while (curr > 0) {
                int par = (curr - 1) / 2;

                if (al.get(par) < al.get(curr)) {
                    int temp = al.get(par);
                    al.set(par, al.get(curr));
                    al.set(curr, temp);

                    curr = par;
                } else {
                    break;
                }
            }
        }
        System.out.println(al);
        int max = ExtractMax(al);
        System.out.println(max);
        System.out.println(al);
        changekey(8,100,al);
        System.out.println(al);
        changekey(1,12,al);
        System.out.println(al);
    }
    public static void changekey(int inx,int num,List<Integer> al){
        if(inx<0 || inx>=al.size()){
            return;
        }
        int oldvalue=al.get(inx);
        al.set(inx,num);
        if(num>oldvalue){
            int curr=inx;
            
            while(curr>0){
                int parent=(curr-1)/2;
                if(al.get(curr)>al.get(parent)){
                    int temp=al.get(curr);
                    al.set(curr,al.get(parent));
                    al.set(parent,temp);

                    curr=parent;
                }else{
                    break;
                }
            }
        }else{
            int latest=inx;
            while(true){
                int left=inx*2+1;
                int right=inx*2+2;
                if(left<al.size() && al.get(inx)<al.get(left)){
                    inx=left;
                }
                if(right<al.size() && al.get(inx)<al.get(right)){
                    inx=right;
                }
                if(latest!=inx){
                    int temp=al.get(inx);
                    al.set(inx,al.get(latest));
                    al.set(latest,temp);

                    latest=inx;
                }else{
                    break;
                }
            }
        }

    }
    public static int ExtractMax(List<Integer> al) {
        if (al.size() == 0) {
            return -1;
        }
        int max = al.get(0);
        int last = al.remove(al.size() - 1);

        if (al.size() > 0) {
            al.set(0, last);
            int curr = 0;

            while (true) {
                int left = curr * 2 + 1;
                int right = curr * 2 + 2;
                int latest = curr;

                if (left < al.size() && al.get(curr) < al.get(left)) {
                    curr = left;
                }

                if (right < al.size() && al.get(curr) < al.get(right)) {
                    curr = right;
                }

                if (latest != curr) {
                    int temp = al.get(latest);
                    al.set(latest, al.get(curr));
                    al.set(curr, temp);
                } else {
                    break;
                }
            }
        }
        return max;
    }
}
