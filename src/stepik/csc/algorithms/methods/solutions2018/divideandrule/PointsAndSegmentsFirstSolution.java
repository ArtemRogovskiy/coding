package stepik.csc.algorithms.methods.solutions2018.divideandrule;

import java.io.FileNotFoundException;
import java.util.Random;
import java.util.Scanner;
//wrong solution but good ideas
public class PointsAndSegmentsFirstSolution {

    static int BinSearchLeft(int[][] A, int k){
        int l = 0;
        int r = A.length-1;
        if (A[0][0] > k) return 0;
        if (A[A.length-1][0] <= k) return A.length;
        while (l<=r){
            int m = (l + r) / 2;
            if (A[m][0] <= k && k < A[m+1][0]) return m+1;
            else if (A[m][0] > k) r = m -1;
            else l = m + 1;
        }
        return -1;
    }

    static int BinSearchRight(int[][] A, int k){
        int l = 0;
        int r = A.length-1;
        if (A[0][1]>=k) return A.length;
        if (A[A.length-1][1] < k) return 0;
        while (l<=r){
            int m = (l + r) / 2;
            if (A[m][1] >= k && k > A[m-1][1]) return A.length - m;
            else if (A[m][1] >= k) r = m -1;
            else l = m + 1;
        }
        return -1;
    }

    private int[][] Sort(int[][] A, int l, int r, int k) {   //k = 0 => сортировка по левым концам; k = 1 => сортировка по правым концам
        if (l >= r) {
            return A;
        }
        int[] ret = Partition(A, l, r, k);
        int m = ret[0];
        int count = ret[1];              // число повторения элемента относительно которого сортируется массив
        Sort(A, l, m - count - 1, k);
        Sort(A, m, r, k);
        return A;
    }

    private int[] Partition(int[][] a, int l, int r, int k) { // сортирует массив от l до r, беря элемент с позиции любой
        Random random = new Random();
        int rand = random.nextInt((r - l + 1)) + l;
        int x = a[rand][k];
        int j = l;
        int count = 0;
        for (int i = l; i <= (r - count); i++) {
            // одинаковые эленты равные х закинуть в конец
            if (a[i][k] == x) {
                int[] revers = a[i];
                a[i] = a[r - count];
                a[r - count] = revers;
                count++;
            }
            // элемены меньшие х поменять с элементом на позиции j
            if (a[i][k] < x) {
                int[] revers = a[j];
                a[j] = a[i];
                a[i] = revers;
                j++;
            }
        }
        // проставить одинаковые элементы на свои места
        for (int i = r; i > (r - count); i--) {
            int[] revers = a[i];
            a[i] = a[j];
            a[j] = revers;
            j++;
        }
        int[] ret = new int[2];
        ret[0] = j;
        ret[1] = count;
        return ret;
    }

    private void run() throws FileNotFoundException {
        Scanner input = new Scanner(System.in);
        int n = input.nextInt();
        int m = input.nextInt();
        int[][] A = new int[n][2];
        for (int i = 0; i < n; i++) {
            A[i][0] = input.nextInt();
            A[i][1] = input.nextInt();
        }
        int[] M = new int[m];
        for (int i = 0; i < m; i++) {
            M[i] = input.nextInt();
        }
        Sort(A, 0, A.length - 1, 0);         // отсортировать по левым концам
        for (int j : M) {
            int count = BinSearchLeft(A, j);
            int count2 = 0;
            if (count == 0)count2 =0;
            else{
                int[][] New =new  int[count][2];
                System.arraycopy(A, 0, New, 0, count);
                int[][] res2 = Sort(New, 0, New.length -1, 1);         // отсортировать по правым концам
                count2 = BinSearchRight(res2, j);
            }
            System.out.print(count2+ " ");
        }
    }

    public static void main(String[] args) throws FileNotFoundException {
        long startTime = System.currentTimeMillis();
        new PointsAndSegmentsFirstSolution().run();
        System.out.println();
        //  System.out.println(System.currentTimeMillis() - startTime + " ms");
    }
}
