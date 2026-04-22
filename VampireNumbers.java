import java.util.*;

public class VampireNumbers {

    public static boolean isVampire(int n) {
        String numStr = String.valueOf(n);
        int len = numStr.length();

        if (len % 2 != 0) return false;

        int half = len / 2;
        int start = (int)Math.pow(10, half - 1);
        int end = (int)Math.pow(10, half);

        char[] originalDigits = numStr.toCharArray();
        Arrays.sort(originalDigits);

        for (int x = start; x < end; x++) {
            if (n % x == 0) {
                int y = n / x;

                if (y >= start && y < end) {
                    if (!(x % 10 == 0 && y % 10 == 0)) {

                        char[] combined = (String.valueOf(x) + y).toCharArray();
                        Arrays.sort(combined);

                        if (Arrays.equals(originalDigits, combined))
                            return true;
                    }
                }
            }
        }
        return false;
    }

    public static void main(String[] args) {
        int count = 0, num = 10;

        while (count < 100) {
            if (isVampire(num)) {
                System.out.println(num);
                count++;
            }
            num++;
        }
    }
}