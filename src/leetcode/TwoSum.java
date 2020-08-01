package leetcode;

import java.util.*;

public class TwoSum {
    public static void main(String[] args) {
        System.out.println(Arrays.toString(new TwoSum().twoSum(new int[] {-1, 0, 1, 3, 2, 4}, 7)));
    }

    public int[] twoSum(int[] nums, int target) {
        Map<Integer, Integer> map = new HashMap<>();
        int[] res = new int[2];
        for (int i = 0; i < nums.length; i++) {
            int num = nums[i];
            if (map.containsKey(target - num)) {
                res[0] = i;
                res[1] = map.get(target - num);
                break;
            }
            map.put(num, i);
        }
        return res;
   }
}
