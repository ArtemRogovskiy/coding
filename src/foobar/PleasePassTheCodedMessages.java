package foobar;

import java.util.Arrays;
import java.util.Scanner;

public class PleasePassTheCodedMessages {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        String s = input.nextLine();
        int[] l = Arrays.stream(s.split(" ")).mapToInt(Integer::parseInt).toArray();
        System.out.println(solution(l));
    }

    public static int solution(int[] l) {
        Arrays.sort(l);
        int sum = 0;
        int[] remainders = new int[l.length];
        for (int i = 0; i < l.length; i++) {
            remainders[i] = l[i] % 3;
            sum += l[i];
        }
        if (sum % 3 == 1) {
            return analyze(l, remainders, 1, 2);
        } else if (sum % 3 == 2) {
            return analyze(l, remainders, 2, 1);
        } else {
            return intFromArr(l, new int[] {});
        }
    }

    private static int analyze(int[] l, int[] remainders, int a, int b) {
        int[] exceptTwo = new int[2];
        Arrays.fill(exceptTwo, -1);
        for (int i = 0; i < remainders.length; i++) {
            if (remainders[i] == a) return intFromArr(l, new int[] {i});
            if (remainders[i] == b && exceptTwo[0] == - 1) exceptTwo[0] = i;
            else if (remainders[i] == b && exceptTwo[1] == - 1) exceptTwo[1] = i;
        }
        return intFromArr(l, exceptTwo);
    }

    private static int intFromArr(int[] l, int[] except) {
        StringBuilder s = new StringBuilder("");
        for (int i = l.length - 1; i >= 0; i--) {
            if (notInArray(except, i)) s.append(l[i]);
        }
        if (s.toString().equals("")) return 0;
        return Integer.parseInt(s.toString());
    }

    private static boolean notInArray(int[] except, int i) {
        for (int k = 0; k < except.length; k++) {
            if (except[k] == i) return false;
        }
        return true;
    }
}
