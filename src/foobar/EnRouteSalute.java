package foobar;

import java.util.Scanner;

public class EnRouteSalute {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        String inString = input.nextLine();
        System.out.println(solution(inString));
    }

    public static int solution(String s) {
        int count = 0;
        int rightCount = 0;
        for(int i = 0; i < s.length(); i++) {
            if (s.charAt(i) == '>') {
                rightCount++;
            } else if (s.charAt(i) == '<') {
                count += rightCount;
            }
        }
        return count * 2;
    }
}
