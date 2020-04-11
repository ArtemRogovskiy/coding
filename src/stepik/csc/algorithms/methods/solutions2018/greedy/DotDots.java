package stepik.csc.algorithms.methods.solutions2018.greedy;

import java.util.Arrays;
import java.util.Scanner;

public class DotDots {
    class Segment implements Comparable<Segment>{
        long l;
        long r;

        public Segment(long l, long r) {
            this.l = l;
            this.r = r;
        }

        @Override
        public int compareTo(Segment o) {
            return -Double.compare(o.r, r);
        }

        @Override
        public String toString() {
            return "Segment{" +
                    "l=" + l +
                    ", r=" + r +
                    '}';
        }
    }
    private void run() {
        Scanner input = new Scanner(System.in);
        int n = input.nextInt();
        Segment[] items = new Segment[n];
        for (int i = 0; i < n; i++) {
            items[i] = new Segment(input.nextInt(), input.nextInt());
        }
        Arrays.sort(items);
//        for (int i=0; i<n; i++){
//            System.out.println(items[i]);
//        }
        long[] result = new long[100];
        int count = 1;
        result[0]=items[0].r;
        long R = items[0].r;
        for (int i=1; i<n; i++){
            if(items[i].l>R){
                count++;
                R=items[i].r;
                result[count-1]=items[i].r;
            }
        }
        System.out.println(count);
        for (int i=0; i<count; i++){
            System.out.print(result[i]+ " ");
        }
    }
    public static void main(String[] args) {
        new DotDots().run();
    }
}
