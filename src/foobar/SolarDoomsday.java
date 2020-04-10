package foobar;

import java.util.Arrays;
import java.util.Scanner;

public class SolarDoomsday {

    static class MyList {
        Node head;

        class Node {
            int value;
            Node next;
        }
    }

    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        int area = input.nextInt();
        int[] result = solution(area);
        Arrays.stream(result).forEach(System.out::println);
    }

    public static int[] solution(int area) {
        int[] tempResult = new int[20];
        int count = 0;
        while(area != 0) {
            int maxSquare = (int) Math.pow((int) Math.sqrt(area), 2);
            tempResult[count++] = maxSquare;
            area -= maxSquare;
        }
        int[] res = new int[count];
        for (int i = 0; i < res.length; i++) {
            res[i] = tempResult[i];
        }
        return res;
    }

}
