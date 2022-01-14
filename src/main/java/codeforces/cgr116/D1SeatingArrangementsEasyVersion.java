package codeforces.cgr116;

import fast.io.InputReader;
import fast.io.OutputWriter;

public class D1SeatingArrangementsEasyVersion {
    public void solve(int testNumber, InputReader in, OutputWriter out) {
        int n = in.nextInt();
        int m = in.nextInt();
        int[] a = new int[n];
        for (int i = 0; i < n; i++) {
            a[i] = in.nextInt();
        }
        int res = 0;
        for (int i = 0; i < m; i++) {
            for (int j = i - 1; j >= 0; j--) {
                if (a[j] < a[i]) {
                    res++;
                }
            }
        }
        out.println(res);
    }
}
