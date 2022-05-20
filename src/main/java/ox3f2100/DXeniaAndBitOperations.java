package ox3f2100;

import fast.io.InputReader;
import fast.io.OutputWriter;

public class DXeniaAndBitOperations {
  int n;
  int[] w;

  public void solve(int testNumber, InputReader in, OutputWriter out) {
    n = 1 << in.nextInt();
    int m = in.nextInt();

    w = new int[n + 1];
    for (int i = 1; i <= n; i++) {
      w[i] = in.nextInt();
    }
    build(1, 1, n);
    for (int i = 0; i < m; i++) {
      int a = in.nextInt();
      int b = in.nextInt();
      modify(1, a, b);
      out.println(query(1));
    }

  }

  int N = (1 << 17) + 5;
  Node[] tr = new Node[N * 4];
  int[] dep = new int[N * 4];

  void pushUp(int u) {
    if (dep[u] % 2 == 0) {
      tr[u].v = tr[u << 1].v ^ tr[u << 1 | 1].v;
    } else {
      tr[u].v = tr[u << 1].v | tr[u << 1 | 1].v;
    }

  }

  void build(int u, int l, int r) {
    if (l == r) {
      tr[u] = new Node(l, r, w[r]);
      return;
    }
    tr[u] = new Node(l, r);
    int mid = l + r >> 1;
    build(u << 1, l, mid);
    build(u << 1 | 1, mid + 1, r);
    dep[u] = dep[u << 1] + 1;
    pushUp(u);
  }

  int query(int u) {
    return tr[u].v;
  }

  void modify(int u, int x, int v) {
    if (tr[u].l == x && tr[u].r == x) {
      tr[u].v = v;
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
    int v;

    public Node(int l, int r) {
      this.l = l;
      this.r = r;
    }

    public Node(int l, int r, int v) {
      this.l = l;
      this.r = r;
      this.v = v;
    }
  }
}
