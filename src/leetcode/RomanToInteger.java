package leetcode;

import java.util.HashMap;
import java.util.Map;

public class RomanToInteger {

    Map<Character, Integer> mapping;

    RomanToInteger() {
        mapping = new HashMap<>();
        mapping.put('I', 1);
        mapping.put('V', 5);
        mapping.put('X', 10);
        mapping.put('L', 50);
        mapping.put('C', 100);
        mapping.put('D', 500);
        mapping.put('M', 1000);
    }

    public static void main(String[] args) {
        RomanToInteger instance = new RomanToInteger();
        System.out.println(instance.romanToInt("III"));
        System.out.println(instance.romanToInt("IV"));
        System.out.println(instance.romanToInt("IX"));
        System.out.println(instance.romanToInt("LVIII"));
        System.out.println(instance.romanToInt("MCMXCIV"));
    }

    public int romanToInt(String s) {
        if (s == null || s.length() == 0) return 0;
        if (s.length() == 1) return mapping.get(s.charAt(0));
        int result = 0;
        for (int i = 0; i < s.length() - 1; i++) {
            if (mapping.get(s.charAt(i)) < mapping.get(s.charAt(i + 1))) {
                result -= mapping.get(s.charAt(i));
            } else {
                result += mapping.get(s.charAt(i));
            }
        }
        result += mapping.get(s.charAt(s.length() - 1));
        return result;
    }
}
