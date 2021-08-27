package codeforces.c741;

import fast.io.InputReader;
import fast.io.OutputWriter;

public class CRings {
    public void solve(int testNumber, InputReader in, OutputWriter out) {
        int n = in.nextInt();
        String s = in.nextString();
        int i = s.lastIndexOf('0');
        if (i == -1) {
            out.println(1, n - 1, 2, n);
            return;
        }
        int mid = n / 2;
        if (i >= mid) {
            out.println(1, i + 1, 1, i);
            return;
        }
        out.println(i + 1, n, i + 2, n);
    }
}
