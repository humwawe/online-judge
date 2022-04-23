package acwing.contest.weekly.c48;

import fast.io.InputReader;
import fast.io.OutputWriter;

import java.util.HashMap;
import java.util.Map;

public class TaskC {
  public void solve(int testNumber, InputReader in, OutputWriter out) {
    int mod = 998244353;
    int n = in.nextInt();
    int[] a = new int[n];
    Map<Integer, Integer> l = new HashMap<>();
    Map<Integer, Integer> r = new HashMap<>();
    for (int i = 0; i < n; i++) {
      a[i] = in.nextInt();
      if (!l.containsKey(a[i])) {
        l.put(a[i], i);
        r.put(a[i], i);
      } else {
        r.put(a[i], i);
      }
    }

    int cnt = 0;
    for (int i = 0; i < n; ) {
      int right = r.get(a[i]);
      for (int j = i; j < right; j++) {
        right = Math.max(right, r.get(a[j]));
      }
      cnt++;
      i = right + 1;
    }
    long p = 1;
    for (int i = 0; i < cnt - 1; i++) {
      p = (p * 2) % mod;
    }
    out.println(p);
  }
}
