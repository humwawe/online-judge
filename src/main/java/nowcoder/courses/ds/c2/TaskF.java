package nowcoder.courses.ds.c2;

import fast.io.InputReader;
import fast.io.OutputWriter;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;

public class TaskF {
  public void solve(int testNumber, InputReader in, OutputWriter out) {
    int n = in.nextInt();
    int[] a = in.nextInt(n);
    int m = in.nextInt();
    int[][] q = new int[m][3];
    List<int[]>[] lists = new List[n + 1];
    Arrays.setAll(lists, e -> new ArrayList<>());
    int[] res = new int[m];
    for (int i = 0; i < m; i++) {
      q[i][0] = in.nextInt();
      q[i][1] = in.nextInt();
      q[i][2] = i;
      res[i] = q[i][1] - q[i][0] + 1;
      lists[q[i][1]].add(new int[]{q[i][0], i});
    }
    SegmentTree1 segmentTree1 = new SegmentTree1(n);
    FenwickTree fenwickTree = new FenwickTree(n + 1);
    List<int[]> event = new ArrayList<>();
    for (int i = 1; i <= n; i++) {
      int x = a[i - 1];
      if (x <= n) {
        segmentTree1.modify(1, x, i);
      }

      for (int[] qs : lists[i]) {
        int l = qs[0];
        int id = qs[1];
        int mex = segmentTree1.query(1, l);
        event.add(new int[]{1, l - 1, mex, id});
        event.add(new int[]{-1, i, mex, id});
      }
    }

    event.sort(Comparator.comparingInt(a2 -> a2[1]));
    int j = 0;
    while (j < event.size() && event.get(j)[1] == 0) {
      j++;
    }
    for (int i = 1; i <= n; i++) {
      if (a[i - 1] <= n) {
        fenwickTree.add(a[i - 1], 1);
      }

      while (j < event.size() && event.get(j)[1] == i) {
        int[] ev = event.get(j);
        res[ev[3]] += fenwickTree.getSum(ev[2] + 1) * ev[0];
        j++;
      }
    }
    for (int r : res) {
      out.println(r);
    }

  }

  class FenwickTree {
    private final int n;
    // 从0开始
    private final long[] table;

    FenwickTree(int n) {
      this.n = n;
      this.table = new long[n];
    }

    FenwickTree(int n, long x) {
      this(n);
      for (int i = 0; i < n; i++) {
        table[i] += x;
        int j = i + ((i + 1) & -(i + 1));
        if (j < n) {
          table[j] += table[i];
        }
      }
    }

    FenwickTree(long[] a) {
      this(a.length);
      for (int i = 0; i < n; i++) {
        table[i] = a[i];
        int j = i + ((i + 1) & -(i + 1));
        if (j < n) {
          table[j] += table[i];
        }
      }
    }

    private long getSum(int i) {
      long sum = 0;
      for (; i > 0; i -= i & -i) {
        sum += table[i - 1];
      }
      return sum;
    }

    void add(int i, long x) {
      for (i++; i <= n; i += i & -i) {
        table[i - 1] += x;
      }
    }

    void set(int i, long x) {
      add(i, x - get(i));
    }

    long get(int i) {
      return getSum(i + 1) - getSum(i);
    }

    long getSum(int l, int r) {
      return l >= r ? 0 : getSum(r) - getSum(l);
    }

    // 二分查询最大的位置满足 前缀和 <= s
    int lowerBound(long x) {
      if (x <= 0) {
        return 0;
      }
      int pos = 0;
      for (int i = Integer.highestOneBit(n); i > 0; i /= 2) {
        if (pos + i <= n && table[pos + i - 1] < x) {
          x -= table[pos + i - 1];
          pos += i;
        }
      }
      return pos;
    }

    long[] toList() {
      long[] res = new long[n];
      for (int i = 0; i < n; i++) {
        res[i] = get(i);
      }
      return res;
    }

    @Override
    public String toString() {
      return Arrays.toString(toList());
    }

  }

  class SegmentTree1 {
    int N;
    int[] left;
    int[] right;
    int[] val;

    public SegmentTree1(int n) {
      this.N = n + 5;
      left = new int[N * 4];
      right = new int[N * 4];
      val = new int[N * 4];
      build(1, 1, n);
    }


    void pushUp(int u) {
      // 由子节点信息更新父节点
      val[u] = Math.min(val[u << 1], val[u << 1 | 1]);
    }

    // u是线段树的节点编号，一般从1开始，构建[l,r]的树，w[i]存每个节点的值(从l到r)
    private void build(int u, int l, int r) {
      left[u] = l;
      right[u] = r;
      if (l == r) {
        return;
      }
      int mid = l + r >> 1;
      build(u << 1, l, mid);
      build(u << 1 | 1, mid + 1, r);
      pushUp(u);
    }

    int query(int u, int l) {
      int t = u;
      while (left[t] != right[t]) {
        if (val[t << 1] < l) {
          t = t << 1;
        } else {
          t = t << 1 | 1;
        }
      }
      return left[t];
    }


    void modify(int u, int x, int v) {
      if (left[u] == x && right[u] == x) {
        val[u] = v;
        return;
      }
      int mid = left[u] + right[u] >> 1;
      if (x <= mid) {
        modify(u << 1, x, v);
      } else {
        modify(u << 1 | 1, x, v);
      }
      pushUp(u);
    }
  }
}
