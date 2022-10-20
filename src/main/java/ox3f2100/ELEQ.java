package ox3f2100;

import fast.io.InputReader;
import fast.io.OutputWriter;
import util.CombinationMath;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class ELEQ {
  int mod = 998244353;

  public void solve(int testNumber, InputReader in, OutputWriter out) {
    int n = in.nextInt();
    int[] a = new int[n];
    for (int i = 0; i < n; i++) {
      a[i] = in.nextInt();
    }
    mapping(a);
    FenwickTree fenwickTree = new FenwickTree(n);

    long res = 0;

    for (int i = 0; i < n; i++) {
      if (i > 0) {
        res += CombinationMath.pow(2, i - 1) * fenwickTree.getSum(a[i] + 1) % mod;
      }
      res %= mod;
      fenwickTree.add(a[i], CombinationMath.inv(CombinationMath.pow(2, i)));
    }
    out.println(res);

  }

  Map<Integer, Integer> mapping(int[] x) {
    Map<Integer, Integer> map = new HashMap<>(x.length);
    int cnt = 0;
    int[] a = Arrays.copyOf(x, x.length);
    Arrays.sort(a);
    for (int value : a) {
      if (!map.containsKey(value)) {
        map.put(value, cnt++);
      }
    }
    for (int i = 0; i < x.length; i++) {
      x[i] = map.get(x[i]);
    }
    return map;
  }

  public class FenwickTree {
    private final int n;
    // 从0开始
    private final long[] table;

    FenwickTree(int n) {
      this.n = n;
      this.table = new long[n];
    }


    private long getSum(int i) {
      long sum = 0;
      for (; i > 0; i -= i & -i) {
        sum += table[i - 1];
        sum %= mod;
      }
      return sum;
    }

    void add(int i, long x) {
      for (i++; i <= n; i += i & -i) {
        table[i - 1] += x;
        table[i - 1] %= mod;
      }
    }


    long getSum(int l, int r) {
      return l >= r ? 0 : (getSum(r) - getSum(l) + mod) % mod;
    }

  }
}
