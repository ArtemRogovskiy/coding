package leetcode;

public class LongestCommonPrefix {
    public static void main(String[] args) {
        LongestCommonPrefix instance = new LongestCommonPrefix();
        System.out.println(instance.longestCommonPrefix(new String[] {"flower","flow","flight"}));
//        System.out.println(instance.longestCommonPrefix(new String[] {"dog","racecar","car"}));
    }

    public String longestCommonPrefix(String[] strs) {
        if (strs == null || strs.length == 0) return "";
        StringBuilder result = new StringBuilder("");
        for (int i = 0; i < strs[0].length(); i++) {
            for (String s : strs) {
                if (s.length() < i + 1 || s.charAt(i) != strs[0].charAt(i)) {
                    return result.toString();
                }
            }
            result.append(strs[0].charAt(i));
        }
        return result.toString();
    }
}
