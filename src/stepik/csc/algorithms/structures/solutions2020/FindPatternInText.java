package stepik.csc.algorithms.structures.solutions2020;

import java.util.Scanner;

// time limit failure
public class FindPatternInText {

    private static int prime = 1_000_000_007;
    private static int x = 263;
    private static int patternHash;
    private static int[] hashes;

    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        String pattern = input.next();
        String text = input.next();

        patternHash = hash(pattern);
        long xPower = power(x, pattern.length() - 1);
        hashes = new int[text.length() - pattern.length() + 1];
        int hashIndex = text.length() - pattern.length(); // index for filling hashes (from last index to 0)

        int currentHash = hash(text.substring(text.length() - pattern.length()));
        hashes[hashIndex] = currentHash;
        for (int i = text.length() - pattern.length() - 1; i >= 0; i--) {
            // calculate next hash value using previous
            int nextHash = (int) (((currentHash - (text.charAt(i + pattern.length()) * xPower) % prime + prime) % prime)
                    * x % prime + text.charAt(i)) % prime;
            hashes[--hashIndex] = nextHash;
            currentHash = nextHash;
        }

        System.out.println(find(pattern, text));
    }

    private static String find(String pattern, String text) {
        StringBuilder result = new StringBuilder();
        for (int i = 0; i < hashes.length; i++) {
            if (hashes[i] == patternHash && text.substring(i, i + pattern.length()).equals(pattern)) {
                result.append(i);
                result.append(" ");
            }
        }
        return result.toString();
    }

    private static int hash(String s) {
        long hash = 0;
        for (int i = 0; i < s.length(); i++) {
            long charCode = s.charAt(i);
            hash += (charCode * power(x, i)) % prime;
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
