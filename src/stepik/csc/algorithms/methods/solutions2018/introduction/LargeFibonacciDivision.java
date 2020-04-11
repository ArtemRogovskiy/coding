package stepik.csc.algorithms.methods.solutions2018.introduction;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class LargeFibonacciDivision {

    List<Integer> cache = new ArrayList<>();{
        cache.add(0);
        cache.add(1);
    }

    private void fibonacci(long n, int MOD ) {
        for (int i = cache.size(); i<=n; i++){
            int res = (cache.get(i-1)+cache.get(i-2))%MOD;
            if ( (res== 0) & (cache.get(i-1)==1)) break;
            cache.add(res);
        }
        long m = n% (long) cache.size();
        System.out.println(cache.get((int) (m)));
    }

    private void run(long n, int m){
        fibonacci(n, m);
    }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        long n = sc.nextLong();
        int m = sc.nextInt();
        new LargeFibonacciDivision().run(n, m);
    }
}
