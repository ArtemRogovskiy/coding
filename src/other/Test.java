package other;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Test {
    public static void main(String[] args) {
        int i = 0;
        int b = i++;
        System.out.println(i + " " + b);
        int c = --i;
        System.out.println(i + " " + c);
        System.out.println("Hello, word!");
        double d = 0.1;
        System.out.println(++d);
        Integer[] array = new Integer[10];
    }

    static void ex() {
        Scanner input = new Scanner(System.in);
//        int a =
        try {
            input.nextInt();
        } catch (Exception e) {
//            return -1;
        }


    }
}
