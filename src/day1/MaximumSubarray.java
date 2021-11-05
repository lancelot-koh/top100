package day1;

public class MaximumSubarray {
    public int maxSubArray(int[] nums) {
        int maxSubArray = Integer.MIN_VALUE;

        for(int i = 0; i < nums.length; i++) {
            int currSubArray = 0;
            for(int j = i; j < nums.length; j++) {
                currSubArray += nums[j];
                maxSubArray = Math.max(maxSubArray, currSubArray);
            }
        }

        return maxSubArray;
    }

    public int maxSubArray2(int[] nums) {
        int currSubArray = nums[0];
        int maxSubArray = nums[0];
        for(int i = 1; i < nums.length; i++) {
            int num = nums[i];
            currSubArray = Math.max(num, currSubArray + num);
            maxSubArray = Math.max(maxSubArray, currSubArray);
        }
        return maxSubArray;
    }
}
