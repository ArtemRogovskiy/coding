package stepik.csc.algorithms.methods.solutions2018.greedy;

import java.util.Comparator;
import java.util.PriorityQueue;
import java.util.Scanner;

public class PQ {

    PriorityQueue<Integer> priorityQueue = new PriorityQueue<>(new Comparator<Integer>() {
        @Override
        public int compare(Integer o1, Integer o2) {
            return -Integer.compare(o1,o2);
        }
    });

    public void run() {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        for (int i = 0; i < n; i++){
            String str = scanner.next();
            if (str.startsWith("Insert")){
                priorityQueue.add(scanner.nextInt());
            } else {
                System.out.println(priorityQueue.poll());
            }
        }
    }

    public static void main(String[] args) {
        new PQ().run();
    }
}
