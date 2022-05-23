package codeforces.c793;

import fast.io.InputReader;
import fast.io.OutputWriter;

import java.util.Map;
import java.util.TreeMap;

public class CLISOrReverseLIS {
  public void solve(int testNumber, InputReader in, OutputWriter out) {
    int n = in.nextInt();
    int[] a = new int[n];
    TreeMap<Integer, Integer> map = new TreeMap<>((x, y) -> y - x);
    for (int i = 0; i < n; i++) {
      a[i] = in.nextInt();
      map.put(a[i], map.getOrDefault(a[i], 0) + 1);
    }

    int l = 1;
    int r = map.size();
    while (l < r) {
      int mid = l + r + 1 >> 1;
      if (check(mid, map)) {
        l = mid;
      } else {
        r = mid - 1;
      }
    }

    out.println(l);

  }

  private boolean check(int mid, TreeMap<Integer, Integer> map) {
    int last = map.size() - mid;
    int res = 0;
    int[] cnt = new int[mid];
    int idx = 0;
    for (Map.Entry<Integer, Integer> kv : map.entrySet()) {
      if (kv.getValue() >= 2) {
        cnt[idx++] = 1;
      }
      if (idx == mid) {
        break;
      }
    }
    int sum = 0;
    for (int i = 1; i <= mid; i++) {
      sum += cnt[i - 1];
    }

    return last + 1 + sum >= mid;
  }
}
