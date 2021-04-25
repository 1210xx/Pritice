package mapandset;

import java.util.*;

/**
 * 给定两个字符串 s 和 t ，编写一个函数来判断 t 是否是 s 的字母异位词。
 *
 * 示例 1:
 *
 * 输入: s = "anagram", t = "nagaram"
 * 输出: true
 * 示例 2:
 *
 * 输入: s = "rat", t = "car"
 * 输出: false
 *
 */
public class LeetCode0242 {
    public boolean isAnagram(String s, String t) {
        if (s.length() != t.length()) {
            return false;
        }
        List<Character> slist = new ArrayList<>();
        List<Character> tlist = new ArrayList<>();
        for (int i = 0; i < s.length(); i++) {
            slist.add(s.charAt(i));
            tlist.add(t.charAt(i));
        }
        Collections.sort(slist);
        Collections.sort(tlist);
        if (slist.equals(tlist)) {
            return true;
        } else {
            return false;
        }
    }

    public boolean isAnagram2(String s, String t) {
        if (s.length() != t.length()) {
            return false;
        }
        char[] sarray = s.toCharArray();
        char[] tarray = t.toCharArray();
        Arrays.sort(sarray);
        Arrays.sort(tarray);
        return Arrays.equals(sarray, tarray);
    }

    public boolean isAnagram3(String s, String t){
        if (s.length() != t.length()){
            return false;
        }
        int[] s_indicator = new int[26];
        int[] t_indicator = new int[26];
        for (int i = 0; i < s.length(); i++) {
            s_indicator[s.charAt(i) - 'a'] ++;
            t_indicator[t.charAt(i) - 'a'] ++;
        }
        for (int i = 0; i < 26; i++) {
            if (s_indicator[i] != t_indicator[i]){
                return false;
            }
        }
        return true;
    }

    public boolean isAnagram3_Other(String s, String t){
        if (s.length() != t.length()){
            return false;
        }
        int[] indicator = new int[26];

        for (int i = 0; i < s.length(); i++) {
            indicator[s.charAt(i) - 'a'] ++;
            indicator[t.charAt(i) - 'a'] --;
        }
        for (int i = 0; i < 26; i++) {
            if (indicator[i] != 0){
                return false;
            }
        }
        return true;
    }

    public boolean isAnagram4(String s, String t){
        if (s.length() != t.length()){
            return false;
        }
        int[] indicator = new int[26];
        for (int i = 0; i < s.length(); i++) {
            indicator[s.charAt(i) - 'a'] ++;
        }
        for (int i = 0; i < t.length(); i++) {
            indicator[t.charAt(i) - 'a'] --;
            if (indicator[t.charAt(i) - 'a'] < 0){
                return false;
            }
        }
        return true;
    }
    public static void main(String[] args) {
        LeetCode0242 leetCode0242 = new LeetCode0242();
        String s = "anagram";
        String t = "nagaram";
        String s1 = "";
        String t1 = "";
        System.out.println(leetCode0242.isAnagram3_Other(s, t));

    }
}
