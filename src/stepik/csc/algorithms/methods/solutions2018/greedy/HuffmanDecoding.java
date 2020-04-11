package stepik.csc.algorithms.methods.solutions2018.greedy;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class HuffmanDecoding {

    public void run() {
        Map<String, Character> map = new HashMap<>();
        Scanner scanner = new Scanner(System.in);
        int leters = scanner.nextInt();
        int length = scanner.nextInt();
        for (int i = 0; i<leters; i++){
            char value = scanner.next().charAt(0);
            String key = scanner.next();
            map.put(key, value);
        }
        String str = scanner.next();
//        for (Map.Entry<String, Character> entry: map.entrySet()){
//            System.out.println(entry.getKey() + " " + entry.getValue());
//        }
        int j = 1;
        for (int i = 0; i<length;){
            while (! map.containsKey(str.substring(i, i+j))){
                j++;
            }
            System.out.print(map.get(str.substring(i, i+j)));
            i+=j;
            j = 1;
        }
    }

    public static void main(String[] args) {
        new HuffmanDecoding().run();
    }
}
