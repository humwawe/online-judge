package leetcode.b105;

import java.util.*;

/**
 * @author hum
 */
public class C4 {
  public boolean canTraverseAllPairs(int[] nums) {
    int max = 0;
    for (int num : nums) {
      max = Math.max(max, num);
    }

    int[] sieve = sieveLowestPrime(max);
    Map<Integer, List<Integer>> map = new HashMap<>();

    int n = nums.length;
    for (int i = 0; i < n; i++) {
      int[][] tmp = mulDivide(nums[i], sieve);
      for (int[] ints : tmp) {
        int t = ints[0];
        map.computeIfAbsent(t, e -> new ArrayList<>()).add(i);
      }
    }
    DJSet djSet = new DJSet(n);
    for (List<Integer> value : map.values()) {
      for (int i = 0; i < value.size() - 1; i++) {
        djSet.unite(value.get(i), value.get(i + 1));
      }
    }
    return djSet.upper[djSet.root(0)] == -n;
  }

  int[][] mulDivide(int n, int[] lpf) {
    int[][] f = new int[9][];
    int q = 0;
    while (lpf[n] > 0) {
      int p = lpf[n];
      if (q == 0 || p != f[q - 1][0]) {
        f[q++] = new int[]{p, 1};
      } else {
        f[q - 1][1]++;
      }
      n /= p;
    }
    return Arrays.copyOf(f, q);
  }

  int[] sieveLowestPrime(int n) {
    int tot = 0;
    int[] lpf = new int[n + 1];
    int u = n + 32;
    double lu = Math.log(u);
    int[] primes = new int[(int) (u / lu + u / lu / lu * 1.5)];
    for (int i = 2; i <= n; i++) {
      lpf[i] = i;
    }
    for (int p = 2; p <= n; p++) {
      if (lpf[p] == p) {
        primes[tot++] = p;
      }
      int tmp;
      for (int i = 0; i < tot && primes[i] <= lpf[p] && (tmp = primes[i] * p) <= n; i++) {
        lpf[tmp] = primes[i];
      }
    }
    return lpf;
  }

  class DJSet {
    // 负数表示集合的大小，正数表示属于这个集合的代表元素
    public int[] upper;
    private final int[] prev;

    public DJSet(int n) {
      upper = new int[n];
      prev = new int[n];
      for (int i = 0; i < n; i++) {
        upper[i] = -1;
        prev[i] = i - 1;
      }
    }

    public int root(int x) {
      return upper[x] < 0 ? x : (upper[x] = root(upper[x]));
    }

    public boolean equiv(int x, int y) {
      return root(x) == root(y);
    }

    public boolean unite(int x, int y) {
      x = root(x);
      y = root(y);
      // 按集合大小合并，否则优先合并到x
      if (x != y) {
        if (upper[y] < upper[x]) {
          int d = x;
          x = y;
          y = d;
        }
        upper[x] += upper[y];
        upper[y] = x;
      }
      return x == y;
    }

    // 查询[l,r] 是否在同一个集合
    boolean query(int l, int r) {
      assert l <= r;
      int root = root(r);
      int rr = r;
      while (0 <= rr && root(rr) == root) {
        rr = prev[rr];
      }
      int i = r;
      while (0 <= i && root(i) == root) {
        int temp = prev[i];
        prev[i] = rr;
        i = temp;
      }
      return rr < l;
    }

    // 集合个数
    public int count() {
      int ct = 0;
      for (int u : upper) {
        if (u < 0) {
          ct++;
        }
      }
      return ct;
    }

    public int[][] toBucket() {
      int n = upper.length;
      int[][] ret = new int[n][];
      int[] rp = new int[n];
      for (int i = 0; i < n; i++) {
        if (upper[i] < 0) {
          ret[i] = new int[-upper[i]];
        }
      }
      for (int i = 0; i < n; i++) {
        int r = root(i);
        ret[r][rp[r]++] = i;
      }
      return ret;
    }
  }
}
