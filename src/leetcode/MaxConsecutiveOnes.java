package leetcode;

public class MaxConsecutiveOnes {

    public static void main(String[] args) {
        System.out.println(findMaxConsecutiveOnes(new int[] {0}));
        System.out.println(findMaxConsecutiveOnes(new int[] {0, 1, 0, 1}));
        System.out.println(findMaxConsecutiveOnes(new int[] {1, 0, 0}));
        System.out.println(findMaxConsecutiveOnes(new int[] {1,0,1,1,0}));
    }

    public static int findMaxConsecutiveOnes(int[] nums) {
        int start = 0;
        int next = 0;
        int res = 0;
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] == 0) {
                start = next;
                next = i + 1;
            }
            res = Math.max(res, i - start + 1);
        }
        return res;
    }
}
