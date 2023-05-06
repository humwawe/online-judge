package acwing.contest.weekly.c102;

import fast.io.InputReader;
import fast.io.OutputWriter;

import java.util.HashMap;
import java.util.Map;

public class TaskC {
  public void solve(int testNumber, InputReader in, OutputWriter out) {
    int n = in.nextInt();
    long k = in.nextInt();
    Map<Long, Integer> pre = new HashMap<>();
    Map<Long, Integer> suf = new HashMap<>();
    long[] a = new long[n];
    for (int i = 0; i < n; i++) {
      long x = in.nextInt();
      a[i] = x;
      suf.put(x, suf.getOrDefault(x, 0) + 1);
    }
    long res = 0;
    for (int i = 0; i < n; i++) {
      suf.put(a[i], suf.get(a[i]) - 1);
      if (a[i] % k != 0) {
        pre.put(a[i], pre.getOrDefault(a[i], 0) + 1);
        continue;
      }
      int left = pre.getOrDefault(a[i] / k, 0);

      int right = suf.getOrDefault(a[i] * k, 0);
      res += (long) left * right;

      pre.put(a[i], pre.getOrDefault(a[i], 0) + 1);
    }
    out.println(res);
  }
}
