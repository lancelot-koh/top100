package day2;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

public class LongestConsecutiveSequence {

    public int longestConsecutive(int[] nums) {
        // {0,3,7,2,5,8,4,6,0,1}
        if (nums.length == 0) {
            return 0;
        }

        Arrays.sort(nums);

        int longestStreak = 1;
        int currentStreak = 1;

        for(int i = 1; i < nums.length; i++) {
            if (nums[i] != nums[i - 1]) {
                if(nums[i] == nums[i - 1] + 1) {
                    currentStreak++;
                } else {
                    longestStreak = Math.max(longestStreak, currentStreak);
                    currentStreak = 1;
                }
            }
        }
        return Math.max(currentStreak, longestStreak);

    }

    public int longestConsecutive2(int[] nums) {
        Set<Integer> num_set = new HashSet<>();
        for(int num: nums) {
            num_set.add(num);
        }

        int longestStreak = 0;
        for(int num: num_set) {
            if(!num_set.contains(num -1)) {
                int currentNum = num;
                int currentStreak = 1;

                while (num_set.contains(currentNum + 1)) {
                    currentNum++;
                    currentStreak++;
                }
                longestStreak = Math.max(currentStreak, longestStreak);
            }
        }
        return longestStreak;
    }
}
