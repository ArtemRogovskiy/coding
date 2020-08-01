package stepik.csc.algorithms.structures.solutions2020;

import java.util.Scanner;

// reverse order of hash calculation. Now form start to end of text
public class FindPatternInText2 {

    private static int prime = 1_000_000_007;
    private static int x = 263;
    private static StringBuilder result = new StringBuilder();
    private static int patternHash;
    private static String text;
    private static String pattern;

    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        pattern = input.next();
        text = input.next();

        patternHash = hash(pattern);
        long xPower = power(x, pattern.length() - 1);
        int currentHash = hash(text.substring(0, pattern.length()));
        addValidToResult(currentHash, 0, pattern.length() - 1);
        for (int i = pattern.length(); i < text.length(); i++) {
            // calculate next hash value using previous
            int nextHash = (int) (((currentHash - (text.charAt(i - pattern.length()) * xPower) % prime + prime) % prime)
                    * x % prime + text.charAt(i)) % prime;

            addValidToResult(nextHash, i - pattern.length() + 1, i);

            currentHash = nextHash;
        }

        System.out.println(result.toString());
    }

    private static void addValidToResult(int currentHash, int start, int end) {
//        if (currentHash == patternHash && text.substring(start, end + 1).equals(pattern)) {
        if (currentHash == patternHash) {
            result.append(start);
            result.append(" ");
        }
    }

    private static int hash(String s) {
        long hash = 0;
        for (int i = 0; i < s.length(); i++) {
            long charCode = s.charAt(i);
            hash += (charCode * power(x, s.length() - i - 1)) % prime;
        }
        return (int) (hash % prime);
    }

    private static long power(int x, int power) {
        if (power == 0) return 1;
        long result = x;
        for (int i = 1; i < power; i++) {
            result = (result * x) % prime;
        }
        return result;
    }
}
