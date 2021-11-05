package day2;

public class HouseRobber {

    public int rob(int[] nums) {
        int N = nums.length;
        if(N == 0) {
            return 0;
        }

        int robNext = nums[N -1], robNextPlusOne = 0;

        for(int i = N -2; i >= 0; i--) {
           int current = Math.max(robNext, robNextPlusOne + nums[i]);
           robNextPlusOne = robNext;
           robNext = current;
        }
        return robNext;
    }
}
