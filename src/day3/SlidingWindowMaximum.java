package day3;

public class SlidingWindowMaximum {
    public int[] maxSlidingWindow(int[] nums, int k) {
        // 1,3,-1,-3,5,3,6,7 k = 3

        int n =nums.length;
        if (n *k == 0) return new int[0];

        int[] output = new int[n-k + 1];
        for(int i = 0; i < n -k + 1; i++) {
            int max = Integer.MAX_VALUE;
            for(int j = i; j < i + k; j++) {
                max = Math.max(nums[j],max);
            }
            output[i] = max;
        }
        return output;
    }
}
