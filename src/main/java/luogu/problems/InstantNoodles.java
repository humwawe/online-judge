package luogu.problems;

import fast.io.InputReader;
import fast.io.OutputWriter;

import java.math.BigInteger;
import java.util.*;

public class InstantNoodles {
  final Random rnd = new Random();
  final int mod = BigInteger.valueOf((int) (1e9 + rnd.nextInt((int) 1e9))).nextProbablePrime().intValue();

  public void solve(int testNumber, InputReader in, OutputWriter out) {
    int n = in.nextInt();
    int m = in.nextInt();
    long[] a = in.nextLong(n);
    List<Integer>[] lists = new List[n];
    Arrays.setAll(lists, e -> new ArrayList<>());
    for (int i = 0; i < m; i++) {
      int x = in.nextInt() - 1;
      int y = in.nextInt() - 1;
      lists[y].add(x);
    }

    Map<Long, Long> map = new HashMap<>();
    int base = 131;
    for (int i = 0; i < n; i++) {
      if (!lists[i].isEmpty()) {
        Collections.sort(lists[i]);
        long v = helper(lists[i], base);
        map.put(v, map.getOrDefault(v, 0L) + a[i]);
      }
    }
    BigInteger res = BigInteger.ZERO;
    for (Long value : map.values()) {
      res = res.gcd(BigInteger.valueOf(value));
    }
    out.println(res);
  }

  private long helper(List<Integer> list, int base) {
    long res = 1;
    for (Integer x : list) {
      res = (res * base + x) % mod;
    }
    return res;
  }


}
