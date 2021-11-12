package codeforces.c754;

import fast.io.InputReader;
import fast.io.OutputWriter;

public class AAMDeviation {
    public void solve(int testNumber, InputReader in, OutputWriter out) {
        int a1 = in.nextInt();
        int a2 = in.nextInt();
        int a3 = in.nextInt();
        int d = a1 + a3 - 2 * a2;
        if (d % 3 == 0) {
            out.println(0);
        } else {
            out.println(1);
        }
    }
}
