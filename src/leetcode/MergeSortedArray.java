package leetcode;

import java.util.Arrays;

public class MergeSortedArray {
    public static void main(String[] args) {
        int[] nums1 = {3, 10, 32, 0, 0, 0};
        merge(nums1, 3, new int[]{-1, 4, 70}, 3);
        System.out.println(Arrays.toString(nums1));
    }

    //in place
    public static void merge(int[] nums1, int m, int[] nums2, int n) {
        int p1 = m - 1;
        int p2 = n - 1;
        for (int i = nums1.length - 1; i >= 0; i--) {
            if (p2 == -1 || p1 != -1 && nums1[p1] > nums2[p2]) {
                nums1[i] = nums1[p1--];
            } else {
                nums1[i] = nums2[p2--];
            }
        }
    }

    //with additional memory
    public static void merge2(int[] nums1, int m, int[] nums2, int n) {
        int[] aux = Arrays.copyOf(nums1, m);
        int i = 0, j = 0;
        while (i + j < m + n) {
            if (j == n || i != m && aux[i] < nums2[j]) {
                nums1[i + j] = aux[i++];
            } else {
                nums1[i + j] = nums2[j++];
            }
        }
    }
}
