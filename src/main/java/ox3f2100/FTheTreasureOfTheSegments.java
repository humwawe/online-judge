package ox3f2100;

import fast.io.InputReader;
import fast.io.OutputWriter;

import java.util.Arrays;
import java.util.Comparator;
import java.util.HashMap;
import java.util.Map;

public class FTheTreasureOfTheSegments {
  public void solve(int testNumber, InputReader in, OutputWriter out) {
    int n = in.nextInt();
    int[] l = new int[n];
    int[] r = new int[n];
    int[] a = new int[n * 2];
    for (int i = 0; i < n; i++) {
      l[i] = in.nextInt();
      r[i] = in.nextInt();
      a[i] = l[i];
      a[i + n] = r[i];
    }
    Map<Integer, Integer> mapping = mapping(a);
    Integer[] idx = new Integer[n];
    for (int i = 0; i < n; i++) {
      l[i] = mapping.get(l[i]);
      r[i] = mapping.get(r[i]);
      idx[i] = i;
    }

    Arrays.sort(idx, Comparator.comparingInt(x -> l[x]));


    int[] left = new int[n];
    int[] right = new int[n];
    FenwickTree fenwickTree = new FenwickTree(mapping.size());

    for (int i = 0; i < n; i++) {
      int x = l[idx[i]];
      int y = r[idx[i]];
      fenwickTree.add(y, 1);
      left[i] = (int) (i - fenwickTree.getSum(0, x) + 1);
    }

    fenwickTree = new FenwickTree(mapping.size());
    for (int i = n - 1; i >= 0; i--) {
      int x = l[idx[i]];
      int y = r[idx[i]];
      right[i] = (int) fenwickTree.getSum(0, y + 1);
      fenwickTree.add(x, 1);
    }
    int max = 0;
    for (int i = 0; i < n; i++) {
      max = Math.max(max, left[i] + right[i]);
    }
    out.println(n - max);

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

  Map<Integer, Integer> mapping(int[] a) {
    Map<Integer, Integer> map = new HashMap<>(a.length);
    int cnt = 0;
    Arrays.sort(a);
    for (int value : a) {
      if (!map.containsKey(value)) {
        map.put(value, cnt++);
      }
    }
    return map;
  }
}
