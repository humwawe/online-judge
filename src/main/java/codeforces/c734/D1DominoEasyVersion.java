package codeforces.c734;

import fast.io.InputReader;
import fast.io.OutputWriter;

public class D1DominoEasyVersion {
    int n, m, k;

    // todo
    public void solve(int testNumber, InputReader in, OutputWriter out) {
        n = in.nextInt();
        m = in.nextInt();
        k = in.nextInt();
        if (m == 1 && k != 0) {
            out.println("NO");
            return;
        }
        boolean ok = true;
        int a2 = m / 2;
        if (k % a2 != 0) {
            ok = false;
        } else if ((n - k / a2) % 2 != 0) {
            ok = false;
        } else if ((n - k / a2) < 2) {
            ok = false;
        }
        if (ok) {
            out.println("YES");
            return;
        }
        ok = true;
        if ((n - k % n) % 2 != 0) {
            ok = false;
        } else if ((n - k % n) < 2) {
            ok = false;
        }
        if (ok) {
            out.println("YES");
            return;
        }
        out.println("NO");

    }
}
