package codeforces.c773;

import fast.io.InputReader;
import fast.io.OutputWriter;

import java.util.TreeMap;

public class CGreatSequence {
  public void solve(int testNumber, InputReader in, OutputWriter out) {
    int n = in.nextInt();
    long x = in.nextInt();
    long[] a = new long[n];
    TreeMap<Long, Integer> map = new TreeMap<>();
    for (int i = 0; i < n; i++) {
      a[i] = in.nextInt();
      map.put(a[i], map.getOrDefault(a[i], 0) + 1);
    }
    for (Long key : map.keySet()) {
      long o = key * x;
      if (!map.containsKey(o)) {
        continue;
      }
      int t = Math.min(map.get(key), map.get(o));
      map.put(key, map.get(key) - t);
      map.put(o, map.get(o) - t);
    }
    long res = 0;
    for (Integer value : map.values()) {
      res += value;
    }
    out.println(res);
  }
}
