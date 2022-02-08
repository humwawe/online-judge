package codeforces.c769;

import fast.io.InputReader;
import fast.io.OutputWriter;

public class CStrangeTest {
    public void solve(int testNumber, InputReader in, OutputWriter out) {
        int a = in.nextInt();
        int b = in.nextInt();
        int res = b - a;
        int t = a;
        for (int i = 0; i < res; i++) {
            if ((t | b) == b) {
                res = Math.min(res, i + 1);
            }
            t += 1;
        }
        t = b;
        for (int i = 0; i < res; i++) {
            if ((a | t) == t) {
                res = Math.min(res, i + 1);
            }
            t += 1;
        }
        out.println(res);
    }

}
