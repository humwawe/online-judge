package ox3f2100;

import fast.io.InputReader;
import fast.io.OutputWriter;

public class EMaximumSubsequenceValue {
    public void solve(int testNumber, InputReader in, OutputWriter out) {
        int n = in.nextInt();
        long[] a = new long[n];
        for (int i = 0; i < n; i++) {
            a[i] = in.nextLong();
        }
        long res = 0;
        if (n <= 3) {
            for (int i = 0; i < n; i++) {
                res |= a[i];
            }
            out.println(res);
            return;
        }
        for (int i = 0; i < n; i++) {
            for (int j = i + 1; j < n; j++) {
                for (int k = j + 1; k < n; k++) {
                    res = Math.max(res, a[i] | a[j] | a[k]);
                }
            }
        }
        out.println(res);
    }
}
