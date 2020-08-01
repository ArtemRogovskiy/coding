package leetcode;

import java.util.Arrays;

public class RemoveDuplicatesFromSortedArray {

    public static void main(String[] args) {
        RemoveDuplicatesFromSortedArray instance = new RemoveDuplicatesFromSortedArray();
        int[] input = new int[]{1, 2, 3, 3, 4, 6, 6};
        System.out.println(instance.removeDuplicates(input));
        System.out.println(Arrays.toString(input));
    }

    public int removeDuplicates(int[] nums) {
        if (nums == null || nums.length == 0) return 0;
        int unique = nums[0];
        int length = 1;
        for (int i = 1; i < nums.length; i++) {
            if (unique != nums[i]) {
                if (i != length) nums[length] = nums[i];
                unique = nums[i];
                length++;
            }
        }
        return length;
    }
}
