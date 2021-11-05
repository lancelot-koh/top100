package day3;

public class CountingBits {
    public int[] countBits(int num) {
        int[] ans = new int[num + 1];
        for(int x = 1; x <= num; x++) {
            ans[x] = ans[x & (x -1)] + 1;
        }
        return ans;
    }

    public static void main(String[] args) {
        CountingBits a = new CountingBits();
        a.countBits(10);
    }
}
