package codeforces.rounds.round624;

import java.io.DataInputStream;
import java.io.IOException;
import java.util.HashSet;
import java.util.Set;

public class Task2 {

    public static void main(String[] args) throws IOException {
        Reader input = new Reader();
        int t = input.nextInt();
        for (int i = 0; i < t; i++) {
            int n = input.nextInt();
            int m = input.nextInt();
            int[] data = new int[n];
            Set<Integer> p = new HashSet<>();
            for (int j = 0; j < n; j++) {
                data[j] = input.nextInt();
            }
            for (int j = 0; j < m; j++) {
                p.add(input.nextInt());
            }
            System.out.println(isCanSort(data, p));
        }
    }

    private static String isCanSort(int[] data, Set<Integer> p) {
        Set<Integer> replacements = new HashSet<>();
        for (int i = 1; i < data.length; i++) {
            for (int j = i - 1; j >= 0; j--) {
                if (data[j + 1] < data[j]) {
                    int temp = data[j + 1];
                    data[j + 1] = data[j];
                    data[j] = temp;
                    replacements.add(j + 1);
                }
            }
        }
//        setToString(p);
//        setToString(replacements);
//        System.out.println(Arrays.toString(data));
        for (int item : replacements) {
            if (!p.contains(item)) return "NO";
        }
        return "YES";
    }

    private static void setToString(Set<Integer> set) {
        for (int item : set) {
            System.out.print(item + " ");
        }
        System.out.println();
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
