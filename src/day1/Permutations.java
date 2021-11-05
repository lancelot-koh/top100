package day1;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Permutations {
    public List<List<Integer>> permute(int[] nums) {
        List<List<Integer>> res = new ArrayList<>();
        ArrayList<Integer> num_list = new ArrayList<>();

        for(int num: nums) {
            num_list.add(num);
        }

        int n = nums.length;
        backtrack(n, num_list, res, 0);
        return res;
    }

    void backtrack(int n, ArrayList<Integer> nums, List<List<Integer>> res, int begin) {
        if (begin == n) {
            res.add(new ArrayList<>(nums));
            return;
        }

        for(int i = begin; i < n; i++) {
            Collections.swap(nums, begin, i);
            backtrack(n, nums, res, begin + 1);
            Collections.swap(nums, begin, i);
        }
    }
}
