package basicds.hashmap;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

/**
 * LeetCode001 给定一个整数数组nums和一个整数目标值target，请你在该数组中找出和为目标值的那两个整数，并返回它们的数组下标。
 * <p>
 * 你可以假设每种输入只会对应一个答案。但是，数组中同一个元素在答案里不能重复出现。
 *
 * @author rjjerry
 */
public class TwoSum {
    public static void main(String[] args) {
        System.out.println(Arrays.toString(twoSumHashmap2(new int[]{7, 2, 11, 15}, 9)));
    }

    public static int[] twoSumForce(int[] nums, int target) {
        for (int i = 0; i < nums.length; i++) {
            for (int j = i + 1; j < nums.length; j++) {
                if ((nums[i] + nums[j]) == target) {
                    return new int[]{i, j};
                }
            }
        }

        return null;
    }

    public static int[] twoSumHashmap(int[] nums, int target) {
        HashMap<Integer, Integer> hashMap = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            hashMap.put(nums[i], i);
        }
        for (int i = 0; i < nums.length; i++) {
            if (hashMap.containsKey(target - nums[i]) && hashMap.get(target - nums[i]) != i) {
                return new int[]{hashMap.get(nums[i]), hashMap.get(target - nums[i])};
            }
        }
        return null;
    }

    public static int[] twoSumHashmap2(int[] nums, int target) {
        HashMap<Integer, Integer> hashMap = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            int complement = target - nums[i];
            if (hashMap.containsKey(complement) && hashMap.get(complement) != i){
                return new int[]{hashMap.get(complement), i};
            }else{
                hashMap.put(nums[i],i);
            }

        }
        return null;
    }
}
