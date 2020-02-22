package other;

import java.util.Arrays;

public class BinarySearchExamples {
    public static void main(String[] args) {
        int[] array = {0, 1, 2, 3, 6};
        System.out.println(Arrays.binarySearch(array, -1));
        System.out.println(Arrays.binarySearch(array, 2));
        System.out.println(Arrays.binarySearch(array, 4));
        System.out.println(Arrays.binarySearch(array, 10));
        System.out.println("Example 2:");
        int[] array_2 = {4, 10, 11};
        System.out.println(Arrays.binarySearch(array_2, 1));
        System.out.println(Arrays.binarySearch(array_2, 6));
    }
}
