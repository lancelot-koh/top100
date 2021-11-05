package day1;

public class JumpGame {
    public boolean canJump(int[] nums) {
        return canJumpFromPosition(0, nums);
    }

    boolean canJumpFromPosition(int begin, int[] nums) {
        if(begin == nums.length - 1) {
            return true;
        }

        int furtherJump = Math.min(begin + nums[begin], nums.length -1 );
        for(int nextPos = begin + 1; nextPos <= furtherJump; nextPos++) {
            if (canJumpFromPosition(nextPos, nums)) {
                return true;
            }
        }
        return false;
    }

    public static void main(String[] args) {
        int [] a = {2,3,1,1,4};
        JumpGame j = new JumpGame();
        j.canJump(a);
    }
}
