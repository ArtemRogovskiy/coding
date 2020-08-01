package leetcode;

import java.util.Arrays;

public class RemoveElement {
    public static void main(String[] args) {
        RemoveElement instance = new RemoveElement();
        int[] ints = {1};
        System.out.println(instance.removeElement(ints, 1));
        System.out.println(Arrays.toString(ints));
    }

    public int removeElement(int[] nums, int val) {
        if (nums == null || nums.length == 0) return 0;
        int res = nums.length;
        for (int i = 0; i < res; ) {
            if (nums[i] == val) {
                res--;
                nums[i] = nums[res];
            } else {
                i++;
            }
        }
        return res;
    }
}
