package day1;

public class SearchinRotatedSortedArray {
    int [] nums;
    int target;

    public int search(int[] nums, int target) {
        this.nums = nums;
        this.target = target;

        int n = nums.length;
        if (n == 1) {
            return this.nums[0] == target ? 0 : -1;
        }

        int rotate_index= find_rotate_index(0, n -1);
        if(nums[rotate_index] == target) {
            return rotate_index;
        }
        if(rotate_index == 0) {
            return searchInRange(0, n -1);
        }
        if(target < nums[0]) {
            return searchInRange(rotate_index, n -1);
        }
        return searchInRange(0, rotate_index);
    }

    public int find_rotate_index(int left, int right) {
        if(nums[left] < nums[right]) {
            return 0;
        }

        while (left < right) {
            int pivot = (left + right) / 2;
            if(nums[pivot] > nums[pivot + 1]){
                return pivot + 1;
            } else {
                if(nums[pivot] < nums[left]) {
                    right = pivot - 1;
                } else {
                    left = pivot + 1;
                }
            }
        }
        return 0;
    }

    public int searchInRange(int begin, int end) {
        while (begin <= end) {
            int pivot = (begin + end)/2;
            if(nums[pivot] == target) {
                return pivot;
            } else {
                if(target < nums[pivot]) {
                    end = pivot - 1;
                } else {
                    begin = pivot + 1;
                }
            }
        }
        return -1;
    }

    public int search2(int[] nums, int target) {
        int left = 0, right = nums.length - 1;
        while (left <= right) {
            int mid = left + (right - left) / 2;
            if (nums[mid] == target) {
                return mid;
            } else if (nums[mid] >= nums[left]) {
                if (target >=  nums[left] && target < nums[mid]) {
                    right = mid - 1;
                } else {
                    left = mid + 1;
                }
            } else {
                if (target < nums[right] && target >= nums[mid]) {
                    left = mid + 1;
                } else {
                    right = mid - 1;
                }
            }
        }
        return -1;

    }
}
