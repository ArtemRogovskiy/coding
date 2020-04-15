package stepik.csc.algorithms.structures.solutions2020;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

//try to make more faster input. Didn't help, case of problem in output :)
public class CreateHeapFromArray2 {

    private static int exchanges;
    private static List<Integer> changedIndexes = new ArrayList<>();

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int[] elements = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();

        createHeap(elements);
        printResult();
    }

    private static void createHeap(int[] heap) {
        for (int i = heap.length / 2; i >= 0; i--) {
            siftDown(heap, i);
        }
    }

    private static void siftDown(int[] heap, int i) {
//        int exchangeIndex = 2 * i + 1;
//        if (exchangeIndex >= heap.length) return;
//        if (exchangeIndex + 1 < heap.length && heap[exchangeIndex] > heap[exchangeIndex + 1]) {
//            exchangeIndex = exchangeIndex + 1;
//        }
//        if (heap[i] > heap[exchangeIndex]) {
//            swap(i, exchangeIndex, heap);
//            siftDown(heap, exchangeIndex);
//        }
        int minIndex = i;
        int leftChild = 2 * i + 1;
        if (leftChild < heap.length && heap[minIndex] > heap[leftChild]) {
            minIndex = leftChild;
        }
        int rightChild = 2 * i + 2;
        if (rightChild < heap.length && heap[minIndex] > heap[rightChild]) {
            minIndex = rightChild;
        }
        if (minIndex != i) {
            swap(i, minIndex, heap);
            siftDown(heap, minIndex);
        }
    }

    private static void swap(int i, int exchangeIndex, int[] heap) {
        exchanges++;
        changedIndexes.add(i);
        changedIndexes.add(exchangeIndex);
        int tmp = heap[i];
        heap[i] = heap[exchangeIndex];
        heap[exchangeIndex] = tmp;
    }


    private static void printResult() {
        System.out.println(exchanges);
        for (int i = 0; i < exchanges; i++) {
            System.out.printf("%d %d\n", changedIndexes.get(i * 2), changedIndexes.get(i * 2 + 1));
        }
    }
}
