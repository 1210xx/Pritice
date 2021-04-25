
package sort;
import java.util.Arrays;

public class TesMergeSort {

    public static void main(String[] args) {

        int[] arr = {11,10, 9, 8, 7, 6, 5, 4, 3, 2, 1};
//        int[] arr = {50, 10, 90, 30, 70, 40, 80, 60, 20};

        int[] tmp = new int[arr.length];

        System.out.println("原始数据: " + Arrays.toString(arr));

        mergeSortIt(arr, tmp);

        System.out.println("归并排序: " + Arrays.toString(arr));

    }


    /**
     * 二路归并排序的迭代实现。
     * 虽然递归版本比较好理解，但是会造成时间和空间上的性能损耗。
     * 故可以通过迭代进一步提升性能。
     */
    public static void mergeSortIt(int[] targetArray, int[] tempArray) {
        int k = 1;
        while (k <= targetArray.length) {
            mergePass(targetArray, tempArray, k, targetArray.length);
            k = 2 * k;
            mergePass(tempArray,targetArray, k, tempArray.length);
            k = 2 * k;
        }

        for (int i = 0; i < targetArray.length; i++) {
            targetArray[i] = tempArray[i];
        }
        System.out.println("After mergeSortIt: " + Arrays.toString(targetArray));
    }

    /**
     * 将间隔为k的子序列排序归并
     *
     * @param targetArray 带排序数组
     * @param tempArray   临时数组
     * @param k           间隔
     * @param length      数组长度
     *                    todo:归并排序的非递归实现
     */

    public static void mergePass(int[] targetArray, int[] tempArray, int k, int length) {
        int i;
        for (i = 0; i <= length - 2 * k ; i += 2 * k) {
            subMergeIt(targetArray, tempArray, i, i + k - 1, i + 2 * k - 1);
        }
        if (i < length - k +1) {
            subMergeIt(targetArray, tempArray, i, i + k - 1, length-1);
        } else {
            for (int j = i; j < length; j++) {
                tempArray[j] = targetArray[j];
            }
        }
    }


    public static void subMergeIt(int[] targetArray, int[] mergedArray, int i, int m, int n) {
        int j, k,indexLeft = i;
        for (j = m + 1, k = i; indexLeft <= m && j <= n; k++) {
            if (targetArray[indexLeft] <= targetArray[j]) {
                mergedArray[k] = targetArray[indexLeft++];
            } else {
                mergedArray[k] = targetArray[j++];
            }
        }
        if (indexLeft <= m) {
            for (int l = 0; l <= m - indexLeft ; l++) {
                mergedArray[k + l] = targetArray[indexLeft + l];
            }
        }
        if (j <= n) {
            for (int l = 0; l <= n - j ; l++) {
                mergedArray[k + l] = targetArray[j + l];
            }
        }

        for (int l = i; l <= n; l++) {
            targetArray[l] = mergedArray[l];
        }

    }

}