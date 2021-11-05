package day1;

public class FindFirstandLastPositionofElementinSortedArray {

    public static int[] searchRange(int[] nums, int target) {
        int leftIdx = binarySearch(nums, target, true);
        int rightIndx = binarySearch(nums, target, false) - 1;

        if(leftIdx <= rightIndx && rightIndx < nums.length) {
            return new int[]{leftIdx, rightIndx};
        }

        return new int[]{-1, -1};
    }

    public static int binarySearch(int[] nums, int target, boolean lower) {
        int left = 0, right = nums.length - 1, ans = nums.length;
        while (left <= right) {
            int mid = left + (right - left) /2;
            if (nums[mid] > target || (lower && nums[mid] >= target)) {
                right = mid - 1;
                ans = mid;
            } else {
                left = mid + 1;
            }
        }
        return ans;
    }

    public static void main(String[] args) {
        int [] nums = {5,7,7,8,8,10};
        FindFirstandLastPositionofElementinSortedArray.searchRange(nums, 8);
    }
}
