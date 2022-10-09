package ox3f2100;

import fast.io.InputReader;
import fast.io.OutputWriter;

import java.util.*;

public class DRescueNibel {
  public void solve(int testNumber, InputReader in, OutputWriter out) {
    int n = in.nextInt();
    int k = in.nextInt();
    int[] a = new int[2 * n];
    for (int i = 0; i < n; i++) {
      a[i] = in.nextInt();
      a[i + n] = in.nextInt();
    }
    mapping(a);
    int[][] range = new int[n][2];
    for (int i = 0; i < n; i++) {
      range[i][0] = a[i];
      range[i][1] = a[i + n];
    }

    Arrays.sort(range, Comparator.comparingInt(x -> x[0]));

    long res = 0;
    int mod = 998244353;
    FenwickTree fenwickTree = new FenwickTree(2 * n);
    for (int i = 0; i < n; i++) {
      long cnt = fenwickTree.getSum(range[i][0], 2 * n);
      if (cnt >= k - 1) {
        res = (res + CombinationMath.comb(cnt, k - 1)) % mod;
      }
      fenwickTree.add(range[i][1], 1);
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

class CombinationMath {
  private static final int MEMO_THRESHOLD = 1000000;
  static long mod = 998244353;
  private static final List<Long> inv = new ArrayList<>();
  private static final List<Long> fact = new ArrayList<>();
  private static final List<Long> invFact = new ArrayList<>();
  private static final Map<Long, List<Long>> pow = new HashMap<>();

  private static void buildInvTable(int n) {
    if (inv.isEmpty()) {
      inv.add(null);
      inv.add(1L);
    }
    for (int i = inv.size(); i <= n; i++) {
      inv.add(mod - inv.get((int) (mod % i)) * (mod / i) % mod);
    }
  }

  private static void buildFactTable(int n) {
    if (fact.isEmpty()) {
      fact.add(1L);
      invFact.add(1L);
    }
    for (int i = fact.size(); i <= n; i++) {
      fact.add(fact.get(i - 1) * i % mod);
      invFact.add(inv(fact.get(i)));
    }
  }

  public static void setupPowTable(long a) {
    pow.put(a, new ArrayList<>(Collections.singleton(1L)));
  }

  private static void rangeCheck(long n, long r) {
    if (n < r) {
      throw new IllegalArgumentException("n < r");
    }
    if (n < 0) {
      throw new IllegalArgumentException("n < 0");
    }
    if (r < 0) {
      throw new IllegalArgumentException("r < 0");
    }
  }

  static long fact(int n) {
    buildFactTable(n);
    return fact.get(n);
  }

  static long invFact(int n) {
    buildFactTable(n);
    return invFact.get(n);
  }

  private static long comb0(int n, int r) {
    rangeCheck(n, r);
    return fact(n) * invFact(r) % mod * invFact(n - r) % mod;
  }

  static long comb(long n, long r) {
    rangeCheck(n, r);
    if (n < MEMO_THRESHOLD) {
      return comb0((int) n, (int) r);
    }
    r = Math.min(r, n - r);
    long x = 1, y = 1;
    for (long i = 1; i <= r; i++) {
      x = x * (n - r + i) % mod;
      y = y * i % mod;
    }
    return x * inv(y) % mod;
  }

  private static long perm0(int n, int r) {
    rangeCheck(n, r);
    return fact(n) * invFact(n - r) % mod;
  }

  static long perm(long n, long r) {
    rangeCheck(n, r);
    if (n < MEMO_THRESHOLD) {
      return perm0((int) n, (int) r);
    }
    long x = 1;
    for (long i = 1; i <= r; i++) {
      x = x * (n - r + i) % mod;
    }
    return x;
  }

  static long homo(long n, long r) {
    return r == 0 ? 1 : comb(n + r - 1, r);
  }

  private static long inv0(int a) {
    buildInvTable(a);
    return inv.get(a);
  }

  static long inv(long a) {
    if (a < MEMO_THRESHOLD) {
      return inv0((int) a);
    }
    long b = mod;
    long u = 1, v = 0;
    while (b >= 1) {
      long t = a / b;
      a -= t * b;
      u -= t * v;
      if (a < 1) {
        return (v %= mod) < 0 ? v + mod : v;
      }
      t = b / a;
      b -= t * a;
      v -= t * u;
    }
    return (u %= mod) < 0 ? u + mod : u;
  }

  static long pow(long a, long b) {
    if (pow.containsKey(a) && b < MEMO_THRESHOLD) {
      return powMemo(a, (int) b);
    }
    long x = 1;
    while (b > 0) {
      if (b % 2 == 1) {
        x = x * a % mod;
      }
      a = a * a % mod;
      b >>= 1;
    }
    return x;
  }

  private static long powMemo(long a, int b) {
    List<Long> powMemo = pow.get(a);
    while (powMemo.size() <= b) {
      powMemo.add(powMemo.get(powMemo.size() - 1) * a % mod);
    }
    return powMemo.get(b);
  }
}