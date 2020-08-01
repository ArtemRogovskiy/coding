package leetcode;

import org.w3c.dom.ls.LSOutput;

public class ImplementStrStr {
    public static void main(String[] args) {
        ImplementStrStr instance = new ImplementStrStr();
        System.out.println(instance.strStr("hello", "ll"));
        System.out.println(instance.strStr("aaaaa", "bba"));

    }

    public int strStr(String haystack, String needle) {
        if ("".equals(needle)) return 0;
        for (int i = 0; i + needle.length() <= haystack.length(); i++) {
            int hashCode = needle.hashCode();
            String s = haystack.substring(i, i + needle.length());
            if (hashCode == s.hashCode()
                    && needle.equals(s)) return i;
        }
        return -1;
    }
}
