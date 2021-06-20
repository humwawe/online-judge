package codeforces.c727;

import fast.io.InputReader;
import fast.io.OutputWriter;

public class AContestStart {
    long n, x, t;

    public void solve(int testNumber, InputReader in, OutputWriter out) {
        n = in.nextLong();
        x = in.nextLong();
        t = in.nextLong();
        long k = t / x;
        if (n <= k) {
            out.println(n * (n - 1) / 2);
        } else {
            out.println(k * (k - 1) / 2 + (n - k) * k);
        }
    }
}
