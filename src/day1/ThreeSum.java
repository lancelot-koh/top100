package day1;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;

public class ThreeSum {

    public List<List<Integer>> threeSum(int[] nums) {
        Arrays.sort(nums);
        List<List<Integer>> res = new ArrayList<>();
        for (int i = 0; i < nums.length && nums[i] <= 0; i++) {
            if (i == 0 || nums[i - 1] != nums[i]) {
                twoSumII(nums, i, res);
                twoSum(nums, i, res);
            }
        }
        return res;

    }

    void twoSumII(int[] nums, int i, List<List<Integer>> res) {
        int left = i + 1;
        int right = nums.length - 1;
        while (left < right) {
            int sum = nums[i] + nums[left] + nums[right];
            if (sum < 0) {
                left++;
            } else if (sum > 0) {
                right--;
            } else {
                res.add(Arrays.asList(nums[i], nums[left], nums[right]));
                while (left < right && nums[left] == nums[left - 1]) {
                    left++;
                }
            }
        }
    }

    void twoSum(int[] nums, int i, List<List<Integer>> res) {
        HashSet<Integer> seen = new HashSet<>();
        for(int j = i + 1; j < nums.length; j++) {
            int remain = -nums[i] - nums[j];
            if (seen.contains(remain)) {
                res.add(Arrays.asList(nums[i], nums[j], remain));
                while (j + 1 < nums.length && nums[j] == nums[j + 1]){
                    j++;
                }
            }
            seen.add(nums[j]);
        }
    }

}
