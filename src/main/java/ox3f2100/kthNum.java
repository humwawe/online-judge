package ox3f2100;

import fast.io.InputReader;
import fast.io.OutputWriter;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class kthNum {

  public void solve(int testNumber, InputReader in, OutputWriter out) {
    int n = in.nextInt();
    int m = in.nextInt();
    int[] a = in.nextInt(n);
    int[] b = mapping(a);

    int[] root = new int[n + 1];
    SegmentPersistenceTree segmentPersistenceTree = new SegmentPersistenceTree(b.length, m);
    root[0] = segmentPersistenceTree.build(0, b.length - 1);

    for (int i = 1; i <= n; i++) {
      root[i] = segmentPersistenceTree.insert(root[i - 1], a[i - 1]);
    }

    for (int i = 0; i < m; i++) {
      int l = in.nextInt() - 1;
      int r = in.nextInt();
      int k = in.nextInt();
      out.println(b[segmentPersistenceTree.query(root[r], root[l], k)]);
    }

  }

  int[] mapping(int[] x) {
    int n = x.length;
    Map<Integer, Integer> map = new HashMap<>(n);
    int cnt = 0;
    int[] a = Arrays.copyOf(x, n);
    int[] b = new int[n];
    Arrays.sort(a);
    for (int value : a) {
      if (!map.containsKey(value)) {
        b[cnt] = value;
        map.put(value, cnt++);
      }
    }
    for (int i = 0; i < n; i++) {
      x[i] = map.get(x[i]);
    }
    return Arrays.copyOf(b, cnt);
  }


  class SegmentPersistenceTree {
    int N;
    int[] lch;
    int[] rch;
    int[] cnt;
    int idx;

    public SegmentPersistenceTree(int n, int m) {
      N = n + 5;
      lch = new int[N * 20];
      rch = new int[N * 20];
      cnt = new int[N * 20];
      idx = 0;
      // build(0, n - 1);
    }

    public int build(int l, int r) {
      int p = ++idx;
      if (l == r) {
        return p;
      }
      int mid = l + r >> 1;
      lch[p] = build(l, mid);
      rch[p] = build(mid + 1, r);

      return p;
    }


    private int insert(int pre, int l, int r, int x) {
      int q = ++idx;
      copy(pre, q);

      if (l == r) {
        cnt[q]++;
        return q;
      }

      int mid = l + r >> 1;
      if (x <= mid) {
        lch[q] = insert(lch[pre], l, mid, x);
      } else {
        rch[q] = insert(rch[pre], mid + 1, r, x);
      }

      pushUp(q);
      return q;
    }


    private int query(int cur, int pre, int l, int r, int k) {
      if (l == r) {
        return l;
      }

      int mid = l + r >> 1;
      int c = cnt[lch[cur]] - cnt[lch[pre]];

      if (k <= c) {
        return query(lch[cur], lch[pre], l, mid, k);
      } else {
        return query(rch[cur], rch[pre], mid + 1, r, k - c);
      }

    }

    public int insert(int pre, int x) {
      // [0,n-1]
      return insert(pre, 0, N - 6, x);
    }

    public int query(int cur, int pre, int k) {
      return query(cur, pre, 0, N - 6, k);
    }

    private void copy(int s, int t) {
      lch[t] = lch[s];
      rch[t] = rch[s];
      cnt[t] = cnt[s];
    }

    private void pushUp(int u) {
      cnt[u] = cnt[lch[u]] + cnt[rch[u]];
    }

  }
}
