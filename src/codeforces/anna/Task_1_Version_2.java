package codeforces.anna;

import java.io.DataInputStream;
import java.io.IOException;
import java.util.*;

/*
10 4 3
1 2 3 4 1 2 3 1 2 1

10 4 5
1 2 3 4 1 2 3 1 2 1
* */

public class Task_1_Version_2 {
    public static void main(String[] args) throws IOException {
        Reader input = new Reader();
        int N = input.nextInt();
        int M = input.nextInt();
        int K = input.nextInt();
        List<List<Integer>> data = new ArrayList<>();
        for (int i = 0; i < M; i++) {
            data.add(new ArrayList<>());
        }
        for (int i = 0; i < N; i++) {
            data.get(input.nextInt() - 1).add(i + 1);
        }
        divide(data, N, K);
    }

    private static void divide(List<List<Integer>> data, int N, int K) {
        int baseLength = N / K;
        int plusOneToLength = N % K;
        int[][] result = new int[K][];
        for (int i = 0; i < K; i++) {
            result[i] = new int[baseLength + (plusOneToLength-- > 0 ? 1 : 0)];
        }
        int k = 0;
        for (List<Integer> list : data) {
            for (int item : list) {
                result[k % K][k++ / K] = item;
            }
        }
        for (int i = 0; i < result.length; i++) {
            System.out.print(result[i].length);
            for (int j = 0; j < result[i].length; j++) {
                System.out.print(" " + result[i][j]);
            }
            System.out.println();
        }
    }

    static class Reader
    {
        final private int BUFFER_SIZE = 1 << 16;
        private DataInputStream din;
        private byte[] buffer;
        private int bufferPointer, bytesRead;

        public Reader()
        {
            din = new DataInputStream(System.in);
            buffer = new byte[BUFFER_SIZE];
            bufferPointer = bytesRead = 0;
        }

        public int nextInt() throws IOException
        {
            int ret = 0;
            byte c = read();
            while (c <= ' ')
                c = read();
            boolean neg = (c == '-');
            if (neg)
                c = read();
            do
            {
                ret = ret * 10 + c - '0';
            }  while ((c = read()) >= '0' && c <= '9');

            if (neg)
                return -ret;
            return ret;
        }

        private void fillBuffer() throws IOException
        {
            bytesRead = din.read(buffer, bufferPointer = 0, BUFFER_SIZE);
            if (bytesRead == -1)
                buffer[0] = -1;
        }

        private byte read() throws IOException
        {
            if (bufferPointer == bytesRead)
                fillBuffer();
            return buffer[bufferPointer++];
        }

        public void close() throws IOException
        {
            if (din == null)
                return;
            din.close();
        }
    }
}
