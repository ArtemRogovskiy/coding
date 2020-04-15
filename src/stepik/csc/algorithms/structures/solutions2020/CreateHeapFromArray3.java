package stepik.csc.algorithms.structures.solutions2020;

import java.io.DataInputStream;
import java.io.IOException;

//Applied solution. StringBuilder had helped
public class CreateHeapFromArray3 {

    private static int exchanges;
    private static StringBuilder changedIndexes = new StringBuilder();

    public static void main(String[] args) throws IOException {
        Reader input = new Reader();
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
        //my realization
        int exchangeIndex = 2 * i + 1;
        if (exchangeIndex >= heap.length) return;
        if (exchangeIndex + 1 < heap.length && heap[exchangeIndex] > heap[exchangeIndex + 1]) {
            exchangeIndex = exchangeIndex + 1;
        }
        if (heap[i] > heap[exchangeIndex]) {
            swap(i, exchangeIndex, heap);
            siftDown(heap, exchangeIndex);
        }
        //realization from lecture
//        int minIndex = i;
//        int leftChild = 2 * i + 1;
//        if (leftChild < heap.length && heap[minIndex] > heap[leftChild]) {
//            minIndex = leftChild;
//        }
//        int rightChild = 2 * i + 2;
//        if (rightChild < heap.length && heap[minIndex] > heap[rightChild]) {
//            minIndex = rightChild;
//        }
//        if (minIndex != i) {
//            swap(i, minIndex, heap);
//            siftDown(heap, minIndex);
//        }
    }

    private static void swap(int i, int exchangeIndex, int[] heap) {
        exchanges++;
        changedIndexes.append(i);
        changedIndexes.append(" ");
        changedIndexes.append(exchangeIndex);
        changedIndexes.append("\n");
        int tmp = heap[i];
        heap[i] = heap[exchangeIndex];
        heap[exchangeIndex] = tmp;
    }


    private static void printResult() {
        System.out.println(exchanges);
        System.out.println(changedIndexes.toString());
    }

    static class Reader {
        final private int BUFFER_SIZE = 1 << 16;
        private DataInputStream din;
        private byte[] buffer;
        private int bufferPointer, bytesRead;

        public Reader() {
            din = new DataInputStream(System.in);
            buffer = new byte[BUFFER_SIZE];
            bufferPointer = bytesRead = 0;
        }

        public int nextInt() throws IOException {
            int ret = 0;
            byte c = read();
            while (c <= ' ')
                c = read();
            boolean neg = (c == '-');
            if (neg)
                c = read();
            do {
                ret = ret * 10 + c - '0';
            } while ((c = read()) >= '0' && c <= '9');

            if (neg)
                return -ret;
            return ret;
        }

        private void fillBuffer() throws IOException {
            bytesRead = din.read(buffer, bufferPointer = 0, BUFFER_SIZE);
            if (bytesRead == -1)
                buffer[0] = -1;
        }

        private byte read() throws IOException {
            if (bufferPointer == bytesRead)
                fillBuffer();
            return buffer[bufferPointer++];
        }
    }
}
