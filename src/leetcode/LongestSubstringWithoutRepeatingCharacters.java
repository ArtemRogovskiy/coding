package leetcode;

import java.util.HashMap;
import java.util.Map;

public class LongestSubstringWithoutRepeatingCharacters {
    public static void main(String[] args) {
        String test1 = "abcabcbb";
        String test2 = "bbbbb";
        String test3 = "pwwkew";
        String test4 = "";
        String test5 = "abba"; // WARNING
        System.out.println(lengthOfLongestSubstring(test1));
        System.out.println(lengthOfLongestSubstring(test2));
        System.out.println(lengthOfLongestSubstring(test3));
        System.out.println(lengthOfLongestSubstring(test4));
        System.out.println(lengthOfLongestSubstring(test5));
    }

    public static int lengthOfLongestSubstring(String s) {
        int res = 0;
        int start = 0;
        Map<Character, Integer> map = new HashMap<>();
        for (int i = 0; i < s.length(); i++) {
             char ch = s.charAt(i);
             if (map.containsKey(ch)) {
                 start = Math.max(map.get(ch) + 1, start);
             }
             map.put(ch, i);
             res = Math.max(res, i - start + 1);
        }
        return res;
    }
}
