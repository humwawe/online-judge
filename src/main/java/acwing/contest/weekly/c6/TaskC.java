package acwing.contest.weekly.c6;

import fast.io.InputReader;
import fast.io.OutputWriter;

import java.util.Arrays;

public class TaskC {
    int N = 22, M = 1 << N;
    int n, m;
    int[] e = new int[N];
    int[] f = new int[M];
    Node[] g = new Node[M];
    int inf = (int) 1e8;

    public void solve(int testNumber, InputReader in, OutputWriter out) {
        n = in.nextInt();
        m = in.nextInt();
        if (m == n * (n - 1) / 2) {
            out.println(0);
            return;
        }
        for (int i = 0; i < n; i++) {
            e[i] |= 1 << i;
        }
        for (int i = 0; i < m; i++) {
            int a = in.nextInt() - 1;
            int b = in.nextInt() - 1;
            e[a] |= 1 << b;
            e[b] |= 1 << a;
        }
        Arrays.fill(f, inf);
        for (int i = 0; i < n; i++) {
            f[e[i]] = 1;
            g[e[i]] = new Node(0, i);
        }

        for (int i = 0; i < 1 << n; i++) {
            if (f[i] == inf) {
                continue;
            }
            for (int j = 0; j < n; j++) {
                if (((i >> j) & 1) == 1) {
                    int k = i | e[j];
                    if (f[k] > f[i] + 1) {
                        f[k] = f[i] + 1;
                        g[k] = new Node(i, j);
                    }
                }
            }
        }
        int k = (1 << n) - 1;
        out.println(f[k]);
        while (k > 0) {
            out.print(g[k].p + 1 + " ");
            k = g[k].prevSt;
        }
    }

    class Node {
        int prevSt;
        int p;

        public Node(int prevSt, int p) {
            this.prevSt = prevSt;
            this.p = p;
        }
    }
}
