package acwing.contest.weekly.c3;

import fast.io.InputReader;
import fast.io.OutputWriter;

import java.util.Arrays;

public class TaskC {
  int N = (int) (1e5 + 5);
  long[] dp = new long[N];
  int n;
  int len = 0;

  // 也可以树状数组求最大值
  public void solve(int testNumber, InputReader in, OutputWriter out) {
    n = in.nextInt();
    int[] w = new int[n + 1];
    int[] a = new int[n];
    for (int i = 0; i < n; i++) {
      w[i + 1] = in.nextInt();
      a[i] = w[i + 1];
    }
    discrete(a);
    build(1, 1, len);
    long res = 0;
    for (int i = 1; i <= n; i++) {
      int v = find(a, w[i]) + 1;
      long query = query(1, 1, v - 1);
      dp[i] = query + w[i];
      modify(1, v, dp[i]);
      res = Math.max(res, dp[i]);
    }
    out.println(res);

  }

  public int find(int[] a, int x) {
    return Arrays.binarySearch(a, 0, len, x);
  }

  void discrete(int[] a) {
    Arrays.sort(a);
    for (int i = 0; i < a.length; i++) {
      if (i == 0 || a[i] != a[i - 1]) {
        a[len++] = a[i];
      }
    }
  }

  Node[] tr = new Node[N * 4];


  void pushUp(int u) {
    tr[u].v = Math.max(tr[u << 1].v, tr[u << 1 | 1].v);
  }

  void build(int u, int l, int r) {
    if (l == r) {
      tr[u] = new Node(l, r, 0);
      return;
    }
    tr[u] = new Node(l, r);
    int mid = l + r >> 1;
    build(u << 1, l, mid);
    build(u << 1 | 1, mid + 1, r);
    pushUp(u);
  }

  long query(int u, int l, int r) {
    if (l > r) {
      return 0;
    }
    if (tr[u].l >= l && tr[u].r <= r) {
      return tr[u].v;
    }
    int mid = tr[u].l + tr[u].r >> 1;
    long v = Long.MIN_VALUE;
    if (l <= mid) {
      v = query(u << 1, l, r);
    }
    if (r > mid) {
      v = Math.max(v, query(u << 1 | 1, l, r));
    }
    return v;
  }

  void modify(int u, int x, long v) {
    if (tr[u].l == x && tr[u].r == x) {
      tr[u].v = Math.max(tr[u].v, v);
      return;
    }
    int mid = tr[u].l + tr[u].r >> 1;
    if (x <= mid) {
      modify(u << 1, x, v);
    } else {
      modify(u << 1 | 1, x, v);
    }
    pushUp(u);
  }

  class Node {
    int l;
    int r;
    long v;

    public Node(int l, int r) {
      this.l = l;
      this.r = r;
    }

    public Node(int l, int r, long v) {
      this.l = l;
      this.r = r;
      this.v = v;
    }
  }
}
