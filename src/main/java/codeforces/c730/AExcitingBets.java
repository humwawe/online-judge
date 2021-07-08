package codeforces.c730;

import fast.io.InputReader;
import fast.io.OutputWriter;

public class AExcitingBets {
    public void solve(int testNumber, InputReader in, OutputWriter out) {
        long a = in.nextLong();
        long b = in.nextLong();
        if (a == b) {
            out.println("0 0");
            return;
        }
        if (a > b) {
            long t = a;
            a = b;
            b = t;
        }

        long m = b - a;
        long x = (a + m - 1) / m;
        long y = m * x - a;
        long x1 = a / m;
        long y1 = a - m * x1;
        if (y1 < 0) {
            out.println(m + " " + y);
            return;
        }
        out.println(m + " " + Math.min(y1, y));
    }
}
