package basicds.array;

/**
 *  假设在一个数组中，有一个数字出现的次数超过数组长度的一半，现在要求你找出这个数字。
 *
 * 你可以假设一定存在这个出现次数超过数组长度的一半的数字，即不用考虑输入不合法的情况。要求时间复杂度是 O(n)，空间复杂度是 O(1)。例如，输入 a = {1,2,1,1,2,4,1,5,1}，输出 1。
 */
public class NumMoreHalf {
    //遵循的理论依据是：如果一个数字出现的次数超过数组长度的一般，那这个数字比剩下的数字总和还要多。
    //所以这个数字可以和其他任何数字比，最终数目优势一定会凸显。
    //看最后剩下了谁。不知道那个数字多，但是目前你多，你继续比，如果你不行继续换。
    public static void main(String[] args) {
        int[] a = {1,2,2,1,1,4,1,5,1};
        int result = a[0];
        int times = 1;
        for (int i = 1; i < a.length; i++) {
            //如果不是友军，牺牲一个士兵
            if (a[i] != result) {
                times--;
            }
            //如果是友军，来来来加入我。
            else {
                times++;
            }
            //如果我军人数没你多，那你上。
            if (times == -1) {
                times = 1;
                result = a[i];
            }
        }
        System.out.println(result);
    }
}
