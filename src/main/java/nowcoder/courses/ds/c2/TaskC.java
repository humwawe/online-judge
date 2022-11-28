package nowcoder.courses.ds.c2;

import fast.io.InputReader;
import fast.io.OutputWriter;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class TaskC {
  int n, m, c;
  int[] a;

  public void solve(int testNumber, InputReader in, OutputWriter out) {
    n = in.nextInt();
    c = in.nextInt();
    m = in.nextInt();
    a = in.nextInt(n);

    int[] left = new int[m];
    int[] right = new int[m];
    int[] id = new int[m];
    List<int[]>[] lists = new List[n];
    Arrays.setAll(lists, e -> new ArrayList<>());

    for (int i = 0; i < m; i++) {
      left[i] = in.nextInt() - 1;
      right[i] = in.nextInt() - 1;
      id[i] = i;
      lists[right[i]].add(new int[]{left[i], id[i]});
    }

    FenwickTree fenwickTree = new FenwickTree(n);

    int[][] pre = new int[c][2];
    for (int i = 0; i < c; i++) {
      Arrays.fill(pre[i], -1);
    }
    long[] res = new long[m];
    for (int i = 0; i < n; i++) {
      int cur = a[i] - 1;
      if (pre[cur][1] != -1) {
        fenwickTree.add(pre[cur][1], -1);
        fenwickTree.add(pre[cur][0], 1);
      } else if (pre[cur][0] != -1) {
        fenwickTree.add(pre[cur][0], 1);
      }

      pre[cur][1] = pre[cur][0];
      pre[cur][0] = i;

      for (int[] li : lists[i]) {
        int l = li[0];
        res[li[1]] = fenwickTree.getSum(l, i + 1);
      }
    }
    for (long r : res) {
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
}
