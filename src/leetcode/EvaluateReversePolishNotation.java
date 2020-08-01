package leetcode;

import java.util.ArrayDeque;
import java.util.Deque;
import java.util.Map;
import java.util.Objects;
import java.util.function.IntBinaryOperator;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class EvaluateReversePolishNotation {

    public static void main(String[] args) {
        System.out.println(new EvaluateReversePolishNotation().evalRPN(new String[] {"2", "1", "+", "3", "*"}));
        System.out.println(new EvaluateReversePolishNotation().evalRPN(new String[] {"4", "13", "5", "/", "+"}));
        System.out.println(new EvaluateReversePolishNotation().evalRPN(new String[] {
                "10", "6", "9", "3", "+", "-11", "*", "/", "*", "17", "+", "5", "+"}));
    }

    private enum Operation {
        PLUS("+", Integer::sum),
        MINUS("-", (a, b) -> a - b),
        MULTIPLY("*", (a, b) -> a * b),
        DIVIDE("/", (a, b) -> a / b);

        String operation;
        IntBinaryOperator op;
        private static Map<String, Operation> stringToEnum = Stream.of(values())
                .collect(Collectors.toMap(o -> o.operation, e -> e));

        Operation(String operation, IntBinaryOperator op) {
            this.operation = operation;
            this.op = op;
        }

        public static Operation fromString(String s) {
            return stringToEnum.get(s);
        }
    }

    public int evalRPN(String[] tokens) {
        if (tokens == null || tokens.length == 0) return 0;
        Deque<Integer> dq = new ArrayDeque<>();
        for (String token : tokens) {
            try {
                dq.addLast(Integer.parseInt(token));
            } catch (Exception e) {
                Operation o = Operation.fromString(token);
                int b = Objects.requireNonNull(dq.pollLast());
                int a = Objects.requireNonNull(dq.pollLast());
                int res = o.op.applyAsInt(a, b);
                dq.addLast(res);
            }
        }
        return Objects.requireNonNull(dq.pollLast());
    }
}
