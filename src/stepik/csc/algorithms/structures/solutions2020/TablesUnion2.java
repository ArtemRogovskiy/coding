package stepik.csc.algorithms.structures.solutions2020;

import java.util.Arrays;
import java.util.Scanner;
// with paths compression
public class TablesUnion2 {
    // subtree height. i = subtree root -> rank[i] = height
    private static int[] rank;
    // size of the bunch of tables. Initialized by task input
    private static int[] tablesSize;
    // represent trees. Parent of the i = parent[i]
    private static int[] parent;

    private static int maxSize = 0;

    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        int n = input.nextInt();
        parent = new int[n];
        Arrays.fill(parent, -1);
        rank = new int[n];
        Arrays.fill(rank, 1); // at the beginning all tables are separated
        int m = input.nextInt();
        tablesSize = new int[n];
        for (int i = 0; i < n; i++) {
            int size = input.nextInt();
            if (maxSize < size) maxSize = size;
            tablesSize[i] = size;
        }

        StringBuilder result = new StringBuilder();
        for (int i = 0; i < m; i++) {
            int destination = input.nextInt();
            int source = input.nextInt();
            result.append(union(destination - 1, source - 1));
            result.append("\n");
        }
        System.out.println(result.toString());
    }

    private static int union(int destination, int source) {
        int root1 = find(destination);
        int root2 = find(source);
        if (root1 == root2) {
            return maxSize;
        }
        if (rank[root1] < rank[root2]) {
            parent[root1] = root2;
            tablesSize[root2] += tablesSize[root1];
            if (maxSize < tablesSize[root2]) maxSize = tablesSize[root2];
        } else {
            parent[root2] = root1;
            tablesSize[root1] += tablesSize[root2];
            if (rank[root1] == rank[root2]) {
                rank[root1] ++;
            }
            if (maxSize < tablesSize[root1]) maxSize = tablesSize[root1];
        }
        return maxSize;
    }

    // paths compressions
    private static int find(int table) {
        if (parent[table] == -1) return table;
        parent[table] = find(parent[table]);
        return parent[table];
    }
}
