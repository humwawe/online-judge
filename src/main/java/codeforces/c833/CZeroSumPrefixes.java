package codeforces.c833;

import fast.io.InputReader;
import fast.io.OutputWriter;

import java.util.HashMap;
import java.util.Map;

public class CZeroSumPrefixes {
  public void solve(int testNumber, InputReader in, OutputWriter out) {
    int n = in.nextInt();
    int[] a = new int[n];
    long[] sum = new long[n + 1];
    for (int i = 0; i < n; i++) {
      a[i] = in.nextInt();
      sum[i + 1] = sum[i] + a[i];
    }
    Map<Long, Integer> map = new HashMap<>();
    int res = 0;
    for (int i = n - 1; i >= 0; i--) {
      map.put(sum[i + 1], map.getOrDefault(sum[i + 1], 0) + 1);
      if (a[i] == 0) {
        int max = 0;
        for (Integer value : map.values()) {
          max = Math.max(max, value);
        }
        res += max;
        map.clear();
      }
    }
    res += map.getOrDefault(0L, 0);
    out.println(res);
  }
}
