Step-by-step algorithm to find the median from a data stream using two heaps:
Step 1: Initialize the required data structures.
 • Create a Min Heap (PriorityQueue) called min to store the larger half of the numbers.
 • Create a Max Heap (PriorityQueue) called max to store the smaller half of the numbers.
 • The Max Heap keeps the largest element of the smaller half at the top.
 • The Min Heap keeps the smallest element of the larger half at the top.
Step 2: Add a new number to the data structure.
 • Sub-step 2a: Check where the new number should be placed.
  o If the Max Heap is empty or the number is smaller than the top of the Max Heap, insert the number into the Max Heap.
  o Otherwise, insert the number into the Min Heap.
Step 3: Balance the two heaps if their sizes differ by more than 1.
 • Sub-step 3a: If the Max Heap size is greater than the Min Heap size by more than 1:
  o Remove the top element from the Max Heap.
  o Insert that element into the Min Heap.
 • Sub-step 3b: If the Min Heap size is greater than the Max Heap size by more than 1:
  o Remove the top element from the Min Heap.
  o Insert that element into the Max Heap.
Step 4: Find the median of the numbers.
 • Sub-step 4a: If the sizes of both heaps are equal:
  o The median is the average of the top elements of both heaps.
 • Sub-step 4b: If the Max Heap has more elements:
  o The median is the top element of the Max Heap.
 • Sub-step 4c: If the Min Heap has more elements:
  o The median is the top element of the Min Heap.
Logic:
 • The numbers are divided into two halves using two heaps.
 • The Max Heap stores the smaller half of the numbers.
 • The Min Heap stores the larger half of the numbers.
 • By balancing the heaps after every insertion, the median can always be obtained from the heap tops.
Time Complexity:
 • Inserting a number into a heap takes O(log n) time.
 • Finding the median only requires accessing the top elements of the heaps.
 • Time Complexity = O(log n) for insertion and O(1) for finding the median.
Space Complexity:
 • Both heaps together store all inserted numbers.
 • Space Complexity = O(n).










  ===================> Code <=================

  class MedianFinder {
    PriorityQueue<Integer> max;
    PriorityQueue<Integer> min;
    public MedianFinder() {
        max=new PriorityQueue<>((a,b)->b-a);
        min=new PriorityQueue<>();
    }
    
    public void addNum(int num) {
        if(max.isEmpty() || num<max.peek()){
            max.offer(num);
        }else{
            min.offer(num);
        }
        if(Math.abs(max.size()-min.size())>1){
            if(max.size()>min.size()){
                min.offer(max.poll());
            }else{
                max.offer(min.poll());
            }
        }
    }
    
    public double findMedian() {
        if(max.size()==min.size()){
            return (double)(max.peek()+min.peek())/2;
        }else{
            return max.size()>min.size() ?  max.peek() : min.peek();
        }
    }
}

/**
 * Your MedianFinder object will be instantiated and called as such:
 * MedianFinder obj = new MedianFinder();
 * obj.addNum(num);
 * double param_2 = obj.findMedian();
 */
