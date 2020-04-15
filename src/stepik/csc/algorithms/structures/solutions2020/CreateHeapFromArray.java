package stepik.csc.algorithms.structures.solutions2020;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

//time limit failure
public class CreateHeapFromArray {

    private static int exchanges;
    private static List<Integer> changedIndexes = new ArrayList<>();

    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        int n = input.nextInt();
        int[] elements = new int[n];
        for (int i = 0; i < n; i++) {
            elements[i] = input.nextInt();
        }
        
        createHeap(elements);
        printResult();
    }

    private static void createHeap(int[] heap) {
        for (int i = heap.length / 2; i >= 0; i--) {
            siftDown(heap, i);
        }
    }

    private static void siftDown(int[] heap, int i) {
        int exchangeIndex = 2 * i + 1;
        if (exchangeIndex >= heap.length) return;
        if (exchangeIndex + 1 < heap.length && heap[exchangeIndex] > heap[exchangeIndex + 1]) {
            exchangeIndex = exchangeIndex + 1;
        }
        if (heap[i] > heap[exchangeIndex]) {
            swap(i, exchangeIndex, heap);
            siftDown(heap, exchangeIndex);
        }
    }

    private static void swap(int i, int exchangeIndex, int[] heap) {
        exchanges++;
        changedIndexes.add(i);
        changedIndexes.add(exchangeIndex);
        //exchange two variables without third
        heap[i] = heap[i] ^ heap[exchangeIndex];
        heap[exchangeIndex] = heap[i] ^ heap[exchangeIndex];
        heap[i] = heap[exchangeIndex] ^ heap[i];
    }


    private static void printResult() {
        System.out.println(exchanges);
        for (int i = 0; i < exchanges; i++) {
            System.out.printf("%d %d\n", changedIndexes.get(i * 2), changedIndexes.get(i * 2 + 1));
        }
    }
}
