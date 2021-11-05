package day1;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class CombinationSum {
    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        List<List<Integer>> res = new ArrayList<>();
        LinkedList<Integer> comb = new LinkedList<>();

        this.backtrack(target, comb, 0, candidates, res);
        return res;
    }

    public void backtrack(int remain, LinkedList<Integer> comb, int start, int[] candidates, List<List<Integer>> res) {
        if(remain == 0) {
            res.add(new ArrayList<>(comb));
            return;
        } else if(remain < 0) {
            return;
        }

        for(int i = start; i < candidates.length; i++ ) {
            comb.add(candidates[i]);
            this.backtrack(remain - candidates[i], comb, i, candidates, res);
            comb.removeLast();
        }
    }
}
