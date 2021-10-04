package codeforces.c746;

import fast.io.InputReader;
import fast.io.OutputWriter;

import java.util.Arrays;

public class CBakryAndPartitioning {
    int tmp = 0;
    int n, k;

    int[] h;
    int[] e;
    int[] ne;
    int idx;
    int[] d;
    int[] v;
    int need;

    public void solve(int testNumber, InputReader in, OutputWriter out) {
        n = in.nextInt();
        k = in.nextInt();

        int N = n + 5;
        int M = 2 * N;
        h = new int[N];
        e = new int[M];
        ne = new int[M];
        d = new int[N];
        v = new int[N];
        Arrays.fill(h, -1);
        Arrays.fill(d, 0);
        idx = 0;
        tmp = 0;

        for (int i = 1; i <= n; i++) {
            v[i] = in.nextInt();
            tmp ^= v[i];
        }
        for (int i = 0; i < n - 1; i++) {
            int a = in.nextInt();
            int b = in.nextInt();
            add(a, b);
            add(b, a);
        }
        if (tmp == 0) {
            out.println("YES");
            return;
        }
        need = 0;
        dfs(1, 1);
        if (k == 2) {
            out.println("NO");
            return;
        }
        if (need >= 2) {
            out.println("YES");
            return;
        }
        out.println("NO");

    }

    private void dfs(int u, int p) {
        d[u] = v[u];
        for (int i = h[u]; i != -1; i = ne[i]) {
            int j = e[i];
            if (j == p) {
                continue;
            }
            dfs(j, u);
            if (d[j] == tmp) {
                need++;
            } else {
                d[u] ^= d[j];
            }
        }
    }

    void add(int a, int b) {
        e[idx] = b;
        ne[idx] = h[a];
        h[a] = idx++;
    }
}
