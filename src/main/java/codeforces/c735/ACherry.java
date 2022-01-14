package codeforces.c735;

import fast.io.InputReader;
import fast.io.OutputWriter;

public class ACherry {
    public void solve(int testNumber, InputReader in, OutputWriter out) {
        int n = in.nextInt();
        long[] a = new long[n];
        for (int i = 0; i < n; i++) {
            a[i] = in.nextLong();
        }
        long res = 0;
        for (int i = 1; i < n; i++) {
            res = Math.max(res, a[i] * a[i - 1]);
        }
        out.println(res);
    }
}
