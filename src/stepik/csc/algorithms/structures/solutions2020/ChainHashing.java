package stepik.csc.algorithms.structures.solutions2020;

import java.util.Scanner;

public class ChainHashing {

    private static int prime = 1_000_000_007;
    private static int x = 263;

    static  class HashTbl {
        static class Node {
            String value;
            Node next;

            Node(String value, Node next) {
                this.value = value;
                this.next = next;
            }
        }

        static int size;
        static Node[] table;

        HashTbl(int size) {
            HashTbl.size = size;
            table = new Node[size];
        }

        private static int hash(String s) {
            long hash = 0;
            for (int i = 0; i < s.length(); i++) {
                long charCode = s.charAt(i);
                hash += (charCode * power(x, i)) % prime;
            }
            return (int) (hash % prime) % size;
        }

        private static long power(int x, int power) {
            if (power == 0) return 1;
            long result = x;
            for (int i = 1; i < power; i++) {
                result = (result * x) % prime;
            }
            return result;
        }

        static String check(int i) {
            StringBuilder sb = new StringBuilder("");
            Node head = table[i];
            while (head != null) {
                sb.append(head.value);
                sb.append(" ");
                head = head.next;
            }
            return sb.toString();
        }

        static void del(String string) {
            int index = hash(string);
            Node head = table[index];
            if (head == null) return;
            if (head.value.equals(string)) {
                table[index] = head.next;
                return;
            }
            Node prev = null;
            while (!head.value.equals(string) && head.next != null) {
                prev = head;
                head = head.next;
            }
            if (head.value.equals(string)) {
                prev.next = head.next;
            }
        }

        static void add(String string) {
            if (isPresent(string)) return;
            int index = hash(string);
            Node head = table[index];
            Node newHead = new Node(string, head);
            table[index] = newHead;
        }

        static String find(String string) {
            return isPresent(string) ? "yes" : "no";
        }

        static boolean isPresent(String string) {
            int index = hash(string);
            Node head = table[index];
            while (head != null) {
                if (head.value.equals(string)) {
                    return true;
                }
                head = head.next;
            }
            return false;
        }
    }

    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        int m = input.nextInt();
        int n = input.nextInt();
        new HashTbl(m);
        for (int i = 0; i < n; i++) {
            String operation = input.next();
            if (operation.equals("add")) {
                HashTbl.add(input.next());
            } else if (operation.equals("del")) {
                HashTbl.del(input.next());
            } else if (operation.equals("find")) {
                System.out.println(HashTbl.find(input.next()));
            } else {
                System.out.println(HashTbl.check(input.nextInt()));
            }
        }
    }
}
