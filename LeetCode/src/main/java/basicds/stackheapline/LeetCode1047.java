package basicds.stackheapline;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Stack;

public class LeetCode1047 {
    /**
     * 给出由小写字母组成的字符串 S，重复项删除操作会选择两个相邻且相同的字母，并删除它们。
     * <p>
     * 在 S 上反复执行重复项删除操作，直到无法继续删除。
     * <p>
     * 在完成所有重复项删除操作后返回最终的字符串。答案保证唯一。
     *
     * @param S
     * @return
     */
    public String removeDuplicates(String S) {
        Stack<Character> operation = new Stack<>();
        char[] sarray = S.toCharArray();
        System.out.println(Arrays.toString(sarray));
        for (char c : sarray) {
            if (operation.size() == 0 || operation.isEmpty()) {
                operation.push(c);
            } else {
                if (operation.get(operation.size() - 1) == c) {
                    operation.pop();
                } else {
                    operation.push(c);
                }
            }
        }

        StringBuilder sb = new StringBuilder();
        for (char c : operation) {
            sb.append(c);
        }
        return sb.toString();
    }

    /**
     * 利用stringbuilder直接进行栈的操作，简化了stack-->string的过程
     *
     * 数据结构并不一定非要用固定的数据结构。
     * 规定其操作以及相关的限制即可进行数据结构的应用。
     * @param S
     * @return
     */
    public String removeDuplicates2(String S) {
        StringBuilder sb = new StringBuilder();
        int sbLength = 0;
        for (char character : S.toCharArray()) {
            if (sbLength != 0 && character == sb.charAt(sbLength - 1)) {
                sb.deleteCharAt(sbLength-- - 1);
            } else {
                sb.append(character);
                sbLength++;
            }
        }
        return sb.toString();
    }

    /**
     *  我们可以用字符串自带的替换函数，由于字符串仅包含小写字母，因此只有 26 种不同的重复项。
     *
     * 将 aa 到 zz 的 26 种重复项放入集合中；
     *
     * 遍历这 26 种重复项，并用字符串的替换函数把重复项替换成空串。
     *
     * 注意，在进行过一次替换之后，可能会出现新的重复项。例如对于字符串 abbaca，如果替换了重复项 bb，字符串会变为 aaca，出现了新的重复项 aa。
     * 因此，上面的过程需要背重复若干次，直到字符串在一整轮替换过程后保持不变（即长度不变）为止。
     * @param S
     * @return
     */
    public String removeDuplicates3(String S) {
        // generate 26 possible duplicates
        HashSet<String> duplicates = new HashSet();
        StringBuilder sb = new StringBuilder();
        for (char i = 'a'; i <= 'z'; ++i) {
            sb.setLength(0);
            sb.append(i);
            sb.append(i);
//            System.out.println(sb);
            duplicates.add(sb.toString());
        }

        int prevLength = -1;
        while (prevLength != S.length()) {
            prevLength = S.length();
            for (String d : duplicates) {
                S = S.replace(d, "");
            }
        }

        return S;
    }


    public static void main(String[] args) {
        LeetCode1047 leetCode1047 = new LeetCode1047();
        String S = "abbacaaaddeccdvde";
        System.out.println(leetCode1047.removeDuplicates3(S));
    }
}
