package stepik.csc.algorithms.structures.solutions2020;

import java.util.PriorityQueue;
import java.util.Scanner;

public class ParallelProcessing {

    private static PriorityQueue<Processor> pq = new PriorityQueue<>();
    private static StringBuilder result = new StringBuilder();

    private static class Processor implements Comparable<Processor> {
        int processor;
        long endTime;

        Processor(int processor, long endTime) {
            this.processor = processor;
            this.endTime = endTime;
        }

        @Override
        public int compareTo(Processor process) {
            if (this.endTime == process.endTime) {
                return this.processor - process.processor;
            }
            return (this.endTime - process.endTime) < 0 ? -1 : 1;
        }
    }

    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        int n = input.nextInt();
        initPQ(n);
        int m = input.nextInt();
        for (int i = 0; i < m; i++) {
            int processDuration = input.nextInt();
            addProcessToProcessing(processDuration);
        }
        System.out.println(result.toString());
    }

    private static void addProcessToProcessing(int processDuration) {
        Processor freeProcessor = pq.poll();
        long currentTime = freeProcessor.endTime;
        int processorNumber = freeProcessor.processor;
        result.append(processorNumber);
        result.append(" ");
        result.append(currentTime);
        result.append("\n");
        pq.add(new Processor(processorNumber, currentTime + processDuration));
    }

    private static void initPQ(int n) {
        for (int i = 0; i < n; i++) {
            pq.add(new Processor(i, 0));
        }
    }

}
