package acwing.contest.weekly.c12;

import fast.io.InputReader;
import fast.io.OutputWriter;

public class TaskC {
    int n, m;

    public void solve(int testNumber, InputReader in, OutputWriter out) {
        n = in.nextInt();
        w = new int[n + 1];
        for (int i = 1; i <= n; i++) {
            w[i] = in.nextInt();
        }
        build(1, 1, n);
        m = in.nextInt();
        for (int i = 0; i < m; i++) {
            String s = in.readLine();
            String[] s1 = s.split(" ");
            int l = Integer.parseInt(s1[0]) + 1;
            int r = Integer.parseInt(s1[1]) + 1;
            if (s1.length == 3) {
                int d = Integer.parseInt(s1[2]);
                if (l <= r) {
                    modify(1, l, r, d);
                } else {
                    modify(1, l, n, d);
                    modify(1, 1, r, d);
                }
            } else {
                if (l <= r) {
                    long res = query(1, l, r);
                    out.println(res);
                } else {
                    long res1 = query(1, l, n);
                    long res2 = query(1, 1, r);
                    out.println(Math.min(res1, res2));
                }
            }
        }
    }

    int N = (int) (2e5 + 5);
    Node[] tr = new Node[N * 4];
    int[] w;

    void pushUp(int u) {
        tr[u].min = Math.min(tr[u << 1].min, tr[u << 1 | 1].min);
    }

    void pushDown(int u) {
        if (tr[u].add != 0) {
            tr[u << 1].add += tr[u].add;
            tr[u << 1].min += tr[u].add;
            tr[u << 1 | 1].add += tr[u].add;
            tr[u << 1 | 1].min += tr[u].add;
            tr[u].add = 0;
        }
    }

    void build(int u, int l, int r) {
        if (l == r) {
            tr[u] = new Node(l, r, w[r], 0);
            return;
        }
        tr[u] = new Node(l, r);
        int mid = l + r >> 1;
        build(u << 1, l, mid);
        build(u << 1 | 1, mid + 1, r);
        pushUp(u);
    }

    // 从u开始查找
    long query(int u, int l, int r) {
        if (tr[u].l >= l && tr[u].r <= r) {
            return tr[u].min;
        }
        pushDown(u);
        int mid = tr[u].l + tr[u].r >> 1;
        long min = Long.MAX_VALUE;
        if (l <= mid) {
            min = Math.min(min, query(u << 1, l, r));
        }
        if (r > mid) {
            min = Math.min(min, query(u << 1 | 1, l, r));
        }
        return min;
    }

    void modify(int u, int l, int r, int d) {
        if (tr[u].l >= l && tr[u].r <= r) {
            tr[u].min += d;
            tr[u].add += d;
            return;
        }
        // 分裂
        pushDown(u);
        int mid = tr[u].l + tr[u].r >> 1;
        if (l <= mid) {
            modify(u << 1, l, r, d);
        }
        if (r > mid) {
            modify(u << 1 | 1, l, r, d);
        }
        pushUp(u);
    }

    class Node {
        int l;
        int r;
        long min;
        long add;

        public Node(int l, int r) {
            this.l = l;
            this.r = r;
        }

        public Node(int l, int r, long min, long add) {
            this.l = l;
            this.r = r;
            this.min = min;
            this.add = add;
        }
    }
}
