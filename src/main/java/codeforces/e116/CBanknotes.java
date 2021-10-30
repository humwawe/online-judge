package codeforces.e116;

import fast.io.InputReader;
import fast.io.OutputWriter;

public class CBanknotes {
    public void solve(int testNumber, InputReader in, OutputWriter out) {
        int n = in.nextInt();
        int k = in.nextInt() + 1;
        int[] a = in.nextIntArray(n);
        StringBuilder sb = new StringBuilder();
        for (int i = 1; i < n; i++) {
            int t = a[i] - a[i - 1];
            int max = 0;
            while (t-- > 0) {
                max *= 10;
                max += 9;
            }
            if (k <= max) {
                sb.insert(0, k);
                out.println(sb.toString());
                return;
            } else {
                k -= max;
                sb.insert(0, max);
            }
        }
        if (k > 0) {
            sb.insert(0, k);
            out.println(sb.toString());
        }

    }
}
