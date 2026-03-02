Step-by-step algorithm for ExtractMax in a Max Heap:

Step 1: If the heap is empty, return -1.

Step 2: Store the root element (index 0) in a variable max.
(This is the maximum element.)

Step 3: Remove the last element from the heap and store it in a variable last.

Step 4: If the heap is not empty after removal:

Sub-step 4a: Place last at the root (index 0).

Sub-step 4b: Set curr = 0.
(Start heapify-down from the root.)

Step 5: Repeat the following steps:

Sub-step 5a: Find left child index:
left = 2 × curr + 1

Sub-step 5b: Find right child index:
right = 2 × curr + 2

Sub-step 5c: Assume current index is the largest (store it in latest).

Sub-step 5d: If left child exists and its value is greater than current value,
update curr to left index.

Sub-step 5e: If right child exists and its value is greater than the current updated value,
update curr to right index.

Sub-step 5f: If curr changed (means a larger child was found),
swap the element at latest with element at curr.

Sub-step 5g: If no swap happened, break the loop.
(Heap property is restored.)

Step 6: Return max.

Time Complexity:
In the worst case, the element moves from root to leaf.
Height of heap = log n
Time Complexity = O(log n)

Space Complexity:
Only a few variables are used.
Space Complexity = O(1)




              ----------------------> Code <--------------------



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
