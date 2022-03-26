package acwing.contest.weekly.c44;

import fast.io.InputReader;
import fast.io.OutputWriter;

import java.util.HashMap;
import java.util.Map;

public class TaskC {
  int k;
  int n;

  public void solve(int testNumber, InputReader in, OutputWriter out) {
    n = in.nextInt();
    k = in.nextInt();
    Map<Long, Integer> map = new HashMap<>();
    long res = 0;
    for (int i = 0; i < n; i++) {
      int a = in.nextInt();
      long[] divide = divide(a);
      res += map.getOrDefault(divide[1], 0);
      map.put(divide[0], map.getOrDefault(divide[0], 0) + 1);
    }
    out.println(res);
  }

  long[] divide(int x) {
    Map<Integer, Integer> map = new HashMap<>();
    for (int i = 2; i * i <= x; i++) {
      while (x % i == 0) {
        x /= i;
        map.put(i, map.getOrDefault(i, 0) + 1);
      }
    }
    if (x > 1) {
      map.put(x, map.getOrDefault(x, 0) + 1);
    }
    long res1 = 1;
    long res2 = 1;
    for (Integer integer : map.keySet()) {
      res1 *= Math.pow(integer, map.get(integer) % k);
      res2 *= Math.pow(integer, (k - map.get(integer) % k) % k);
    }
    return new long[]{res1, res2};
  }
}
