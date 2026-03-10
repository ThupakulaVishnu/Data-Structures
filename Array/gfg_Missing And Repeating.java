Step-by-step algorithm to find the repeating and missing elements in an array:

Step 1: Create an empty `ArrayList` `al` to store the result.
Step 2: Create an empty `HashSet` `hm` to store unique elements from the array.

Step 3: Traverse each element `curr` in the array:

* Sub-step 3a: Try to add `curr` to the HashSet.
* Sub-step 3b: If adding fails (element already exists),

  * It is the **repeating element**.
  * Add it to `al`.

Step 4: Traverse numbers from 1 to `n` (where `n` is the length of the array):

* Sub-step 4a: Check if the number is **not present** in the HashSet.
* Sub-step 4b: If not present, it is the **missing element**.

  * Add it to `al`.
  * Break the loop since the missing element is found.

Step 5: Return the ArrayList `al` containing two elements:

* First element = repeating number
* Second element = missing number

Logic:

* HashSet keeps track of seen numbers.
* Any duplicate will fail to be added → gives repeating number.
* Any number from 1 to n not in the HashSet → gives missing number.

Time Complexity:

* Traversing array = O(n)
* Traversing numbers 1 to n = O(n)
* Total Time Complexity = **O(n)**

Space Complexity:

* HashSet may store up to n elements.
* Result list stores 2 elements.
  Space Complexity = **O(n)**







  -----------------> Code <---------------------

  class Solution {
    ArrayList<Integer> findTwoElement(int arr[]) {
        // code here
        ArrayList<Integer> al=new ArrayList<>();
        HashSet<Integer> hm=new HashSet<>();
        for(int curr:arr){
            if(!hm.add(curr)){
                al.add(curr);
            }
        }
        for(int i=1;i<=arr.length;i++){
            if(!hm.contains(i)){
                al.add(i);
                break;
            }
        }
        return al;
    }
}
