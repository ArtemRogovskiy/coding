package stepik.csc.algorithms.methods.solutions2018.greedy;

import java.util.Scanner;

public class VariousTerms {

    public void run() {
        Scanner sc = new Scanner(System.in);
        int sum = sc.nextInt();
        int[] result = new int[10000000];
        int count = 0;
        int i = 1;
        if (sum == 2) {
            System.out.println(1);
            System.out.println(2);
        } else {
            while (sum!=0){
                count++;
                result[i-1]=i;
                if (i>=sum-i){
                    result[i-1]=sum;
                    i=sum;
                }
                sum-=i;
                i++;
            }
            System.out.println(count);
            for (int j = 0; j < count; j++) {
                System.out.print(result[j] + " ");
            }
        }
    }

    public static void main(String[] args) {
        new VariousTerms().run();
    }
}
