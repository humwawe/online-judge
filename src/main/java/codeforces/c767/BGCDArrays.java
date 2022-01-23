package codeforces.c767;

import fast.io.InputReader;
import fast.io.OutputWriter;

public class BGCDArrays {
    public void solve(int testNumber, InputReader in, OutputWriter out) {
        int l = in.nextInt();
        int r = in.nextInt();
        int k = in.nextInt();
        if (l == r) {
            if (l > 1) {
                out.println("YES");
                return;
            } else {
                out.println("NO");
                return;
            }
        }
        int t = r - l + 1;
        if (l % 2 == 0) {
            if (t / 2 <= k) {
                out.println("YES");
                return;
            }
        } else {
            if ((t + 1) / 2 <= k) {
                out.println("YES");
                return;
            }
        }
        out.println("NO");

    }
}
