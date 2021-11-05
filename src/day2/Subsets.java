package day2;

import java.util.ArrayList;
import java.util.List;

public class Subsets {
    List<List<Integer>> res = new ArrayList<>();
    int n, k;

    public List<List<Integer>> subsets(int[] nums) {
        n = nums.length;
        for(k = 0; k < n + 1; k++) {
            backtrack(0, new ArrayList<Integer>(), nums);
        }
        return res;
    }

    void backtrack(int first, ArrayList<Integer> curr, int[] nums) {
        if (curr.size() == k) {
            res.add(new ArrayList<>(curr));
            return;
        }

        for(int i = first; i < nums.length; i++) {
            curr.add(nums[i]);
            backtrack(i + 1, curr, nums);
            curr.remove(curr.size() - 1);
        }
    }

    public static void main(String[] args) {
        Subsets c = new Subsets();
        c.subsets(new int[]{1,2,3});
    }
}
