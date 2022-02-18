package ox3f2100;

import fast.io.InputReader;
import fast.io.OutputWriter;

public class DWalkingBetweenHouses {
    public void solve(int testNumber, InputReader in, OutputWriter out) {
        long n = in.nextLong();
        long k = in.nextLong();
        long s = in.nextLong();
        long min = k;
        long max = (n - 1) * k;
        if (s < min || s > max) {
            out.println("NO");
            return;
        }
        out.println("YES");
        long t = s / k;
        long m = s % k;
        t++;
        long cur = 0;
        for (int i = 0; i < m; i++) {
            if (i % 2 == 0) {
                out.print(t + 1, "");
                cur = t + 1;
            } else {
                out.print(1, " ");
                cur = 1;
            }
        }
        if (cur == t + 1) {
            for (int i = 0; i < k - m; i++) {
                if (i % 2 == 0) {
                    out.print(2, "");
                } else {
                    out.print(t + 1, "");
                }
            }
        } else {
            for (int i = 0; i < k - m; i++) {
                if (i % 2 == 0) {
                    out.print(t, "");
                } else {
                    out.print(1, "");
                }
            }
        }


    }
}
