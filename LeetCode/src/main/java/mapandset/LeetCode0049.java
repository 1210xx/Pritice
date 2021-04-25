package mapandset;

import com.sun.applet2.AppletParameters;

import java.lang.reflect.Array;
import java.security.Key;
import java.util.*;

public class LeetCode0049 {
    /**
     * 给定一个字符串数组，将字母异位词组合在一起。字母异位词指字母相同，但排列不同的字符串。
     * <p>
     * 示例:
     * <p>
     * 输入: ["eat", "tea", "tan", "ate", "nat", "bat"]
     * 输出:
     * [
     * ["ate","eat","tea"],
     * ["nat","tan"],
     * ["bat"]
     * ]
     * 说明：
     * <p>
     * 所有输入均为小写字母。
     * 不考虑答案输出的顺序。
     */
    List<List<String>> result = new ArrayList<>();
    public List<List<String>> groupAnagrams(String[] strs) {
        List<String> tempStrsList = new ArrayList<>();
        String[] tempStrs;
        List<String> list = new ArrayList<>();
        // terminator 
        if (strs == null || strs.length == 0) {
            return null;
            // process result 
        } else if (strs.length == 1) {
            result.add(Arrays.asList(new String[]{strs[0]}));
        } else {
            // process current logic 
            // restore current status 
            list.add(strs[0]);
            for (int i = 1; i < strs.length; i++) {
                if (isAnagram(strs[0], strs[i])) {
                    list.add(strs[i]);

                } else {
                    tempStrsList.add(strs[i]);
                }
            }
            result.add(list);
            System.out.println("strs : " + Arrays.toString(strs));
            System.out.println("reslut :" + result);
            System.out.println("tempStrsList :" + tempStrsList);

            if (!tempStrsList.isEmpty()){
                tempStrs = new String[tempStrsList.size()];
                for (int i = 0; i < tempStrsList.size(); i++) {
                    tempStrs[i] = tempStrsList.get(i);
                }
            }else {
            tempStrs = null;
            }
            System.out.println("tempStrs:" + Arrays.toString(tempStrs));
            // drill down 
            groupAnagrams(tempStrs);
        }
        return result;
    }


    public boolean isAnagram(String s, String t) {
        if (s.length() != t.length()) {
            return false;
        }
        int[] indicator = new int[26];
        for (int i = 0; i < s.length(); i++) {
            indicator[s.charAt(i) - 'a']++;
            indicator[t.charAt(i) - 'a']--;
        }
        for (int i : indicator) {
            if (i != 0) {
                return false;
            }
        }
        return true;
    }

    public List<List<String>> groupAnagrams2(String[] strs) {
        if (strs.length == 0) {return new ArrayList();}
        Map<String, List> ans = new HashMap<String, List>();
        for (String s : strs) {
            char[] ca = s.toCharArray();
            Arrays.sort(ca);
            System.out.println(ca);
            String key = String.valueOf(ca);
            if (!ans.containsKey(key)) {
                ans.put(key, new ArrayList());
            }
            ans.get(key).add(s);
        }
        return new ArrayList(ans.values());
    }

    public List<List<String>> groupAnagrams3(String[] strings){
        if (strings.length == 0) {return new ArrayList<>();}
        Map<String,List> ans = new HashMap<>();
        int[] indicator = new int[26];
        for (String str : strings){
            Arrays.fill(indicator, 0);
            for (char c : str.toCharArray()){
                indicator[c - 'a']++;
            }
            StringBuilder sb = new StringBuilder("");
            for (int i = 0; i < 26; i++) {
                sb.append(" ");
                sb.append(indicator[i]);
            }
            System.out.println(sb);

            String key = sb.toString();
            if (! ans.containsKey(key)){
                ans.put(key,new ArrayList());
            }
            ans.get(key).add(str);

        }

        return new ArrayList(ans.values());
    }

    public static void main(String[] args) {
        LeetCode0049 leetCode0049 = new LeetCode0049();
        String[] strs = {"eat", "tea", "tan", "ate", "nat", "bat","",""};
        String[] strs1 = {"", "", ""};
        String[] strs2 = {"eat", "tea", "ate"};
        System.out.println("最终结果：" + leetCode0049.groupAnagrams3(strs));

    }
}
