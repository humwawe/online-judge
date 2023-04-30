package leetcode.b103;

import java.util.Arrays;
import java.util.Comparator;

/**
 * @author hum
 */
public class C4 {


  public long countOperationsToEmptyArray(int[] nums) {
    int n = nums.length;
    Integer[] idx = new Integer[n];
    for (int i = 0; i < n; i++) {
      idx[i] = i;
    }
    Arrays.sort(idx, Comparator.comparingInt(x -> nums[x]));
    FenwickTree fenwickTree = new FenwickTree(n);
    long res = 0;
    int pre = -1;
    for (int i = 0; i < n; i++) {
      int cur = idx[i];
      if (cur > pre) {
        res += cur - pre - fenwickTree.getSum(pre + 1, cur);
      } else {
        res += n - pre - fenwickTree.getSum(pre + 1, n) + cur - fenwickTree.getSum(0, cur);
      }

      fenwickTree.add(cur, 1);
      pre = cur;
    }
    return res;
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
        table[i] += a[i];
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
