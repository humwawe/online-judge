package ox3f2100;

import fast.io.InputReader;
import fast.io.OutputWriter;

import java.util.Arrays;

public class BEdgeWeightAssignment {
    int N = 100010;
    int M = N * 2;
    int[] h = new int[N];
    int[] cnt = new int[N];
    int[] e = new int[M];
    int[] ne = new int[M];
    int idx;
    int n;
    boolean[] leaf = new boolean[N];
    int root, root2;
    int min;
    int max;

    public void solve(int testNumber, InputReader in, OutputWriter out) {
        Arrays.fill(h, -1);
        idx = 0;
        n = in.nextInt();
        for (int i = 0; i < n - 1; i++) {
            int a = in.nextInt();
            int b = in.nextInt();
            add(a, b);
            add(b, a);
            cnt[a]++;
            cnt[b]++;
        }

        for (int i = 1; i <= n; i++) {
            if (cnt[i] == 1) {
                leaf[i] = true;
                root = i;
            } else {
                root2 = i;
            }
        }
        dfs(root, root, 0);
        if (min >= 2) {
            out.print(3 + " ");
        } else {
            out.print(1 + " ");
        }
        max = n - 1;
        dfs2(root2, root2);
        out.println(max);
    }

    private void dfs2(int u, int p) {
        if (leaf[u]) {
            return;
        }
        int cnt = 0;
        for (int i = h[u]; i != -1; i = ne[i]) {
            int j = e[i];
            if (j == p) {
                continue;
            }
            if (leaf[j]) {
                cnt++;
            }
            dfs2(j, u);
        }
        max -= Math.max(0, cnt - 1);
    }

    private void dfs(int u, int p, int hei) {
        if (u != root && leaf[u]) {
            min |= 1 << (hei % 2);
        }
        for (int i = h[u]; i != -1; i = ne[i]) {
            int j = e[i];
            if (j == p) {
                continue;
            }
            dfs(j, u, hei + 1);
        }
    }

    void add(int a, int b) {
        e[idx] = b;
        ne[idx] = h[a];
        h[a] = idx++;
    }
}
