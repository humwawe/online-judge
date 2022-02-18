package ox3f2100;

import fast.io.InputReader;
import fast.io.OutputWriter;

public class ASortingRailwayCars {
    public void solve(int testNumber, InputReader in, OutputWriter out) {
        int n = in.nextInt();
        int[] a = new int[n];
        for (int i = 0; i < n; i++) {
            a[i] = in.nextInt();
        }
        int[] vis = new int[n + 2];
        int res = 1;
        for (int i = n - 1; i >= 0; i--) {
            res = Math.max(res, vis[a[i] + 1] + 1);
            vis[a[i]] = vis[a[i] + 1] + 1;
        }
        out.println(n - res);
    }
}
