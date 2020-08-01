package stepik.csc.algorithms.structures.solutions2020;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class PhoneBook {

    private static Map<String, String> phoneBook = new HashMap<>();
    private static StringBuilder result = new StringBuilder();

    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        int n = input.nextInt();
        for (int i = 0; i < n; i++) {
            String operation = input.next();
            if (operation.equals("add")) {
                phoneBook.put(input.next(), input.next());
            } else if (operation.equals("del")) {
                phoneBook.remove(input.next());
            } else {
                String name = phoneBook.get(input.next());
                result.append(name == null ? "not found" : name);
                result.append("\n");
            }
        }
        System.out.println(result.toString());
    }
}
