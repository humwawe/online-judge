package test;

/**
 * @author hum
 */
public class Test {
    public static void main(String[] args) {
        for (int i = 2; i <= 100; i++) {
            for (int j = 2; j <= 100; j++) {
                String t = test(i, j);
                String q = q(i, j);
                if (!t.equals(q)) {
                    System.out.println(i + " " + j);
                    System.out.println(t);
                    System.out.println(q);
                }
            }
        }

    }

    public static String q(int a, int b) {
        int lim = Math.max(a, b);
        int c1 = -1;
        int c2 = -1;
        for (int i = 2; i <= lim; i++) {
            if (a % i == b % i) {
                if (c1 == -1) {
                    c1 = i;
                    c2 = i;
                } else {
                    c2 = i;
                }
            }
        }
        return c1 + " " + c2;
    }

    public static String test(int a, int b) {
        if (a > b) {
            int t = a;
            a = b;
            b = t;
        }
        int c1 = 0, c2 = 0;
        if (a == b) {
            c1 = 2;
            c2 = a;
        } else {
            if (a % 2 == b % 2) {
                c1 = 2;
                c2 = b - a;
            } else {
                c2 = b - a;
                c1 = c2;
                for (int i = 3; i * i <= c2; i++) {
                    if (c2 % i == 0) {
                        c1 = i;
                        break;
                    }
                }
            }
        }
        if (c2 < c1 || c1 <= 1) {
            return "-1 -1";
        } else {
            return c1 + " " + c2;
        }
    }
}
