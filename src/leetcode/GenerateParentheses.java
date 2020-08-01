package leetcode;

import java.util.*;

public class GenerateParentheses {

    public static void main(String[] args) {
        List<String> res = generateParenthesis(3);
        for (String item : res) {
            System.out.println(item);
        }
    }

    public static List<String> generateParenthesis(int n) {
        List<String> res = new ArrayList<>();
        generateParenthesis(n, 0, 0, "", res);
        return res;
    }

    private static void generateParenthesis(int n, int open, int close, String s, List<String> list) {
        if (s.length() == n * 2) {
            list.add(s);
        }
        if (open < n) {
            generateParenthesis(n, open + 1, close, s + '(', list);
        }
        if (open > close) {
            generateParenthesis(n, open, close + 1, s + ')', list);
        }
    }
}
