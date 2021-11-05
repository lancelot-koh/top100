package day3;

import java.util.PriorityQueue;

public class KthLargestElementinanArray {

    public int findKthLargest(int[] nums, int k) {
        PriorityQueue<Integer> heap = new PriorityQueue<Integer>((n1, n2) -> n1 - n2);

        for(int n: nums) {
            heap.add(n);
            if (heap.size() > k) {
                heap.poll();
            }
        }

        return heap.poll();
    }

//    int [] nums;
//
//    public void swap(int a, int b) {
//        int tmp = this.nums[a];
//        this.nums[a] = this.nums[b];
//        this.nums[b] = tmp;
//    }
//    public int findKthLargest2(int[] nums, int k) {
//        this.nums = nums;
//        int size = nums.length;
//        // kth largest is (N - k)th smallest
//        return quickselect(0, size - 1, size - k);
//    }
//
//



}
