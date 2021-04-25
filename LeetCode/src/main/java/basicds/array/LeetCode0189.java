package basicds.array;

import java.util.Arrays;

/**
 * 给定一个数组，将数组中的元素向右移动 k 个位置，其中 k 是非负数。
 */
public class LeetCode0189 {
    /**
     * 自己写的有bug 当k大于】、nums的长度时就gg
     * 忘记了 %nums.length
     * 注意k的处理
     * @param nums
     * @param k
     */
    public static void rotate(int[] nums, int k) {
        k = k % nums.length;
        int[] num2 = new int[nums.length];
        int j = 0;
        for (int i = k ; i < nums.length; i++) {
            num2[i] = nums[j];
            j++;
        }

        for (int i = 0; i < k; i++) {
            num2[i] = nums[nums.length - k + i];
        }
        System.out.println(Arrays.toString(num2));
    }

    /**
     * 给出的答案，开辟了新数组。利用 i+k % nums.length 循环
     * @param nums
     * @param k
     */
    public static void rotate1(int[] nums, int k) {
        k = k & nums.length;
        int[] num2 = new int[nums.length];
        //
        for (int i = 0; i < nums.length; i++) {
            num2[(i+k)%nums.length] = nums[i];
        }

        for (int i = 0; i < nums.length; i++) {
            nums[i]=num2[i];

        }
        System.out.println(Arrays.toString(nums));
    }

    public static void rorate2(int[] nums, int k){
        int temp, privious;
        for (int i = 0; i < k; i++) {
            privious = nums[nums.length - 1];
            for (int j = 0; j < nums.length; j++) {
                //借助temp把每个数临时存储起来
                temp = nums[j];
                nums[j] = privious;
                privious = temp;
            }
        }
        System.out.println(Arrays.toString(nums));
    }

    /**
     * 环状替换
     * 可以理解，以k为目标地，直接放置最终元素，直到一圈结束。每次只挪动「n/k上取整。移动k次总计n次
     * @param nums
     * @param k
     */
    public static void rotate3(int[] nums, int k){
        k = k % nums.length;
        int steps = 0;
        for (int startPos = 0; steps < nums.length; startPos++) {
            int currentPos = startPos;
            int movingPoint = nums[startPos];
            //do while 直到不成立
            do {
                int destPos = (currentPos + k) % nums.length;
                //存储被挪出来的值
                int tempPoint = nums[destPos];
                nums[destPos] = movingPoint;
                movingPoint = tempPoint;
                currentPos = destPos;
                steps++;
            } while (startPos != currentPos);
        }
        System.out.println(Arrays.toString(nums));
    }

    public static void rotate3_rew(int[] nums, int k){
        k %= nums.length;
        int step = 0;

        for (int startPos = 0; step < nums.length; startPos++) {
            int currentPos = startPos;
            int movingPoint = nums[currentPos];
            do {
                int destPos = (currentPos + k) % nums.length;
                int tempPoint = nums[destPos];
                nums[destPos] = movingPoint;
                movingPoint = tempPoint;
                currentPos = destPos;
                step++;
            }while (startPos != currentPos);//直到statPos == currentPos 跳到下一轮
        }
    }

    /**
     * 三次反转
     * @param nums
     * @param k
     */
    public static void rotate4(int[] nums, int k){
        k %= nums.length;
        reverse(nums, 0, nums.length - 1);
        reverse(nums, 0, k - 1);
        reverse(nums, k, nums.length-1);

        System.out.println(Arrays.toString(nums));
    }

    public static void reverse(int[] destArray, int start, int end){
        while (start < end){
            int temp = destArray[start];
            destArray[start] = destArray[end];
            destArray[end] = temp;
            start++;
            end--;
        }
        System.out.println(Arrays.toString(destArray));
    }

    public static void main(String[] args) {

        int[] a = {1,2,3,4,5,6,7};
//        rotate(a, 4);
//        rotate1(a, 4);
//        rorate2(a, 4);
//        rotate3(a, 3);
//        rot

    }



}
