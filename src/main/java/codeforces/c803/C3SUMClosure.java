package codeforces.c803;

import fast.io.InputReader;
import fast.io.OutputWriter;

import java.util.*;

public class C3SUMClosure {
  public void solve(int testNumber, InputReader in, OutputWriter out) {
    int n = in.nextInt();
    long[] a = new long[n];
    Map<Long, Integer> map = new HashMap<>();
    for (int i = 0; i < n; i++) {
      a[i] = in.nextInt();
      map.put(a[i], map.getOrDefault(a[i], 0) + 1);
    }
    long[] b = new long[n];
    int idx = 0;
    for (Long key : map.keySet()) {
      int min = Math.min(map.get(key), 3);
      for (int i = 0; i < min; i++) {
        b[idx++] = key;
      }
    }
    for (int i = 0; i < idx; i++) {
      for (int j = i + 1; j < idx; j++) {
        for (int k = j + 1; k < idx; k++) {
          if (!map.containsKey(b[i] + b[j] + b[k])) {
            out.println("NO");
            return;
          }
        }
      }
    }

    out.println("YES");
  }
}
