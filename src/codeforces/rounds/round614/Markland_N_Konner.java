package codeforces.rounds.round614;

import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;

public class Markland_N_Konner {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        Set<Integer> repairedFloors = new HashSet<>();
        int T = input.nextInt();
        for (int t = 0; t < T; ++t) {
            int n = input.nextInt();
            int s = input.nextInt();
            int k = input.nextInt();
            repairedFloors.clear();
            for (int i = 0; i < k; ++i) {
                repairedFloors.add(input.nextInt());
            }
            System.out.println(getMinLength(n, s, repairedFloors));
        }
    }

    private static int getMinLength(int n, int s, Set<Integer> floors) {
        for (int i = 0; ; ++i) {
            if (s - i >= 1 && !floors.contains(s - i)) return i;
            else if (s + i <= n && !floors.contains(s + i)) return i;
        }
    }
}
