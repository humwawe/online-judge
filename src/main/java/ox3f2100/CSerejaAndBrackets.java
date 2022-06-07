package ox3f2100;

import fast.io.InputReader;
import fast.io.OutputWriter;

public class CSerejaAndBrackets {
  String s;

  public void solve(int testNumber, InputReader in, OutputWriter out) {
    s = in.nextString();
    int q = in.nextInt();
    SegmentTree segmentTree = new SegmentTree(s.toCharArray());
    segmentTree.build(1, 1, s.length());

    for (int i = 0; i < q; i++) {
      int l = in.nextInt();
      int r = in.nextInt();
      int[] query = segmentTree.query(1, l, r);
      out.println(r - l + 1 - query[0] - query[1]);
    }
  }

  class SegmentTree {
    int N;
    Node[] tr;
    char[] w;

    public SegmentTree(char[] w) {
      this.w = w;
      this.N = w.length + 5;
      tr = new Node[N * 4];
    }

    void pushUp(int u) {
      int min = Math.min(tr[u << 1].ll, tr[u << 1 | 1].rr);
      tr[u].ll = tr[u << 1].ll + tr[u << 1 | 1].ll - min;
      tr[u].rr = tr[u << 1].rr + tr[u << 1 | 1].rr - min;
    }

    void build(int u, int l, int r) {
      if (l == r) {
        if (w[l - 1] == '(') {
          tr[u] = new Node(l, r, 1, 0);
        } else {
          tr[u] = new Node(l, r, 0, 1);
        }

        return;
      }
      tr[u] = new Node(l, r);
      int mid = l + r >> 1;
      build(u << 1, l, mid);
      build(u << 1 | 1, mid + 1, r);
      pushUp(u);
    }

    int[] query(int u, int l, int r) {
      if (tr[u].l >= l && tr[u].r <= r) {
        return new int[]{tr[u].ll, tr[u].rr};
      }
      int mid = tr[u].l + tr[u].r >> 1;
      int[] res = new int[2];

      if (l <= mid) {
        int[] t = query(u << 1, l, r);
        int min = Math.min(res[0], t[1]);
        res[0] = res[0] + t[0] - min;
        res[1] = res[1] + t[1] - min;
      }
      if (r > mid) {
        int[] t = query(u << 1 | 1, l, r);
        int min = Math.min(res[0], t[1]);
        res[0] = res[0] + t[0] - min;
        res[1] = res[1] + t[1] - min;
      }
      return res;
    }


    class Node {
      int l;
      int r;
      int ll;
      int rr;

      public Node(int l, int r) {
        this.l = l;
        this.r = r;
      }

      public Node(int l, int r, int ll, int rr) {
        this.l = l;
        this.r = r;
        this.ll = ll;
        this.rr = rr;
      }
    }

  }

}
