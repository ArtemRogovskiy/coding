package leetcode;

import java.util.ArrayList;
import java.util.List;

public class GroupAnagrams {
    public static void main(String[] args) {
        String[] test1 = {"eat", "tea", "tan", "ate", "nat", "bat"};
        System.out.println(groupAnagrams(test1));
    }

    public static List<List<String>> groupAnagrams(String[] strs) {
        List<List<String>> res = new ArrayList<>();
        boolean[] added = new boolean[strs.length];
        for (int i = 0; i < strs.length; i++) {
            if (added[i]) continue;
            List<String> subList = new ArrayList<>();
            subList.add(strs[i]);
            added[i] = true;
            for (int j = i + 1; j < strs.length; j++) {
                if (isAnagrams(strs[i], strs[j])) {
                    subList.add(strs[j]);
                    added[j] = true;
                }
            }
            res.add(subList);
        }
        return res;
    }

    private static boolean isAnagrams(String s1, String s2) {
        if (s1.length() != s2.length()) return false;
        int[] counts = new int[26];
        for (int i = 0; i < s1.length(); i++) {
            counts[s1.charAt(i) - 'a']++;
        }
        for (int i = 0; i < s2.length(); i++) {
            if (--counts[s2.charAt(i) - 'a'] < 0) return false;
        }
        return true;
    }
}
