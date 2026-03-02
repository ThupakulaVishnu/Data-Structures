Step-by-step algorithm for the insertion method (Max Heap insertion logic only):

Step 1: Insert the new element at the end of the list.
(This keeps the tree complete.)

Step 2: Set a variable `curr` to the index of the newly inserted element.

Step 3: Repeat the following steps while `curr > 0`:

* Sub-step 3a: Find the parent index using the formula:
  parent = (curr - 1) / 2

* Sub-step 3b: Compare the value at `parent` with the value at `curr`.

* Sub-step 3c: If parent value is less than current value:

  * Swap the parent and current values.
  * Update `curr` to the parent index.
    (This moves the element upward in the heap.)

* Sub-step 3d: If parent value is greater than or equal to current value:

  * Stop the process.
    (Heap property is satisfied.)

Step 4: Continue this process until:

* The element reaches the root, or
* The heap property is satisfied.

This ensures the Max Heap property is maintained after insertion.

Time Complexity:
In the worst case, the element moves from bottom to root.
Height of heap = log n
Time Complexity = O(log n)

Space Complexity:
Only a few variables are used.
Space Complexity = O(1)





                    -------------------> Code <---------------------------

  import java.util.*;

class sample {

    public static void main(String[] args) {
        List<Integer> al = new ArrayList<>();
        int[] arr = { 50, 20, 70, 10, 90, 40, 60, 80, 15 };
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
    }
}
