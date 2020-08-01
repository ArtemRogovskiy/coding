package leetcode;

import java.util.Arrays;

public class PerfectSquares {

    public static void main(String[] args) {
        new PerfectSquares().numSquares(25);
    }

    public int numSquares(int n) {
        int[] aux = new int[n + 1];
        for (int i = 1; i < aux.length; i++) {
            int k = (int) Math.sqrt(i);
            int min = Integer.MAX_VALUE;
            for (int j = 1; j <= k; j++) {
                min = Math.min(min, aux[i - j * j]);
            }
            aux[i] = min + 1;
        }
//        System.out.println(Arrays.toString(aux));
        return aux[n];
    }
}
