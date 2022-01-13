package codeforces.c765;

import fast.io.InputReader;
import fast.io.OutputWriter;

public class AAncientCivilization {
    public void solve(int testNumber, InputReader in, OutputWriter out) {
        int n = in.nextInt();
        int l = in.nextInt();
        int[] a = in.nextIntArray(n);
        int res = 0;
        for (int i = 0; i < l; i++) {
            int cnt = 0;
            for (int j = 0; j < n; j++) {
                if (((a[j] >> i) & 1) == 1) {
                    cnt++;
                }
            }
            if (cnt > n - cnt) {
                res += (1 << i);
            }

        }
        out.println(res);
    }
}
