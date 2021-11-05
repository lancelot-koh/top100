package day2;

public class UniqueBinarySearchTrees {
    int [][] memo;

    int numTress(int n) {
        memo = new int[n + 1][n + 1];
        return count(1, n);
    }

    int count(int low, int high) {
        if (low > high) return 1;

        if (memo[low][high] != 0) {
            return memo[low][high];
        }
        int res = 0;
        for(int i = low; i <= high; i++) {
            int left = count(low, i - 1);
            int right = count(i + 1, high);
            res += left * right;
        }
        memo[low][high] = res;

        return res;
    }
}
