package leetcode.aux;

import java.util.Arrays;

public class Common {
    private Common() {

    }

    public static void print2DimensionalArray(int[][] arr) {
        System.out.println();
        System.out.print("[ ");
        for (int[] ar : arr) {
            System.out.print(Arrays.toString(ar) + " ");
        }
        System.out.print("]");
    }
}
