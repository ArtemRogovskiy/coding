package stepik.csc.javabasics;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.UnsupportedEncodingException;
import java.nio.charset.StandardCharsets;
import java.util.stream.Stream;

public class Stream1 {
    public static void main(String[] args) throws UnsupportedEncodingException {
        Stream in = new BufferedReader(new InputStreamReader(System.in, StandardCharsets.UTF_8)).lines();
        in.forEach(System.out::println);

    }
}
