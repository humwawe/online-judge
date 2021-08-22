package best.coder.o2021.two;

import fast.io.InputReader;
import fast.io.OutputWriter;

import java.util.Arrays;

public class Task1003 {
    int[] h;
    int[] e;
    int[] ne;
    int[] w;
    int idx;
    int n;
    int[] b;
    int[] p;
    int[][] f;
    long res;
    long[] c;

    public void solve(int testNumber, InputReader in, OutputWriter out) {
        n = in.nextInt();
        h = new int[n + 1];
        b = new int[n + 1];
        p = new int[n + 1];
        f = new int[n + 1][2];
        e = new int[(n + 1) * 2];
        ne = new int[(n + 1) * 2];
        c = new long[n + 1];
        Arrays.fill(h, -1);
        idx = 0;
        for (int i = 0; i < n - 1; i++) {
            int a = in.nextInt();
            int b = in.nextInt();
            add(a, b);
            add(b, a);
        }
        res = 0;
        for (int i = 1; i <= n; i++) {
            b[i] = in.nextInt();
            res += b[i];
            p[i] = in.nextInt();
        }
        dfs(1, 1);

        out.println(res);
    }

    private void dfs(int u, int fa) {
        long s = 0;
        for (int i = h[u]; i != -1; i = ne[i]) {
            int j = e[i];
            if (j == fa) {
                continue;
            }
            dfs(j, u);
            s += Math.min(c[j], b[u]);
        }
        c[u] = Math.max(Math.min(b[u], p[u] * b[u] - s), 0);
        res -= Math.min(s, p[u] * b[u]);
    }


    void add(int a, int b) {
        e[idx] = b;
        ne[idx] = h[a];
        h[a] = idx++;
    }
}
