package leetcode;

import java.util.Deque;
import java.util.LinkedList;

public class PalindromeNumber {
    public static void main(String[] args) {
        System.out.println(new PalindromeNumber().isPalindrome3(100020001));
    }


    // reverse half and compare
    public boolean isPalindrome3(int x) {
        if (x < 0) return false;
        int halfRev = 0;
        while (x > halfRev) {
            halfRev = halfRev * 10 + x % 10;
            x /= 10;
        }
        return halfRev == x || x == halfRev / 10;
    }


    // compare first and last digits of int. Catting only last digits for saving 0 in front
    public boolean isPalindrome2(int x) {
        if (x < 0) return false;
        int length = (int) Math.log10(x);
        int pow = (int) Math.pow(10, length);
        while ( length + 1 > 1) {
            int first = x / pow % 10;
            int last = x % 10;
            if (first != last) return false;
            x /= 10;
            pow /= 100;
            length -= 2;
        }
        return true;
    }


    // using deque
    public boolean isPalindrome(int x) {
        if (x < 0) return false;
        Deque<Integer> dq = new LinkedList<>();
        while (x != 0) {
            dq.add(x % 10);
            x /= 10;
        }
        int half = dq.size() / 2;
        for (int i = 0; i < half; i++) {
            if (dq.pollFirst() != dq.pollLast()) return false;
        }
        return true;
    }
}
