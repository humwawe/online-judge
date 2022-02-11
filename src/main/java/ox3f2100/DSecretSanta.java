package ox3f2100;

import fast.io.InputReader;
import fast.io.OutputWriter;

public class DSecretSanta {
    public void solve(int testNumber, InputReader in, OutputWriter out) {
        int n = in.nextInt();
        int[] a = new int[n + 1];
        int[] b = new int[n + 1];
        boolean[] vis = new boolean[n + 1];
        for (int i = 1; i <= n; i++) {
            a[i] = in.nextInt();
            vis[a[i]] = true;
        }
        int cnt = 0;
        int p = 1;
        int[] idx = new int[n + 1];
        boolean[] used = new boolean[n + 1];
        for (int i = 1; i <= n; i++) {
            if (!used[a[i]]) {
                b[i] = a[i];
            } else {
                cnt++;
                while (vis[p]) {
                    p++;
                }
                b[i] = p++;
            }
            used[b[i]] = true;
            idx[b[i]] = i;
        }

        for (int i = 1; i <= n; i++) {
            if (b[i] == i) {
                int t = idx[a[b[i]]];
                int tmp = b[i];
                b[i] = b[t];
                b[t] = tmp;
            }
        }
        out.println(n - cnt);
        for (int i = 1; i <= n; i++) {
            out.print(b[i] + " ");
        }
        out.println();
    }
}
