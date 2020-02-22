package leetcode;

import java.util.Arrays;
import java.util.Scanner;

public class MedianOfTwoSortedArrays {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        String s1 = input.nextLine();
        int[] ar1 = Arrays.stream(s1.split(" ")).mapToInt(Integer::parseInt).toArray();
        String s2 = input.nextLine();
        int[] ar2 = Arrays.stream(s2.split(" ")).mapToInt(Integer::parseInt).toArray();
        input.close();
        System.out.println(MedianOfTwoSortedArrays.findMedianSortedArrays(ar1, ar2));
    }

    private static double findMedianSortedArrays(int[] nums1, int[] nums2) {
        int l = 0;
        int r = nums1.length - 1;
        while (l <= r) {
            int mid = l + (r - l) / 2;
            int search = Arrays.binarySearch(nums2, nums1[mid]);
            int position = search < 0 ? Math.abs(search) - 1 : search;
            if (mid + position == nums1.length - mid - 1 + nums2.length - position) {
                return nums1[mid];
            } else if (mid + position == nums1.length - mid - 1 + nums2.length - position) {
                l = mid + 1;
            } else {
                r = mid - 1;
            }
        }
        return -1000;
    }
}
