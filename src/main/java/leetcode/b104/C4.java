package leetcode.b104;

import java.util.*;

/**
 * @author hum
 */
public class C4 {

  CombinationMath combinationMath = new CombinationMath();

  public int sumOfPower(int[] nums) {
    int mod = (int) (1e9 + 7);
    int n = nums.length;

    Arrays.sort(nums);
    long res = 0;
    long sum = 0;
    for (int i = 0; i < n; i++) {
      res = (res + (long) nums[i] * nums[i] % mod * combinationMath.pow(2, i - 1) % mod * sum % mod) % mod;
      res += (long) nums[i] * nums[i] % mod * nums[i] % mod;
      res %= mod;
      sum += nums[i] * combinationMath.inv(combinationMath.pow(2, i)) % mod;
      sum %= mod;
    }
    return (int) res % mod;
  }

  class CombinationMath {
    private static final int MEMO_THRESHOLD = 100005;
    long mod = (long) (1e9 + 7);
    private final List<Long> inv = new ArrayList<>();
    private final List<Long> fact = new ArrayList<>();
    private final List<Long> invFact = new ArrayList<>();
    private final Map<Long, List<Long>> pow = new HashMap<>();

    public void initMod(long n) {
      mod = n;
    }

    private void buildInvTable(int n) {
      if (inv.isEmpty()) {
        inv.add(null);
        inv.add(1L);
      }
      for (int i = inv.size(); i <= n; i++) {
        inv.add(mod - inv.get((int) (mod % i)) * (mod / i) % mod);
      }
    }

    private void buildFactTable(int n) {
      if (fact.isEmpty()) {
        fact.add(1L);
        invFact.add(1L);
      }
      for (int i = fact.size(); i <= n; i++) {
        fact.add(fact.get(i - 1) * i % mod);
        invFact.add(inv(fact.get(i)));
      }
    }

    public void setupPowTable(long a) {
      pow.put(a, new ArrayList<>(Collections.singleton(1L)));
    }

    private void rangeCheck(long n, long r) {
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

    public long fact(int n) {
      buildFactTable(n);
      return fact.get(n);
    }

    public long invFact(int n) {
      buildFactTable(n);
      return invFact.get(n);
    }

    private long comb0(int n, int r) {
      rangeCheck(n, r);
      return fact(n) * invFact(r) % mod * invFact(n - r) % mod;
    }

    public long comb(long n, long r) {
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

    private long perm0(int n, int r) {
      rangeCheck(n, r);
      return fact(n) * invFact(n - r) % mod;
    }

    public long perm(long n, long r) {
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

    public long homo(long n, long r) {
      return r == 0 ? 1 : comb(n + r - 1, r);
    }

    private long inv0(int a) {
      buildInvTable(a);
      return inv.get(a);
    }

    public long inv(long a) {
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

    public long pow(long a, long b) {
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

    private long powMemo(long a, int b) {
      List<Long> powMemo = pow.get(a);
      while (powMemo.size() <= b) {
        powMemo.add(powMemo.get(powMemo.size() - 1) * a % mod);
      }
      return powMemo.get(b);
    }

    public long mod(long a) {
      while (a >= mod) {
        a -= mod;
      }
      while (a < 0) {
        a += mod;
      }
      return a;
    }
  }
}
