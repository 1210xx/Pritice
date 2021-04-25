package basicds.linkedlist;

import java.util.*;

/**
 * 给你一个包含 n 个整数的数组 nums，判断 nums 中是否存在三个元素 a，b，c ，
 * 使得 a + b + c = 0 ？请你找出所有满足条件且不重复的三元组。
 *
 * 注意：答案中不可以包含重复的三元组。
 *

 */
public class LeetCode0015 {

    /**
     * 可尝试栈的应用
     * 利用自己实现的栈
     *
     * index 控制总的循环（第一位数）
     * tag 控制第二位数的
     * len 控制第三位数
     * @param nums
     * @return
     */

    public  List<List<Integer>> threeSum(int[] nums) {
        SimpleStack simpleStack = new SimpleStack();
        List<List<Integer>> result = new ArrayList<>();
//        for (int i = 0; i < nums.length - 2;) {
//            int target = 0;
//            while (simpleStack.size() < 3 ){
//                 target += simpleStack.push(nums[i++]);
//            }
//            if (target == 0) {
//                List<Integer> list = new ArrayList<>();
//                for (int j = 0; j < simpleStack.size(); j++) {
//                    list.add(simpleStack.get(j));
//                }
//                result.add(list);
//            }
//        }
        int index  = 0;
        int len = 0;
        int tag = index + 1;
        while (index < nums.length - 2){
            int target = 0;
            while (simpleStack.size() < 3){
                simpleStack.push(nums[len++]);
            }

            for (int j = 0; j < simpleStack.size(); j++) {
                target+=simpleStack.get(j);
            }
            if (target == 0){
                List<Integer> list = new ArrayList<>();
                for (int j = 0; j < simpleStack.size(); j++) {
                    list.add(simpleStack.get(j));
                }
                result.add(list);
            }
            //len 的控制
            //控制栈顶的弹出，顺序弹出
            simpleStack.pop();
            //控制第二位的弹出，条件是栈顶到达最后栈顶到达数组的长度
            if (len == nums.length){
                simpleStack.pop();
                tag++;
                len = tag;
                //控制栈底的弹出，条件是第二位到达数组的长度减一
                if (tag == nums.length - 1){
                    simpleStack.popAll();
                    index++;
                    len = index;
                    tag = index + 1;
                }
            }

        }
        return result;
    }

    public  List<List<Integer>> threeSum2(int[] nums) {
        Stack<Integer> stack = new Stack<>();
        List<List<Integer>> result = new ArrayList<>();
        int index  = 0;
        int len = 0;
        int tag = index + 1;
        Arrays.sort(nums);
        System.out.println(Arrays.toString(nums));
        while (index < nums.length - 2){
            int target = 0;
            while (stack.size() < 4){
                stack.push(nums[len++]);
            }

            for (int j = 0; j < stack.size(); j++) {
                target+=stack.get(j);
            }
            if (target == 0){
                List<Integer> list = new ArrayList<>();
                for (int j = 0; j < stack.size(); j++) {
                    list.add(stack.get(j));
                }
                //重复检测  没起到效果
                if (result.isEmpty()){
                    result.add(list);
                }else{
                    boolean only = true;
                    List<Integer> l2 = new ArrayList<>();
                    for (List<Integer> l : result){
                        if (l.equals(list)){
                            only = false;
                        }
                    }
                    if (only){
                        result.add(list);
                    }
                }

                result.add(list);
            }
            //len 的控制
            //控制栈顶的弹出，顺序弹出
            stack.pop();
            //控制第二位的弹出，条件是栈顶到达最后栈顶到达数组的长度
            if (len == nums.length){
                stack.pop();
                tag++;
                len = tag;
                //控制栈底的弹出，条件是第二位到达数组的长度减一
                if (tag == nums.length - 1){
                    stack.pop();
                    index++;
                    len = index;
                    tag = index + 1;
                }
            }

        }
        return result;
    }

    /**
     * 思路
     *
     * 标签：数组遍历
     * 首先对数组进行排序，排序后固定一个数nums[i]，再使用左右指针指向nums[i]后面的两端，数字分别为nums[L] 和nums[R]，计算三个数的和
     * sum 判断是否满足为0，满足则添加进结果集
     * 如果nums[i]大于 0，则三数之和必然无法等于 0，结束循环
     * 如果 nums[i] == nums[i−1]，则说明该数字重复，会导致结果重复，所以应该跳过
     * sum == 0 时，nums[L] == nums[L+1] 则会导致结果重复，应该跳过，L++
     * sum == 0 时， nums[R] == nums[R−1] 则会导致结果重复，应该跳过，R--
     * 时间复杂度n 为数组长度

     */
    public  List<List<Integer>> threeSum3(int[] nums) {
        List<List<Integer>> ans = new ArrayList();
        int len = nums.length;
        if(nums == null || len < 3) {
            return ans;
        }
        // 排序
        Arrays.sort(nums);
        for (int i = 0; i < len ; i++) {
            if(nums[i] > 0) {
                // 如果当前数字大于0，则三数之和一定大于0，所以结束循环
                break;
            }
            if(i > 0 && nums[i] == nums[i-1]) {
                // 去重
                continue;
            }
            int L = i+1;
            int R = len-1;
            while(L < R){
                int sum = nums[i] + nums[L] + nums[R];
                if(sum == 0){
                    ans.add(Arrays.asList(nums[i],nums[L],nums[R]));
                    while (L<R && nums[L] == nums[L+1]) {
                        // 去重
                        L++;
                    }
                    while (L<R && nums[R] == nums[R-1]) {
                        // 去重
                        R--;
                    }
                    L++;
                    R--;
                }
                else if (sum < 0) {
                    L++;
                } else if (sum > 0) {
                    R--;
                }
            }
        }
        return ans;
    }

    public  List<List<Integer>> threeSum3_RW(int[] nums) {
        List<List<Integer>> result = new ArrayList<>();
        int end = nums.length;
        if (nums == null || end < 3) {
            return result;
        }
        Arrays.sort(nums);
        for (int i = 0; i < end; i++) {
            //排序后，第一个数大于0，则。。
            if (nums[i] > 0) {
                break;
            }
            if (i > 0 && nums[i] == nums[i] - 1){
                continue;
            }
            int L = i + 1;
            int R = end - 1;
            while (L < R){
                int tempSum = nums[i] + nums[L] + nums[R];
                if (tempSum == 0) {
                    result.add(Arrays.asList(nums[i], nums[L], nums[R]));
                    while (L < R && nums[L] == nums[L + 1]) {
                        L++;
                    }
                    while (L < R && nums[R] == nums[R - 1]) {
                        R--;
                    }
                    L++;
                    R--;
                }else if(tempSum > 0) {R--;}
                else if(tempSum < 0) {L++;}
            }
        }
        return result;
    }
    /**
     * 双指针 + 排序去重
     * 转换为twoSum
     * 并且在相同的时候跳过，避免重复
     */
    public List<List<Integer>> threeSum4(int[] nums){
        int end = nums.length;
        Arrays.sort(nums);
        List<List<Integer>> result = new ArrayList<>();
        for (int first = 0; first < nums.length; first++) {
            if (first > 0 && nums[first] == nums[first - 1]){
                continue;
            }
            int third = end - 1;
            int target = -nums[first];
            for (int second = first + 1; second < nums.length; second++) {
                if (second > first + 1 && nums[second] == nums[second - 1]){
                    continue;
                }
                while (second < third && nums[second] + nums[third] > target){
                    --third;
                }
               if (second == third ){
                   break;
               }
                if (nums[second] + nums[third] == target) {
                    List<Integer> list = new ArrayList<>();
                    list.add(nums[first]);
                    list.add(nums[second]);
                    list.add(nums[third]);
                    result.add(list);
                }
            }
        }
        return result;
    }


    public static void main(String[] args) {
//        System.out.println("test the simplestack");
        int[] a = {-7,-1,-13,2,13,2,12,3,-11,3,7,-15,2,-9,-13,-13,11,-10,5,-13,2,-12,0,-8,8,-1,4,10,-13,-5,-6,-4,9,-12,5,8,5,3,-4,9,13,10,10,-8,-14,4,-6,5,10,-15,-1,-3,10,-15,-4,3,-1,-15,-10,-6,-13,-9,5,11,-6,-13,-4,14,-3,8,1,-4,-5,-12,3,-11,7,13,9,2,13,-7,6,0,-15,-13,-11,-8,9,-14,1,11,-7,13,0,-6,-15,11,-6,-2,4,2,9,-15,5,-11,-11,-11,-13,5,7,7,5,-10,-7,6,-7,-11,13,9,-10,-9};
//        SimpleStack test = new SimpleStack();
//        for(int i : a){
//            test.push(i);
//        }
//        for (int i = 0; i < a.length; i++) {
//            System.out.println(test.get(i));
//        }
//        System.out.println(test);
//        System.out.println(test.size());
        System.out.println("test the soulution");
        LeetCode0015 leetCode0015 = new LeetCode0015();
        List<List<Integer>> list = new ArrayList<>();
        list = leetCode0015.threeSum3_RW(a);
        System.out.println(list);

    }
}
