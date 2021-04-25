package stringoperation;

import java.util.Arrays;

public class StringMatching {
    public static void main(String[] args) {
//        String target = "goodgoogle";
//        String sub = "google";
//        matching2(target, sub);
//        maxSubString("12345689998","13452439689998");
        getMaxSubString("12345689998","13452439689998");
    }

    //字符串匹配
    public static void matching(String targetS, String subS) {
        boolean flag = false;
        for (int i = 0; i < targetS.length(); i++) {
            for (int j = 0; j < subS.length(); j++) {
                if (targetS.charAt(i) != subS.charAt(j)) {
                    break;
                } else {
                    i++;
                    if (j == subS.length() - 1) {
                        flag = true;
                    }
                }
            }
        }
        System.out.println(flag);
    }
    
    //字符串匹配
    public static void matching2(String targetS, String subS) {
        boolean flag = false;
        for (int i = 0; i < targetS.length() - subS.length() + 1; i++) {
            int tag = 0;
            if (targetS.charAt(i) == subS.charAt(0)) {
                for (int j = 0; j < subS.length(); j++) {
                    if (targetS.charAt(i + j) != subS.charAt(j)) {
                        break;
                    }
                    tag = j;
                }

                if (tag == subS.length() - 1) {
                    flag = true;
                }
            }
        }
        System.out.println(flag);
    }

    //字符串匹配
    public void s1() {
        String s = "goodgoogle";
        String t = "google";
        int isfind = 0;
        for (int i = 0; i < s.length() - t.length() + 1; i++) {
            if (s.charAt(i) == t.charAt(0)) {
                int jc = 0;
                for (int j = 0; j < t.length(); j++) {
                    if (s.charAt(i + j) != t.charAt(j)) {
                        break;
                    }
                    jc = j;
                }
                if (jc == t.length() - 1) {
                    isfind = 1;
                }
            }
        }
        System.out.println(isfind);
    }

    /**
     * 最长公共字串
     * @param S1 字符串1
     * @param S2 字符串2
     */
    public static void maxSubString (String S1, String S2){
        //记录长度
        int max_len = 0;
        //最长字串
        String maxSubS = "";
        //第一个循环对于s1，相当于用第一个串与第二个串比较。
        for (int i = 0; i < S1.length(); i++) {
            //第二个循环s2
            for (int j = 0; j < S2.length(); j++) {
                //如果两个字符串有相同的字符，则继续，否则继续寻找
                if (S1.charAt(i) == S2.charAt(j)){
                    //继续找，s1和s2同时向后移动
                    for (int m=i, n=j; m<S1.length()&&n<S2.length(); m++,n++) {
                        //如果出现不同，跳出继续寻找与第二个串相同的字符
                        if (S1.charAt(m) != S2.charAt(n)){
                            break;
                        }
                        //如果相同，判断字符串长度是否大于之前的字串。并输出字串
                        if (m-i+1 > max_len){
                            max_len = m-i+1;
                            maxSubS = S1.substring(i, m+1);
                            System.out.println(maxSubS + " ----- "  +max_len);
                        }
                    }
                }
            }
        }
        System.out.println(maxSubS);
    }
    
    public static void getMaxSubString(String s1, String s2){
        char[] c1 = s1.toCharArray();
        char[] c2 = s2.toCharArray();
        int[][] m = new int[c2.length+1][c1.length+1];
        //构建状态转移矩阵
        for (int i = 1; i <= c2.length; i++) {
            for (int j = 1; j <= c1.length; j++) {
                if (c2[i - 1] == c1[j - 1]) {
                    m[i][j] = m[i - 1][j - 1] + 1;
                }
            }
        }
//        System.out.println(Arrays.deepToString(m));
        int max = 0;
        int index = 0;
        for (int i = 0; i <= c2.length; i++) {
            for (int j = 0; j <= c1.length; j++) {
                if (m[i][j] > max) {
                    max = m[i][j];
                    index = i;
                }
            }
        }
        String s = "";
        for (int i = index - max; i < index; i++) {
            s += s2.charAt(i);
        }
        System.out.println(s);
    }
}
