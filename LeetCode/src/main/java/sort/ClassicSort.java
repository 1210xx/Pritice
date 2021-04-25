package sort;

import com.sun.deploy.panel.ITreeNode;

import java.util.Arrays;
import java.util.Comparator;
import java.util.PriorityQueue;

/**
 * @author rjjerry
 */
public class ClassicSort {
    public static void main(String[] args) {
        int[] arr = {10, 9, 8, 7, 6, 5, 4, 3, 2, 1};
        int[] arr2 = {50, 10, 90, 30, 70, 40, 80, 60, 20};
//        int[] array = generateRandomArray(10, 200);
        int[] temp = new int[arr.length];
//        mergeSort2(arr2,temp,0,arr2.length- 1);
//        System.out.println("After mergeSort2 : " + Arrays.toString(temp));
//        mergeSortIt(arr,temp);
//        System.out.println("After mergeSort2: " + Arrays.toString(arr));
//        quickSort2(arr);
//        quickSort(arr2,0, arr2.length-1);
//        System.out.println("After quick sort:" + Arrays.toString(arr));
//        insetSort2(arr);
        mergeSort(arr,temp,0,arr.length-1);
        System.out.println("After merge sort: " + Arrays.toString(arr));
    }

    public static int[] generateRandomArray(int length, int max) {
        int[] array = new int[length];
        for (int i = 0; i < length; i++) {
            array[i] = (int) (Math.random() * max);
        }
        return array;
    }

    //像是冒泡排序，其实只是两两交换
    public static void bubbleSort(int[] targetArray) {
        System.out.println("原始数组:" + Arrays.toString(targetArray));
        long startTime = System.currentTimeMillis();
        for (int i = 0; i < targetArray.length - 1; i++) {
            for (int j = i + 1; j < targetArray.length; j++) {
                if (targetArray[i] > targetArray[j]) {
                    int temp = targetArray[j];
                    targetArray[j] = targetArray[i];
                    targetArray[i] = temp;
                }
            }
        }
        long endTime = System.currentTimeMillis();
        System.out.println("耗时:" + (endTime - startTime) + " ms");
        System.out.println("冒泡排序后:" + Arrays.toString(targetArray));
    }

    //最正常的冒泡排序
    public static void bubbleSort2(int[] targetArray) {
        System.out.println("The Array: " + Arrays.toString(targetArray));
        long startTime = System.currentTimeMillis();
        //循环次数
        for (int i = 1; i < targetArray.length; i++) {
            //冒泡过程，从后往前，
            for (int j = targetArray.length - 1; j > 0; j--) {
                //冒泡
                if (targetArray[j - 1] > targetArray[j]) {
                    int temp = targetArray[j];
                    targetArray[j] = targetArray[j - 1];
                    targetArray[j - 1] = temp;
                }
            }
        }
        long entTime = System.currentTimeMillis();
        System.out.println("Time consume :" + (entTime - startTime) + "ms");
        System.out.println("Sorted by bubble sort" + Arrays.toString(targetArray));
    }


    //优化冒泡排序
    //对于部分有序的数组，无须都进行比较
    public static void bubbleSort3(int[] targetArray) {
        System.out.println("The Array: " + Arrays.toString(targetArray));
        long startTime = System.currentTimeMillis();
        boolean flag = true;
        //循环次数,如果有数据交换则继续，否则退出一次循环
        for (int i = 1; i < targetArray.length && flag; i++) {
            flag = false;
            for (int j = targetArray.length - 1; j > 0; j--) {
                if (targetArray[j - 1] > targetArray[j]) {
                    int temp = targetArray[j];
                    targetArray[j] = targetArray[j - 1];
                    targetArray[j - 1] = temp;
                    flag = true;
                }
            }
        }
        long entTime = System.currentTimeMillis();
        System.out.println("Time consume :" + (entTime - startTime) + "ms");
        System.out.println("Sorted by bubble sort" + Arrays.toString(targetArray));
    }

    //选择排序
    public static void selectSort(int[] targetArray) {
        int i, j, min;
        System.out.println("Array :" + Arrays.toString(targetArray));
        //循环次数
        for (i = 0; i < targetArray.length; i++) {
            //记录最小值下标
            min = i;
            //找出最小值下标
            for (j = i + 1; j < targetArray.length; j++) {
                //交换最小值下标
                if (targetArray[min] > targetArray[j]) {
                    min = j;
                }
                //如果不是原来的下标，则交换
                if (i != min) {
                    int temp = targetArray[min];
                    targetArray[min] = targetArray[i];
                    targetArray[i] = temp;
                }
            }
        }
        System.out.println("Sorted by selectSort :" + Arrays.toString(targetArray));
    }

    public static void insetSort(int[] targetArray) {
        System.out.println("原始数组:" + Arrays.toString(targetArray));
        long startTime = System.currentTimeMillis();
        //插入排序解释
        //待插入的循环
        for (int i = 1; i < targetArray.length; i++) {
            //待插入的目标数
            int insertItem = targetArray[i];
            //标记位置，所谓哨兵
            int j = i - 1;
            //对于已经排好序的数组对比
            for (; j >= 0; j--) {
                //如果已经排好序的部分的元素大于待插入元素
                if (targetArray[j] > insertItem) {
                    //则将该元素后移
                    targetArray[j + 1] = targetArray[j];
                } else {
                    //否则：表明待插入元素找到了位置，退出循环，保留该位置
                    break;
                }
            }
            //在小于待插入元素的前一个位置插入待插入元素。
            targetArray[j + 1] = insertItem;
        }
        long endTime = System.currentTimeMillis();
        System.out.println("耗时:" + (endTime - startTime) + " ms");
        System.out.println("插入排序后:" + Arrays.toString(targetArray));
    }

    public static void insetSort2(int[] targetArray) {
        System.out.println("原始数组:" + Arrays.toString(targetArray));
        long startTime = System.currentTimeMillis();
        for (int i = 1; i < targetArray.length; i++) {
            int insertItem = targetArray[i];
            int j = i - 1;
            while (j >= 0) {
                if (targetArray[j] > insertItem) {
                    targetArray[j + 1] = targetArray[j];
                } else {
                    break;
                }
                j--;
            }
            targetArray[j + 1] = insertItem;
        }
        long endTime = System.currentTimeMillis();
        System.out.println("耗时:" + (endTime - startTime) + " ms");
        System.out.println("插入排序后:" + Arrays.toString(targetArray));
    }


    public static void insertSort3(int[] targetArray) {
        System.out.println("原始数组:" + Arrays.toString(targetArray));
        long startTime = System.currentTimeMillis();
        for (int i = 1; i < targetArray.length; i++) {
            int insertItem = targetArray[i];
            int j = i;
            //对比排序好的前j个数
            while (j > 0 && insertItem < targetArray[j - 1]) {
                targetArray[j] = targetArray[j - 1];
                j--;
            }
            if (j != i) {
                targetArray[j] = insertItem;
            }
        }
        long endTime = System.currentTimeMillis();
        System.out.println("耗时:" + (endTime - startTime) + " ms");
        System.out.println("插入排序后:" + Arrays.toString(targetArray));
    }

    //有一段时间竟然说排序算法的复杂的不可能突破O(n^2),直至希尔排序出现

    /**
     * 希尔排序 1959年
     * 堆插入排序的一种高效的改进版本
     * - 插入排序对已经排好序的序列操作时，效率高，可以达到线性的效率
     * - 插入排序一般来说是低效的，因为插入排序一次只能将数据移动一位
     * 分割待排序的序列的目的是减少插入的个数，并使得序列向基本有序发展。所以在分组的时候采用跳跃分割的策略。
     * O(n^3/2)
     *
     * @param targetArray 待排序数组
     */
    public static void shellSort(int[] targetArray) {
        System.out.println("The array: " + Arrays.toString(targetArray));
        //增量（区间）
        int increment = targetArray.length;
        //插入标记
        int tag;
        //增量为1是停止
        while (increment > 1) {
            //增量计算
            increment = increment / 3 + 1;
            //固定增量下的循环
            for (int i = increment; i < targetArray.length; i++) {
                //如果增量区间左边小于右边
                if (targetArray[i] < targetArray[i - increment]) {
                    //记录该数据，待插入数据
                    int temp = targetArray[i];
                    //如果该数据在增量区间上小于其余增量间隔的数据，则后移
                    for (tag = i - increment; tag >= 0 && temp < targetArray[tag]; tag -= increment) {
                        targetArray[tag + increment] = targetArray[tag];
                    }
                    //否则插入待插入数据
                    targetArray[tag + increment] = temp;
                }
            }
        }
        System.out.println("After shellSort :" + Arrays.toString(targetArray));
    }


    public static void shellSort2(int[] targetArray) {
        System.out.println("The array: " + Arrays.toString(targetArray));
        int increment = 1;
        while (increment < targetArray.length / 3) {
            increment = increment * 3 + 1;
        }
        while (increment > 0) {
            for (int i = increment; i < targetArray.length; i++) {
                int temp = targetArray[i];
                int j = i - increment;
                //插入排序典型套路
                while (j >= 0 && targetArray[j] > temp) {
                    targetArray[j + increment] = targetArray[j];
                    j -= increment;
                }
                targetArray[j + increment] = temp;
            }
            increment = increment / 3;
        }
        System.out.println("After shellSort :" + Arrays.toString(targetArray));
    }

    /**
     * 堆排序是针对了选择排序而优化的，首先在选择排序中选取最小的下标需要对比n-1次，继续选择的时候依然要对比之前比过的数据。
     * 如果可以做到在选择最小的记录同时对其他记录做出调整，就会提高总体效率。
     * 堆是一个近似完全二叉树的结构。堆排序可以说是一种利用堆的概念来排序的选择排序。分为两种方法：
     * 大顶堆：每个节点的值都大于或等于其子节点的值，在堆排序算法中用于升序排列；
     * 小顶堆：每个节点的值都小于或等于其子节点的值，在堆排序算法中用于降序排列；
     * 堆排序的平均时间复杂度为 Ο(nlogn)。
     * 对于堆而言，一般来说按照层序遍历存储在数组中。
     * 1964年
     *
     * @param targetArray 待排序数组
     */
    public static void heapSort(int[] targetArray) {
        System.out.println("The array:" + Arrays.toString(targetArray));
        int len = targetArray.length;

        buildMaxHeap(targetArray, len);

        for (int i = len - 1; i > 0; i--) {
            swap(targetArray, 0, i);
            len--;
            heapify(targetArray, 0, len);
        }
        System.out.println("After heapSort:" + Arrays.toString(targetArray));
    }

    private static void buildMaxHeap(int[] arr, int len) {
        for (int i = len / 2; i >= 0; i--) {
            heapify(arr, i, len);
        }
    }

    private static void heapify(int[] arr, int i, int len) {
        int left = 2 * i + 1;
        int right = 2 * i + 2;
        int largest = i;

        if (left < len && arr[left] > arr[largest]) {
            largest = left;
        }

        if (right < len && arr[right] > arr[largest]) {
            largest = right;
        }

        if (largest != i) {
            swap(arr, i, largest);
            heapify(arr, largest, len);
        }
    }

    private static void swap(int[] arr, int i, int j) {
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }

    public static void heapSort2(int[] targetArray){
        PriorityQueue<Integer> maxHeap = new PriorityQueue<>(new Comparator<Integer>() {
            @Override
            public int compare(Integer o1, Integer o2) {
                return o2.compareTo(o1);
            }
        });
        int len = targetArray.length;
        for (int i = 0; i < len; i++) {
            maxHeap.offer(targetArray[i]);
        }
        System.out.println(maxHeap);
    }

    /**
     * 堆的结构用到了完全二叉树，利用了完全二叉树的深度是log2n+1的特性，所以效率较高。
     * 直接利用完全二叉树排序就是归并排序。
     * 归并排序
     * 主要理解递归函数的执行方式
     * @param targetArray 目标数组
     * @param tempArray   临时数组
     * @param start       开始位置
     * @param end         结束位置
     */
    public static void mergeSort(int[] targetArray, int[] tempArray, int start, int end) {
        //当开始位置小于结束位置，具有排序意义
        if (start < end) {
            //计算中间值，为接下来的分治做准备
            int mid = (start + end) / 2;
            //对于前半部分继续分治
            mergeSort(targetArray, tempArray, start, mid);
            //对于后半部分继续分治
            mergeSort(targetArray, tempArray, mid + 1, end);
            //合并两部分
            subMerge(targetArray, tempArray, start, mid, end);

        }
    }

    /**
     * 合并之前分治的两部分(分别有序的两部分)
     *
     * @param targetArray 目标数组
     * @param tempArray   临时数组
     * @param start        左边的下标
     * @param mid         中间
     * @param end       右边下标
     */
    public static void subMerge(int[] targetArray, int[] tempArray, int start, int mid, int end) {
        //定义变量
        int indexLeft = start, indexMid = mid + 1, newArrayIndex = start;
        //如果下限小于中间值且中间值小于上限 其中tempLeft <= mid && tempMid < right 表明需要两两比较，不存在跳跃，所以是稳定的排序。
        while (indexLeft <= mid && indexMid <= end) {
            //若下限小于等于中间值
            if (targetArray[indexLeft] <= targetArray[indexMid]) {
                //将下限到中间的值复制到临时数组中
                tempArray[newArrayIndex++] = targetArray[indexLeft++];
            } else {
                //否则将中间到上限的值复制到临时数组中
                tempArray[newArrayIndex++] = targetArray[indexMid++];
            }
        }
        //当下限小于等于中间值，复制剩下的数据（剩下前半部分）
        while (indexLeft <= mid) {
            tempArray[newArrayIndex++] = targetArray[indexLeft++];
        }
        //当中间值小于等于上限，复制剩下的数据（剩下后半部分）
        while (indexMid <= end) {
            tempArray[newArrayIndex++] = targetArray[indexMid++];
        }
        //将临时数组复制到原数组
        for (int i = start; i <= end; i++) {
            targetArray[i] = tempArray[i];
        }
    }


    public static void mergeSort2(int[] targetArray,int[] tempArray, int start, int end){
        //当开始位置小于结束位置，具有排序意义
        int[] tempArray2 = new int[targetArray.length];
        if (start == end){
            tempArray[start] = targetArray[start];
        }
        if (start < end) {
            //计算中间值，为接下来的分治做准备
            int mid = (start + end) / 2;
            //对于前半部分继续分治
            mergeSort2(targetArray, tempArray2, start, mid);
            //对于后半部分继续分治
            mergeSort2(targetArray, tempArray2, mid + 1, end);
            //合并两部分
            subMergeIt(tempArray2, tempArray, start, mid, end);
        }
    }
    /**
     * 二路归并排序的迭代实现。
     * 虽然递归版本比较好理解，但是会造成时间和空间上的性能损耗。
     * 故可以通过迭代进一步提升性能。
     */
    public static void mergeSortIt(int[] targetArray, int[] tempArray){
        int k = 1;
        while (k <= targetArray.length) {
            mergePass(targetArray, tempArray, k, targetArray.length);
            k = 2 * k;
            mergePass(targetArray, tempArray, k, tempArray.length);
            k = 2 * k;
        }

        for (int i = 0; i < targetArray.length; i++) {
            targetArray[i] = tempArray[i];
        }
        System.out.println("After mergeSortIt: " + Arrays.toString(targetArray));
    }

    /**
     * 将间隔为k的子序列排序归并
     * @param targetArray 带排序数组
     * @param tempArray 临时数组
     * @param k 间隔
     * @param length 数组长度
     * todo:归并排序的非递归实现
     */
    public static void mergePass(int[] targetArray, int[] tempArray, int k, int length){
        int i;
        for (i = 0; i <= length - 2 * k  ; i += 2 * k) {
            subMergeIt(targetArray, tempArray, i , i + k  - 1 , i + 2 * k - 1 );
        }
        if (i < length - k + 1){
            subMergeIt(targetArray, tempArray, i , i + k  -  1, length - 1);
        }else{
            for (int j = i; j < length; j++) {
                tempArray[j] = targetArray[j];
            }
        }
    }


    public static void subMergeIt(int[] targetArray, int[] mergedArray, int start, int mid, int end) {
        int indexMid, newArrayIndex, indexLeft = start;
        for (indexMid = mid + 1, newArrayIndex = start; indexLeft <= mid && indexMid <= end; newArrayIndex++) {
            if (targetArray[indexLeft] <= targetArray[indexMid]) {
                mergedArray[newArrayIndex] = targetArray[indexLeft++];
            } else {
                mergedArray[newArrayIndex] = targetArray[indexMid++];
            }
        }
        if (indexLeft <= mid) {
            for (int l = 0; l <= mid - indexLeft; l++) {
                mergedArray[newArrayIndex + l] = targetArray[indexLeft + l];
            }
        }
        if (indexMid <= end) {
            for (int l = 0; l <= end - indexMid; l++) {
                mergedArray[newArrayIndex + l] = targetArray[indexMid + l];
            }
        }

        for (int i = start; i <= end; i++) {
            targetArray[i] = mergedArray[i];
        }
    }

    public static void subMergeIt2(int[] targetArray, int[] mergedArray,int i, int m, int n){
        int j,k,index = i;
        for (j = m + 1,k = i; index <= m && j <= n ; k++) {
            if (targetArray[index] <= targetArray[j]){
                mergedArray[k] = targetArray[index++];
            }else{
                mergedArray[k] = targetArray[j++];
            }
        }
        if (index <= m) {
            for (int l = 0; l <= m - index ;l++){
                mergedArray[k + l] = targetArray[index + l];
            }
        }
        if (j <= n) {
            for (int l = 0; l <= n - j ;l++){
                mergedArray[k + l] = targetArray[j + l];
            }
        }

        for (int l = i; l <= n; l++) {
            targetArray[i] = mergedArray[i];

        }
    }

    public static void subMergeIt3(int[] targetArray, int[] mergedArray, int i, int m, int n) {
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

    public static void mergePass2(int[] targetArray, int[] tempArray, int k, int length){
        int i=0;
        while (i < (length - 2*k )){
            subMergeIt(targetArray,tempArray,i,i+k-1,i+2*k-1);
            i += 2 * k;
        }
        if (i < length - k ){
            subMergeIt(targetArray, tempArray, i , i + k  -  1, length - 1);
        }else {
            for (int j = i; j < length; j++) {
                tempArray[j] = targetArray[j];
            }
        }
    }


    /**
     * 快速排序
     * 升级版的冒泡排序，都属于交换排序类。
     * @param targetArray
     * @param start
     * @param end
     */
    public static void quickSort(int[] targetArray, int start, int end) {
        //定义变量
        int indexLeft, indexRight, pivotValue;
        if (start >= end) {
            return;
        }

        indexLeft = start;
        indexRight= end;
        pivotValue = targetArray[start];
        //找到枢轴的下标
        while (indexLeft < indexRight) {
            // 先看右边，依次往左递减
            while (pivotValue <= targetArray[indexRight] && indexLeft < indexRight) {
                indexRight--;
            }
            // 再看左边，依次往右递增
            while (pivotValue >= targetArray[indexLeft] && indexLeft < indexRight) {
                indexLeft++;
            }
            //交换
//            temp = targetArray[indexRight];
//            targetArray[indexRight] = targetArray[indexLeft];
//            targetArray[indexLeft] = temp;
            swap(targetArray,indexLeft,indexRight);
        }

        //调整位置，将pivot放到正确的位置上
        targetArray[start] = targetArray[indexLeft];
        targetArray[indexLeft] = pivotValue;
        // 递归调用左半数组
        quickSort(targetArray, start, indexRight - 1);
        // 递归调用右半数组
        quickSort(targetArray, indexRight + 1, end);
    }


    public static void quickSortRJ(int[] targetArray, int start, int end) {
        //定义变量
        int indexLeft, indexRight, pivotValue;
        if (start >= end) {
            return;
        }

        indexLeft = start;
        indexRight= end;
        pivotValue = targetArray[start];
        //找到枢轴的下标
        while (indexLeft < indexRight) {
            // 先看右边，依次往左递减
            while (pivotValue <= targetArray[indexRight] && indexLeft < indexRight) {
                indexRight--;
            }
            // 再看左边，依次往右递增
            while (pivotValue >= targetArray[indexLeft] && indexLeft < indexRight) {
                indexLeft++;
            }
            //交换
//            temp = targetArray[indexRight];
//            targetArray[indexRight] = targetArray[indexLeft];
//            targetArray[indexLeft] = temp;
            swap(targetArray,indexLeft,indexRight);
        }

        //调整位置，将pivot放到正确的位置上（找的位置与枢轴位置调换）
        targetArray[start] = targetArray[indexLeft];
        targetArray[indexLeft] = pivotValue;
        // 递归调用左半数组
        quickSort(targetArray, start, indexRight - 1);
        // 递归调用右半数组
        quickSort(targetArray, indexRight + 1, end);
    }

    public static void quickSort2(int[] targetArray){
        QSort(targetArray,0,targetArray.length-1);
    }

    public static void QSort(int[] targetArray, int low, int high){
        int pivotIndex;
        if (low < high){
            pivotIndex = partition(targetArray,low,high);
            QSort(targetArray,low,pivotIndex-1);
            QSort(targetArray,pivotIndex+1,high);
        }
    }
    public static void QSort1(int[] targetArray, int low, int high){
        int pivotIndex;
        if (low - high > 7){
            while ( low > high) {
                pivotIndex = partition(targetArray, low, high);
                QSort1(targetArray,low,pivotIndex - 1);
                low = pivotIndex + 1;
            }
        }else {
            insetSort(targetArray);
        }
    }



    /**
     * 找出枢纽的正确位置，即左边的数都小于枢纽值右边的数都大于枢纽值
     * @param targetArray 目标数组
     * @param low 左边区间
     * @param high 右边区间
     * @return 枢纽位置
     */
    public static int partition(int[] targetArray,int low, int high){
        int pivotValue = targetArray[low];
        int leftIndex = low, rightIndex = high;
        while (leftIndex < rightIndex){
            //右边的数小于枢纽值，则右边标记位置左移
            while (leftIndex < rightIndex && targetArray[rightIndex] >= pivotValue){
                rightIndex--;
            }
            //右边的数小于枢纽值，交换（为了让左边的数小于枢纽值，右边的数大于枢纽值）
            swap(targetArray,leftIndex,rightIndex);
            //左边的数小于枢纽值，则左边标记位置右移
            while (leftIndex < rightIndex && targetArray[leftIndex] <= pivotValue){
                leftIndex++;
            }
            //左边的数大于枢纽值，交换
//            int temp;
//            temp = targetArray[low];
//            targetArray[low] = targetArray[high];
//            targetArray[high] = temp;
            swap(targetArray,leftIndex,rightIndex);
        }
        return leftIndex;
    }

    /**
     * 对于选取枢轴的优化，由于选取枢轴终总是  int pivotkey = targetArray[low];可能选到边界数值，对于排序来讲没有任何的性能提升。
     * 固有几种改进方法：
     * 1. 随机选取枢轴
     * 2. 三数取中（选取边界和中间数）
     * 3. 九数取中（三次取样）
     * @param targetArray
     * @param low
     * @param high
     * @return
     */
    public static int partition2(int[] targetArray,int low, int high){
        int m = (low + high) / 2;
        if (targetArray[low] > targetArray[high]){
            swap(targetArray,low, high);
        }
        if (targetArray[m] > targetArray[high]){
            swap(targetArray,m, high);
        }
        if (targetArray[m] > targetArray[low]){
            swap(targetArray,m, low);
        }
        int pivotValue = targetArray[low];
        while (low < high){
            while (low < high && pivotValue <= targetArray[high]) {
                high--;
            }
            swap(targetArray,low,high);
            while (low < high && pivotValue >= targetArray[low]){
                low++;
            }
//            int temp;
//            temp = targetArray[low];
//            targetArray[low] = targetArray[high];
//            targetArray[high] = temp;
            swap(targetArray,low,high);
        }
        return low;
    }

    /**
     * 对于交换方式可以修改
     * @param targetArray
     * @param low
     * @param high
     * @return
     */
    public static int partition3(int[] targetArray,int low, int high){
        int m = (low + high) / 2;
        if (targetArray[low] > targetArray[high]){
            swap(targetArray,low, high);
        }
        if (targetArray[m] > targetArray[high]){
            swap(targetArray,m, high);
        }
        if (targetArray[m] > targetArray[low]){
            swap(targetArray,m, low);
        }
        int pivotValue = targetArray[low];
        while (low < high){
            while (low < high && pivotValue <= targetArray[high]){
                high--;
            }
//            swap(targetArray,low,high);
            targetArray[low] = targetArray[high];
            while (low < high && pivotValue >= targetArray[low]){
                low++;
            }
            targetArray[high] = targetArray[low];
        }
        targetArray[low] = pivotValue;
        return low;
    }

}
