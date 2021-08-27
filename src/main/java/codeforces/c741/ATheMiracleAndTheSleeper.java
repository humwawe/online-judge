package codeforces.c741;

import fast.io.InputReader;
import fast.io.OutputWriter;

public class ATheMiracleAndTheSleeper {
    public void solve(int testNumber, InputReader in, OutputWriter out) {
        int l = in.nextInt();
        int a = in.nextInt();
        int b = Math.max(l, a / 2 + 1);
        out.println(a % b);
    }
}
