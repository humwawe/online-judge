package codeforces.c735;

import fast.io.InputReader;
import fast.io.OutputWriter;

public class BCobb {
    public void solve(int testNumber, InputReader in, OutputWriter out) {
        int n = in.nextInt();
        int k = in.nextInt();
        int[] a = new int[n + 1];
        for (int i = 1; i <= n; i++) {
            a[i] = in.nextInt();
        }
        int l = Math.max(1, n - 2 * k);
        long res = (long) -1e12;
        for (int i = l; i <= n; i++) {
            for (int j = i + 1; j <= n; j++) {
                res = Math.max(res, (long) i * j - (long) k * (a[i] | a[j]));
            }
        }
        out.println(res);
    }
}
