package ox3f2100;

import fast.io.InputReader;
import fast.io.OutputWriter;

public class DHarmoniousGraph {
    int N = 200005;
    int[] p = new int[N];
    int n, m;

    public void solve(int testNumber, InputReader in, OutputWriter out) {
        n = in.nextInt();
        m = in.nextInt();
        for (int i = 1; i <= n; i++) {
            p[i] = i;
        }
        for (int i = 1; i <= m; i++) {
            int a = in.nextInt();
            int b = in.nextInt();
            union(a, b);
        }
        int l = n;
        int res = 0;
        for (int i = n; i > 0; i--) {
            int x = find(i);
            if (x <= l) {
                l = x;
            } else {
                res++;
                union(x, l);
            }
        }
        out.println(res);
    }

    void union(int a, int b) {
        if (find(a) == find(b)) {
            return;
        }
        if (find(a) < find(b)) {
            p[find(b)] = find(a);
        } else {
            p[find(a)] = find(b);
        }

    }

    int find(int x) {
        if (p[x] != x) {
            p[x] = find(p[x]);
        }
        return p[x];
    }
}
