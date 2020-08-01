package leetcode;

public class ValidPalindrome {

    private static String test1 = "A man, a plan, a canal: Panama"; //true
    private static String test2 = "race a car"; //false
    private static String test3 = ""; // true;
    private static String test4 = "0P"; // false;

    public static void main(String[] args) {
        System.out.println(new ValidPalindrome().isPalindrome(test1));
        System.out.println(new ValidPalindrome().isPalindrome(test2));
        System.out.println(new ValidPalindrome().isPalindrome(test3));
        System.out.println(new ValidPalindrome().isPalindrome(test4));
    }

    public boolean isPalindrome(String s) {
        for (int i = 0, j = s.length() - 1; i <= j; ) {
            if (!isValidChar(s.charAt(i))) {
                i++;
                continue;
            }
            if (!isValidChar(s.charAt(j))) {
                j--;
                continue;
            }
            if (!theSame(s.charAt(i), s.charAt(j))) return false;
            i++;
            j--;
        }
        return true;
    }

    private boolean isValidChar(char ch) {
        return  isAlpha(ch) || ch >= '0' && ch <= '9';
    }

    private boolean theSame(char ch, char chr) {
        return ch - chr == 0 || isAlpha(ch) && isAlpha(chr) && Math.abs(ch - chr) == 32;
    }

    private boolean isAlpha(char ch) {
        return ch >= 'a' && ch <= 'z' || ch >= 'A' && ch <= 'Z';
    }
}
