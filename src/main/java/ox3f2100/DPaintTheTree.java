package ox3f2100;

import fast.io.InputReader;
import fast.io.OutputWriter;

import java.util.Arrays;

public class DPaintTheTree {
    int N = 100010;
    int M = N * 2;
    int[] h = new int[N];
    int[] e = new int[M];
    int[] ne = new int[M];
    int idx;
    int[] deg = new int[N];
    int n;
    long[][] a;

    public void solve(int testNumber, InputReader in, OutputWriter out) {
        Arrays.fill(h, -1);
        idx = 0;
        n = in.nextInt();
        a = new long[3][n + 1];
        for (int i = 0; i < 3; i++) {
            for (int j = 1; j <= n; j++) {
                a[i][j] = in.nextInt();
            }
        }

        for (int i = 0; i < n - 1; i++) {
            int x = in.nextInt();
            int y = in.nextInt();
            add(x, y);
            add(y, x);
            deg[x]++;
            deg[y]++;
        }
        int cnt = 0;
        int root = 0;
        for (int i = 1; i <= n; i++) {
            if (deg[i] == 1) {
                cnt++;
                root = i;
            }
        }
        if (cnt != 2) {
            out.println(-1);
            return;
        }

        int[][] fs = new int[][]{{1, 2, 3}, {1, 3, 2}, {2, 1, 3}, {2, 3, 1}, {3, 1, 2}, {3, 2, 1}};

        long res = Long.MAX_VALUE;
        int[] map = new int[n + 1];
        for (int[] f : fs) {
            int[] t = new int[n + 1];
            long tmp = dfs(f, 0, t, root, root);
            if (tmp < res) {
                res = tmp;
                map = t;
            }
        }
        out.println(res);
        for (int i = 1; i <= n; i++) {
            out.print(map[i], "");
        }
        out.println();
    }

    private long dfs(int[] f, int idx, int[] map, int u, int p) {
        map[u] = f[idx % 3];
        long res = a[map[u] - 1][u];
        for (int i = h[u]; i != -1; i = ne[i]) {
            int j = e[i];
            if (j == p) {
                continue;
            }
            res += dfs(f, idx + 1, map, j, u);
        }
        return res;
    }

    void add(int a, int b) {
        e[idx] = b;
        ne[idx] = h[a];
        h[a] = idx++;
    }
}
