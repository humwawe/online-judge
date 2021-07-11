package acwing.contest.weekly.c7;

import fast.io.InputReader;
import fast.io.OutputWriter;

import java.util.Arrays;

public class TaskC {
    int N = (int) (3e5 + 5);
    int M = 2 * N;
    int[] h = new int[N];
    int[] e = new int[M];
    int[] ne = new int[M];
    int[] w = new int[M];
    int idx;
    int[] c = new int[N];
    int n;
    long res = 0;

    public void solve(int testNumber, InputReader in, OutputWriter out) {
        Arrays.fill(h, -1);
        idx = 0;
        n = in.nextInt();
        for (int i = 1; i <= n; i++) {
            c[i] = in.nextInt();
        }
        for (int i = 0; i < n - 1; i++) {
            int a = in.nextInt();
            int b = in.nextInt();
            int v = in.nextInt();
            add(a, b, v);
            add(b, a, v);
        }

        dfs(1, -1);
        out.println(res);
    }

    private long dfs(int u, int p) {
        long d1 = 0;
        long d2 = 0;
        for (int i = h[u]; i != -1; i = ne[i]) {
            int j = e[i];
            if (j == p) {
                continue;
            }
            long l = dfs(j, u);
            if (w[i] > l) {
                continue;
            }
            l -= w[i];
            if (l > d1) {
                d2 = d1;
                d1 = l;
            } else if (l > d2) {
                d2 = l;
            }

        }
        res = Math.max(res, d1 + d2 + c[u]);
        return d1 + c[u];
    }

    void add(int a, int b, int v) {
        e[idx] = b;
        ne[idx] = h[a];
        w[idx] = v;
        h[a] = idx++;
    }
}
