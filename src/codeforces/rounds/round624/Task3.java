package codeforces.rounds.round624;

import java.io.DataInputStream;
import java.io.IOException;

public class Task3 {

    public static void main(String[] args) throws IOException {
        Reader input = new Reader();
        int t = input.nextInt();
        for (int i = 0; i < t; i++) {
            int n = input.nextInt();
            int m = input.nextInt();
            String s = input.readLine();
            int[] p = new int[m];
            for (int j = 0; j < m; j++) {
                p[j] = input.nextInt();
            }
//            System.out.println(s + Arrays.toString(p));
            charsCounting(s, p);
        }
    }

    private static void charsCounting(String s, int[] p) {
        int[] result = new int[26];
        for (int i = 0; i < p.length; i++) {
            for (int j = 0; j < p[i]; j++) {
                result[s.charAt(j) - 'a']++;
            }
        }
        for (int i = 0; i < s.length(); i++) {
            result[s.charAt(i) - 'a']++;
        }
        for (int i = 0; i < result.length - 1; i++) {
            System.out.print(result[i] + " ");
        }
        System.out.print(result[25]);
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

        public String readLine() throws IOException
        {
            byte[] buf = new byte[64]; // line length
            int cnt = 0, c;
            while ((c = read()) != -1)
            {
                if (c == '\n')
                    break;
                buf[cnt++] = (byte) c;
            }
            return new String(buf, 0, cnt);
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
