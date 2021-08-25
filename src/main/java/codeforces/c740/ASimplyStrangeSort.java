package codeforces.c740;

import fast.io.InputReader;
import fast.io.OutputWriter;

public class ASimplyStrangeSort {
    public void solve(int testNumber, InputReader in, OutputWriter out) {
        int n = in.nextInt();
        int[] a = in.nextIntArray(n);

        int res = 0;
        while (true) {
            boolean f = true;
            for (int i = 0; i < n; i++) {
                if (a[i] != i + 1) {
                    f = false;
                    break;
                }
            }
            if (f) {
                out.println(res);
                return;
            }
            for (int i = res % 2; i < n - 1; i += 2) {
                if (a[i] > a[i + 1]) {
                    int t = a[i];
                    a[i] = a[i + 1];
                    a[i + 1] = t;
                }
            }
            res++;
        }

    }
}
