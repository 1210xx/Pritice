package basicds.array;


import java.util.Arrays;

/**
 * 给你两个有序整数数组 nums1 和 nums2，请你将 nums2 合并到 nums1 中，使 nums1 成为一个有序数组。
 * 输入:
 * nums1 = [1,2,3,0,0,0], m = 3
 * nums2 = [2,5,6],       n = 3
 * <p>
 * 输出: [1,2,2,3,5,6]
 */
public class LeetCode0088 {
    /**
     * 利用两个下标分别指向两个数组的最后的值，从后往前进行判断迭代。
     * 处理特殊情况
     * 有序可以直接处理copy
     * @param nums1
     * @param m
     * @param nums2
     * @param n
     */
    public static void merge(int[] nums1, int m, int[] nums2, int n) {
        if (m == 0) {
//           nums1 = nums2;
            for (int i = n - 1; i > -1; i--) {
                nums1[i] = nums2[i];
            }
        } else if (m != 0 && n != 0) {
            int i1 = m - 1;
            int i2 = n - 1;
            for (int i = m + n - 1; i > -1; i--) {
                while (i1 >= 0 && i2 >= 0) {
                    if (nums1[i1] >= nums2[i2]) {
                        nums1[i] = nums1[i1];
                        i1--;
                    } else {
                        nums1[i] = nums2[i2];
                        i2--;
                    }
                    i--;
                }
                if (i1 > -1) {
                    nums1[i] = nums1[i1];
                    i1--;
                } else if (i2 > -1) {
                    nums1[i] = nums2[i2];
                    i2--;
                }

            }
        }
        System.out.println(Arrays.toString(nums1));
    }

    /**
     * 双指针 / 从后往前,类似于我的想法，用了一些相对简洁的方法
     *
     * @param nums1
     * @param m
     * @param nums2
     * @param n
     */
    public static void merge3(int[] nums1, int m, int[] nums2, int n) {
        // two get pointers for nums1 and nums2
        int p1 = m - 1;
        int p2 = n - 1;
        // set pointer for nums1
        int p = m + n - 1;

        // while there are still elements to compare
        while ((p1 >= 0) && (p2 >= 0)) {
            // compare two elements from nums1 and nums2
            // and add the largest one in nums1
            nums1[p--] = (nums1[p1] < nums2[p2]) ? nums2[p2--] : nums1[p1--];
        }
        // add missing elements from nums2
        System.arraycopy(nums2, 0, nums1, 0, p2 + 1);
        System.out.println(Arrays.toString(nums1));
    }

    /**
     * 最朴素的解法就是将两个数组合并之后再排序。该算法只需要一行(Java是2行)，时间复杂度较差，
     * 为O((n+m)log(n+m))。这是由于这种方法没有利用两个数组本身已经有序这一点。
     */
    public static void merge1(int[] nums1, int m, int[] nums2, int n) {
        System.arraycopy(nums2, 0, nums1, m, n);
        Arrays.sort(nums1);
    }

    /**
     * 双指针 / 从前往后
     */
    public static void merge2(int[] nums1, int m, int[] nums2, int n) {
        // Make a copy of nums1.
        int[] nums1_copy = new int[m];
        System.arraycopy(nums1, 0, nums1_copy, 0, m);

        // Two get pointers for nums1_copy and nums2.
        int p1 = 0;
        int p2 = 0;

        // Set pointer for nums1
        int p = 0;

        // Compare elements from nums1_copy and nums2
        // and add the smallest one into nums1.
        while ((p1 < m) && (p2 < n)) {
            nums1[p++] = (nums1_copy[p1] < nums2[p2]) ? nums1_copy[p1++] : nums2[p2++];
        }
        // if there are still elements to add
        if (p1 < m) {
            System.arraycopy(nums1_copy, p1, nums1, p1 + p2, m + n - p1 - p2);
        }
        if (p2 < n) {
            System.arraycopy(nums2, p2, nums1, p1 + p2, m + n - p1 - p2);
        }

    }




    public static void main(String[] args) {
        int[] nums1 = {1, 3, 4, 0, 0, 0};
        int[] nums2 = {2, 5, 6};
        merge3(nums1, 3, nums2, 3);
    }
}
