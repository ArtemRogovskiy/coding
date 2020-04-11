package stepik.csc.algorithms.methods.solutions2020;

import java.util.Arrays;
import java.util.Collections;
import java.util.Scanner;

public class LargestNonIncreasingSubsequence {

    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        int n = input.nextInt();
        int[] sequence = new int[n];
        for (int i = 0; i < n; i++) {
            sequence[i] = input.nextInt();
        }
        int[] subsequence = getLargestNonIncreasingSubsequence(sequence); //more correct indexes of subsequence
        printResult(subsequence);
    }

    private static void printResult(int[] subsequence) {
        System.out.println(subsequence.length);
        for (int value : subsequence) {
            System.out.print(value + " ");
        }
    }

    private static int[] getLargestNonIncreasingSubsequence(int[] sequence) {
        //current max length of non increasing subsequence
        int length = 0;
        int[] dpIndexes = new int[sequence.length];
        //non increasing sorting array from index 0 to length
        Integer[] dpValues = new Integer[sequence.length];
        //array for restore resulting subsequence
        int[] restore = new int[sequence.length];
        Arrays.fill(restore, -1);
        for (int i = 0; i < sequence.length; i++) {
            int insertionIndex = getInsertionIndex(dpValues, length, sequence[i]);
            if (insertionIndex == length) {
                length++;
            }
            dpValues[insertionIndex] = sequence[i];
            dpIndexes[insertionIndex] = i;
            if (insertionIndex != 0) {
                restore[i] = dpIndexes[insertionIndex - 1];
            }
        }
        //for printing values, not indexes
//        return restoreResultValues(restore, length, sequence, dpIndexes);
        return restoreResultIndexes(restore, length, sequence, dpIndexes);
    }

    private static int getInsertionIndex(Integer[] values, int length, int value) {
        int position = Arrays.binarySearch(values, 0, length, value, Collections.reverseOrder());
        while (position >= 0) {
            position = Arrays.binarySearch(values, position + 1, length, value, Collections.reverseOrder());
        }
        return - (position + 1);
    }

    private static int[] restoreResultIndexes(int[] restore, int length, int[] sequence, int[] dpIndexes) {
        int[] result = new int[length];
        if(length == 0) return result;
        int index = dpIndexes[length - 1];
        result[--length] = index + 1;
        while (restore[index] != -1) {
            index = restore[index];
            result[--length] = index + 1;
        }
        return result;
    }

    private static int[] restoreResultValues(int[] restore, int length, int[] sequence, int[] dpIndexes) {
        int[] result = new int[length];
        if (length == 0) return result;
        int index = dpIndexes[length - 1];
        result[--length] = sequence[index];
        while (restore[index] != -1) {
            index = restore[index];
            result[--length] = sequence[index];
        }
        return result;
    }
}
