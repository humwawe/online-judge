package acwing.contest.weekly.c18;

import fast.io.InputReader;
import fast.io.OutputWriter;

import java.util.Arrays;

public class TaskC {
    int N = 100010;
    int M = N * 2;
    int[] h = new int[N];
    int[] e = new int[M];
    int[] ne = new int[M];
    int idx;
    int n;
    int[] size = new int[N];
    int res = 0;

    public void solve(int testNumber, InputReader in, OutputWriter out) {
        Arrays.fill(h, -1);
        idx = 0;
        n = in.nextInt();
        if (n % 2 != 0) {
            out.println(-1);
            return;
        }
        for (int i = 0; i < n - 1; i++) {
            int a = in.nextInt();
            int b = in.nextInt();
            add(a, b);
            add(b, a);
        }
        dfs(1, -1);
        out.println(res);
    }

    private void dfs(int u, int p) {
        size[u] = 1;
        for (int i = h[u]; i != -1; i = ne[i]) {
            int j = e[i];
            if (j == p) {
                continue;
            }
            dfs(j, u);
            if (size[j] % 2 == 0) {
                res++;
            } else {
                size[u] += size[j];
            }
        }
    }

    void add(int a, int b) {
        e[idx] = b;
        ne[idx] = h[a];
        h[a] = idx++;
    }
}
