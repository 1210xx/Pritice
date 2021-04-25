package basicds.stackheapline;

/**
 * 给定 n 个非负整数，用来表示柱状图中各个柱子的高度。每个柱子彼此相邻，且宽度为 1 。
 *
 * 求在该柱状图中，能够勾勒出来的矩形的最大面积。
 */
public class LeetCode0084 {
    public static void main(String[] args) {
        int[] h = {2,1,5,6,2,3};
        int[] h1 = {2,0,2};
        System.out.println(largestRectangleArea(h1));
    }
    public static int largestRectangleArea(int[] heights) {
        int maxArea = 0;
        for (int i = 0; i < heights.length; i++) {
            int temp = 0, s = 0;
            for (int j = 0; j < heights.length; j++) {
                if (heights[j] - heights[i] >= 0) {
                    s++;
                    temp = s * heights[i];
                }else {
                    s = 0;
                    temp = 0;
                    continue;
                }
                if (temp > maxArea){
                    maxArea = temp;
                }
            }
        }
        return maxArea;
    }
}


