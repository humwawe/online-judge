package ox3f2100;

import fast.io.InputReader;
import fast.io.OutputWriter;

import java.util.HashMap;
import java.util.Map;

public class ELuckyNumbers {
  public void solve(int testNumber, InputReader in, OutputWriter out) {
    int n = in.nextInt();
    int m = in.nextInt();
    long[] s = new long[n];
    for (int i = 1; i < n; i++) {
      s[i] = in.nextInt();
    }
    long[] x = new long[m];
    for (int i = 0; i < m; i++) {
      x[i] = in.nextInt();
    }
    Map<Long, Integer> map = new HashMap<>();
    long z = 0;
    for (int j = 0; j < m; j++) {
      map.put(x[j] - z, map.getOrDefault(x[j] - z, 0) + 1);
    }

    for (int i = 1; i < n; i++) {
      if (i % 2 == 1) {
        z += s[i];
        for (int j = 0; j < m; j++) {
          map.put(z - x[j], map.getOrDefault(z - x[j], 0) + 1);
        }
      } else {
        z -= s[i];
        for (int j = 0; j < m; j++) {
          map.put(z + x[j], map.getOrDefault(z + x[j], 0) + 1);
        }
      }


    }
    int res = 0;
    for (Integer value : map.values()) {
      res = Math.max(res, value);
    }
    out.println(res);
  }
}
