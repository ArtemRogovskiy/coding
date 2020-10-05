package leetcode;

import java.util.HashMap;
import java.util.Map;

// new int[26] is using in good solution instead of hashmap!
public class PermutationInString {

    public static void main(String[] args) {
        System.out.println(checkInclusion("ab", "eidbaooo"));
        System.out.println(checkInclusion("ab", "eidboaoo"));
    }

    static boolean checkInclusion(String s1, String s2) {
        if (s1.length() > s2.length()) return false;

        Map<Character, Integer> fromMap = new HashMap<>();
        Map<Character, Integer> toMap = new HashMap<>();

        fillMap(fromMap, s1, s1.length());
        fillMap(toMap, s2, s1.length());

        if (fromMap.equals(toMap)) {
            return true;
        }

        for (int i = s1.length(); i < s2.length(); i++) {
            char ch = s2.charAt(i);
            char old = s2.charAt(i - s1.length());

            if (toMap.get(old) == 1) {
                toMap.remove(old);
            } else {
                toMap.put(ch, toMap.get(ch) - 1);
            }

            if (toMap.containsKey(ch)) {
                toMap.put(ch, toMap.get(ch) + 1);
            } else {
                toMap.put(ch, 1);
            }

            if (fromMap.equals(toMap)) {
                return true;
            }

        }
        return false;

    }

    private static void fillMap(Map<Character, Integer> map, String s, int len) {
        for (int i = 0; i < len; i++) {
            if (map.containsKey(s.charAt(i))) {
                map.put(s.charAt(i), map.get(s.charAt(i)) + 1);
            } else {
                map.put(s.charAt(i), 1);
            }
        }
    }
}
