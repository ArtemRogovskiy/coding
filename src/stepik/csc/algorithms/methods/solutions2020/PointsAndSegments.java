package stepik.csc.algorithms.methods.solutions2020;

import java.util.Arrays;
import java.util.Scanner;

public class PointsAndSegments {

    private static int[] leftBorders;
    private static int[] rightBorders;

    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        int countOfSegments = input.nextInt();
        leftBorders = new int[countOfSegments];
        rightBorders = new int[countOfSegments];
        int countOfPoints = input.nextInt();
        for (int i = 0; i < countOfSegments; i++) {
            leftBorders[i] = input.nextInt();
            rightBorders[i] = input.nextInt();
        }
        Arrays.sort(leftBorders);
        Arrays.sort(rightBorders);
        for (int i = 0; i < countOfPoints; i++) {
            int point = input.nextInt();
            System.out.print(segmentsContainsPoint(point) + " ");
        }
    }

    private static int segmentsContainsPoint(int point) {
        int a = leftBinSearch(point);
        //point less then left border -> exclude segments started from this left border
        int excludedByLeftBorders = (a < 0) ? leftBorders.length - Math.abs(a + 1) : leftBorders.length - a - 1;

        int b = rightBinSearch(point);
        //point bigger then right border -> exclude segments ended with this right border
        int excludedByRightBorders = (b < 0) ? Math.abs(b + 1) : b;

        return leftBorders.length - excludedByLeftBorders - excludedByRightBorders;
    }

    //binary search in segments left borders
    //if there are several match elements, return right most element index
    private static int leftBinSearch(int point) {
        int a = Arrays.binarySearch(leftBorders, point);
        if (a < 0) return a; //no match elements
        int fromIndex = a + 1;
        while(a >= 0) {
            fromIndex = a + 1;
            a = Arrays.binarySearch(leftBorders, fromIndex, leftBorders.length, point);
        }
        return fromIndex - 1;
    }

    //binary search in segments right borders
    //If there are several match elements, return left most element index
    private static int rightBinSearch(int point) {
        int a = Arrays.binarySearch(rightBorders, point);
        if (a < 0) return a;//no match elements
        int toIndex = a;
        while(a >= 0) {
            toIndex = a;
            a = Arrays.binarySearch(rightBorders, 0, toIndex, point);
        }
        return toIndex;
    }
}
