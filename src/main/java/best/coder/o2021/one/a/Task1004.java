package best.coder.o2021.one.a;

import fast.io.InputReader;
import fast.io.OutputWriter;

public class Task1004 {
    public void solve(int testNumber, InputReader in, OutputWriter out) {
        int a = in.nextInt();
        int b = in.nextInt();
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
            out.println("-1 -1");
        } else {
            out.println(c1 + " " + c2);
        }
    }
}
