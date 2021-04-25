package backtracking;

import java.util.*;

public class LeetCode0017 {
    Map<String, String> map = new HashMap<String, String>(){
        {
            put("2", "abc");
            put("3", "def");
            put("4", "ghi");
            put("5", "jkl");
            put("6", "mno");
            put("7", "pqrs");
            put("8", "tuv");
            put("9", "wxyz");
        }
    };

    List<String> output = new ArrayList<>();

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String string = scanner.nextLine();
        LeetCode0017 leetCode0017 = new LeetCode0017();
        System.out.println(leetCode0017.letterCombinations(string));
        BackTracking backTracking = new BackTracking();
        backTracking.combination(string);
        System.out.println(backTracking.res);
    }
    public void backtrack(String combination,String next_digits){
        if (next_digits.length() == 0)
            output.add(combination);
        else {
            String digit = next_digits.substring(0,1);
            String letters = map.get(digit);
            for (int i = 0; i < letters.length(); i++) {
                String letter = map.get(digit).substring(i, i + 1);
                backtrack(combination + letter, next_digits.substring(1));

            }

        }

    }
    public List<String> letterCombinations(String digits){
        if (digits.length() != 0)
            backtrack("",digits);
        return output;
    }

    //gg,做不出来
 /*   public List<String> letterCombinations(String digits) {
        List<String> list = new ArrayList<>();
        Map<Character,String[]> map = new HashMap<Character, String[]>();
        String[] char2 = {"a","b","c"};
        map.put('2',char2);
        String[] char3 = {"d","e","f"};
        map.put('3',char3);
        String[] char4 = {"g","h","i"};
        map.put('4',char4);
        String[] char5 = {"j","k","l"};
        map.put('5',char5);
        String[] char6 = {"m","n","o"};
        map.put('6',char6);
        String[] char7 = {"p","q","r","s"};
        map.put('7',char7);
        String[] char8 = {"t","u","v"};
        map.put('8',char8);
        String[] char9 = {"x","y","z"};
        map.put('9',char9);
        for (int i = 0 ; i < digits.length(); i++) {
            if (map.containsKey(digits.charAt(i))){
                for (String str:map.get(digits.charAt(i))){
                    list.add(str);
                }
            }

        }
        return list;
    }*/


}

class BackTracking{
    String[] letter_map = {" ", "*", "abc", "def", "ghi", "jkl", "mno", "pqrs", "tuv", "wxyz"};
    List<String> res = new ArrayList<String>();
    public List<String> combination(String digits){
        if (null == digits || 0 == digits.length())
            return res;
        backtrackCombination(0, digits,"");
        return res;
    }

    public void backtrackCombination(int index, String digits, String com){
        if (index == digits.length()) {
            res.add(com);
            return;
        } else {
            char digit = digits.charAt(index);
            String letters = letter_map[digit - '0'];
            for (int i = 0; i <letters.length(); i++) {
                backtrackCombination(index+1, digits, com+letters.charAt(i));
            }

        }
    }
}