package leetcode;

import leetcode.aux.Common;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;

public class MergeIntervals {

    public static void main(String[] args) {
        double d = 0.0;
        int[][] res = new MergeIntervals().merge(new int[][]{{1, 3}, {2, 6}, {8, 10}, {15, 18}});
        int[][] res2 = new MergeIntervals().merge(new int[][]{{1, 4}, {4, 5}});
        int[][] res3 = new MergeIntervals().merge(new int[][]{{2, 3}, {4, 5}, {8, 9}, {1, 10}});
        int[][] res4 = new MergeIntervals().merge(new int[][]{{2, 3}, {2, 2}, {3, 3}, {1, 3}, {5, 7}, {2, 2}, {4, 6}});
        Common.print2DimensionalArray(res);
        Common.print2DimensionalArray(res2);
        Common.print2DimensionalArray(res3);
        Common.print2DimensionalArray(res4);
    }

    public int[][] merge(int[][] intervals) {
        if (intervals == null || intervals.length == 0) return new int[0][];
//        Arrays.sort(intervals, (a, b) -> Integer.compare(a[0], b[0]));
        Arrays.sort(intervals, Comparator.comparingInt(a -> a[0]));
        List<List<Integer>> listRes = new ArrayList<>();
        int intervalStart = intervals[0][0];
        int intervalEnd = intervals[0][1];
        for (int i = 1; i < intervals.length; i++){
            if (intervals[i][0] > intervalEnd) {
                listRes.add(Arrays.asList(intervalStart, intervalEnd));
                intervalStart = intervals[i][0];
            }
            intervalEnd = Math.max(intervals[i][1], intervalEnd);
        }
        listRes.add(Arrays.asList(intervalStart, intervalEnd));
        int[][] res = new int[listRes.size()][];
        for (int i = 0; i < listRes.size(); i++) {
            res[i] = new int[]{listRes.get(i).get(0), listRes.get(i).get(1)};
        }
        return res;
    }
}
