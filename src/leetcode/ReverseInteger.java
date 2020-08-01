package leetcode;

public class ReverseInteger {
    public static void main(String[] args) {
        System.out.println(new ReverseInteger().reverse(-2147483648));
        System.out.println(new ReverseInteger().reverse2(-2147483648));
    }

    public int reverse2(int x) {
        int MAX = Integer.MAX_VALUE / 10;
        int MIN = Integer.MIN_VALUE / 10;
        int reverse = 0;
        while (x != 0) {
            int pop = x % 10;
            if (reverse > MAX || reverse == MAX && pop > 8) return 0;
            if (reverse < MIN || reverse == MIN && pop < -7) return 0;
            reverse = reverse * 10 + pop;
            x /= 10;
        }
        return reverse;
    }

    public int reverse(int x) {
        if (x == Integer.MIN_VALUE) return 0;
        int unsigned = Math.abs(x);
        String slrRep = String.valueOf(unsigned);
        StringBuilder sb = new StringBuilder("");
        for (int i = slrRep.length() - 1; i >= 0; i--) {
            sb.append(slrRep.charAt(i));
        }
        long result;
        if (x < 0) {
            result = - Long.valueOf(sb.toString());
            if (result < Integer.MIN_VALUE) return 0;
        } else {
            result = Long.valueOf(sb.toString());
            if (result > Integer.MAX_VALUE) return 0;
        }

        return (int) result;
    }
}
