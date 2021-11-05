package day1;

public class MedianofTwoSortedArrays {
    public static double findMedianSortedArrays(int[] nums1, int[] nums2) {
        int i = 0, j = 0, k = 0;
        int m = (nums1.length + nums2.length) / 2;
        boolean isEven = (nums1.length + nums2.length) % 2 == 0;
        int prev = 0;

        while (i < nums1.length || j < nums2.length || k <= m) {
            int cur = 0;
            if(i < nums1.length && j < nums2.length) {
                if (nums1[i] < nums2[j]) {
                    cur = nums1[i++];
                } else {
                    cur = nums2[j++];
                }
            } else if (i < nums1.length) {
                cur = nums1[i++];
            } else if (j < nums1.length) {
                cur = nums2[j++];
            }

            if (k++ == m) {
                if (isEven) {
                    return (cur + prev)/ 2.0;
                }
                return cur;
            }
            prev = cur;
        }
        return 0;

    }

    public static void main(String[] args) {
        int[] a = {1,2,3,4,5};
        int[] b = {1,2,3,4,5,6,7,8};
        MedianofTwoSortedArrays.findMedianSortedArrays(a,b);
    }
}
