package recursion;

import javax.xml.transform.Result;
import java.util.ArrayList;
import java.util.List;

/**
 * 数字 n 代表生成括号的对数，请你设计一个函数，用于能够生成所有可能的并且 有效的 括号组合。
 *
 *  
 *
 * 示例：
 *
 * 输入：n = 3
 * 输出：[
 *        "((()))",
 *        "(()())",
 *        "(())()",
 *        "()(())",
 *        "()()()"
 *      ]
 *
 */
public class LeetCode0022 {

    private List<String> result    ;

    public List<String> generateParenthesis(int n) {
       result = new ArrayList<String>();
        _generate(0, 0, n,"");
        return result;
    }

    private void _generate(int left, int right, int n, String s) {
        //terminator
        if (left >= n && right >= n){
            //filter the invalid s
            result.add(s);

            return;
        }
        //process current logic:left , right
        //String s1 = s + "(";
        //String s2 = s + ")";
        //drill down
        if (left < n){
        _generate(left + 1, right, n, s + "(" );
        }
        if (left > right)
        _generate(left , right + 1, n, s + ")");
        //restore current status
    }

    public static void main(String[] args) {
        LeetCode0022 lt22 = new LeetCode0022();
        System.out.println(lt22.generateParenthesis(3));
    }
}
