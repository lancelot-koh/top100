package day2;

public class SortColors {

    public void sortColors(int[] nums) {
        int left = 0, curr = 0;
        int right = nums.length - 1;
        int tmp;
        while (curr <= right) {
            if (nums[curr] == 0) {
                tmp = nums[left];
                nums[left++] = nums[curr];
                nums[curr++] = tmp;
            } else if (nums[curr] == 2) {
                tmp = nums[right];
                nums[curr] = nums[right];
                nums[right--] = tmp;
            } else {
                curr++;
            }
        }
    }

    public void sortColors2(int[] nums) {
        int left = 0, right = nums.length - 1;
        int k = 0;

        while (k <= right) {
            if (nums[k] ==0 ) {
                swap(nums, left++, k++);
            } else if (nums[k] == 2) {
                swap(nums, k, right--);
            } else if (nums[k] == 1) {
                k++;
            }
        }
    }

    void swap(int[] nums, int i, int j) {
        int tmp = nums[i];
        nums[i] = nums[j];
        nums[j] =tmp;
    }

}
