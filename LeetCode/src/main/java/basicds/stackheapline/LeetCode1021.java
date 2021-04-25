package basicds.stackheapline;

/**
 * 有效括号字符串为空("")、"(" + A + ")"或A + B，其中A 和B都是有效的括号字符串，+代表字符串的连接。例如，""，"()"，"(())()"和"(()(()))"都是有效的括号字符串。
 *
 * 如果有效字符串S非空，且不存在将其拆分为S = A+B的方法，我们称其为原语（primitive），其中A 和B都是非空有效括号字符串。
 *
 * 给出一个非空有效字符串S，考虑将其进行原语化分解，使得：S = P_1 + P_2 + ... + P_k，其中P_i是有效括号字符串原语。
 *
 * 对S进行原语化分解，删除分解中每个原语字符串的最外层括号，返回 S。
 *
 */
public class LeetCode1021 {
    public static void main(String[] args) {
//        Scanner scanner = new Scanner(System.in);
//        List<String> stringList = new ArrayList<>();
//        if (scanner.hasNextLine()){
//            stringList.add(scanner.nextLine());
//        }
        String[] strings = {"(","(",")","(",")",")","(","(",")",")","(","(",")","(","(",")",")",")"};

        String s = "(()())(())" ;
        String s1 = "(()())(())(()(()))";
                removeBracket(s1);
//        removeOuterParentheses(s1);
    }


    public static String removeBracket(String s){
        StringBuilder stringBuilder = new StringBuilder();
        String resultString = new String();
        int index = 0;

       for (char c : s.toCharArray()){

           if ((c == '(') ){
               index ++;
               stringBuilder.append(c);
           }

           if (c == ')'){
               index--;
               stringBuilder.append(c);
               if (index == 0){
                   resultString += stringBuilder.substring(1 , stringBuilder.length() -1);
                   stringBuilder = new StringBuilder();
               }
           }


       }

        System.out.println(resultString);
        return resultString;
    }

    public static String removeOuterParentheses(String S) {
        StringBuilder stringBuilder = new StringBuilder();
        int index = 0;
        for (char c : S.toCharArray()){

            if (c == '('){
                ++index;
            }
            if (c == ')'){
                --index;
            }
            if (index > 0 ){
                stringBuilder.append(c);
            }
        }
        System.out.println(stringBuilder);
        return stringBuilder.toString();
    }
    public static String removeOuterParentheses2(String S) {
        StringBuilder sb = new StringBuilder();
        int level = 0;
        for (char c : S.toCharArray()) {
            if (c == ')') {--level;}
            if (level >= 1){ sb.append(c);}
            if (c == '('){ ++level;}
        }
        System.out.println(sb);
        return sb.toString();
    }

}
