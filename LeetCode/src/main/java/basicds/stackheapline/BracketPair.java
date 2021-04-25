package basicds.stackheapline;

import java.util.Stack;

/**
 * @author rjjerry
 */
public class BracketPair {

    public static void main(String[] args) {
        String s = "{[()()]}";
        System.out.println(isLegel(s));
    }

    public static int isLeft(char c){
        if (c == '{' || c == '[' || c == '('){
            return 1;
        }else {
            return -1;
        }
    }

    public static int isPair(char a, char b){
        if ((a == '{' && b == '}') || (a == '[' && b == ']') || (a == '(' && b == ')') ){
            return 1;
        }else {
            return -1;
        }
    }
   public static String isLegel (String s ){
       Stack<Character> stack = new Stack<>();
       for (int i = 0; i < s.length(); i++) {
           char curr = s.charAt(i);
           if (isLeft(curr) == 1){
               stack.push(curr);
           }else {
               if (stack.empty()){
                   return "非法";
               }
               char top = (char) stack.pop();
               if (isPair(top,curr) == -1){
                   return "非法";
               }
           }
       }

       if (stack.empty()){
           return "合法";
       }else {
           return "非法";
       }

   }
}
