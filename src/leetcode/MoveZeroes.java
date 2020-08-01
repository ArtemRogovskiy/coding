package leetcode;

import java.util.Arrays;

public class MoveZeroes {

    public static void main(String[] args) {
        int[] test1 = {0, 0, 1, 0, 0, 3, 4, 5, 0, 1000};
        int[] test2 = {1};
        int[] test3 = {2, 3};
        moveZeroes(test1);
        moveZeroes(test2);
        moveZeroes(test3);
        System.out.println(Arrays.toString(test1));
        System.out.println(Arrays.toString(test2));
        System.out.println(Arrays.toString(test3));
    }

    public static void moveZeroes(int[] nums) {
        int insertionPosition = 0;
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] != 0) {
                if (i != insertionPosition) {
                    nums[insertionPosition] = nums[i];
                    nums[i] = 0;
                }
                insertionPosition++;
            }
        }
    }
}
