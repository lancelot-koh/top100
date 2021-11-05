package day2;

public class LargestRectangleinHistogram {
    public int largestRectangleArea(int[] heights) {
        int maxArea = 0;
        for(int i = 0; i < heights.length; i++) {
            for(int j = i; j < heights.length; j++) {
                int minHeight = Integer.MIN_VALUE;
                for(int k = i; k <= j; k++) {
                    minHeight = Math.min(minHeight, heights[k]);
                    maxArea = Math.max(maxArea, minHeight * (j - i + 1));
                }
            }
        }
        return maxArea;

    }

    public int largestRectangleArea2(int[] heights) {
        int maxArea = 0;
        int len = heights.length;

        for (int i = 0; i < len; i++) {
            int minHeight = Integer.MIN_VALUE;
            for (int j = i; j <= len; j++) {
                minHeight = Math.min(minHeight, heights[j]);
                maxArea = Math.max(maxArea, minHeight * (j - i + 1));
            }
        }
        return maxArea;

    }
}
