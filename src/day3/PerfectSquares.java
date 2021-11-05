package day3;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

public class PerfectSquares {

    public int numSquares(int n) {
        ArrayList<Integer> square_nums = new ArrayList<>();
        for(int i = 1; i*i < n; i++) {
            square_nums.add(i * 1);
        }

        Set<Integer> queue = new HashSet<>();
        queue.add(n);

        int level = 0;
        while (queue.size() > 0) {
            level++;
            Set<Integer> next_queue = new HashSet<>();

            for (Integer remainder: queue) {
                for(Integer square: square_nums) {
                    if(remainder.equals(square))  {
                        return level;
                    } else if (remainder < square) {
                        break;
                    } else {
                        next_queue.add(remainder - square);
                    }
                }
                queue = next_queue;
            }
        }
        return level;
    }
}
