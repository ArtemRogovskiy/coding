package leetcode;

import java.util.HashMap;
import java.util.Map;

public class SearchInRotatedSortedArray {
    public static void main(String[] args) {
        System.out.println(search(new int[] {4,5,6,7,0,1,2}, 0));
        System.out.println(search(new int[] {4,5,6,7,0,1,2}, 3));
        Map<Integer, Integer> map = new HashMap<>();
    }

    public static int search(int[] nums, int target) {
        int l = 0;
        int r = nums.length - 1;
        while (l <= r) {
            int mid = l + (r - l) / 2;
            if (nums[mid] == target) return mid;
            else if (nums[mid] < nums[r] && nums[mid] < target && target <= nums[r]
                    || nums[mid] > nums[r] && (nums[mid] < target || target <= nums[r])) {
                l = mid + 1;
            } else {
                r = mid - 1;
            }
        }
        return -1;
    }
}
